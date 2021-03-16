package librerias.estructurasDeDatos.modelos; 

public interface Cola<E> {
    public void encolar(E e);
    public E desencolar();
    public E primero();
    public boolean esVacia();
}
