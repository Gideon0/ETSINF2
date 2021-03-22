package DataStructure;

import Models.InterfeceMap;
import Models.InterfaceList;

public class HashTable<K,V> implements InterfeceMap <K,V>{
    public NodeHash<K,V> theArray[];
    protected int size;

    
   @SuppressWarnings("unchecked") 
    public HashTable(int numBuckets){
        theArray = new NodeHash[numBuckets];
        size = 0;
    }

    public int f_hash(K key){
        int hash_value = key.hashCode();
        if (hash_value < 0 )
            hash_value = - hash_value;
        return hash_value % theArray.length;
    }

    @SuppressWarnings("unchecked") 
    public void rehashing(){
        NodeHash <K,V> old_theArray[] = theArray;

        theArray = new NodeHash[theArray.length * 2];
        size = 0;

        for(int buk = 0; buk < old_theArray.length; buk++){
            NodeHash<K,V> aux = old_theArray[buk];
            while(aux != null){
                insert(aux.key, aux.value);
                aux = aux.next;
            }
        }
    }
    
    public V insert(K key, V value){
        if (charge_factor() > 1.5){
            rehashing();
        }

        V res = null;
        int buk = f_hash(key);

        NodeHash<K,V> aux = theArray[buk];

        while(aux != null && !key.equals(aux.key))
            aux = aux.next;

        if(aux == null){
            theArray[buk] = new NodeHash<>(key, value,theArray[buk]);
            size++;
        }else {
            res = aux.value;
            aux.value = value;
        }
        return res;
    }
    public V delete(K key){
        int buk = f_hash(key);
        V res = null;

        NodeHash<K,V> aux  = theArray[buk];
        NodeHash<K,V> pre_aux = null;
        while(aux != null && !key.equals(aux.key)){
            pre_aux = aux;
            aux = aux.next;
        }
        if (aux != null){
            res = aux.value;
            if (pre_aux == null)
                theArray[buk] = aux;
            else 
                pre_aux.next = aux.next;
            size--;
        }
        return res;
    }
    
    public V recove(K key){
        int buk = f_hash(key);

        NodeHash<K,V> aux = theArray[buk];
        while (aux != null && !key.equals(aux.key))
            aux = aux.next;
        if(aux == null){
            return null;
        }
        return aux.value;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }
    
    public InterfaceList<K> keys() {
        InterfaceList<K> list = new LinkedListIP<K>();
        
        for (NodeHash<K,V> e: theArray){
            NodeHash<K,V> aux = e;
            while (aux != null){
                list.insert(aux.key);
                aux = aux.next;
            }
        }
        return list;
    }

    public float charge_factor(){
        return size / (float) theArray.length;
    }

    public float variance(){
        float average =charge_factor();
        float sum = 0;

        for (int buk = 0; buk < theArray.length; buk++){
            NodeHash<K,V> aux = theArray[buk];
            int cont = 0;
            while (aux != null){
                cont++;
                aux = aux.next;
            }
            sum += (cont - average) *(cont - average);
        }
        return sum / theArray.length;
    }


} 
