package aplicaciones.impresora;

import librerias.estructurasDeDatos.modelos.Cola;
import librerias.estructurasDeDatos.lineales.ArrayCola;

/** Clase ServidorCola: implementa un ServidorDeImpresion
 *  que usa un modelo FIFO (Cola) para gestionar los trabajos
 *  a la espera de ser impresos que almacena.
 *  
 *  @author (EDA-QB)
 *  @version (Curso 2020-2021)
 */

public class ServidorCola implements ServidorDeImpresion {
    
    // Un ServidorCola TIENE UNA Cola c de Trabajos 
    // a la espera de ser impresos
    private Cola<Trabajo> c;   
    
    /** Crea un Servidor de Impresion vacio. */
    public ServidorCola() { c = new ArrayCola<Trabajo>(); }
    
    /** Incluye un nuevo Trabajo t en un ServidorDeImpresion.
     *  @param t   Trabajo
     */
    public void insertar(Trabajo t) { c.encolar(t); }
    
    /** Comprueba si hay algun Trabajo a imprimir en un ServidorDeImpresion.
     *  @return boolean
     */
    public boolean hayTrabajos() { return !c.esVacia(); }
    
    /** SII hayTrabajos(): devuelve el Trabajo de un ServidorDeImpresion
     *  que va a ser impreso.
     *  @return Trabajo
     */
    public Trabajo getTrabajo() { return c.primero(); }
    
    /** SII hayTrabajos(): elimina de un ServidorDeImpresion el 
     *  Trabajo que va a ser impreso y devuelve el tiempo que 
     *  este tardara en imprimirse, en base a la velocidad de la impresora.
     *  @return int (seg.)
     */
    public int imprimirTrabajo() {
        Trabajo t = c.desencolar();
        int tiempoImpresion = 
            (int) (Math.round(60.0 * t.getNumPaginas() / PAGINAS_POR_MINUTO));
        return tiempoImpresion;
    }
}
