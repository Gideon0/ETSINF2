/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

/**
 *
 * @author ydavpacat
 */
public class Node<E>{
    E data;
    Node<E> next;
    
    public Node(){
        this.data = null;
        this.next = null;
    }
    
    public Node(E e, Node<E> n){
        this.data = e;
        this.next = n;
    }
    
    public Node(E e){
        this.data = e;
        this.next = null;
    }
}
