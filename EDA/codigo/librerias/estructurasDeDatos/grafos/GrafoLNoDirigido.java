package librerias.estructurasDeDatos.grafos;

import librerias.estructurasDeDatos.modelos.ListaPI;
import librerias.estructurasDeDatos.lineales.LEGListaPI;

public class GrafoLNoDirigido extends GrafoLDirigido {
    public GrafoLNoDirigido(int numV) {
        super(numV);
    }

    public void insertarArista(int u, int v) {
        if (!existeArista(u,v)) {
            super.insertarArista(u,v,1);
            super.insertarArista(v,u,1);
            numA--;
        }
    }

    public void insertarArista(int u, int v, int p) {
        if (!existeArista(u,v)) {
            super.insertarArista(u,v,p);
            super.insertarArista(v,u,p);
            numA--;
        }
    }

    public GrafoLNoDirigido interseccion(GrafoLNoDirigido g) {
        GrafoLNoDirigido res = new GrafoLNoDirigido(numV);
        ListaPI<Adyacente> l;
        int dest;

        for(int i = 0; i < numV; i++) {
            l = elArray[i];
            for(l.irInicio(); !l.esFinal(); l.siguiente()) {
                dest = l.recuperar().getDestino();
                if (g.existeArista(i,dest))
                    res.insertarArista(i, dest);
            }
        }
        return res;
    }

    public static GrafoLNoDirigido interseccion2(GrafoLNoDirigido g1, GrafoLNoDirigido g2) {
        GrafoLNoDirigido res = new GrafoLNoDirigido(g1.numVertices());
        ListaPI<Adyacente> l;
        int dest;

        for(int i = 0; i < g1.numVertices(); i++) {
            l = g1.adyacentesDe(i);
            for(l.irInicio(); !l.esFinal(); l.siguiente()) {
                dest = l.recuperar().getDestino();
                if (g2.existeArista(i,dest))
                    res.insertarArista(i, dest);
            }
        }
        return res;
    }
}
