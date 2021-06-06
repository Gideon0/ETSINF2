package librerias.estructurasDeDatos.grafos;

import librerias.estructurasDeDatos.modelos.ColaPrioridad;
import librerias.estructurasDeDatos.modelos.ListaPI;
import librerias.estructurasDeDatos.modelos.UFSet;
import librerias.estructurasDeDatos.jerarquicos.MonticuloBinario;
import librerias.estructurasDeDatos.lineales.LEGListaPI;

public class GrafoLDirigido extends GrafoL {
    protected int numV, numA;
    protected ListaPI<Adyacente> elArray[];

    @SuppressWarnings("unchecked")
    
    public GrafoLDirigido(int numV) {
        this.numV = numV;
        this.numA = 0;
        elArray = new ListaPI[numV];
        for (int i = 0; i < numV; i++)
            elArray[i] = new LEGListaPI<Adyacente>();
    }

    public int numVertices() {
        return this.numV;
    }

    public int numAristas() {
        return this.numA;
    }

    public boolean existeArista(int u, int v) {
        ListaPI<Adyacente> l = elArray[u];
        for(l.irInicio(); !l.esFinal(); l.siguiente()) {
            if (l.recuperar().getDestino() == v)
                return true;
        } 
        return false;
    }

    public double pesoArista(int u, int v) {
        ListaPI<Adyacente> l = elArray[u];
        for(l.irInicio(); !l.esFinal(); l.siguiente()) {
            if (l.recuperar().getDestino() == v)
                return l.recuperar().getPeso();
        } 
        return 0.0;
    }

    public void insertarArista(int u, int v) {
        insertarArista(u,v,1);
    }

    public void insertarArista(int u, int v, double p) {
        if (!existeArista(u, v)) {
            elArray[u].insertar(new Adyacente(v,p));
            numA++;
        }
    }

    public ListaPI<Adyacente> adyacentesDe(int u) {
        return elArray[u];
    }

    public int gradoEntrada() {
        int aux [] = new int[numV];
        int res = 0;
        ListaPI<Adyacente> l;

        for(int i = 0; i < numV; i++) {
            aux[i] = 0;
        }

        for(int i = 0; i < numV; i++) {
            l = elArray[i];
            for(l.irInicio();!l.esFinal();l.siguiente()) {
                aux[l.recuperar().getDestino()]++;
            }
        }

        for(int i = 0; i < numV; i++)
            if(res < aux[i])
                res = aux[i];
        return res;
    }

    public int gradoEntrada(int v) {
        int res = 0;
        ListaPI<Adyacente> l;
        for(int i = 0; i < numV; i++) {
            l = elArray[i];
            for(l.irInicio();!l.esFinal();l.siguiente()){
                if(l.recuperar().getDestino() == v)
                    res++;
            }
        }
        return res;
    }

    public int gradoSalida() {
        int res = 0;
        int aux = 0;
        for(int i = 0; i < numV; i++) {
            aux = elArray[i].talla();
            if (res < aux)
                res = aux;
        }
        return res;
    }

    public int gradoSalida(int v) {
        return elArray[v].talla();
    }

    public GrafoLDirigido traspuesto() {
        GrafoLDirigido g = new GrafoLDirigido(numV);
        ListaPI<Adyacente> l;
        for(int i = 0; i < numV; i++) {
            l = elArray[i];
            for(l.irInicio();!l.esFinal();l.siguiente()) {
                g.insertarArista(l.recuperar().getDestino(), i);
            }
        }
        return g;
    }

    public GrafoLDirigido kruskal() {
        GrafoLDirigido res = new GrafoLDirigido(numV);
        ColaPrioridad<Arista> q = new MonticuloBinario<Arista>();
        ListaPI<Adyacente> l;
        UFSet uf = new ForestUFSet(numV);
        for (int i = 0; i < numV; i++) {
            l = elArray[i];
            for(l.irInicio();!l.esFinal();l.siguiente()) {
                Adyacente a = l.recuperar();
                q.insertar(new Arista(i,a.getDestino(),a.getPeso()));
            }
        }
        while(res.numA < res.numV - 1 && !q.esVacia()) {
            Arista a = q.eliminarMin();
            if (uf.find(a.getOrigen()) != uf.find(a.getDestino())) {
                uf.union(uf.find(a.getOrigen()),uf.find(a.getDestino()));
                res.insertarArista(a.getOrigen(),a.getDestino(),a.getPeso());
            }
        }
        return res;
    }

    public String toString() {
        String res = "Vértices: 0 - " + (numV - 1) + "\nAristas: ";
        ListaPI<Adyacente> l;
        for (int i = 0; i < numV; i++) {
            l = elArray[i];
            for(l.irInicio();!l.esFinal();l.siguiente()) {
                Adyacente a = l.recuperar();
                res += "(" + i + "," + a.getDestino() + "," + a.getPeso() + ") ";
            }
        }
        return res;
    }
}
