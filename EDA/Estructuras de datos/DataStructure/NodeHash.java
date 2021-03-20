package DataStructure;

public class NodeHash <K,V> {
    K key;
    V value;
    NodeHash<K,V> next;

    public NodeHash(K key, V value, NodeHash<K,V> next){
        this.key = key;
        this.value = value;
        this.next = next;
    }
    
}
