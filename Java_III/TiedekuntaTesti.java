/*
 * 
 * TiedekuntaTesti - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 6 - Tehtävä 5
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class TiedekuntaTesti {
   public static void main(String[] args) {
      
      System.out.println("Hello! The faculties of the University of Tampere are:");
      
      // Otetaan luetellun tyypin arvot talteen taulukkoon
      Tiedekunta[] lyhenteet = Tiedekunta.values();
      
      // Tulostetaan taulukon arvot näytölle
      for (Tiedekunta lyhenne : lyhenteet) {
         System.out.println(lyhenne);
      }
   }
}
