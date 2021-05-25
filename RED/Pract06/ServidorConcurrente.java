package Pract06;

import java.io.*;
import java.net.*;
import java.util.*;

 

class Servicio extends Thread {
    Socket sc; // atributo de la clase
    public Servicio(Socket s) { // constructor de la clase
        sc = s; // Código a ejecutar durante la inicialización
    }
    public void run() {
        // Código del hilo
        // Aquí ponemos lo que queremos que ejecute cada hilo
        try {
            Scanner in = new Scanner(sc.getInputStream());
            PrintWriter out = new PrintWriter(sc.getOutputStream(),true);
            String linea = in.nextLine();
            while (!linea.equalsIgnoreCase("fin")) {
                out.println(linea);
                linea = in.nextLine();
            }
            sc.close();
        }
        catch (IOException e) {}
    }
}

 

public class ServidorConcurrente {
    public static void main(String argv[]) throws
    UnknownHostException, IOException {
        int puerto = 8000; // puerto bien conocido del servidor
        ServerSocket servidor = new ServerSocket(puerto);
        while (true) {
            Socket cliente = servidor.accept(); // Espero un cliente
            // Para atender la petición se crea un objeto Servicio
            // Se ejecuta el constructor sobre el socket “cliente”
            Servicio Cl = new Servicio(cliente); 
            Cl.start(); // Y se arranca el hilo para atender al cliente en paralelo
        } // Fin While 
    } // Fin Main
} // Fin ServidorConcurrente
