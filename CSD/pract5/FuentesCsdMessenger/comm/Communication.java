package comm;

import java.util.ArrayList;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import messageBodies.AckChatMessage;
import messageBodies.NewChatMessage;
import messageBodies.NewUser;
import messageBodies.ReadedChatMessage;
import messageBodies.UserStart;
import messageBodies.UsersList;
import ui.Model;

import javax.jms.TemporaryQueue;
import javax.jms.*;

/**
 * 
 * @author Agustín Espinosa Minguet (aespinos@upvnet.upv.es)
 *
 */
public class Communication implements Runnable {

    public static Communication theCommunication = new Communication();
    
    private InitialContext ic;
    private JMSContext jmsContext;
    private JMSProducer producer;

    private Communication() {
    }

    static Communication getCommunication() {
        return theCommunication;
    }



    /**
     * Este método es llamado cuando se completa la inicialización de la
     * interfaz de usuario. Su función consiste en inicializar el componente de
     * comunicación.
     * 
     */
    void initialize() {
        // ACTIVIDAD 3 y 4
        try{
            ic = new InitialContext(); // 3.6.1
            
            ConnectionFactory cfac = (ConnectionFactory) ic.lookup("ConnectionFactory"); // 3.6.2
            
            jmsContext = cfac.createContext(); // 3.6.3
            
            producer = jmsContext.createProducer(); // 3.6.4 
            
            // UserStart us = new UserStart(""); // 3.6.5
            
            UserStart us = new UserStart(ui.API.getMyName()); // 4.1.1
            
            ObjectMessage replyMsg = jmsContext.createObjectMessage(us); // 3.6.6
            
            TemporaryQueue tq = jmsContext.createTemporaryQueue(); // 4.1.2
            
            replyMsg.setJMSReplyTo(tq); // 4.1.3
            
            Queue queue = (Queue) ic.lookup("dynamicQueues/csd"); // 3.6.7
    
            producer.send(queue, replyMsg); // 3.6.8
            
            JMSConsumer consumer = jmsContext.createConsumer(tq); // 4.2.1
            
            UsersList ul =(UsersList) ((ObjectMessage) consumer.receive()).getObject(); // 4.2.2
            
            ui.API.updateUserList(ul.getUsers()); // 4.2.3
        } catch (Exception e) {}
        
    }

    /*
     * Hilo receptor de mensajes
     */
    public void run() {
        // ACTIVIDAD 6
        try{
            JMSContext jmscontext = jmsContext.createContext(JMSContext.AUTO_ACKNOWLEDGE);// 6.1.1
            
            producer = jmscontext.createProducer();// 6.1.2
            
            Queue queue = (Queue) ic.lookup("dynamicQueues/users-" + ui.API.getMyName());// 6.1.3
            
            JMSConsumer consumer = jmscontext.createConsumer(queue);// 6.1.4
            
            while(true){
                ObjectMessage ncm = (ObjectMessage) consumer.receive();// 6.1.5
                Object aux2 = ncm.getObject();
                
                if(aux2 instanceof NewChatMessage){
                    // 6.1.6
                    NewChatMessage aux = (NewChatMessage) aux2;
                    ui.API.chatMessageReceived(aux.getSenderName(), 
                    aux.getText(), aux.getTimestamp());         
                }else if (aux2 instanceof NewUser){
                    // 7.1
                    NewUser nUser = (NewUser) aux2;        
                    ui.API.addToUserList(nUser.getName());
                
                }else if (aux2 instanceof AckChatMessage){
                    AckChatMessage ack = (AckChatMessage) aux2;
                    ui.API.changeMessageStatusToDelivered(ack.getSenderName(),ack.getTimestamp() );// 7.2
                
                }else if (aux2 instanceof ReadedChatMessage){
                    ReadedChatMessage readed = (ReadedChatMessage) aux2;
                    ui.API.changeMessageStatusToReaded(readed.getSenderName(),readed.getTimestamp());
                }else{
                    // 6.1.7
                    ui.API.addToLog(0, ncm.getClass().getSimpleName());
                }
            }
        } catch (Exception e) {}
    }

    /**
     * Envía un mensaje de chat al usuario especificado.
     * 
     * @param destUser
     *            El usuario destinatario
     * @param text
     *            El texto del mensaje
     * @param timestamp
     *            La hora local del sistema
     * @throws NamingException
     * @throws JMSException
     */
    void sendChatMessage(String destUser, String text, long timestamp) throws NamingException, JMSException {
        // ACTIVIDAD 5 
        Queue queue = (Queue) ic.lookup("dynamicQueues/users-" + destUser); // 5.1.1
        
        NewChatMessage ncm = new NewChatMessage(text, ui.API.getMyName(), timestamp); // 5.1.2
        
        ObjectMessage JMSMessage = jmsContext.createObjectMessage(ncm);// 5.1.3
        
        producer.send(queue, JMSMessage);// 5.1.4
        
        
    }

    /**
     * Notifica al usuario especificado que un mensaje en particular ha sido
     * leído.
     * 
     * @param user
     *            El usuario que envió el mensaje que se ha leído
     * @param timestamp
     *            La hora que fue establecida en origen del mensaje que se ha
     *            leído
     * @throws NamingException
     * @throws JMSException
     */
    void sendMessageReaded(String user, long timestamp) throws NamingException, JMSException {
        //7.3
        Queue queue = (Queue) ic.lookup("dynamicQueues/users-" + user);
        
        ReadedChatMessage ncm = new ReadedChatMessage(ui.API.getMyName(), timestamp); 
        
        ObjectMessage JMSMessage = jmsContext.createObjectMessage(ncm);
        
        producer.send(queue, JMSMessage);

    }

}
