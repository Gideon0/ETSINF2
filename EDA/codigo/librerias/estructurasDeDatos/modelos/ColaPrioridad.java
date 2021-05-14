package librerias.estructurasDeDatos.modelos; 

public interface ColaPrioridad<E extends Comparable <E>> {
    void insertar(E e);
    E recuperarMin();
    E eliminarMin();
    E eliminarMax(); //Añadido para variante del ejercicio 2
    boolean esVacia();
}