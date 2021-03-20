package ejemplos;

import librerias.estructurasDeDatos.modelos.ListaPI;
import librerias.estructurasDeDatos.lineales.LEGListaPI;

@SuppressWarnings("deprecation")
public class TestListaPI {
    public static void main(String[] args)
    {
        ListaPI<Integer> lista = new LEGListaPI<Integer>();

        if (lista.esVacia())
            System.out.println("Al principio la lista está vacía");

        for (int i = 0; i < 10; i++)
        {
            Integer aux = new Integer(i);
            lista.insertar(aux);
            System.out.println("Después de insertar, la lista tiene " + lista.talla() + " elementos.");
        }

        while(!lista.esVacia()){
            System.out.println(lista.recuperar());
            lista.eliminar();
            //lista.siguiente();
        }
    }
}
