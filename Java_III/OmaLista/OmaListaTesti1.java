/*
 * 
 * OmaListaTesti1 - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 7 - Tehtävä 1
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 *
 */

import java.util.LinkedList;

public class OmaListaTesti1 {
   public static void main(String[] args) {
      
      // Luodaan OmaLista-tyyppinen olio, joka varattu Object-tyyppisille viitteille
      OmaLista<Object> alkiot = new OmaLista<Object>();
      
      // Lisätään listaan olioita
      alkiot.add(null);
      alkiot.add(42);
      alkiot.add("abc");
      alkiot.add(5.3);
      alkiot.add(null);
      ´
      // Tulostetaan lista alkutilanteessa
      System.out.print("[ ");
         for (Object o : alkiot) {
            System.out.print(o + " ");
         }
      System.out.println("]");
      
      // Kutsutaan omaa poistaNullArvot - metodia
      System.out.println("Poistetaan null-arvot listasta...");
      int poistettujenLkm = alkiot.poistaNullArvot();
      
      // Tulostetaan listan alkiot uudelleen
      if (poistettujenLkm > 0) {
         System.out.println("Poistettu " + poistettujenLkm + " null-arvoa listasta.");
         System.out.print("[ ");
         for (Object o : alkiot) {
            System.out.print(o + " ");
         }
         System.out.println("]");
      }
      // Jos listalla ei ollut null-arvoja poistettavaksi, tulostetaan ilmoitus siitä
      else {
         System.out.println("Listalla ei ollut poistettavia null-arvoja.");
      }
   }
}
