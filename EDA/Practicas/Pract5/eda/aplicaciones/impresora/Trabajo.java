package aplicaciones.impresora;

/** Clase Trabajo: representa un trabajo a imprimir.
 *  ATRIBUTOS: 
 *      TIENE UN titulo (String)
 *      TIENE UN numero de paginas (int)
 *      TIENE UN instante de tiempo (en segundos) 
 *      en el que "entra" (es enviado) al servidor 
 *      de impresión (int)
 *      
 *  @author (EDA-QB)
 *  @version (Curso 2020-2021)
 */
 
public class Trabajo implements Comparable<Trabajo>{
    
    private String titulo;
    private int numPaginas;
    private int entraAlServidor;
    
    /** Crea un Trabajo de titulo t, numero de paginas n
     *  e instante en el que "entra" al servidor e.
     *  @param t    String
     *  @param n    int
     *  @param e    int (seg.)
     */
    public Trabajo(String t, int n, int e) {
        titulo = t;
        numPaginas = n;
        entraAlServidor = e;
    }
    
    /** Devuelve el titulo de un Trabajo.
     *  @return String
     */
    public String getTitulo() { return titulo; }
    
    /** Devuelve el numero de paginas de un Trabajo.
     *  @return int
     */
    public int getNumPaginas() { return numPaginas; }
    
    /** Devuelve el instante de tiempo (en seg.) en el que un
     *  un Trabajo "entra" al servidor de impresión.
     *  @return int (seg.)
     */
    public int getEntraAlServidor() { return entraAlServidor; }
 
    /** Devuelve el valor int que resulta de comparar el numero de
     *  paginas de un Trabajo (this) con las de otro. Dicho valor
     *  sera...
     *  ** NEGATIVO si un Trabajo (this) tiene MENOS paginas que el otro,
     *     i.e. si su impresion es MAS prioritaria que la del otro
     *  ** POSITIVO si un Trabajo (this) tiene MAS paginas que otro, 
     *     i.e. si su impresion es MENOS prioritaria que la del otro
     *  ** CERO si ambos Trabajos tienen el mismo numero de paginas
     *  @param otro  Trabajo  
     *  @return int resultado de la comparacion de un Trabajo (this) con otro 
     */
    public int compareTo(Trabajo otro) { 
        return this.getNumPaginas() - otro.getNumPaginas();
    }
    
    /** Devuelve el String que representa un Trabajo en un cierto 
     *  formato texto.
     *  @return String
     */
    public String toString() {
        return titulo + " (" + numPaginas + " pag.) Entra al servidor: " + entraAlServidor;
    }
}

