/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;
import Models.InterfaceQueue;

public class ArrayQueue<T> implements InterfaceQueue<T> {
    protected T[] arrayT;
    protected int ini;
    protected int fin;
    protected int size;
    
    protected static final int DEFAULT_SIZE = 3000; 
    
   @SuppressWarnings("unchecked") 
    public ArrayQueue(){
        arrayT =(T[]) new Object[DEFAULT_SIZE];
        ini = 0;
        fin = 0;
        size = 0;
    }
    
    public void enqueue(T x){
        if (size == arrayT.length){
            duplicateArraySize();
        }
        
        arrayT[fin] = x;
        fin = increase(fin);
        size++;
        
    }
       
   @SuppressWarnings("unchecked") 
    protected void duplicateArraySize(){
        T[] newArray = (T[]) new Object[arrayT.length * 2];
        for (int i = 0; i < size; i++){
            newArray[i] = arrayT[ini];
            ini = increase(ini);
        }
        arrayT = newArray;
        ini = 0;
        fin = size;
    }
    
    protected int increase(int i){
        
        if(i < arrayT.length - 1){
            i++;
        }else {
            i = 0;
        }
        return i;
    }

  
    public T dequeue() {
        // return Alt + F4
        T i  = arrayT[ini];
        ini = increase(ini);
        size--;
        return i; 
    }
        

    public T first() {
        return arrayT[ini];
    }

   
    public boolean isEmpty() {
        return size == 0;
    }
    
    
    
}
