package Pract5;

import java.net.*; 
import java.io.*; 
/**
 * Write a description of class ServidorTCP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ServidorTCP{

    public static void main(String args[]) { 
        try{ 
            ServerSocket ss=new ServerSocket(7777); 
            while(true){ 
                Socket s=ss.accept(); // espera un cliente //código para dar servicio al cliente 
                s.close(); 
            }
        } catch(IOException e) {
            System.out.println(e); 
        }
    } 
}
