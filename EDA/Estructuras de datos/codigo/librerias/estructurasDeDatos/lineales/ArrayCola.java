package librerias.estructurasDeDatos.lineales;

import librerias.estructurasDeDatos.modelos.*;

public class ArrayCola<E> implements Cola<E> {
    protected E[] elArray;
    protected int finalC;
    protected int principioC;
    protected int talla;
    protected static final int CAPACIDAD_POR_DEFECTO = 10;

    @SuppressWarnings("unchecked")
    public ArrayCola() {
        elArray = (E[]) new Object[CAPACIDAD_POR_DEFECTO];  //coste K
        talla = 0;                                          //coste K
        principioC = 0;                                     //coste K
        finalC = 0;                                         //coste K
    }

    public void encolar(E e) {              //coste N <---
        if (talla == elArray.length)        //coste K
            duplicarArrayCircular();        //coste N <---
        elArray[finalC] = e;                //coste K
        finalC = incrementar(finalC);       //coste K
        talla++;                            //coste K
    }
    
    @SuppressWarnings("unchecked")
    protected void duplicarArrayCircular() {                        //coste N <---
        E[] nuevoArray = (E[]) new Object[elArray.length * 2];      //coste K
        for (int i = 0; i < talla; i++) {                           //coste N <---
            nuevoArray[i] = elArray[principioC];                    //coste K
            principioC = incrementar(principioC);                   //coste K
        }
        elArray = nuevoArray;                                       //coste K
        principioC = 0;                                             //coste K
        finalC = talla;                                             //coste K
    }

    // SII !esVacia()
    public E desencolar() {
        E elPrimero = elArray[principioC];      //coste K
        principioC = incrementar(principioC);   //coste K
        talla--;                                //coste K
        return elPrimero;                       //coste K
    }

    protected int incrementar(int indice) {     //coste K
        indice += 1;                            //coste K
        if (indice == elArray.length)           //coste K
            indice = 0;                         //coste K
        return indice;                          //coste K
    }

    public E primero() {
        return elArray[principioC];             //coste K
    }
    
    public boolean esVacia() {
        return talla == 0;                      //coste K
    }

    public int getTalla() {
        return talla;
    }
}
