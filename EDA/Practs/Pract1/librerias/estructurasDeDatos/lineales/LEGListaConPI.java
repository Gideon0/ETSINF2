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
public class LEGListaConPI<E> implements ListaConPI<E>
{
    protected NodoLEG<E> pri;
    protected NodoLEG<E> ant;
    protected NodoLEG<E> ult;
    protected int talla;
    
    public LEGListaConPI(){
        pri = ult = ant = new NodoLEG<E>(null);
        talla = 0;
    }
    // Metodos Modificadores del estado de una Lista
    /** Inserta e en una Lista antes del Elemento que ocupa su PI, 
     *  que permanece inalterado */
    public void insertar(E e){
        NodoLEG<E> nuevo = new NodoLEG<E>(e);
        talla++; 
        nuevo.siguiente = ant.siguiente; 
        ant.siguiente = nuevo; 
        if(ant == ult){
            ult = ant.siguiente;
        }
        ant = nuevo;
    }
     /** SII !esFin(): 
     *  elimina de una Lista el Elemento que ocupa su PI, 
     *  que permanece inalterado */
    public void eliminar(){
        if(!esVacia()){
            talla--;
            if(ant.siguiente == ult){
                ant = ult;
            }
            ant.siguiente = null;
        }
    }
    
    // Metodos Modificadores del estado del PI de una Lista
    /** Situa el PI de una Lista en su inicio */
    public void inicio(){
        if(!esVacia()){
            ant = pri;
        }
    }
    
    /** SII !esFin(): 
     *  avanza el PI de una Lista */
    public void siguiente(){
        if(!esFin()){
            ant = ant.siguiente;
        }
    }
    
    /** Situa el PI de una Lista en su fin */
    public void fin(){
        ant = ult;
    }
    
    // Metodos Consultores del estado de una Lista
    /** SII !esFin(): 
     *  obtiene el Elemento que ocupa el PI de una Lista */
    public E recuperar(){
        return ant.siguiente.dato;
    }
        /** Comprueba si el PI de 
     * una Lista esta en su fin */
    public boolean esFin(){
        return ant == ult;
    }
    
    /** Comprueba si una Lista Con PI esta vacia */
    public boolean esVacia(){
        return pri == ult;
    }
    
    /** Devuelve la talla, o numero de elementos, de una Lista */
    public int talla(){
        return talla;
    }
}