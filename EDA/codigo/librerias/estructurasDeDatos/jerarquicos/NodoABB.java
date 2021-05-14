package librerias.estructurasDeDatos.jerarquicos;

public class NodoABB<E> {
    E dato;
    NodoABB<E> izq;
    NodoABB<E> der;

    public NodoABB() {
        dato = null;
        izq = null;
        der = null;
    }
    public NodoABB(E e) {
        dato = e;
    }

    public NodoABB(E e, NodoABB<E> izq, NodoABB<E> der) {
        dato = e;
        this.izq = izq;
        this.der = der;
    }
}
