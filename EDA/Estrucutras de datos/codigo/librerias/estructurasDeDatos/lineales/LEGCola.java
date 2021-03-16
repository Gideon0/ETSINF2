package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.Cola;

public class LEGCola<E> implements Cola<E> {
    private NodoLEG<E> primero;
    private NodoLEG<E> ultimo;
    private int talla;

    public LEGCola() {
        primero = null;
        ultimo = null;
        talla = 0;
    }

    public LEGCola(E e) {
        primero = new NodoLEG<E>(e);
        ultimo = primero;
        talla = 1;  // En realidad no hace falta.
    }

    public void encolar(E e) {                  // coste K
        NodoLEG<E> aux = new NodoLEG<E>(e);     // coste K
        if (esVacia())                          // coste K
            primero = aux;                      // coste K
        else                                    // coste K
            ultimo.siguiente = aux;             // coste K
        ultimo = aux;                           // coste K
        talla = talla + 1;                      // coste K
    }

    public E desencolar() {                 // coste K
        if (esVacia())                      // coste K
            return null;                    // coste K
        E aux = primero.dato;               // coste K
        if (primero == ultimo)              // coste K
            ultimo = null;                  // coste K
        primero = primero.siguiente;        // coste K
        talla = talla - 1;                  // coste K
        return aux;                         // coste K
    }

    public E primero() {            // coste K
        if (esVacia())              // coste K
            return null;            // coste K
        return primero.dato;        // coste K
    }

    public boolean esVacia() {      // coste K
        return (ultimo == null);    // coste K
    }

    public int getTalla() {         // coste K
        return talla;               // coste K
    }
}
