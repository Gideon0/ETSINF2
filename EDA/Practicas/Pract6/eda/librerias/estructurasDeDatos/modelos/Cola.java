package librerias.estructurasDeDatos.modelos;

/**
 * Modelo Cola: acceso FIFO a los elementos de una coleccion
 * @param <E> tipo de datos de la estructura
 * 
 * @author (EDA) 
 * @version (Curso 2018-2019)
 */

public interface Cola<E> {
    
    // Metodos Modificadores del estado de una Cola:
    /** Inserta el Elemento e en una Cola, o lo situa en su final */
    void encolar(E e);
    
    /** SII !esVacia(): 
     *  obtiene y elimina de una Cola el Elemento que ocupa su principio */
    E desencolar();
    
    // Metodos Consultores del estado de una Cola
    /** SII !esVacia(): obtiene el Elemento que ocupa el principio 
      * de una Cola, el primero en orden de insercion */
    E primero();
    
    /** Comprueba si una Cola esta vacia */
    boolean esVacia();
}