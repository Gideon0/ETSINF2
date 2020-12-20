package Pract7;
import java.io.*;
import java.net.*;
import java.util.*;


/**
 * Write a description of class Ejercicio1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ejercicio1
{
    public static void dnslookup (String s){
        try{
            InetAddress ipServer = InetAddress.getByName(s);
            System.out.println(ipServer.toString());
        }catch(UnknownHostException e){
            System.out.println("Errror al traducir el nombre" + e);
        }
    }
}
