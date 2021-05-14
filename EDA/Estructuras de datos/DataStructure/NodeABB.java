package DataStructure;
public class NodeABB<E> {
    E dato; 
    NodeABB<E> izq, der;

    public NodeABB(E e){
        dato = e;
    }

    public NodeABB(E e, NodeABB<E> izq, NodeABB<E> der){
        dato = e;
        this.izq = izq;
        this.der = der;
    }
    
}
