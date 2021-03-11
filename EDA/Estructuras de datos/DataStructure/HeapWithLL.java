package DataStructure;

import Models.InterfaceHeap;

public class HeapWithLL<T> implements InterfaceHeap<T> {
   private LinkedListIP<T> list;
   public HeapWithLL(){
      list = new LinkedListIP<T>();
   }
   public void stack(T t){
      list.goFirst();
      list.insert(t);
   }
   public T unstack(){
      list.goFirst();
      T aux = list.get();
      list.remove();
      return aux;
   }
   public T top(){
      list.goFirst();
      return list.get();
   }
   public boolean isEmpty(){
      return list.isEmpty();
   }
}
