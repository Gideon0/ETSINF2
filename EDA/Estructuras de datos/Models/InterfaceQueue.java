/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author ydavpacat
 */
public interface InterfaceQueue<T> {
    void enqueue (T t);
    T dequeue(); 
    T first();
    boolean isEmpty();
}
