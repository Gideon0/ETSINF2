package ejemplos;

import librerias.estructurasDeDatos.modelos.ListaPI;
import librerias.estructurasDeDatos.lineales.LEGListaPI;

import librerias.estructurasDeDatos.modelos.ColaPrioridad;
import librerias.estructurasDeDatos.jerarquicos.MonticuloBinario;

public class EjerciciosT5 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        System.out.println("\n - Ejercicio 1 - ");
        Integer[] v = { 5, 9, 23, 1, 42, 35, 42, 12, 3, 7 };

        System.out.println("Vector desordenado: " + toStringV(v));
        cPSort(v);
        System.out.println("Vector sordenado:   " + toStringV(v));
        
        System.out.println("\n - Ejercicio 2 - ");
        //Integer[] v1 = { 1, 3, 5, 7, 9, 11, 7, 15, 17, 19 };
        //Integer[] v2 = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };

        Integer[] v1 = { 8, 9, 10, 12 };
        Integer[] v2 = { 5, 7, 11, 13 };

        ColaPrioridad<Integer> cP1 = new MonticuloBinario<Integer>(v1);
        ColaPrioridad<Integer> cP2 = new MonticuloBinario<Integer>(v2);
        
        ListaPI<Integer> lista = ((MonticuloBinario<Integer>)cP2).caminoDesdeLaMenorHoja();
        System.out.println("Camino menor hoja de cP2: " + toStringL(lista));

        lista = cpFusionarMax(cP1, cP2);
        System.out.println("Colas fusionadas: " + toStringL(lista));

        
        System.out.println("\n - Ejercicio 3 - ");
        Double[] v3a = { 0.3, 0.31, 0.34};
        Double[] v3b = { 0.3, 0.31, 0.37};

        ColaPrioridad<Double> cP3a = new MonticuloBinario<Double>(v3a);
        ColaPrioridad<Double> cP3b = new MonticuloBinario<Double>(v3b);

        System.out.println("esLineal cP3a: " + cPEsLineal(cP3a, 0.05));
        System.out.println("esLineal cP3b: " + cPEsLineal(cP3b, 0.05));

        System.out.println("\n - Ejercicio 4 - ");
        cP1 = new MonticuloBinario<Integer>(v1);
        int iguales = ((MonticuloBinario<Integer>)cP1).igualesA(7);
        System.out.println("Iguales a 7: " + iguales);
    }

    public static <E> String toStringV(E[] v) {
        String res = "";
        if (v == null)
            return res;
        for (int i = 0; i < v.length; i++)
            res += v[i] + " ";
        return res;
    }

    public static <E> String toStringL(ListaPI lista) {
        String res = "";
        if (lista == null)
            return res;
        
        lista.irInicio();
        while(!lista.esFinal()) {
            res += lista.recuperar().toString() + " ";
            lista.siguiente();
        }
        return res;
    }

    // Ejercicio 1
    //Diseñar un método estático, genérico e iterativo cPSort que, con la ayuda de una Cola de Prioridad, 
    //ordene un array v de elementos Comparable.
    public static <E extends Comparable<E>> void cPSort(E[] v) {
        ColaPrioridad<E> aux = new MonticuloBinario<E>(v.length + 1);
        for (int i = 0; i < v.length; i++) {
            aux.insertar(v[i]);
        }
        
        for(int i = 0; i < v.length; i++) {
            v[i] = aux.eliminarMin();
        }
    }

    //Ejercicio 2
    //Diseñar un método estático, genérico e iterativo cPFusionar que devuelva una Lista Con PI con los datos 
    //de dos Colas de Prioridad dadas, cP1 y cP2, ordenados ascendentemente. El método no puede usar ninguna 
    //EDA auxiliar para calcular su resultado y, además, cP1 y cP2 deben quedar vacías al concluir su ejecución.
    public static <E extends Comparable<E>> ListaPI<E> cpFusionar(ColaPrioridad<E> cP1, ColaPrioridad<E> cP2) {
        ListaPI<E> res = new LEGListaPI<E>();

        while (!cP1.esVacia() && !cP2.esVacia()) {
            if (cP1.recuperarMin().compareTo(cP2.recuperarMin()) <= 0)
                res.insertar(cP1.eliminarMin());
            else
                res.insertar(cP2.eliminarMin());
        }

        while(!cP1.esVacia()) {
            res.insertar(cP1.eliminarMin());
        }

        while(!cP2.esVacia()) {
            res.insertar(cP2.eliminarMin());
        }
        return res;
    }

    public static <E extends Comparable<E>> ListaPI<E> cpFusionarMax(ColaPrioridad<E> cP1, ColaPrioridad<E> cP2) {
        ListaPI<E> res = new LEGListaPI<E>();
        //Asumimos que cP1 y cP2 no están vacías y tienen al menos un elemento
        E e1 = cP1.eliminarMax();
        E e2 = cP2.eliminarMax();

        while (!cP1.esVacia() && !cP2.esVacia()) {
            if (e1.compareTo(e2) >= 0) {
                res.insertar(e1);
                e1 = cP1.eliminarMax();
            }
            else {
                res.insertar(e2);
                e2 = cP2.eliminarMax();
            }
        }

        while(!cP1.esVacia()) {
            if (e2 != null && e2.compareTo(e1) >= 0) {
                res.insertar(e2);
                e2 = null;
            }
            else {
                res.insertar(e1);
                e1 = cP1.eliminarMax();
            }
        }

        while(!cP2.esVacia()) {
            if (e1 != null && e1.compareTo(e2) >= 0) {
                res.insertar(e1);
                e1 = null;
            }
            else {
                res.insertar(e2);
                e2 = cP2.eliminarMax();
            }
        }

        if (e1 != null && e2 != null) {
            if (e1.compareTo(e2) >= 0) {
                res.insertar(e1);
                res.insertar(e2);
            }
            else {
                res.insertar(e2);
                res.insertar(e1);
            }
        }
        else if (e1 != null)
            res.insertar(e1);
        else if (e2 != null)
            res.insertar(e2);
        return res;
    }

    //Ejercicio 3
    //Diseñar un método estático e iterativo cPEsLineal que determine si un conjunto de valores reales 
    //se ajusta (aprox.) a una función lineal creciente usando el siguiente algoritmo: comprobar si la 
    //diferencia entre todo par de valores consecutivos, en orden ascendente, está acotada por un epsilon 
    //dado.

    public static boolean cPEsLineal(ColaPrioridad<Double> cP, double epsilon) {
        double ele1 = cP.eliminarMin();
        while(!cP.esVacia()) {
            double ele2 = cP.eliminarMin();
            if ((ele2 - ele1) > epsilon)
                return false;
            ele1 = ele2;
        }
        return true;
    }
}

    