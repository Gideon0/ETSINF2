package librerias.estructurasDeDatos.deDispersion;

import librerias.estructurasDeDatos.modelos.Map;
import librerias.estructurasDeDatos.modelos.ListaConPI; 
import librerias.estructurasDeDatos.lineales.LEGListaConPI;

/**
 * TablaHash: implementacion de una Tabla Hash Enlazada 
 * en la que sus cubetas, o listas de colisiones, se
 * representan mediante Listas con PI de EntradaHash<C, V>
 * 
 * @param <C>  tipo de las Claves del Map que implementa
 * @param <V>  tipo de Valores del Map que implementa
 * 
 * @author (EDA-QA) 
 * @version (Curso 2020-2021)
 */

public class TablaHash<C, V> implements Map<C, V> {
    
    // Una Tabla Hash TIENE:
    
    // UNA CTE JAVA que representa...
    /** El valor (float) del factor de carga estandar (por defecto) de una  
     *  Tabla Hash, el mismo que se usa en la clase java.util.HashMap) */
    public static final double FC_ESTANDAR = 0.75;
    
    // UNA CTE JAVA que representa...
    /** El valor (boolean) que indica si una Tabla Hash realiza 
     *  Rehashing cuando su factor de carga supera FC_ESTANDAR
     */
    public static final boolean REHASHING = true; // en Parte 1 vale false;
    
    // UN array de Listas Con PI de EntradaHash<C, V> elArray:
    // - elArray[h] representa una cubeta, o lista de    
    //   colisiones asociadas al indice Hash h
    // - elArray[h] contiene la referencia a la Lista     
    //   Con PI donde se encuentran todas las Entradas  
    //   cuya Clave tiene un indice Hash h 
    protected ListaConPI<EntradaHash<C, V>>[] elArray;
    
    // UNA talla que representa el numero de Entradas  
    // almacenadas en una Tabla Hash o, equivalentemente, 
    // en sus cubetas
    protected int talla; 
    
    // UN numero de operaciones de Rehashing (int) efectuadas
    // para mejorar el tiempo promedio que tardan en localizarse
    // las claves de sus talla Entradas
    private int numRH;
    
    
    // UN metodo indiceHash que representa la funcion de 
    // Dispersion de la Tabla
    //**SIN ESTE METODO NO SE TIENE UNA TABLA HASH, SOLO UN ARRAY**
    // Devuelve el indice Hash de la Clave c de una Entrada, 
    // i.e. la posicion de la cubeta en la que la que se ubica  
    // la Entrada de Clave c
    protected int indiceHash(C c) {
        int indiceHash = c.hashCode() % this.elArray.length;
        if (indiceHash < 0) { indiceHash += this.elArray.length; }
        return indiceHash;
    }
    
