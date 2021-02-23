/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerias.estructurasDeDatos.lineales;
import librerias.estructurasDeDatos.modelos.ListaConPI;
/**
 *
 * @author ydavpacat
 */
public class LEGListaConPIOrdenada<E> extends LEGListaConPI<E> implements ListaConPI<E>{
    public void insertar(E e){
    
    }
    
    /** SII !esFin(): 
     *  elimina de una Lista el Elemento que ocupa su PI, 
     *  que permanece inalterado */
    public void eliminar(){
    
    }
    
    // Metodos Modificadores del estado del PI de una Lista
    /** Situa el PI de una Lista en su inicio */
    public void inicio(){
        
    }
    
    /** SII !esFin(): 
     *  avanza el PI de una Lista */
    public void siguiente(){
    
    }
    
    /** Situa el PI de una Lista en su fin */
    public void fin(){
    
    }
    
    // Metodos Consultores del estado de una Lista
    /** SII !esFin(): 
     *  obtiene el Elemento que ocupa el PI de una Lista */
    public E recuperar(){
        return null;
    }
    /** Comprueba si el PI de una Lista esta en su fin */
    public boolean esFin(){
        return false;
    }
    
    /** Comprueba si una Lista Con PI esta vacia */
    public boolean esVacia(){
        return 0==0;
    }
    
    /** Devuelve la talla, o numero de elementos, de una Lista */
    public int talla(){
        return 0;
    }
}
