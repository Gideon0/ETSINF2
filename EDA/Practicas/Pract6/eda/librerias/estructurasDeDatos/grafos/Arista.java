package librerias.estructurasDeDatos.grafos;

/** Clase Arista: representa una arista de un grafo.<br> 
 *  
 *  @version Mayo 2018
 */
 
public class Arista implements Comparable<Arista>{
    
    // UNA Arista TIENE UN vertice origen y UN vertice destino:
    protected int origen;
    protected int destino;
    // UNA Arista TIENE UN peso:
    protected double peso;
    
    /** Crea una arista (v, w) con peso p.
      *
      * @param v  Vertice origen
      * @param w  Vertice destino
      * @param p  Peso
     */
    public Arista(int v, int w, double p) {
       origen = v;
       destino = w;
       peso = p;
        
    }

    /** Devuelve el vertice origen de una arista.
      *
      * @return int vertice origen
     */
    public int getOrigen() {    
        return origen;
    }
    
    /** Devuelve el vertice destino de una arista.
      *
      * @return int vertice destino
     */
    public int getDestino() {  
        return destino;
    }
    
    /** Devuelve el peso de una arista.
      *
      * @return double Peso de la arista
     */
    public double getPeso() {
        return peso; 
    }
    
    /** Devuelve un String que representa una arista
      * en formato (origen, destino, peso)
      *
      * @return  String que representa la arista
     */
    public String toString() {
        return "(" + origen + ", " + destino + ", " + peso + ")"; 
    }
    public int compareTo(Arista a){
         double diferencia = this.peso - a.peso;
         if (diferencia > 0) return 1;
        else if (diferencia < 0) return -1;
        else return 0;
    }
}