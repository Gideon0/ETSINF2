package librerias.estructurasDeDatos.grafos;

public class Arista implements Comparable<Arista> {
    int origen;
    int destino;
    double peso;

    public Arista(int u, int v, double p) {
        origen = u;
        destino = v;
        peso = p;
    }

    public int compareTo(Arista a) {
        return (int)(peso - a.peso);
    }

    public int getOrigen() {
        return origen;
    }

    public int getDestino() {
        return destino;
    }

    public double getPeso() {
        return peso;
    }
}
