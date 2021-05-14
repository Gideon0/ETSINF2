package librerias.estructurasDeDatos.modelos;

public interface ArbolBinarioBusqueda<E extends Comparable <E>> {
    void insertar(E e);
    void borrar(E e);
    boolean buscar(E e);
    boolean esVacia();
    int talla();
    int altura();

    String preOrden();
    String inOrden();
    String postOrden();
    
    E min();
    E max();

    E sucesor(E e);
    E predecesor(E e);
}
