package librerias.estructurasDeDatos.lineales;


/**
 * Write a description of class LEGListaConPIOrdenaa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEGListaConPIOrdenada<E extends Comparable<E>> extends LEGListaConPI<E>
{
    
    public void insertar(E e){
        inicio();
        while(!esFin() && e.compareTo(recuperar()) > 0){
            siguiente();
        }
        super.insertar(e);
    }
    
}
