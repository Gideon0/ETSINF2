package Pract06;
import java.io.*;
import java.net.*;
import java.util.*;

public class Ejercicio1 extends Thread{
    String texto;
    public Ejercicio1(String t){
        texto = t;
    }
    public void run (){
        //Codigo del hilo
        for (int i=0; i<10;i++){
            System.out.println(texto);
            try{
                sleep(1000);
            }catch (InterruptedException e){}
        }
    } 
    public static void main(String args[]){
        for(int i=0; i<3;i++){
            Ejercicio1 h = new Ejercicio1("Soy el hilo" + i);
            h.start();
        }
    }
}
