package ejemplos;

//import librerias.estructurasDeDatos.lineales.LEGCola;
import librerias.estructurasDeDatos.lineales.ArrayCola;

@SuppressWarnings("deprecation")
public class TestCola {
    public static void main(String[] args){
        ArrayCola<Integer> cola = new ArrayCola<Integer>();
        //LEGCola<Integer> cola = new LEGCola<Integer>();
        System.out.println("Al principio, la cola contiene " + cola.getTalla() + " elementos.");

        for (int i = 0; i < 100; i++){
            cola.encolar((new Integer(i)));
            System.out.println("Después de encolar, la cola contiene " + cola.getTalla() + " elementos.");
            if ((i % 5) == 0){
                cola.desencolar();
                System.out.println("Después de desencolar, la cola contiene " + cola.getTalla() + " elementos.");
            }
        }
    }
}
