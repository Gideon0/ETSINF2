package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.*;

public class ArrayPila<E> implements Pila<E> {
    protected E[] elArray;
    protected int tope;
    protected static final int CAPACIDAD_POR_DEFECTO = 10;

    @SuppressWarnings("unchecked")
    public ArrayPila() {
        elArray = (E[]) new Object[CAPACIDAD_POR_DEFECTO];  
        tope = -1;
    }
    
    public void apilar(E e) {                   // coste N
        if (tope == elArray.length - 1)         // coste K 
            duplicarArray();                    // coste N                   
        tope += 1;                              // coste K                       
        elArray[tope] = e;                      // coste K                 
    }

    @SuppressWarnings("unchecked")
    protected void duplicarArray() {                                // coste N
        E[] nuevoArray = (E[]) new Object[elArray.length * 2];      // coste K
        for(int i = 0; i <= tope; i++)                              // coste N
            nuevoArray[i] = elArray[i];                             // coste K
        elArray = nuevoArray;                                       // coste K
    }

    public E desapilar() {          //coste K
        if (esVacia())              //coste K        
            return null;            //coste K
        E aux = elArray[tope];      //coste K
        tope = tope - 1;            //coste K
        return aux;                 //coste K
    }

    public E tope() {               //coste K
        if (esVacia())              //coste K
            return null;            //coste K
        return elArray[tope];       //coste K
    }

    public boolean esVacia() {      // coste K
        return tope < 0;            // coste K
    }
}
