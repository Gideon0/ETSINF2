package DataStructure;

import Models.InterfaceBinaryTree;
public class ABB<E extends Comparable<E>> implements InterfaceBinaryTree {
    NodeABB<E> raiz;
    @Override
    public void insertar(Comparable e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void borrar(Comparable e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean esVacia() {
        // TODO Auto-generated method stub
        return raiz == null;
    }

    @Override
    public boolean buscar() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int talla() {
        return talla(raiz);
        
    }

    private int talla(NodeABB<E> aux){
        if (aux == null)
            return 0;
        return 1 + talla(aux.izq) + talla(aux.der);
    }

    @Override
    public int altura() {
        return altura(raiz);
    }
    
    private int altura(NodeABB<E> aux){
        if (aux == null)
            return 0;
        int alt_izq = altura(aux.izq);
        int alt_dre = altura(aux.der);

        return 1 + Math.max(alt_dre, alt_izq);
    }

    @Override
    public String preOrder() {
        return null;
    }

    @Override
    public String intOrder() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Comparable min() {
        if (raiz == null){
            return null;
        
        return min(raiz);
    }
    
    private E min(NodeABB<E> aux) {
        if (aux.izq == null)
            return aux.dato;
        return min(aux.izq);
    }

    @Override
    public E max() {
        if (raiz == null)
            return null;
        return max(raiz);
    }

    private E max(NodeABB<E> aux) {
        if (aux.der == null)
            return aux.dato;
        return min(aux.der);
    }
        
}
