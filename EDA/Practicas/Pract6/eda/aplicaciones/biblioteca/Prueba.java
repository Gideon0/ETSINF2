package aplicaciones.biblioteca;
import librerias.estructurasDeDatos.modelos.Map;
import librerias.estructurasDeDatos.modelos.ListaConPI;
import librerias.estructurasDeDatos.deDispersion.TablaHash;
import librerias.estructurasDeDatos.lineales.LEGListaConPI;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Write a description of class Prueba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Prueba
{
    public static void main (String[] args) throws FileNotFoundException {
        BuscadorDeLaBibl buscador10;
        buscador10 = new BuscadorDeLaBibl();
        
        ListaConPI<Termino> hapax10 = buscador10.hapax();
        hapax10.inicio(); 
        Termino t;
        
        t = hapax10.recuperar(); 
        System.out.println("Primero termino: " + t.termino);
        
        hapax10.siguiente();
        hapax10.siguiente();
        t = hapax10.recuperar();
        System.out.println("Tercer termino: " + t.termino);
        
        hapax10.inicio(); 
        String s = hapax10.recuperar().termino;
        
        for(;!hapax10.esFin();hapax10.siguiente()){
            t = hapax10.recuperar();
            s += " , " + t.termino;
        }
        int last = s.lastIndexOf(",");
        String last_item = s.substring(last + 1, s.length());
        System.out.println("Ultimo termino: " + last_item);
        
        
        
    }
}
