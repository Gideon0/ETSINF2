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
public interface InterfaceHeap<T> {
    public void stack(T t);
    public T unstack();
    public T top();
    public boolean isEmpty();
}
