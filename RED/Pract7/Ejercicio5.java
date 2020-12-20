package Pract7;
import java.io.*;
import java.net.*;
import java.util.*;

public class Ejercicio5
{
    public static void main(String[] args)throws SocketException, IOException {
        byte[] buffer = new byte[1000];
        DatagramPacket p = new DatagramPacket(buffer,1000);
        DatagramSocket ds = new DatagramSocket(7777);
        ds.receive(p);
        Date now = new Date();
        String now_string = now.toString() + "\r\n";
        p.setData(now_string.getBytes());
        p.setLength(now_string.getBytes().length);
        ds.send(p);
        ds.close();
        
    }
}
