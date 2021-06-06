package librerias.estructurasDeDatos.grafos;

import librerias.estructurasDeDatos.modelos.UFSet;

public class ForestUFSet implements UFSet {
    protected int[] elArray;

    public ForestUFSet(int n) {
        elArray = new int[n];
        for(int i = 0; i < elArray.length; i++)
            elArray[i] = -1;
    }

    public int find(int i) {
        if (elArray[i] < 0)
            return i;
        return elArray[i] = find(elArray[i]);
    }

    public void union(int claseI, int claseJ) {
        if (elArray[claseI] == elArray[claseJ]) {
            elArray[claseI] = claseJ;
            elArray[claseJ]--;
        }
        else {
            if (elArray[claseI] < elArray[claseJ]) {
                elArray[claseJ] = claseI;
            }
            else {
                elArray[claseI] = claseJ;
            }
        }
    }
}
