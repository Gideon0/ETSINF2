package ejemplos;

import librerias.estructurasDeDatos.modelos.Pila;
import librerias.estructurasDeDatos.lineales.PilaConListaPI;
//import librerias.estructurasDeDatos.lineales.PilaEsListaPI;

public class TestPila {
    public static void main(String[] args) {
        //Pila<Integer> pila = new PilaEsListaPI<Integer>();
        Pila<Integer> pila = new PilaConListaPI<Integer>();

        System.out.println("¿Está vacía?:" + pila.esVacia());
        System.out.println("Desapilar devuelve: " + pila.desapilar());
        System.out.println("Tope devuelve: " + pila.tope());
        
        for (int i = 0; i < 10; i++){
            System.out.println("Apilamos un " + i);
            pila.apilar(i);
        }

        while(!pila.esVacia())
            System.out.println("Desapilamos un " + pila.desapilar());
    }
}
