package librerias.estructurasDeDatos.modelos;

public interface ListaPI<E> {
    
    // inserta en el PI
    void insertar(E e);

    //elimina el dato al que apunta el PI
    void eliminar();

    // Devuelve el dato al que apunta el PI
    E recuperar();

    // Situa el PI al inicio
    void irInicio();

    // Situa el PI al final
    void irFinal();

    // Mueve el PI al siguiente
    void siguiente();

    // Comprueba si el PI ha llegado al final
    boolean esFinal();

    // Comprueba si la lista está vacía
    boolean esVacia();

    // Devuelve la talla de la lista
    int talla();
}
