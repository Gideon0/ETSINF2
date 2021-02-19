/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;
import Models.InterfaceQueue;

public class LinkedQueue<E> implements InterfaceQueue<E>{
    protected Node<E> first;
    protected Node<E> last;
    protected int size;

    @Override
       public void enqueue(E t) {
        Node<E> aux = new Node<E>(t);
        if (isEmpty()){
            first = aux;
        }else {
            last.next = aux;
        }
        last = aux;
        size++;
        
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            return null; 
        E aux = first.data; 
        if(first == last){
            first = null;
            last = null;
        }
        else 
            first = first.next;
        size--;
        return aux;
    }

    @Override
    public E first() {
        if (isEmpty()){
            return null;
        }
        return first.data;
    }

    @Override
    public boolean isEmpty() {
        return last == null;
    }
    
}
