package DataStructure;
import Models.InterfaceHeap;
public class HeapLinkedListPi<T> extends LinkedListIP<T> implements InterfaceHeap<T> {
   public HeapLinkedListPi(){
      super();
   }
   public void stack(T t){
      super.goFirst();
      super.insert(t);
   }
   public T unstack(){
      super.goFirst();
      T aux = super.get();
      super.remove();
      return aux;
   }
   public T top(){
      super.goFirst();
      return super.get();
   }
   public boolean isEmpty(){
      return super.isEmpty();
   }
}
