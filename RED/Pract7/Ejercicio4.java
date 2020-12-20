package Pract7;
import java.io.*;
import java.net.*;
import java.util.*;

public class Ejercicio4
{
   public static void main (String[] args)throws IOException, SocketException{
        DatagramSocket socket = new DatagramSocket();
        String ms = new String("Ydav Pacat");
        DatagramPacket dp = new DatagramPacket(ms.getBytes(),ms.getBytes().length, InetAddress.getByName("localhost"),7777);
        socket.send(dp);
        System.out.println("enviado");
        socket.receive(dp);
        String s = new String(dp.getData(), 0, dp.getLength());
        System.out.println(s);
        socket.close();
   } 
}
