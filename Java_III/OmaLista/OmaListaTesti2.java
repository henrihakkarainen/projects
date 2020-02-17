/*
 * 
 * ListaTesti2 - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 7 - Tehtävä 2
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 *
 */

import java.util.LinkedList;

public class ListaTesti2 {
   
   /*
    * Apumetodi, jolla saadaan tulostettua listan alkiot, eli voidaan seurata
    * pääohjelman listalla tapahtuvia muutoksia.
    */
   public static void tulosta(OmaLista<Object> lista, int lkm) {
      // Tulostetaan listan alkiot, jos lkm > 0, eli joitain arvoja oli korjattu
      if (lkm > 0) {
         System.out.println("Korvattu " + lkm + " arvoa listasta.");
         System.out.print("[ ");
         for (Object o : lista) {
            System.out.print(o + " ");
         }
         System.out.println("]");
      }
      // Jos listalla ei ollut arvoja korvattavaksi, tulostetaan ilmoitus siitä
      else {
         System.out.println("Listalla ei ollut korvattavia arvoja.");
      }
   }
   
   public static void main(String[] args) {
      
      // Luodaan OmaLista-tyyppinen olio, joka varattu Object-tyyppisille viitteille
      OmaLista<Object> alkiot = new OmaLista<Object>();
      
      // Lisätään listaan olioita
      alkiot.add(null);
      alkiot.add(42);
      alkiot.add('A');
      alkiot.add(5.3);
      alkiot.add('A');
      alkiot.add(null);
      
      // Tulostetaan lista alkutilanteessa
      System.out.print("[ ");
         for (Object o : alkiot) {
            System.out.print(o + " ");
         }
      System.out.println("]");
      
      // Kutsutaan korvaa - metodia (korvataan merkki 'A' merkillä 'B').
      System.out.println("Tehdään arvojen muutoksia...");
      int korvattujenLkm = alkiot.korvaa('A', 'B');
      
      tulosta(alkiot, korvattujenLkm);
      
      // Kutsutaan korvaa - metodia uudelleen (korvataan null-arvot itsellään,
      // eli null-arvolla.
      System.out.println("Tehdään arvojen muutoksia...");
      korvattujenLkm = alkiot.korvaa(null, null);
      
      tulosta(alkiot, korvattujenLkm);
      
      // Kutsutaan korvaa - metodia uudelleen (korvataan null-arvot
      // merkkijonolla "ei null").
      System.out.println("Tehdään arvojen muutoksia...");
      korvattujenLkm = alkiot.korvaa(null, "ei null");
      
      tulosta(alkiot, korvattujenLkm);
      
      // Kutsutaan korvaa - metodia viimeisen kerran (korvataan null-arvot
      // merkkijonolla "def"). Enää ei pitäisi olla null-arvoja listalla, eli
      // paluuarvon pitäisi olla 0.
      System.out.println("Tehdään arvojen muutoksia...");
      korvattujenLkm = alkiot.korvaa(null, "def");
      
      tulosta(alkiot, korvattujenLkm);
   }
}
