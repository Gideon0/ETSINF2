package Tests;

import Algorithm.Sort;
import java.util.Random;

public class TestInsertionSort {
    public static void main(String[] args) {
        Random gen = new Random();
        int n = 10000; 
        
        Integer [] vect = new Integer[100];

        System.out.println("\nDesordenado \n--------------");
        for (int i = 0; i < 100; i++) {
            vect[i] = gen.nextInt(100);
            if(i % 10 == 0)
                System.out.println();
            System.out.print(vect[i] + " -> ");
        }
        Sort.insertionSort(vect);
        System.out.println("\n\nOrdenado \n--------------");
        for (int i = 0; i < 100; i++) {
            if(i % 10 == 0)
                System.out.println();
            System.out.print(vect[i] + " -> ");    
        }
        
        for(int size = n; size <= n*10; size += n){
            Integer [] vec = new Integer[size];
            for (int i = 0; i < size; i++)
                vec[i] = gen.nextInt(100);

            long t_ini = System.nanoTime();
            Sort.insertionSort(vec);
            long t_fin = System.nanoTime();

            long t_aux = (t_fin - t_ini)/1000000;
            System.out.print("\nSize: " + size + "\ttime: " + t_aux + " ms");

        }
    }
}
