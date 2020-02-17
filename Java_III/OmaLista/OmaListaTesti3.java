/*
 * 
 * OmaListaTesti3 - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 7 - Tehtävä 3
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 *
 */

import java.util.LinkedList;

public class OmaListaTesti3 {
   
   /*
    * Apumetodi, jolla saadaan tulostettua listan alkiot.
    */
   public static void tulosta(OmaLista<? extends Object> lista) {
      System.out.print("[ ");
      for (Object o : lista) {
         System.out.print(o + " ");
      }
      System.out.println("]");
   }
   
   /*
    * Apumetodi, joka tulostaa näytölle tiedon siitä, ovatko listan
    * alkiot nousevassa järjestyksessä.
    */
   public static void nouseva(OmaLista<? extends Object> lista) {
      try {
         if (lista.onkoNouseva()) {
            System.out.println("Listan alkiot ovat nousevassa järjestyksessä.");
         }
         else {
            System.out.println("Listan alkiot eivät ole nousevassa järjestyksessä" +
                               " tai listalla on liian vähän alkioita vertailuun.");
         }
      }
      catch (Exception e) {
         System.out.println("Tapahtui virhe!");
         e.printStackTrace();
      }
   }
   
   public static void main(String[] args) {
      // Luodaan OmaLista-tyyppinen olio, joka varattu Object-tyyppisille viitteille
      OmaLista<Object> alkiot = new OmaLista<Object>();
      
      // Lisätään listaan olioita
      alkiot.add(1.2);
      alkiot.add(2.5);
      alkiot.add(2.5);
      alkiot.add(3.7);
      alkiot.add(3.7);
      
      // Tulostetaan listan alkiot näytölle
      tulosta(alkiot);
      
      // Kutsutaan onkoNouseva - metodia apumetodin kautta.
      nouseva(alkiot);
      
      // Lisätään listan loppuun uusi luku ja katsotaan, onko järjestys enää validi
      alkiot.add(2.2);
      tulosta(alkiot);
      nouseva(alkiot);
      
      // Luodaan uusi lista, joka varataan String-tyyppisille viitteille.
      OmaLista<String> mjonot = new OmaLista<String>();
      
      // Lisätään listaan merkkijonoja
      mjonot.add("abc");
      mjonot.add("def");
      mjonot.add("X");
      
      // Tulostetaan listan alkiot näytölle
      tulosta(mjonot);
      
      // Kutsutaan onkoNouseva - metodia apumetodin kautta.
      nouseva(mjonot);
      
      // Poistetaan mjonot-listan alkupäästä arvoja
      mjonot.remove();
      mjonot.remove();
      tulosta(mjonot);
      nouseva(mjonot);
   }
}
