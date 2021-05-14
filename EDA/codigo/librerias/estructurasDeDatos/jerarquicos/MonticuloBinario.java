package librerias.estructurasDeDatos.jerarquicos;

import librerias.estructurasDeDatos.modelos.ColaPrioridad;
import librerias.estructurasDeDatos.modelos.ListaPI;
import librerias.estructurasDeDatos.lineales.LEGListaPI;

public class MonticuloBinario<E extends Comparable<E>> implements ColaPrioridad<E> {
    private E [] elArray;
    private final int TAM_INICIAL = 10;
    private int talla;

    @SuppressWarnings("unchecked")
    public MonticuloBinario() {
        elArray = (E[]) new Comparable[TAM_INICIAL];
        talla = 0;
    }

    @SuppressWarnings("unchecked")
    public MonticuloBinario(int capacidad) {
        elArray = (E[]) new Comparable[capacidad];
        talla = 0;
    }

    @SuppressWarnings("unchecked")
    public MonticuloBinario(E [] v) {
        elArray = (E[]) new Comparable[v.length + 1];
        talla = v.length;
        //copiamos el vector
        for(int i = 0; i < v.length; i++)
            elArray[i + 1] = v[i];
        //arreglamos la propiedad de orden
        for(int i = talla/2; i >= 1; i--)
            hundir(i);
    }

    private int padre(int pos) { return pos / 2; }
    private int hijoIzq(int pos) { return pos * 2; }
    private int hijoDer(int pos) { return pos * 2 + 1; }

    private void hundir(int pos){
        E aux = elArray[pos];
        int hijo = pos * 2;
        boolean esHeap = false;
        while (hijo <= talla && !esHeap) {
            //en los minHeap elegimos siempre hundir por el hijo menor y en el maxHeap por el mayor
            if (hijo != talla && elArray[hijo + 1].compareTo(elArray[hijo]) < 0)
                hijo++;
            if (elArray[hijo].compareTo(aux) < 0) {
                elArray[pos] = elArray[hijo];
                pos = hijo;
                hijo = pos * 2;
            }
            else
                esHeap = true;
        }
        elArray[pos] = aux;
    }

    @SuppressWarnings("unchecked")
    private void duplicarArray() {
        E [] aux = (E[]) new Comparable[elArray.length*2];
        for(int i = 1; i < elArray.length; i++)
            aux[i] = elArray[i];
        elArray = aux;
    }

    public void insertar(E e) {
        if (talla == elArray.length - 1)
            duplicarArray();
        int pos = ++talla;
        
        while (pos > 1 && e.compareTo(elArray[pos/2]) < 0) {
            elArray[pos] = elArray[pos/2];
            pos = pos/2;
        }
        elArray[pos] = e;
    }
    
    public E recuperarMin() {
        return elArray[1];
    }

    public E recuperarMax() {
        int pos = talla / 2 + 1;
        E res = elArray[pos];
        for (int i = pos + 1; i <= talla; i++)
            if(res.compareTo(elArray[i]) < 0)
                res = elArray[i];
        return res;
    }

    public E eliminarMax() {
        if (talla == 0)
            return null;
        
        //buscamos posicion max
        int max = talla / 2 + 1;
        for (int i = max + 1; i <= talla; i++)
            if(elArray[max].compareTo(elArray[i]) < 0)
                max = i;
        
        E res = elArray[max];

        if (max == talla) {
            elArray[max] = null;
            talla--;
        }
        else {
            //reflotamos max
            while (max > 1 && elArray[talla].compareTo(elArray[max/2]) < 0) {
                elArray[max] = elArray[max/2];
                max = max/2;
            }
            elArray[max] = elArray[talla];
            talla--;
        }
        return res;
    }

    public E eliminarMin() {
        E res = elArray[1];
        elArray[1] = elArray[talla--];
        hundir(1);
        return res;
    }

    public boolean esVacia() {
        return talla == 0;
    }
    
    public boolean buscar(E e) {
        for(int i = 1; i <= talla; i++)
            if (e.equals(elArray[i]))
                return true;
        return false;
    }

    public boolean buscarOptimizado(E e) {
        return buscarOptimizado(e,1);
    }

    private boolean buscarOptimizado(E e, int pos) {
        if (pos > talla || e.compareTo(elArray[pos]) < 0)
            return false;
        if (e.equals(elArray[pos]))
            return true;
        return buscarOptimizado(e,pos * 2) || buscarOptimizado(e,pos * 2 + 1);
    }

    public ListaPI<E> caminoDesdeLaMenorHoja() {
        ListaPI<E> res = new LEGListaPI<E>();
        int pos = talla / 2 + 1;
        // Obtenemos la mínima hoja
        for(int i = pos + 1; i <= talla; i++) {
            if (elArray[pos].compareTo(elArray[i]) > 0)
                pos = i;
        }
        //Recorrer el camino hasta la raíz
        while(pos >= 1) {
            res.insertar(elArray[pos]);
            pos = pos / 2;
        }
        return res;
    }

    //Implementar un método igualesA que devuelva el número de elementos de un minHeap iguales al elemento dado
    public int igualesA(E e) {
        if (talla == 0 || e == null)
            return 0;
        return igualesA(e,1);
    }

    private int igualesA(E e, int pos) {
        if (pos > talla)
            return 0;
        int comp = e.compareTo(elArray[pos]);
        int res = 0; 

        if (comp >= 0)
            res = igualesA(e,pos * 2) + igualesA(e,pos * 2 + 1);
        
        if (comp == 0)
            res++;
        return res;
    }
}