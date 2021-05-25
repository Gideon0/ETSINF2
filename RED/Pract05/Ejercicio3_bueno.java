package Pract05;
import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 * Write a description of class Ejjercicio3_bueno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ejercicio3_bueno{
     public static void main(String args[]){
        try{
            System.setProperty("line.separator","\r\n");
            ServerSocket ss = new ServerSocket(7777);
            while(true){
                Socket cliente = ss.accept(); //espera cliente
                Scanner recibe = new Scanner(cliente.getInputStream());
                PrintWriter envia = new PrintWriter(cliente.getOutputStream(),true);
                String respuesta = "HTTP/1.0 200 OK\r\n";
                respuesta+="Conetent-Type: text/plain\r\n";
                respuesta+= "\r\n";
                String linea=recibe.nextLine();
                while(!linea.equals("")){
                    envia.println(linea);
                    linea=recibe.nextLine();
                }
                envia.println(respuesta);
                cliente.close();
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }   

}
