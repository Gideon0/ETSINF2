package ejemplos;

import librerias.estructurasDeDatos.jerarquicos.ABB;

public class TestABB {
    public static void main(String[] args) {
        ABB<Integer> abb = new ABB<Integer>();
        for (int i = 1; i <= 100; i +=2) {
            abb.insertar(i);
        }
        for (int i = 2; i <= 100; i +=2) {
            abb.insertar(i);
        }
        System.out.println("preOrder:\n" + abb.preOrden());
        System.out.println("altura: " + abb.altura());
        System.out.println("talla: " + abb.talla());

        System.out.println("Sucesor: " + abb.sucesor(50));
        System.out.println("Predecesor: " + abb.predecesor(49));
        
        System.out.println("inOrder:\n" + abb.inOrden());
        System.out.println("Borramos el 50");
        abb.borrar(50);
        System.out.println("Borramos el 49");
        abb.borrar(49);
        System.out.println("inOrder:\n" + abb.inOrden());
    }
}
