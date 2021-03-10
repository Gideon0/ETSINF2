package librerias.estructurasDeDatos.deDispersion;

/**
 * Representa un elemento de la Lista con PI que implementa   
 * una cubeta de una TablaHash, esto es una Entrada o par
 * (clave, valor)
 * 
 * @param <C>, el tipo de la clave
 * @param <V>, el tipo del valor asociado a una clave
 * 
 * @author (EDA)
 * @version (Curso 2018/19)
 */

class EntradaHash<C, V> {
    
    protected C clave;
    protected V valor;

    EntradaHash(C c, V v) {
        clave = c;
        valor = v;
    }
    
    public String toString() { 
        return "(" + clave + ", " + valor + ")"; 
    }
}