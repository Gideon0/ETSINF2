/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librerias.estructurasDeDatos.lineales;

/**
 *
 * @author ydavpacat
 */
public class NodoLEG<E>{
    E dato;
    NodoLEG<E> siguiente;
    
    public NodoLEG(){
        this.dato = null;
        this.siguiente = null;
    }
    
    public NodoLEG(E e, NodoLEG<E> n){
        this.dato = e;
        this.siguiente = n;
    }
    
    public NodoLEG(E e){
        this.dato = e;
        this.siguiente = null;
    }
}
