package Pract05;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Ejercicio3{
    public static void main(String args[]){
        try{
            System.setProperty("line.separator","\r\n");
            ServerSocket ss = new ServerSocket(7777);
            while(true){
                Socket cliente = ss.accept(); //espera cliente
                Scanner recibe = new Scanner(cliente.getInputStream());
                PrintWriter envia = new PrintWriter(cliente.getOutputStream(),true);
                envia.println("HTTP/1.0 200 OK");
                envia.println("Conent-Type: text/plain");
                envia.println("");
                String linea=recibe.nextLine();
                while(!linea.equals("")){
                    envia.println(linea);
                    linea=recibe.nextLine();
                }
                cliente.close();
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
