package aplicaciones.biblioteca;

import librerias.estructurasDeDatos.deDispersion.TablaHash;
import librerias.estructurasDeDatos.modelos.ListaConPI;
import librerias.estructurasDeDatos.lineales.LEGListaConPI;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * TestEficiencia: programa para analizar la eficiencia del Map index que usa 
 * el Buscador de la aplicacion. Como dicho Map esta implementado mediante una 
 * Tabla Hash Enlazada con factor de carga por defecto 0.75 (FC_ESTANDAR = 0.75), 
 * los factores que determinan la eficiencia del Map son los que hacen que el  
 * de carga real de la Tabla,o longitud media de sus cubetas, sea o no menor o 
 * igual que 0.75. A saber:
 ** (a) El metodo hashCode() que se implemente en la clase Termino, 
 **     la clase de la Clave del Map index: cuanto mejor sea, mas bajo
 **     sera el numero de colisiones que se produzcan
 ** (b) La estimacion de la talla que, como maximo, va a tener el Map
 **     index o, equivalentemente, la estimacion de la capacidad de
 **     de la Tabla Hash Enlazada que lo implementa (elArray.length),
 **     pues el factor de carga de la Tabla es talla / elArray.length
 *
 * Por ello, indicando en el primer argumento de su main la base de   
 * la funcion de dispersion polinomial que implementa el metodo hashCode() 
 * de la clase Termino ("31", "1" y "4") y en el segundo si la Tabla Hash 
 * implementa o no la funcion de Rehashing ("CON" o "SIN"), obtiene como 
 * resultados los factores de carga (reales), desviaciones tipicas, 
 * costes promedio de localizacion de una clave e histogramas de ocupacion
 * de 3 Tablas Hash Enlazadas de tallas maximas estimadas:
 ** (1) 22.310, el numero exacto de Terminos que contienen los libros 
 **     de lista10.txt
 ** (2) 11.155, la mitad (aprox.) de la cifra anterior
 ** (3) 112,    la centesima parte (aprox.) de la cifra anterior
 *
 * Analizado dichos resultados, se puede determinar cual es la 
 * Tabla Hash Enlazada mas eficiente que puede implementar el
 * Map index de lista10.txt, i.e. cual es el "mejor" metodo 
 * hashCode() que se puede implementar en Termino y cual es 
 * y la "mejor" estimacion de la talla que, como maximo, debe
 * tener
 * 
 * @author (EDA-QA) 
 * @version (Curso 2020-2021)
 */

public class TestEficiencia {
    
    public static final String FILE_INPUT =  "lista10.txt";
    public static final String DIR_FILE_INPUT = BuscadorDeLaBibl.dirListaLibros;
    public static final String DIR_LIBROS = BuscadorDeLaBibl.dirLibros;
    
    public static final String DIR_OUTPUT = BuscadorDeLaBibl.dirListaLibros + "res";
    public static final String FILE_OUTPUT = DIR_OUTPUT + File.separator + "histo"; 
    
    public static final int NUM_TERMINOS = 22310;
    public static final int[] MAX_TERMINOS = {NUM_TERMINOS,                        //22310
                                             (int) Math.round(NUM_TERMINOS / 2.0), //11155
                                             (int) Math.round(NUM_TERMINOS / (2.0 * 100))}; //112
    
