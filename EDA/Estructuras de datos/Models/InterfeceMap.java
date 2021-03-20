package Models;

public interface InterfeceMap <K,V> {
    V insert(K key ,V value);
    V delete(K key); 
    V recove(K key);
    boolean isEmpty();
    int size();
    InterfaceList<K> keys();  
}