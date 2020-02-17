import java.io.*;
import java.util.*;
/*
 * 
 * LineCounter - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 5 - Tehtävä 6
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class LineCounter {
   /*
    * Operaatio laskee kuinka monta riviä tekstitiedostossa on. Tiedoston nimi
    * saadaan operaation parametrina. Mikäli tiedoston nimi on virheellinen tai
    * operaation suorittamisessa tapahtuu virhe, palautetaan negatiivinen
    * paluuarvo. Muuten palautetaan tiedoston rivien lukumäärä.
    */
   public static int countLines(String tiedosto) {
      int rivienLkm = 0;
      try {
         File tiedostonNimi = new File(tiedosto);
         Scanner lukija = new Scanner(tiedostonNimi);
         while (lukija.hasNextLine()) {
            lukija.nextLine();
            rivienLkm += 1;
         }
         lukija.close();
         return rivienLkm;
      }
      catch (Exception e) {
         return -1;
      }
   }
   
   public static void main(String[] args) {
      System.out.println("Hello! I count lines.");
      if (args.length == 1) {
         int riveja = countLines(args[0]);
         if (riveja > 0) {
            System.out.println("There are " + riveja + " lines.");
         }
         else {
            System.out.println("I could not count.");
         }
      }
      else {
         System.out.println("I could not count.");
      }
   }
}
