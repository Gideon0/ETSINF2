package aplicaciones.biblioteca;

import librerias.estructurasDeDatos.modelos.Map;
import librerias.estructurasDeDatos.modelos.ListaConPI;
import librerias.estructurasDeDatos.deDispersion.TablaHash;
import librerias.estructurasDeDatos.lineales.LEGListaConPI;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * BuscadorDeLaBibl: clase que representa un Buscador eficiente, i.e. con
 * un Indice, de una Biblioteca Digital (BD). Por ello, su funcionalidad 
 * basica es...
 * 1.- INDEXAR: crear el Indice de la biblioteca, representado mediante  
 *     un Map implementado mediante una Tabla Hash Enlazada.
 * 2.- BUSCAR: recuperar del Indice de la biblioteca la informacion que 
 *     exista sobre una palabra dada (Posting List) en ella.
 * 
 * @author (EDA-QA) 
 * @version (Curso 2020-2021)
 */
 
public class BuscadorDeLaBibl {
    
    // Un BuscadorDeLaBibl TIENE...
    
    // UN String listaLibros, el fichero de texto que contiene los nombres de
    // los (ficheros .txt de los) libros de una biblioteca digital. Su valor 
    // por defecto es el que figura a continuacion, por lo que debe cambiarse 
    // si procede 
    protected static String listaLibros =  "lista10.txt"; // "lista.txt"
    
    // UN String dirListaLibros, el directorio donde se ubica listaLibros. 
    // Su valor por defecto es el que figura a continuacion, por lo que debe 
    // cambiarse si procede 
    protected static String dirListaLibros =  "aplicaciones" + File.separator
                                             + "biblioteca" + File.separator;
    
    // UN String dirLibros, el directorio donde se ubican los (ficheros .txt
    // de los) libros de listaLibros. Su valor por defecto es el que figura a  
    // continuacion, por lo que debe cambiarse si procede 
    protected static String dirLibros =   "aplicaciones" + File.separator
                                        + "biblioteca" + File.separator 
                                        + "TXT" + File.separator;
    
    // UN String separadores, la expresion regular que define los  
    // separadores de palabras que aparecen en los libros de listaLibros.    
    // Su valor por defecto es el que figura a continuacion, por lo que  
    // debe cambiarse si procede
    protected static String separadores = 
       "[[ ]*|[,]*|[\\.]*|[\t]*|[:]*|[;]*|[(]*|[)]*|[/]*|[!]*|[?]*|[¿]*|[“]*|[”]*|[+]*]+";

    // UN int maxTerminos, el numero de terminos que, como maximo, contienen  
    // los libros de listaLibros. Su valor por defecto es el que figura a 
    // continuacion, por lo que debe cambiarse si procede
    protected static int maxTerminos =  22310; // 105985 para "lista.txt"
    
    // UN Map index, que representa el Indice de una biblioteca digital.  
    // La clase de sus Claves es Termino y la de sus Valores ListaConPI<Posting>
    protected Map<Termino, ListaConPI<BuscadorDeLaBibl.Posting>> index;
    
    // UN boolean verb, que activa/desactiva el modo "verbose" del buscador. 
    // Su valor por defecto es el que figura a continuacion, por lo que debe
    // cambiarse (a false) si procede
    protected static boolean verb = true; // false;
    
    /**
     * Posting: clase **interna** que representa la informacion asociada a   
     * la aparicion de un Termino de un Indice en un libro, i.e. el titulo   
     * del libro y (el numero de) la linea donde aparece el Termino.
     * 
     * @author (EDA) 
     * @version (Curso 2020-2021)
     */
    public class Posting {
        
        protected String tituloLibro;
        protected int lineaLibro;
        
        /** Crea un Posting del libro de titulo tL y de su numero de linea nL. */
        public Posting(String tL,  int nL) {
            tituloLibro = new String(tL.substring(0, tL.indexOf(".txt")));
            lineaLibro = nL;
        }
    
        /** Devuelve un String con un Posting en formato texto. */
        public String toString() {
            return tituloLibro + ", linea " + lineaLibro + "\n";
        }
    }
    
