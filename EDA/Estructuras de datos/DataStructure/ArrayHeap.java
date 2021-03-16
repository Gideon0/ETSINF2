/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;
import Models.InterfaceHeap;
/**
 *
 * @author ydavpacat
 */
public class ArrayHeap<T> implements InterfaceHeap<T> {
    protected T[] arrayH;
    protected int size;
    
    protected static final int DEFAULT_SIZE = 3000;
    
    public ArrayHeap(){
        arrayH = (T[]) new Object[DEFAULT_SIZE];
        size = 0;

    }
    
    protected void duplicate(){
        T[] newArray = (T[]) new Object[arrayH.length*2];
        for(int i = 0; i < size; i++){
            newArray[i] = arrayH[i];
        }
        arrayH = newArray;
    }

    public void stack(T t){
        if(size == arrayH.length){
            duplicate();
        }
        arrayH[size] = t;
        size++;
    }


    public T unstack() {
        T topcito = arrayH[size-1];
        arrayH[size-1] = null;
        size--;
        return topcito;
    }


    public T top() {
        return arrayH[size-1];
    }


    public boolean isEmpty() {
        return size==0;
    }
}
