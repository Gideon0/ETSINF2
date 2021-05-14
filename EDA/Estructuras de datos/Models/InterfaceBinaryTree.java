

package Models;

public interface InterfaceBinaryTree<E extends Comparable<E>> {
    void insertar(E e);
    void borrar(E e);
    boolean esVacia();
    boolean buscar();
    int talla();
    int altura();

    String preOrder();
    String intOrder();

    E min();
    E max();

    
    
}