    public static void main(String[] args) {
 
        String baseHashCode; 
        String conRehashing;
        String numRHS = "";
        int numRH = 0;
        if (args.length != 2) { 
            System.out.println("\tNo puedes ejecutar el programa sin indicar:\n "
                               + "\t-La base que usa hashCode() de Termino\n"
                               + "\t-Si la Tabla Hash usa reshashing o no (CON/SIN)");
        }
        else if (args[1].toLowerCase().equals("con") && !TablaHash.REHASHING) {
                System.out.println("\tERROR: la version de la clase TablaHash que usas\n" +
                                   "\t              NO IMPLEMENTA REHASHING           \n" +
                                   "\tPara ejecutar el programa su 2o parametro debe ser \"SIN\"");
        }
        else if (args[1].toLowerCase().equals("sin") && TablaHash.REHASHING) {
                System.out.println("\tERROR: la version de la clase TablaHash que usas\n" +
                                   "\t              IMPLEMENTA REHASHING              \n" +
                                   "\tPara ejecutar el programa su 2o parametro debe ser \"CON\"");
       }
       else {
            baseHashCode = args[0]; 
            conRehashing = args[1].toLowerCase();
            if (conRehashing.equals("con")) { conRehashing = "RH"; }
            else { conRehashing = ""; }
            try {
                int baseHC = Integer.parseInt(baseHashCode);
                File dir = new File(DIR_OUTPUT); dir.mkdir();
                for (int i = 0; i < MAX_TERMINOS.length; i++) {
                
                    // 1.- Construir la Tabla Hash a partir de los terminos
                    // contenidos en los libros de la lista NOM_FILE_INPUT
                    // usando como hashCode una funcion polinomial con base
                    // baseHC, talla NUM_TERMINOS, talla maxima estimada
                    // MAX_TERMINOS[i] y Factor de Carga inicial 0.75
                    TablaHash<Termino, Termino> tH = crearTabla(MAX_TERMINOS[i], baseHC);
                
                    // 2.- Mostrar por pantalla los valores de la Tabla tH 
                    //     construida en la i-esima prueba:
                    // (a) Factor de carga real de la Tabla
                    // (b) Desviacion tipica de las longitudes de las cubetas
                    // (b) Coste promedio de localizar una clave
                    System.out.println("\tTalla Maxima Estimada = " + MAX_TERMINOS[i]);
                    System.out.printf("\tFactor de Carga = %4.3f\n", tH.factorCarga());
                    System.out.printf("\tDesv. Tipica = %4.3f\n", tH.desviacionTipica());
                    
                    if (conRehashing.equals("RH")) {
                        numRH = tH.numeroDeRH();
                        numRHS = String.valueOf(numRH); 
                    }
                    System.out.printf("\tCoste promedio de localizar una clave = %4.3f \n\n", 
                                     tH.costeMLocalizar()); 
       
                    // 3.- Generar y guardar en el subdirectorio DIR_OUTPUT (res) 
                    // el fichero (.txt) con el histograma de ocupacion de tH con 
                    // el siguiente nombre:
                    PrintWriter pw = new PrintWriter(new File(FILE_OUTPUT 
                                                              + "B" + baseHashCode
                                                              + "(" + MAX_TERMINOS[i] + ")"
                                                              + numRHS
                                                              + conRehashing + ".txt"));
                    pw.println(tH.histograma()); 
                    // grafico: gnuplot> plot "histo...txt" using 1:2 with boxes 
                    pw.close(); 
                }
                
            } catch (IOException e) {
                System.err.println("No se ha encontrado el fichero " + FILE_INPUT);
            }
        }
    }
   
    // Crea una Tabla Hash Enlazada de talla maxima estimada maxTerminos
    private static TablaHash<Termino, Termino> crearTabla(int maxTerminos, int baseHC) 
        throws FileNotFoundException {
        
        TablaHash<Termino, Termino> res = new TablaHash<Termino, Termino>(maxTerminos);
        boolean leido = true;  
        Scanner lista = new Scanner(new File(DIR_FILE_INPUT + File.separator + FILE_INPUT));
        //System.out.println("Creando la Tabla Hash de..." + FILE_INPUT);
        //String dirHome = System.getProperty("user.home");
        
        while (lista.hasNext()) {
            String nombreLibro = lista.next();
            leido = extraerClavesDe(DIR_LIBROS + nombreLibro, res, baseHC);
        }   
        if (!leido) { throw new FileNotFoundException(); }
        return res;
    }
    
    // Actualiza la Tabla Hash t con los terminos nuevos que aparecen en nomLibro
    private static boolean extraerClavesDe(String nomLibro, TablaHash<Termino, Termino> t, int baseHC)  {
        boolean res = true;     
        try {            
            Scanner libro = new Scanner(new File(nomLibro)); 
            int posSep = nomLibro.lastIndexOf(File.separator);
            String titulo = nomLibro.substring(posSep + 1);
            //System.out.println("... " + titulo.substring(0, titulo.indexOf(".txt")));
            int numLin = 0;
            while (libro.hasNext()) {
                String linea = libro.nextLine();
                String[] palabras = linea.split(BuscadorDeLaBibl.separadores);
                for (int i = 0; i < palabras.length; i++) {   
                    if (BuscadorDeLaBibl.esTermino(palabras[i])) {
                        Termino clave = new Termino(palabras[i].toLowerCase(), baseHC);
                        Termino valor = t.recuperar(clave);
                        if (valor == null) { 
                            t.insertar(clave, clave);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: no se ha encontrado el fichero del libro " 
                               + nomLibro);
            res = false;     
        }
        return res;
    }
}