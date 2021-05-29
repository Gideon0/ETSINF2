package Pract06;


import java.io.*;
import java.net.*; 
import java.util.*;

 

public class chat extends Thread {
    Socket id;
    public chat(Socket s) {id=s;}
    
    public static void main(String[] args) throws IOException { 
        Socket s = new Socket("zoltar.redes.upv.es",7777); 
        System.out.println("conectado");
        new chat(s).start(); 

        PrintWriter salida = new PrintWriter(s.getOutputStream(), true);
        Scanner leeTeclado=new Scanner(System.in);
        String l = new String();
        while (true) {
            l = leeTeclado.nextLine();
            salida.println(l);
            if (l.equalsIgnoreCase("quit")) break;
        }
        s.close();
    } 

 

    public void run() {
        try { 
            Scanner entrada = new Scanner(id.getInputStream());
            while (entrada.hasNextLine()) {
                System.out.println(entrada.nextLine());
            }            
        } catch (Exception e) {
            System.out.println(e);
        } 
    } 
}
