/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;
import Models.InterfaceList;
/**
 *
 * @author ydavpacat
 */
public class LinkedListIP<T> implements InterfaceList<T> {
    protected Node<T> first;
    protected Node<T> last;
    protected Node<T> IP_pre;
    protected int size;
    
    public LinkedListIP(){
        first = new Node<T>(null); 
        last = first; 
        IP_pre = first;
        size = 0;
    }
    
    public void insert (T t){
        Node<T> newNode = new Node<T> (t);
        size = size + 1;
        newNode.next = IP_pre.next;
        IP_pre.next = newNode;
        IP_pre = newNode; 
        if (newNode.next == null){
            last = newNode; 
        }

    }
    public void remove(){
        if(IP_pre.next != null){
            size--;
            IP_pre.next = IP_pre.next.next;
            if (IP_pre.next == null){
                last = IP_pre;
            }       
        }
    } 
    public void goFirst(){
        IP_pre = first;
    }

    public void goLast(){
        IP_pre = last;
    }
    
    public boolean isLast(){
        return IP_pre.next == last;
    }

    public T get(){
        if (IP_pre.next == null)
            return null;
        return IP_pre.next.data;
    }
    
    
    
    public boolean isEmpty(){
        return size == 0;
    }

    public void next() {
        if(IP_pre.next != null)
            IP_pre.next = IP_pre.next.next;
    }

    public int size(){
        return size;
    }

    
}
