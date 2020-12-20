package Pract7;
import java.io.*;
import java.net.*;
import java.util.*;


/**
 * Write a description of class Ejercicio2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ejercicio2
{
    public static void main(String[] args)throws SocketException{
        DatagramSocket ds = new DatagramSocket();
        System.out.println(ds.getLocalPort());
        ds.close();
    }
}
