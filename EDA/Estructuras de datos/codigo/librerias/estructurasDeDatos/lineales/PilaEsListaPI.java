package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.Pila;

public class PilaEsListaPI<E> extends LEGListaPI<E> implements Pila<E> {
    //atributos - los tenemos heredados
    //constructor

    public PilaEsListaPI() {
        super();
    }

    public void apilar(E e) {
        super.irInicio();
        super.insertar(e);
    }

    public E desapilar() {
        super.irInicio();
        E aux = super.recuperar();
        super.eliminar();
        return aux;
    }

    public E tope() {
        super.irInicio();
        return super.recuperar();
    }

    public boolean esVacia() {
        return super.esVacia();
    }
}
