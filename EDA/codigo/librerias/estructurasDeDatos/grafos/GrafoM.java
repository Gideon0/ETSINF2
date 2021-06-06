package librerias.estructurasDeDatos.grafos;

public class GrafoM {
    private boolean m[][];
    private int nvert;

    public GrafoM(int nvert) {
        m = new boolean[nvert][nvert];
        this.nvert = nvert;
        for(int i = 0; i < nvert; i++)
            for(int j = 0; j < nvert; j++)
                m[i][j] = false;
    }

    public void insertarArista(int u, int v) {
        m[u][v] = true;
    }

    public void eliminarArista(int u, int v) {
        m[u][v] = false;
    }

    public String toString() {
        String s = "";
        for(int i = 0; i < nvert; i++)
            for(int j = 0; j < nvert; j++)
                if(m[i][j])
                    s = s + " " + i + " --> " + j + "\n";
        return s;
    }

    public int gradoEntrada() {
        int max = 0;
        int col = 0;

        for(int i = 0; i < nvert; i++) {
            col = 0;
            for(int j = 0; j < nvert; j++) {
                if (m[j][i])
                    col++;
            }
            if (col > max)
                max = col;
        }
        return max;
    }

    public int gradoSalida() {
        int max = 0;
        int fila = 0;

        for(int i = 0; i < nvert; i++) {
            fila = 0;
            for(int j = 0; j < nvert; j++) {
                if (m[i][j])
                    fila++;
            }
            if (fila > max)
                max = fila;
        }
        return max;
    }

    public int gradoEntrada(int v) {
        int res = 0;
        for(int i = 0; i < nvert; i++) {
            if (m[i][v])
                res++;
        }
        return res;
    }

    public int gradoSalida(int v) {
        int res = 0;
        for(int i = 0; i < nvert; i++) {
            if (m[v][i])
                res++;
        }
        return res;
    }

    public GrafoM traspuesto() {
        GrafoM g = new GrafoM(nvert);
        for(int i = 0; i < nvert; i++) {
            for(int j = 0; j < nvert; i++)
                if(m[i][j])
                    g.insertarArista(j, i);
        }
        return g;
    }
}
