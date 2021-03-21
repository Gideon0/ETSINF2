package Tests;

import java.util.Random;

import Algorithm.Sort;

public class TestSelection {
    public static void main(String[] args) {
        final int size = 10;

        Integer[] v = new Integer[size];
        Random gen = new Random();

        System.out.println("Desordenado");
        for (int i = 0; i < size; i++){
            v[i] = gen.nextInt();
            System.out.println( "(" + i + "," + v[i] + ")");
        }
        System.out.println();
        
        Integer val = Sort.selection(v,6);
        
        System.out.println("Seleccion:");
        
        for(int i = 0; i < size; i++){
            System.out.println("(" + i + "," + v[i] + ")");
        }
            
        System.out.println("");
        System.out.println("Valor selccionado: " + val);

        Sort.quickSort(v);
        System.out.println("Odenado:");
        
        for (int i = 0; i < size; i++) {
            System.out.println("(" + i + "," + v[i] + ")");
        }
    }
    
}
