package librerias.estructurasDeDatos.lineales;

public class NodoLEG<E> {
    E dato;
    NodoLEG<E> siguiente;

    public NodoLEG() {
        this.dato = null;
        this.siguiente = null;
    }

    public NodoLEG(E e, NodoLEG<E> s) {
        this.dato = e;
        this.siguiente = s;
    }

    public NodoLEG(E e) {
        this.dato = e;
        this.siguiente = null;
    }
}
