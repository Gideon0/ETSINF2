package Pract07;
import java.io.*;
import java.net.*;
import java.util.*;

public class Ejercicio1
{
    public static void dnslookup (String s){
        try{
            InetAddress ipServer = InetAddress.getByName(s);
            System.out.println(ipServer.toString());
        }catch(UnknownHostException e){
            System.out.println("Error al traducir el nombre" + e);
        }
    }
}
