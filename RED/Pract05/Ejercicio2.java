package Pract05;
import java.net.*;
import java.io.*;
import java.util.Scanner;
/**
 * Write a description of class Ejercicio2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ejercicio2{
    public static void main(String args[]){
        try{
            ServerSocket ss = new ServerSocket(7777);
            while(true){
                Socket cliente = ss.accept();
                System.out.println("IP Serversocket Local:" + ss.getInetAddress());
                System.out.println("Puesto ServerSocket Local:"+ ss.getLocalPort());
                System.out.println("IP socket Local:"+cliente.getLocalAddress());
                System.out.println("Puerto socket Local:"+ cliente.getLocalPort());
                System.out.println("IP socket Remota:" + cliente.getInetAddress());
                System.out.println("Puerto socket Remoto:"+cliente.getPort());
                Scanner recibe = new Scanner (cliente.getInputStream());
                PrintWriter envia = new PrintWriter(cliente.getOutputStream());
                envia.println(recibe.nextLine());
                envia.flush();
                cliente.close();
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