    /** Crea una Tabla Hash vacia, con tallaMaximaEstimada  
     *  Entradas y factor de carga 0.75 */
    @SuppressWarnings("unchecked") 
    public TablaHash(int tallaMaximaEstimada) {
        int capacidad = (int) (tallaMaximaEstimada / FC_ESTANDAR);
        capacidad = siguientePrimo(capacidad);
        elArray = new LEGListaConPI[capacidad];
        for (int i = 0; i < elArray.length; i++) {
            elArray[i] = new LEGListaConPI<EntradaHash<C, V>>();
        }
        talla = 0;
        numRH = 0;
    }
    // Devuelve un numero primo MAYOR o IGUAL a n, 
    // i.e. el primo que sigue a n
    public static final int siguientePrimo(int n) {
        int aux = n;
        if (aux % 2 == 0) { aux++; }
        for ( ; !esPrimo(aux); aux += 2) { ; }
        return aux;
    } 
    // Comprueba si n es un numero primo
    protected static final boolean esPrimo(int n) {
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) { return false; } // n NO es primo
        }
        return true; // n SI es primo
    }
    
    /** Devuelve el factor de carga (real) de una Tabla Hash,   
     *  lo que equivale a la longitud media de sus cubetas en  
     *  una implemetacion Enlazada de la Tabla */
    public final double factorCarga() { 
        return (double) talla / elArray.length; 
    }
    
    /** Comprueba si una Tabla Hash esta vacia,  
     *  i.e. si tiene 0 Entradas */
    public boolean esVacio() { return talla == 0; }
    
    /** Devuelve la talla, o numero de Entradas, 
      * de una Tabla Hash */
    public int talla() { return talla; } 
    
    /** Devuelve el numero de operaciones de Rehashing que, 
      *  en su caso, se hayan efectuado para crear una 
      *  Tabla Hash */
    public int numeroDeRH() { return numRH; } 

    /** Devuelve una ListaConPI con las talla() claves  
     *  de una Tabla Hash */
    public ListaConPI<C> claves() {
        ListaConPI<C> res = new LEGListaConPI<C>();
        for (int i = 0; i < elArray.length; i++) {
            ListaConPI<EntradaHash<C, V>> l = elArray[i];
            for (l.inicio(); !l.esFin(); l.siguiente()) {
                EntradaHash<C, V> e = l.recuperar();
                res.insertar(e.clave); 
            }
        }
        return res;
    }
    
    /** Devuelve un String con las Entradas de una Tabla Hash
     *  en un formato texto dado (ver toString de EntradaHash)
     */
    // RECUERDA: usa la clase StringBuilder por eficiencia
    public final String toString() {
        StringBuilder res = new StringBuilder();
        for (ListaConPI<EntradaHash<C, V>> l : elArray) {
            for (l.inicio(); !l.esFin(); l.siguiente()) {
                res.append(l.recuperar() + "\n");
            }
        }   
        return res.toString(); 
    }
    
    /** Devuelve el valor de la Entrada con Clave c de una 
     *  Tabla Hash, o null si tal entrada no esta en la Tabla */
    public V recuperar(C c) {
        int pos = indiceHash(c);
        ListaConPI<EntradaHash<C, V>> l = elArray[pos];
        V valor = null;
        // Busqueda de la Entrada de Clave c en la cubeta l
        l.inicio();
        while (!l.esFin() && !l.recuperar().clave.equals(c)) { 
            l.siguiente(); 
        }
        // Resolucion de la Busqueda: SII esta en la Tabla, se   
        // recupera el valor la Entrada de Clave c 
        if (!l.esFin()) { valor = l.recuperar().valor; }
        return valor;
    }
    
    /** Elimina la Entrada con Clave c de una Tabla Hash y 
     *  devuelve su valor asociado, o null si tal entrada 
     *  no esta en la Tabla */
    public V eliminar(C c) {
        int pos = indiceHash(c);
        ListaConPI<EntradaHash<C, V>> l = elArray[pos];
        V valor = null; 
        // Busqueda de la Entrada de Clave c en la cubeta l
        l.inicio();
        while (!l.esFin() && !l.recuperar().clave.equals(c)) { 
            l.siguiente(); 
        }
        // Resolucion de la Busqueda: SII esta en la cubeta     
        // l, se recupera el valor de la Entrada de Clave c  
        // y, luego, se elimina de l
        if (!l.esFin()) {
            valor = l.recuperar().valor;
            l.eliminar();
            talla--;
        }
        return valor;
    }
        
    /** Inserta la Entrada (c, v) en una Tabla Hash y   
     *  devuelve el antiguo valor asociado a c, o null 
     *  si tal entrada no esta en la Tabla */
    // Invoca al metodo rehashing() SII
    // - El valor de la constante REHASHING es true
    // AND
    // - TRAS insertar una nueva Entrada en su  
    //   correspondiente cubeta e incrementar la 
    //   talla de la Tabla, factorCarga() > FC_ESTANDAR
    public V insertar(C c, V v) {
        int pos = indiceHash(c);
        ListaConPI<EntradaHash<C, V>> l = elArray[indiceHash(c)];
        V antiguoValor = null;
        // Busqueda de la Entrada de Clave c en la cubeta l
        l.inicio();
        while (!l.esFin() && !l.recuperar().clave.equals(c)) { 
            l.siguiente(); 
        }
        // Resolucion de la busqueda: si la Entrada (c, v) NO
        // esta en la Tabla, se inserta al final de la cubeta
        // l, se incrementa la talla de la Tabla y, en su caso,
        // se efectua Rehashing; sino, si la Entrada ya esta en 
        // l, se actualiza su valor.
        if (l.esFin()) {
            // Insercion efectiva de la Entrada (c, v)
            l.insertar(new EntradaHash<C, V>(c, v));
            talla++;
            
            if (factorCarga() > FC_ESTANDAR && REHASHING) { 
                numRH++;
                rehashing(); 
            }
        }
        else {
            // Recuperacion del valor actual de la Entrada de
            // Clave C, para devolverlo, y actualizacion de 
            // dicho valor a v
            antiguoValor = l.recuperar().valor; l.recuperar().valor = v;
        }
        return antiguoValor;
    }
    // Metodo que implementa el Rehashing. Por motivos obvios, NO se 
    // debe re-inicializar el atributo numRH
    // PERO... OJO!! Para tener en cuenta el coste de las operaciones de 
    // rehashing en el tiempo que, en promedio, tarda en localizarse
    // una de las talla Entradas de una Tabla, el atributo numColisiones
    // TAMPOCO se debe re-inicializar en este metodo
    //
    @SuppressWarnings("unchecked")
    protected final void rehashing() {
        /* COMPLETAR */
        ListaConPI<EntradaHash<C,V>>[] aux = elArray;
        elArray = new LEGListaConPI[siguientePrimo(elArray.length * 2)];
        
        for (int i = 0; i < elArray.length; i++)
            elArray[i] = new LEGListaConPI<>();
        
        for(ListaConPI<EntradaHash<C,V>> lista: aux){
            for (lista.inicio(); !lista.esFin(); lista.siguiente()){
                EntradaHash<C,V> elemento = lista.recuperar();
                elArray[indiceHash(elemento.clave)].insertar(new EntradaHash<>(elemento.clave, elemento.valor));
            }
        }
    }
    
    // Metodos para el analisis de la eficiencia de una 
    // Tabla Hash Enlazada, NO de un Map!!
    
    /** Devuelve la desviacion tipica de las longitudes de las 
     *  cubetas de una Tabla Hash Enlazada */
    public final double desviacionTipica() {
        /* COMPLETAR */
        double media = factorCarga();
        double suma = 0.0;
                                                          
        for (ListaConPI<EntradaHash<C,V>> cub: elArray)
            suma += (cub.talla() - media) * (cub.talla() - media);
        return Math.sqrt(suma/elArray.length);
        
        
    }
    
    /** Devuelve el coste promedio de localizar
     *  una clave de una Tabla Hash Enlazada, 
     *  calculado a partir del numero de 
     *  colisiones que se producen al localizar 
     *  sus talla claves
     */
    public final double costeMLocalizar() {
        /* COMPLETAR */
        double res =0.0; 
        for(ListaConPI<EntradaHash<C,V>> cub: elArray)
            res += (cub.talla() * (cub.talla()+1))/2;
        return res/talla;
    }

    /** Devuelve un String con el histograma de ocupacion 
     *  de una Tabla Hash Enlazada en formato texto. Asi, 
     *  en cada una de sus lineas deben aparecer dos valores 
     *  enteros separados por un tabulador: una longitud de 
     *  cubeta (valor int en el intervalo [0, 9]) y un numero 
     *  de cubetas. 
     *  MUY IMPORTANTE: el numero de cubetas que aparece en
     *  la linea i, ES: 
     ** (a) Si i en [0, 8], el numero de cubetas de la Tabla  
     **     que tienen una longitud i
     ** (b) Si i = 9 (ultima linea), el numero de cubetas de 
     **     la Tabla que tienen una longitud 9 o MAYOR
     */      
    public String histograma() {
        String res = "";
        int[] histo = new int[10];
        for (int i = 0; i < elArray.length; i++) {
            int longCubeta = elArray[i].talla();
            if (longCubeta < 9) { histo[longCubeta]++; }
            else { histo[9]++; }
        }
        for (int i = 0; i < histo.length; i++) {
            res += i + "\t" + histo[i] + "\n";
        }        
        return res;        
    }
}
