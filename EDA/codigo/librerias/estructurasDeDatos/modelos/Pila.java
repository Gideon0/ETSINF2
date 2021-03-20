package librerias.estructurasDeDatos.modelos;

public interface Pila<E> {
    public void apilar(E e);
    public E desapilar();
    public E tope();
    public boolean esVacia();
}
