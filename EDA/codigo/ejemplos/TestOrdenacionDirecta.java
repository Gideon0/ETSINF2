package ejemplos;

import librerias.util.Ordenacion;
import java.util.Random;

public class TestOrdenacionDirecta {
    public static void main(String[] args) {
        Random gen = new Random();
        
        /*
        Integer [] vec = new Integer[100];

        System.out.println("\nDesordenado:");
        for (int i = 0; i < 100; i++) {
            vec[i] = gen.nextInt(100);
            System.out.print(vec[i] + " ");
        }

        System.out.println("\n\nOrdenado:");
        Ordenacion.insercionDirecta(vec);

        for (int i = 0; i < 100; i++) {
            System.out.print(vec[i] + " ");
        }

        System.out.println("\n");
        */

        for (int talla = 10000; talla < 100000; talla += 10000) {
            Integer [] vec = new Integer[talla];
            for (int i = 0; i < talla; i++)
                vec[i] = gen.nextInt(100);
            long t_ini = System.nanoTime();
            Ordenacion.insercionDirecta(vec);
            long t_fin = System.nanoTime();
            long t_aux = (t_fin - t_ini)/1000;
            System.out.println("Talla: " + talla + ", tiempo: " + t_aux + " ms");
        }
    }
}
