package aplicaciones;

import librerias.util.Ordenacion;
import java.util.Random;

public class TestSeleccion {
    public static void main(String[] args) {
        final int talla = 10;

        Integer [] v = new Integer[talla];
        Random gen = new Random();

        System.out.println("Desordenado:");
        for (int i = 0; i < talla; i++) {
            v[i] = gen.nextInt(1000);
            System.out.print("(" + i + "," + v[i] + ") ");
        }
        System.out.println("");
        
        Integer val = Ordenacion.seleccion(v, 6);

        System.out.println("Seleccion:");
        for (int i = 0; i < talla; i++) {
            System.out.print("(" + i + "," + v[i] + ") ");
        }
        System.out.println("");
        System.out.println("Valor seleccionado: " + val);

        Ordenacion.quickSort(v);
        System.out.println("Ordenado:");
        for (int i = 0; i < talla; i++) {
            System.out.print("(" + i + "," + v[i] + ") ");
        }
        System.out.println("");
    }
}
