package librerias.estructurasDeDatos.jerarquicos;

import librerias.estructurasDeDatos.modelos.ArbolBinarioBusqueda;
import librerias.estructurasDeDatos.jerarquicos.NodoABB;

public class ABB<E extends Comparable<E>> implements ArbolBinarioBusqueda<E> {
    NodoABB<E> raiz;

    public ABB() {
        raiz = null;
    }

    public ABB(E e) {
        raiz = new NodoABB<E>(e);
    }

    public void insertar(E e) {
        if (e == null) return;
        if (raiz == null)
            raiz = new NodoABB<E>(e);
        else
            insertar(raiz,e);
    }

    private void insertar(NodoABB<E> nodo, E e) {
        int comp = e.compareTo(nodo.dato);
        if (comp < 0) {
            if (nodo.izq == null)
                nodo.izq = new NodoABB<E>(e);
            else
                insertar(nodo.izq,e);
        }
        else if (comp > 0) {
            if (nodo.der == null)
                nodo.der = new NodoABB<E>(e);
            else
                insertar(nodo.der,e);
        }
    }

    public void borrar(E e) {
        if (e == null || raiz == null)
            return;
        if (raiz.dato.equals(e)) {
            if (raiz.izq != null && raiz.der != null) {
                NodoABB<E> max = maxNodo(raiz.izq);
                max.der = raiz.der;
                raiz = raiz.izq;
                // alternativa:
                //NodoABB<E> min = minNodo(raiz.der);
                //min.izq = raiz.izq;
                //raiz = raiz.der;
            }
            else if (raiz.izq != null)
                raiz = raiz.izq;
            else //raiz.der != null
                raiz = raiz.der;
        }
        else
            borrar(raiz,null,e);
    }

    private void borrar(NodoABB<E> nodo, NodoABB<E> aux, E e) {
        if (nodo == null)
            return;
        int comp = e.compareTo(nodo.dato);
        if (comp == 0) {
            if (aux.izq == nodo) { //el nodo a eliminar es hijo izq de aux
                if (nodo.izq == null && nodo.der == null)
                    aux.izq = null;
                else if (nodo.izq == null && nodo.der != null)
                    aux.izq = nodo.der;
                else if (nodo.izq != null && nodo.der == null)
                    aux.izq = nodo.izq;
                else {
                    E min = min(nodo.der);
                    borrar(nodo.der,nodo,min);
                    nodo.dato = min;
                }
            }
            else if (aux.der == nodo) { //el nodo a eliminar es hijo der de aux
                if (nodo.izq == null && nodo.der == null)
                    aux.der = null;
                else if (nodo.izq == null && nodo.der != null)
                    aux.der = nodo.der;
                else if (nodo.izq != null && nodo.der == null)
                    aux.der = nodo.izq;
                else {
                    E min = min(nodo.der);
                    borrar(nodo.der,nodo,min);
                    nodo.dato = min;
                }
            }
        }
        else if (comp < 0) // e < nodo.dato
            borrar(nodo.izq,nodo,e);
        else // e > nodo.dato
            borrar(nodo.der,nodo,e);
    }

    public boolean buscarIter(E e) {
        if (e == null)
            return false;
        NodoABB<E> aux = raiz;
        while (aux != null) {
            int comp = e.compareTo(aux.dato);
            if (comp == 0)
                return true;
            else if (comp < 0)
                aux = aux.izq;
            else 
                aux = aux.der;
        }
        return false;
    }

    public boolean buscar(E e) {
        if (e == null)
            return false;
        return buscar(raiz,e);
    }

    private boolean buscar(NodoABB<E> nodo, E e) {
        if (nodo == null)
            return false;
        int comp = e.compareTo(nodo.dato);
        if (comp == 0)
            return true;
        else if (comp < 0)
            return buscar(nodo.izq,e);
        else 
            return buscar(nodo.der,e);
    }

    public boolean esVacia() {
        return raiz == null;
    }

    public int talla() {
        return talla(raiz);
    }

    private int talla(NodoABB<E> aux) {
        if (aux == null)
            return 0;
        return 1 + talla(aux.izq) + talla(aux.der);
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(NodoABB<E> aux) {
        if (aux == null)
            return 0;
        int alt_izq = altura(aux.izq);
        int alt_der = altura(aux.der);
        return 1 + Math.max(alt_izq,alt_der);
    }

    public String preOrden() {
        return preOrden(raiz);
    }

    private String preOrden(NodoABB<E> aux) {
        String res = "";
        if (aux != null) {
            res += aux.dato.toString() + " ";
            res += preOrden(aux.izq);
            res += preOrden(aux.der);
        }
        return res;
    }

    public String inOrden() {
        return inOrden(raiz);
    }

    private String inOrden(NodoABB<E> aux) {
        String res = "";
        if (aux != null) {
            res += inOrden(aux.izq);
            res += aux.dato.toString() + " ";
            res += inOrden(aux.der);
        }
        return res;
    }

    public String postOrden() {
        return postOrden(raiz);
    }
    
    private String postOrden(NodoABB<E> aux) {
        String res = "";
        if (aux != null) {
            res += postOrden(aux.izq);
            res += postOrden(aux.der);
            res += aux.dato.toString() + " ";
        }
        return res;
    }

    public E minIter() {
        if (raiz == null)
            return null;
        NodoABB<E> aux = raiz;
        while (aux.izq != null) {
            aux = aux.izq;
        }
        return aux.dato;
    }

    public E min() {
        if (raiz == null)
            return null;
        return min(raiz);
    }

    private E min(NodoABB<E> nodo) {
        if (nodo.izq != null)
            return min(nodo.izq);
        return nodo.dato;
    }

    private NodoABB<E> minNodo(NodoABB<E> nodo) {
        if (nodo.izq != null)
            return minNodo(nodo.izq);
        return nodo;
    }

    public E maxIter() {
        if (raiz == null)
            return null;
        NodoABB<E> aux = raiz;
        while (aux.der != null) {
            aux = aux.der;
        }
        return aux.dato;
    }

    public E max() {
        if (raiz == null)
            return null;
        return max(raiz);
    }

    private E max(NodoABB<E> nodo) {
        if (nodo.der != null)
            return max(nodo.der);
        return nodo.dato;
    }

    private NodoABB<E> maxNodo(NodoABB<E> nodo) {
        if (nodo.der != null)
            return maxNodo(nodo.der);
        return nodo;
    }

    public E sucesor(E e) {
        if (e == null)
            return null;
        return sucesor(raiz,null,e);
    }

    private E sucesor(NodoABB<E> nodo, NodoABB<E> aux, E e) {
        if (nodo == null)
            return null;
        int comp = e.compareTo(nodo.dato);
        if (comp == 0) {
            if (nodo.der != null)
                return min(nodo.der);
            return aux != null?aux.dato:null;
        }
        else if (comp < 0)  //e < nodo.dato
            return sucesor(nodo.izq,nodo,e);
        return sucesor(nodo.der,aux,e);
    }

    public E predecesor(E e) {
        if (e == null)
            return null;
        return predecesor(raiz,null,e);
    }

    private E predecesor(NodoABB<E> nodo, NodoABB<E> aux, E e) {
        if (nodo == null)
            return null;
        int comp = e.compareTo(nodo.dato);
        if (comp == 0) {
            if (nodo.izq != null)
                return max(nodo.izq);
            return aux != null?aux.dato:null;
        }
        else if (comp < 0)  //e < nodo.dato
            return predecesor(nodo.izq,aux,e);
        return predecesor(nodo.der,nodo,e);
    }
}
