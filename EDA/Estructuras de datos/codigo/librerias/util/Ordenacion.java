package librerias.util;

import java.util.Random;

public class Ordenacion<T> {
    public static <T extends Comparable<T>> void insercionDirecta(T v[]) {
        int i, j;
        for (i = 1; i < v.length; i++) {
            T elem = v[i];
            for (j = i; j > 0 && elem.compareTo(v[j-1]) < 0; j--)
                v[j] = v[j-1];
            v[j] = elem;
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T v[]) {
        mergeSort(v,0,v.length-1);
    }

    private static <T extends Comparable<T>> void mergeSort(T v[],int ini, int fin) {
        if ((fin - ini) >= 1) {
            int mitad = (fin + ini) / 2;
            mergeSort(v,ini,mitad);
            mergeSort(v,mitad+1,fin);
            merge(v,ini,mitad,fin);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> void merge(T v[],int ini, int mitad, int fin) {
        int i = ini;
        int j = mitad + 1;
        int k = 0;

        T[] aux = (T[]) new Comparable[fin - ini + 1];

        while(i <= mitad && j <= fin) {
            if (v[i].compareTo(v[j]) < 0) {
                aux[k] = v[i];
                k++;
                i++;
            }
            else {
                aux[k] = v[j];
                k++;
                j++;
            }
        }

        while(i <= mitad) {
            aux[k] = v[i];
            k++;
            i++;
        }

        while(j <= fin) {
            aux[k] = v[j];
            k++;
            j++;
        }

        for(i = 0; i < aux.length; i++)
            v[ini+i] = aux[i];
    }

    public static <T extends Comparable<T>> void quickSort(T v[]) {
        quickSort(v,0,v.length-1);
    }

    private static <T extends Comparable<T>> void quickSort(T v[],int ini, int fin) {
        if (ini < fin) {
            int pos = particion(v,ini,fin);
            quickSort(v,ini,pos);
            quickSort(v,pos+1,fin);
        }
    }

    private static <T extends Comparable<T>> int particion(T v[],int ini, int fin) {
        
        Random gen = new Random();
        int pos_pivote_aleatorio = ini + gen.nextInt(fin - ini + 1);
        intercambiar(v, pos_pivote_aleatorio, ini);
        
        T pivote = v[ini];
 
        int i = ini-1;
        int j = fin +1;

        while (i < j){
            do {
                i++;
            }
            while (i <= fin && v[i].compareTo(pivote) < 0);

            do {
                j--;
            }
            while (j >= ini && v[j].compareTo(pivote) > 0);
            intercambiar(v,i,j);
        }
        intercambiar(v,i,j);
        return j;
    }

    private static <T extends Comparable<T>> void intercambiar(T[]v,int i, int j) {
        T aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    public static <T extends Comparable<T>> T seleccion(T v[], int ie) {
        if (ie < 0 || ie >= v.length)
            return null;
        return seleccion(v,ie,0,v.length-1);
    }

    private static <T extends Comparable<T>> T seleccion(T v[],int ie, int ini, int fin) {
        if (ini == fin)
            return v[ie];
        
        int pos = particion(v, ini, fin);

        if (pos >= ie) {
            return seleccion(v, ie, ini, pos);
        }
        else {
            return seleccion(v, ie, pos+1, fin);
        }
    }
}
