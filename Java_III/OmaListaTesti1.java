/*
 * 
 * OmaListaTesti1 - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 6 - Tehtävä 3
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 *
 */

import java.util.LinkedList;

public class OmaListaTesti1 {
   public static void main(String[] args) {
      
      // Luodaan OmaLista-tyyppinen olio, joka varattu Integer-tyyppisille viitteille
      OmaLista<Integer> luvut = new OmaLista<Integer>();
      
      // Lisätään listaan lukuja
      luvut.add(11);
      luvut.add(22);
      luvut.add(33);
      luvut.add(44);
      luvut.add(55);
      
      // Tulostetaan lista alkutilanteessa
      System.out.print("[ ");
         for (int luku : luvut) {
            System.out.print(luku + " ");
         }
      System.out.println("]");
      
      // Kutsutaan omaa vaihdaEkaJaVika-operaatiota
      System.out.println("Vaihdetaan ensimmäisen ja viimeisen luvun paikkaa..");
      boolean onnistui = luvut.vaihdaEkaJaVika();
      
      // Tulostetaan listan alkiot uudelleen
      if (onnistui) {
         System.out.print("[ ");
         for (int luku : luvut) {
            System.out.print(luku + " ");
         }
         System.out.println("]");
      }
      // Jos lukujen vaihto epäonnistuu, tulostetaan virheilmoitus
      else {
         System.out.println("Lukujen vaihto epäonnistui.");
      }
   }
}
