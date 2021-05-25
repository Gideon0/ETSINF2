package Pract05;
import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 * Write a description of class Ejercicio1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ejercicio1{
    public static void main(String args[]){
        try{
            ServerSocket ss = new ServerSocket(7777);
            while(true){
                Socket cliente = ss.accept();
                Scanner recibe = new Scanner(cliente.getInputStream());
                PrintWriter envia = new PrintWriter(cliente.getOutputStream());
                String linea = recibe.nextLine();
                envia.println(linea);
                envia.flush();
                System.out.println("Se  ha  conectado  un  cliente  al servidor");
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
