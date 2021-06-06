package librerias.estructurasDeDatos.grafos;

public class Adyacente {
    protected int destino;
    protected double peso;

    public Adyacente(int destino, double peso) {
        this.destino = destino;
        this.peso = peso;
    }

    public int getDestino() {
        return this.destino;
    }

    public double getPeso() {
        return this.peso;
    }

    public String toString() {
        return destino + " (" + peso + ") ";
    }
}
