package Tests;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

import DataStructure.HashTable;
import Models.InterfaceList;

public class TestHashTable {
   public static void main(String[] args) {
       HashTable<String,Integer> table = new HashTable<>(1);

       Scanner file = null; 

       try { 
           file = new Scanner(new File("./Estructuras de datos/Tests/quijote.txt"));
       }
       catch (FileNotFoundException e){
           System.out.println("Error: " + e.getMessage());
           e.printStackTrace();
       }
       
       while (file.hasNext()) {
          String word = file.next();
          Integer appearances = table.recove(word);
          if (appearances == null)
            table.insert(word, 1);
          else{
              appearances ++;
              table.insert(word, appearances);
          }
       }
       
       InterfaceList<String> wordList = table.keys();
       wordList.goFirst();

       while(!wordList.isLast()){
           String word = wordList.get();
           Integer appearence = table.recove(word);
           System.out.println(word + "     \t -> " + appearence + " veces");
           wordList.next();
       }

       System.out.println("Media: " + table.charge_factor());
       System.out.println("Varianza: " + table.variance());
       System.out.println("Cubertas: " + table.theArray.length);
       System.out.println("Numero de palablas diferente: " + table.size());
   } 
}
