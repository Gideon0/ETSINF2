package librerias.estructurasDeDatos.grafos;

import librerias.estructurasDeDatos.modelos.ListaPI;
import librerias.estructurasDeDatos.lineales.LEGListaPI;
import librerias.estructurasDeDatos.modelos.Cola;
import librerias.estructurasDeDatos.lineales.ArrayCola;

public abstract class GrafoL {
    protected int[] visitados;
    protected int ordenVisita;
    protected Cola<Integer> q;

    public abstract int numVertices();
    public abstract int numAristas();
    public abstract boolean existeArista(int u, int v);
    public abstract double pesoArista(int u, int v);
    public abstract void insertarArista(int u, int v);
    public abstract void insertarArista(int u, int v, double p);
    public abstract ListaPI<Adyacente> adyacentesDe(int u);

    public int[] toArrayDFS() {
        int res[] = new int[numVertices()];
        visitados = new int[numVertices()];
        ordenVisita = 0;
        for(int i = 0; i < numVertices(); i++)
            if (visitados[i] == 0)
                res = toArrayDFS(i,res);
        return res;
    }

    private int[] toArrayDFS(int origen, int[] res) {
        visitados[origen] = 1;
        res[ordenVisita++] = origen;
        ListaPI<Adyacente> l = adyacentesDe(origen);
        for(l.irInicio(); !l.esFinal(); l.siguiente()) {
            int destino = l.recuperar().getDestino();
            if (visitados[destino] == 0)
                res = toArrayDFS(destino,res);
        }
        return res;
    }

    public int[] toArrayBFS() {
        int res[] = new int[numVertices()];
        visitados = new int[numVertices()];
        ordenVisita = 0;
        q = new ArrayCola<Integer>();
        for(int i = 0; i < numVertices(); i++) {
            if (visitados[i] == 0)
                res = toArrayBFS(i,res);
        }
        return res;
    }

    private int[] toArrayBFS(int origen, int[] res) {
        visitados[origen] = 1;
        res[ordenVisita++] = origen;
        q.encolar(Integer.valueOf(origen));
        while(!q.esVacia()) {
            int u = q.desencolar().intValue();
            ListaPI<Adyacente> l = adyacentesDe(u);
            for(l.irInicio(); !l.esFinal(); l.siguiente()){
                int v = l.recuperar().getDestino();
                if (visitados[v] == 0) {
                    res[ordenVisita++] = v;
                    visitados[v] = 1;
                    q.encolar(Integer.valueOf(v));
                }
            }
        }
        return res;
    }
}
