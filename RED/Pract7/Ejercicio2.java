package Pract7;
import java.io.*;
import java.net.*;
import java.util.*;

public class Ejercicio2
{
    public static void main(String[] args)throws SocketException{
        DatagramSocket ds = new DatagramSocket();
        System.out.println(ds.getLocalPort());
        ds.close();
    }
}
