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
public interface InterfaceList<T> {
    void insert (T t);
    void remove ();
    T get();
    void next ();
    void goFirst();
    void goLast();
    boolean isLast();
    boolean isEmpty();
    int size();
  
}