    /** Crea el Buscador de la BD que forman los libros de listaLibros.
     *  Basicamente, ello supone crear el Indice de la biblioteca 
     *  con, como maximo, maxTerminos. Si no encuentra (el fichero .txt  
     *  de) un libroLanza FileNotFoundException para advertirlo.
     */ 
    public BuscadorDeLaBibl() throws FileNotFoundException { 
        boolean res = true; 
        Scanner fich = new Scanner(new File(dirListaLibros + listaLibros));
        if (verb) { 
            System.out.println("Creando el Indice de la bibilioteca... " + listaLibros);
        }
        
        // Inicializar el Map index que tiene el Buscador usando como tipo 
        // dinamico la clase TablaHash. 
        // NOTA: el constructor de TablaHash requiere como argumento el  
        //       numero de Entradas que, como maximo, contendra la tabla
        index = new TablaHash<Termino, ListaConPI<BuscadorDeLaBibl.Posting>>(maxTerminos);
        while (fich.hasNext()) {
            String nombreLibro = fich.next();
            String fichLibro = dirLibros + nombreLibro;
            res = indexarLibro(fichLibro);
        }
        if (verb) { 
            System.out.println("Terminos del Indice (talla del Map) = " + index.talla());
        }
        if (!res) { throw new FileNotFoundException(); }
    }
    
    /** Devuelve true tras actualizar el Buscador de una BD con los terminos
     *  que contiene fichLibro (fichero .txt). Basicamente, ello supone actualizar 
     *  el Indice de la biblioteca con los terminos de fichlibro.
     *  El metodo devuelve false si fichlibro no existe.
     */ 
    public boolean indexarLibro(String fichLibro) {
        boolean res = true;     
        try {            
            Scanner libro = new Scanner(new File(fichLibro));            
            int posSep = fichLibro.lastIndexOf(File.separator);
            String titulo = fichLibro.substring(posSep + 1);
            if (verb) {
                System.out.println("Indexando libro... " 
                                  + titulo.substring(0, titulo.indexOf(".txt")));
            }
            int numLin = 0;
            while (libro.hasNext()) {
                String linea = libro.nextLine();
                numLin++;
                String[] palabras = linea.split(separadores);
                BuscadorDeLaBibl.Posting nuevo = new Posting(titulo, numLin);
                for (int i = 0; i < palabras.length; i++) {
                    String palabra = palabras[i];
                    if (esTermino(palabra)) {
                        // Actualizar el Map index con el "Posting" 
                        // nuevo asociado a clave.
                        Termino clave = new Termino(palabra.toLowerCase());
                        ListaConPI<BuscadorDeLaBibl.Posting> valor = index.recuperar(clave);
                        if (valor == null) { 
                            valor = new LEGListaConPI<BuscadorDeLaBibl.Posting>(); 
                        }
                        valor.insertar(nuevo);
                        index.insertar(clave, valor);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: no se ha encontrado el libro " + fichLibro);
            res = false;        
        }
        return res;
    }
       
    /**
     * Devuelve en formato texto (String) el resultado de la busqueda del termino
     * asociado a unaPalabra en el Indice de una BD (frecuencia de aparicion del 
     * termino y, en su caso, el listado que contiene los titulos y lineas de los
     * libros de la bibiblioteca en los que aparece, i.e. su Posting List).
     */
    public String buscar(String unaPalabra) { 
        String res = "";
        Termino clave = new Termino(unaPalabra.toLowerCase());
        ListaConPI<BuscadorDeLaBibl.Posting> valor = index.recuperar(clave);
        if (valor == null) {
            res += "La palabra \"" + unaPalabra + "\" no aparece en ningun libro de esta bibilioteca";
        }
        else {
            res += "Encontradas " + valor.talla() + " apariciones de la palabra \"" + unaPalabra 
                   + "\" en...\n" + valor.toString(); 
        }
        return res;
    }
    
    /** Comprueba si unaPalabra es un termino del Indice de una BD, i.e. 
     *  si unaPalabra esta formada por letras del alfabeto castellano en 
     *  minusculas.
     */
    protected static boolean esTermino(String unaPalabra) {
        if (unaPalabra.length() == 0) { return false; }
        for (int i = 0; i < unaPalabra.length(); i++) {
            if (!Character.isLetter(unaPalabra.charAt(i))) { 
                return false; 
            }
        }
        return true;
    }
    
    /** Devuelve una ListaConPI con aquellos terminos del Indice de una BD que 
     *  solo aparecen solo una vez en sus libros, i.e. los llamados "hapax 
     *  legomena" de la BD, o null si no existe ninguno.
     */
    public ListaConPI<Termino> hapax() {
        /* COMPLETAR */
        ListaConPI<Termino> res = new LEGListaConPI();
        ListaConPI<Termino> c = index.claves(); 
        
        ListaConPI<BuscadorDeLaBibl.Posting> valor;
        for(c.inicio(); !c.esFin(); c.siguiente()){
            Termino clave = c.recuperar();
            valor = index.recuperar(clave);
            if (valor.talla() == 1){
                res.insertar(clave);
            } 
        }
        
        if (res.talla() == 0) return null;
        return res;
    }
}    