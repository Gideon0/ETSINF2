
# Practica 4 - Chat Distribuido

> Para la realización de esta práctica solo necesitarás el código proporcionado en la clase ChatClientCSD y ChatRobot.

## Actividad 1

a) **Al indicar un nick y pulsar en Connect, deberá salir un mensaje del tipo "Server has no channels"**

b) **Si no se indica ningún nick y se pulsaen Connect, deberá salir un mensaje del tipo "Nick cannot be empty"**

c) **Si no se indica ningún nombre de Server pero sí en el nicky se pulsaen Connect, deberá salir un mensaje del tipo "Server name cannot be empty"**

### Cuestión: averigüeen qué clases del proyecto DistributedChatSourcesse detectan e imprimen todos estos mensajes indicados

|Mensaje | Clase|
|--|--|
|Server has no channels| Chat Cliente  |
|Nick cannot be empty| ChatUI  |
|Server name cannot be empty| ChatUI|

## Actividad 2

### Cuestión: Cuando los clientes del Chat preguntan la lista de canales, ¿qué proxies se emplean? ¿Qué métodos de esos proxies? ¿Se envía algún objeto como parámetro o valor de retorno de esosmétodos? ¿Para qué?

- **¿qué proxies se emplean?**

Utiliza un proxy del ChatServer

- **¿Qué métodos de esos proxies?**

Primero connectUser para conectarse al servidor, después listChannels para ver los canales disponibles

- **¿Se envía algún objeto como parámetro o valor de retorno de esosmétodos?**

Se envía un objeto de ChatUser al servidor

- **¿Para qué?**

Para mostrar los canales disponibles

## Actividad 3

### Cuando un cliente del Chat se une a un canal, el canal avisa a los demás usuarios del canal

1. **¿Qué mensaje le llega a cada usuario del canal?**

"JOIN UsarioQueSeConcecta"

2. **¿Se ha creado algún objeto para el envío del mensaje? ¿Cuál o cuáles?**

Objeto de la clase ChatMessage

3. **¿A qué clases y métodos de dichas clases se ha llamado? Explique deta lladamente los pasos que  se  siguen para  que  el  canal  avise a  los  demás  usuarios  de  la  unión  de  un  nuevo  usuario, indicando: (i) Clase y método que se invoca; (ii) si se trata de un objeto remoto (y, por tanto, se hace uso de su proxy); (iii) parámetros del método(y si son por valor o referencia**

```java
// ChatChanel.java
   private void notifyUsers (String code, String nick) {
      IChatMessage msg = null;
      try {
    msg = new ChatMessage (null, this, code + " " + nick);
      } catch (Exception e) {return;}

      for (IChatUser usr: users.values()) {
     try {
        usr.sendMessage (msg);
  } catch (Exception e) {} // Ignore errors when sending channel notifications
      }      

   }

// ChatChanel
public boolean join (IChatUser usr) throws RemoteException
   {
      String nick = usr.getNick();
      String keyNick = nick.trim().toLowerCase();
      if (users.get (keyNick) != null) return false; // User already in channel
      users.put (keyNick, usr);      
      notifyUsers (JOIN, nick);
      return true;
   }

//ChatCliente
public String [] doJoinChannel (String channelName) throws Exception {
          IChatChannel ch = srv.getChannel (channelName);
          if (ch == null) {
              throw new Exception ("Channel not found");
          }
          /* ****************************    */
          //ACTIVITY 3: JOIN A CHANNEL 
          //3.a Make that the user "myUser" joins the channel "ch".   
          ch.join(myUser);
          //Obtains the list of channel users  
          IChatUser [] users = ch.listUsers ();
          if (users == null || users.length == 0){
              throw new Exception ("BUG. Tell professor there are no users after joining");
          }
          
          String [] userList = new String [users.length];      
          for (int i=0; i<users.length; i++) {
              userList[i] = users[i].getNick();
          }
          
          return userList;
       }


```

## Actividad 4

### Cómo  recibe  un  usuario  un  mensaje?  ¿Qué  métodos  y  clases  se  invocan? Identifique en qué parte del código se procede a analizar el tipo de mensaje recibido por parte de un usuario y a mostrar dicho mensaje por pantalla

## Actividad 5

### ¿Cómo  recibe  un  usuario  un  mensaje privado? ¿Cómo  sabe  que  el  mensaje  es privado (y no del canal)? ¿Qué métodos y clases se invocan? Identifiqueen qué parte del código se  procede  a  analizar  el  tipo  de  mensaje  recibido  por  parte  de  un  usuario  y  a  mostrar  dicho mensaje por pantalla


## Actividad 6

### 1. Expliquequé  objetos  y  qué  operaciones son invocados  cada  vez que un usuario  se conecta al canal “#Friends”,asumiendo queel ChatRobotya está conectado aesecanal

Le método notifyUsers() recorre la lista de proxys de usuarios conectadas al canal y utiliza el método sendMessage(msg) para enviar un mensaje a cada uno de los usuarios notificando que se ha unido un nuevo usuario

ChatRobot simplemente lee el mensaje y en caso de que comience por JOIN utiliza el objeto IChatChannel recibido con el mensaje pir enviar un objeto de tipo IChatMessage al canal

### 2. Justifi que la afirmación, “si lanzamos más de una aplicación ChatClient o ChatRobot en la misma máquina, deberán tener valores myport distintos. Si sólo se lanza una aplicación por máquina no es necesario modificar dicho valor”

Esta información es cierta, debido a que solo puede hacer un proceso escuchando en un puerto en una misma maquina, por lo tanto si entrega en maquinas diferentes no habrá problemas ya que se identificarán por la ip de la maquina en la que se encuentran y el puerto en el que se ejecuta

### 3. La ubicación del servidor de nombres (nsport, nshost) debe ser conocida por todos, pero los clientes no necesitan conocer el hostni el portque corresponde al ChatServer. Indique la razón

Correcto, debido a que cuando un cliente quiere acceder a un objeto remoto, no utiliza el el servidor, si no que utilizan el chat de nombres para buscarlo, igual pasa cuando crea un objeto, lo registran en el servidor de nombre para que cualquiera pueda utilizarlo

### 4. Asumiendo que rmiregistry y ChatServer están en una máquina A, y que lanzamos la aplicación ChatRoboten  una  máquina  B,  y  una  aplicación ChatClienten  una  máquina  C,  y sabiendo que estas dos aplicaciones indican la ubicación del servidor de nombres lanzado en la máquina A, describa:

- **dónde se ubican cada uno de los siguientes objetos (en qué máquina)**

- **indique si se emplean una o varias instancias de cada objeto**

- **explique cómo pueden comunicarse las instancias entre sí, es decir, cómo se obtienen sus referencias, qué tipo de invocaciones se realizan (locales o remotas), etc**
