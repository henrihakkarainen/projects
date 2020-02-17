/*
 * 
 * TaulukkolistaTesti - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 6 - Tehtävä 1
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

// Importataan ArrayList java.util-pakkauksesta
import java.util.ArrayList;

public class TaulukkolistaTesti {
   
   /*
    * Metodissa lasketaan kuinka moneen Integer-tyyppiseen olioon metodille
    * parametrina välitettävässä taulukkolistassa (kokoelma) viitataan. Metodi
    * heittää poikkeuksen, jos parametri on null-arvoinen.
    */
   public static int laskeOlioita(ArrayList<Object> kokoelma)
      throws IllegalArgumentException {
      
      // Jos kokoelma-viite on null-arvoinen, heitetään poikkeus
      if (kokoelma == null) {
         throw new IllegalArgumentException();
      }
      // Alustetaan lukumäärän laskuri
      int maara = 0;
      
      // Iteroidaan kokoelman läpi
      for (Object alkio : kokoelma) {
         // Jos käsiteltävä tietoalkio on Integer-tyyppinen, niin kasvatetaan määrää
         if (alkio instanceof Integer) {
            maara += 1;
         }
      }
      // Palautetaan tulos
      return maara;
   }
   
   public static void main(String[] args) {
      
      // Luodaan taulukkolista
      ArrayList<Object> taulukkolista = new ArrayList<Object>();
      
      // Lisätään taulukkolistaan viitteitä
      taulukkolista.add(5);
      taulukkolista.add('X');
      taulukkolista.add("abc");
      taulukkolista.add(68);
      taulukkolista.add(5.2);
      taulukkolista.add("testi");
      
      // Kääritään alla oleva try-catchin sisälle, koska laskeOlioita-metodi voi
      // heittää poikkeuksen.
      try {
         int lukujenLkm = laskeOlioita(taulukkolista);
         System.out.println("Taulukkolistassa on " + lukujenLkm + " kappaletta Integer-"
                           + "tyyppisiä olioita.");
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      
   }
}
