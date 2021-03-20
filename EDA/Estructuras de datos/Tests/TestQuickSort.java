package Tests;

import java.util.Random;

import Algorithm.Sort;

public class TestQuickSort {
    public static void main(String[] args) {
        System.out.println("------Quick Sort-----");
        Random gen = new Random();
        int n = 1000000; 
        
        Integer [] vect = new Integer[100];

        System.out.println("\nDesordenado \n--------------");
        for (int i = 0; i < 100; i++) {
            vect[i] = gen.nextInt(100);
            if(i % 10 == 0)
                System.out.println();
            System.out.print(vect[i] + " -> ");
        }
        Sort.quickSort(vect);
        System.out.println("\nOrdenado \n--------------");
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
            Sort.quickSort(vec);
            long t_fin = System.nanoTime();

            long t_aux = (t_fin - t_ini)/1000000;
            System.out.print("\nSize: " + size + "\ttime: " + t_aux + " ms");

        }
    }
    
    
}
