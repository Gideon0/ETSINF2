package aplicaciones.pruebasOrdenacion;


 
/**
 * GeneradorDeString(n) permite generar String que tienen
 * iguales los n caracteres iniciales.
 * Ejemplo de uso para crear dos cadenas s1 y s2 que comparten los 
 * primeros 10 caracteres:
 * GeneradorDeString g = new GeneradorDeString(10);
 *  String s1 = g.generar();
 *  String s2 = g.generar();
 *
 * @author (EDA) 
 * @version (Curso 2017-2018)
 */

public class GeneradorDeString {
    
    private int numIg;   // Numero de caracteres iniciales iguales de los String
    private String base; // SubString inicial comun a los String generados
    
    /**
     * Crea un GeneradorDeString cuyos n primeros caracteres 
     * son iguales.
     */
    public GeneradorDeString(int n) {
        this.numIg = n;
        String s = "";
        int desAlea = (int) (Math.random() * 10);
        for (int i = 0; i < numIg; i++) {
            s += (char) ((i + desAlea) % 256 + (int) '0'); 
        }
        this.base = s;
    }

    /**
     * Devuelve un String con sus n primeros caracteres
     * identicos, aunque elegidos al azar.
     */
    public String generar() {
        String s = "";   
        for (int i = 1; i <= (int) (Math.random() * 2 * numIg); i++) {
            s += (char) ((int) (Math.random() * 128) + (int) '0');
        }
        return this.base + s;
    }
}