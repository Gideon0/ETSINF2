package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.Pila;

public class PilaConListaPI<E> implements Pila<E> {
    private LEGListaPI<E> lista;
    
    //constructor

    public PilaConListaPI() {
        lista = new LEGListaPI<E>();
    }

    public void apilar(E e) {
        lista.irInicio();
        lista.insertar(e);
    }

    public E desapilar() {
        lista.irInicio();
        E aux = lista.recuperar();
        lista.eliminar();
        return aux;
    }

    public E tope() {
        lista.irInicio();
        return lista.recuperar();
    }

    public boolean esVacia() {
        return lista.esVacia();
    }
}
