package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.ListaPI;

public class LEGListaPI<E> implements ListaPI<E> {
    NodoLEG<E> primero;
    NodoLEG<E> ultimo;
    NodoLEG<E> PI_ant;
    int talla;

    public LEGListaPI() {
        primero = new NodoLEG<E>(null);
        ultimo = primero;
        PI_ant = primero;
        talla = 0;
    }
    
    // inserta en el PI
    public void insertar(E e) {
        NodoLEG<E> nuevo = new NodoLEG<E>(e);
        nuevo.siguiente = PI_ant.siguiente;
        PI_ant.siguiente = nuevo;
        
        if (nuevo.siguiente == null)
            ultimo = nuevo;
        talla++;
    }

    //elimina el dato al que apunta el PI
    public void eliminar(){
        if (PI_ant.siguiente != null){
            PI_ant.siguiente = PI_ant.siguiente.siguiente;
            if (PI_ant.siguiente == null)
                ultimo = PI_ant;
            talla--;
        }
    }

    // Devuelve el dato al que apunta el PI
    public E recuperar() {
        if (PI_ant.siguiente == null)
            return null;
        return PI_ant.siguiente.dato;
    }

    // Situa el PI al inicio
    public void irInicio() {
        PI_ant = primero;
    }

    // Situa el PI al final
    public void irFinal() {
        PI_ant = ultimo;
    }

    // Mueve el PI al siguiente
    public void siguiente() {
        if (PI_ant.siguiente != null)
            PI_ant = PI_ant.siguiente;
    }

    // Comprueba si el PI ha llegado al final
    public boolean esFinal() {
        return ultimo == PI_ant;
    }

    // Comprueba si la lista está vacía
    public boolean esVacia() {
        return talla == 0;
    }

    // Devuelve la talla de la lista
    public int talla() {
        return this.talla;
    }
}
