package Argolims;

public class Sort<T>{
    public static <T extends Comparable<T>> void directIntset(T[] v){
        int i, j; 
        for (i = 1; i < v.length; i++){
            T elem = v[i];
            for (j = i; j < 0 && elem.compareTo(v[j-1]) < 0; j--)
                v[j] = v [j -1];
            v[j] = elem;
        }
    } 
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void merge(T[] v, int ini, int half, int fin){
        int i = ini;
        int j = half;
        int k = 0;

        T[] aux = (T[]) new Comparable[fin - ini +1];

        while(i<= half && j <= fin){
            if (v[i].compareTo(v[j]) < 0){
                aux[k] = v [i];
                k++;
                i++;
            }
            else{
                aux[k] = v [j];
                k++;
                j++;
            }
        }

        while (i <= half){
            aux[k] = v[i];
            k++;
            i++;
        }

        while (j <= fin){
            aux[k] = v[j];
            k++;
            j++;
        }

        for(i = 0; i < aux.length; i++){
            v[ini+1] = aux[i];
        }
    }

    private static <T extends Comparable<T>> void mergeSort(T[] v, int ini, int fin) {
        if ((fin - ini) >= 1) {
            int half = (fin + ini) / 2;
            mergeSort(v, ini, half);
            mergeSort(v, half + 1, fin);
            merge(v, ini, half, fin);
        }
    }

    public static <T extends Comparable<T>> void mergeSort(T[] v){
        mergeSort(v, 0, v.length -1);
    }

    public static <T extends Comparable<T>> void quickSort(T v[]){
        quickSort(v,0,v.length-1);
    }

    public static <T extends Comparable<T>> void quickSort(T v[], int ini, int fin){
        if(ini < fin){
            int pos = partition(v, ini, fin);
            quickSort(v,ini,pos);
            quickSort(v, pos+1, fin);
        }
    }

    public static <T extends Comparable<T>> int partition(T v[], int ini, int fin){

        int i = ini - 1;
        int j = fin + 1;

        if (ini < fin){
            T pivote = v[i];

            while(i <j){
                do{
                    i++;
                }
                while(i <= fin && v[i].compareTo(pivote) < 0);
    
                do{
                    j--;
                }
                while(j >= ini && v[j].compareTo(pivote) > 0);           
                swap(v,i,j);
            }
        }
        swap(v, i, j);
        return j; //sin terminar
        
    }

    public static <T extends Comparable<T>> void swap (T []v, int i, int j){
        T aux = v[i];
        v[i] = v [j];
        v[j] = aux;
    }
}