package ejemplos;

import librerias.estructurasDeDatos.grafos.Adyacente;
import librerias.estructurasDeDatos.grafos.GrafoLDirigido;
import librerias.estructurasDeDatos.grafos.GrafoLNoDirigido;
import librerias.estructurasDeDatos.modelos.ListaPI;

public class EjerciciosT6 {
    public static void main(String[] args) {
        /*
        GrafoLDirigido g = new GrafoLDirigido(9);
        g.insertarArista(0,1);
        g.insertarArista(0,2);
        g.insertarArista(0,3);
        g.insertarArista(0,4);        
        g.insertarArista(2,1);
        g.insertarArista(2,5);
        g.insertarArista(2,7);
        g.insertarArista(3,2);
        g.insertarArista(3,7);
        g.insertarArista(5,6);
        g.insertarArista(6,1);
        g.insertarArista(7,5);
        g.insertarArista(8,4);
        g.insertarArista(8,7);
        */

        GrafoLNoDirigido g = new GrafoLNoDirigido(5);
        g.insertarArista(0,1,8);
        g.insertarArista(0,2,4);
        g.insertarArista(0,3,2);
        g.insertarArista(0,4,9);
        
        g.insertarArista(1,2,6);
        g.insertarArista(1,3,6);
        g.insertarArista(1,4,5);
        
        g.insertarArista(2,3,4);
        g.insertarArista(2,4,1);
        
        g.insertarArista(3,4,3);
        
        // RECORRIDO EN PROFUNDIDAD
        int[] dfs = g.toArrayDFS();
        String res = "Recorrido en profundidad: { ";
        for(int i = 0; i < dfs.length - 1; i++) {
            res += dfs[i] + ",";
        }
        res += dfs[dfs.length-1];
        System.out.println(res + " }");

        // RECORRIDO EN AMPLITUD
        int[] bfs = g.toArrayBFS();
        res = "Recorrido en amplitud: { ";
        for(int i = 0; i < bfs.length - 1; i++) {
            res += bfs[i] + ",";
        }
        res += bfs[bfs.length-1];
        System.out.println(res + " }");
        
        //KRUSKAL
        GrafoLDirigido g2 = g.kruskal();
        System.out.println(g2.toString());

        // GRADO ENTRADA, SALIDA y TOTAL
        /*
        System.out.println("Grado de entrada del grafo: " + g.gradoEntrada());
        System.out.println("Grado de salida del grafo: " + g.gradoSalida());
        for(int i = 0; i < 9; i++) {
            System.out.println("\nGrado entrada v" + i + ": " + g.gradoEntrada(i));
            System.out.println("Grado salida v" + i + ": " + g.gradoSalida(i));
        }
        */
    }
}

    