package ejemplos;

import librerias.estructurasDeDatos.jerarquicos.ABB;
import librerias.estructurasDeDatos.modelos.ArbolBinarioBusqueda;

public class EjerciciosT4 {
    public static void main(String[] args) {
        // Ejercicio 1
        System.out.println("\n- Ejercicio 1 -");
        Integer[] sec1 = { 2, 252, 401, 398, 330, 344, 397, 363 }; //true
        Integer[] sec2 = { 924, 220, 911, 244, 898, 258, 362, 363 }; //true
        Integer[] sec3 = { 925, 202, 911, 240, 912, 245, 363 }; //false
        Integer[] sec4 = { 2, 399, 387, 219, 266, 382, 381, 278, 363 }; //true   
        Integer[] sec5 = { 935, 278, 347, 621, 299, 392, 358, 363 }; //false
        Integer[] sec6 = { 363 }; //true
        Integer[] sec7 = { 2, 252, 401, 398, 330, 344, 397, 362 }; //false
        Integer[] sec8 = { 362 }; //false


        boolean res1 = ejercicio0(sec1,363); 
        boolean res2 = ejercicio0(sec2,363);
        boolean res3 = ejercicio0(sec3,363);
        boolean res4 = ejercicio0(sec4,363);
        boolean res5 = ejercicio0(sec5,363);
        boolean res6 = ejercicio0(sec6,363);
        boolean res7 = ejercicio0(sec7,363);
        boolean res8 = ejercicio0(sec8,363);

        System.out.println("Secuencia 1: " + res1);
        System.out.println("Secuencia 2: " + res2);
        System.out.println("Secuencia 3: " + res3);
        System.out.println("Secuencia 4: " + res4);
        System.out.println("Secuencia 5: " + res5);
        System.out.println("Secuencia 6: " + res6);
        System.out.println("Secuencia 7: " + res7);
        System.out.println("Secuencia 8: " + res8);

        // Ejercicio 2 (dos versiones)
        System.out.println("\n- Ejercicio 2 -");
        Integer sec20[] = new Integer[100];
        for (int i = 0; i < 100; i ++)
            sec20[i] = i;

        String res20 = mapSort0(sec20);
        System.out.println("Resultado (v0): " + res20);
        String res21 = mapSort1(sec20);
        System.out.println("Resultado (v1): " + res21);

        // Ejercicio 3
        System.out.println("\n- Ejercicio 3 -");
        ArbolBinarioBusqueda<String> abb = new ABB<String>();
        abb.insertar("hola");
        abb.insertar("y");
        String texto = "probando hola y adios";
        String res30 = ejercicio3(texto,abb);
        System.out.println("Palabras incorrectas: " + res30);
    }

    public static <T extends Comparable<T>> boolean ejercicio0(T sec[], T valor) {
        if (sec == null || sec.length < 1)
            return false;
        if (sec.length == 1)
            return sec[0].equals(valor);
        
        T max = null;
        T min = null;
        
        for (int i = 1; i <= sec.length - 1; i++) {
            if ((max != null && sec[i].compareTo(max) >= 0) || (min != null && sec[i].compareTo(min) <= 0))
                return false;
            int comp = sec[i].compareTo(sec[i - 1]); 
            if (comp < 0)               //sec[i] < sec[i - 1] (hemos bajado por la izquierda de sec[i-1])
                max = sec[i-1];
            else if (comp > 0)          //sec[i] > sec[i - 1] (hemos bajado por la derecha de sec[i-1])
                min = sec[i-1];
            else return false;
        }
        return sec[sec.length-1].equals(valor);
    }

    //ejercicio 2 (usando el método inOrden que devuelve una secuencia ordenada)
    public static <T extends Comparable<T>> String mapSort0(T v[]) {
        if (v == null)
            return null;
        ArbolBinarioBusqueda<T> abb = new ABB<T>(v[0]);
        for(int i = 0; i <= v.length - 1; i++)
            abb.insertar(v[i]);
        return abb.inOrden();
    }

    //ejercicio 2 (versión alternativa con mínimo y sucesor)
    public static <T extends Comparable<T>> String mapSort1(T v[]) {
        if (v == null)
            return null;
        ArbolBinarioBusqueda<T> abb = new ABB<T>(v[0]);
        for(int i = 0; i <= v.length - 1; i++)
            abb.insertar(v[i]);
        T aux = abb.min();
        String res = "";
        while(aux != null) {
            res += aux.toString() + " ";
            aux = abb.sucesor(aux);
        }
        return res;
    }

    //ejercicio 3 (versión que devuelve String en lugar de ListaConPi)
    public static String ejercicio3(String texto, ArbolBinarioBusqueda<String> m) {
        if (texto == null || texto.length() <= 0)
            return "";
        
        ArbolBinarioBusqueda<String> aux = new ABB<String>();
        String[] palabras = texto.split("\\s+");
        for(int i = 0; i < palabras.length; i++) {
            if (!m.buscar(palabras[i]))
                aux.insertar(palabras[i]);
        }
        return aux.inOrden();
    }
}

    