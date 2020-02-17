/*
 * 
 * OmaLista - luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 7 - Tehtävät 1, 2 & 3
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

import java.util.LinkedList;

public class OmaLista<E> extends LinkedList<E> {
   
   /*
    *                            TEHTÄVÄÄN 1
    * Metodi poistaa listalta kaikki null-arvoiset alkiot. Paluuarvona on poistettujen
    * alkoiden lukumäärä. Jos lista on tyhjä tai null-arvoisia alkioita ei ole, niin
    * paluuarvo on nolla.
    */
   public int poistaNullArvot() {
      
      int poistetut = 0;
      int indeksi = 0;
      
      while (contains(null)) {
         indeksi = indexOf(null);
         remove(indeksi);
         poistetut += 1;
      }
      return poistetut;
   }
   
   /*
    *                             TEHTÄVÄÄN 2
    * Metodi hakee listalta tietoalkiot, jotka ovat samoja kuin ensimmäisen
    * parametrin arvo ja korvaa nämä tietoalkiot toisen parametrin arvolla.
    * Paluuarvo on korvattujen tietoalkioiden lukumäärä. Alkio korvataan ja lasketaan
    * mukaan paluuarvoon myös, jos korvattava ja korvaava arvo ovat samat.
    */
   public int korvaa(Object korvattava, E korvaava) {
      
      int korvatut = 0;
      
      // Käydään läpi listan alkiot
      for (int i=0; i < size(); i++) {
         E alkio = get(i);
         // Jos käsiteltävä alkio ja korvattava alkio ovat molemmat null
         // -> asetetaan tilalle korvaava arvo.
         if (alkio == null && korvattava == null) {
            set(i, korvaava);
               korvatut += 1;
   
         }
         // Jos tietoalkio on null-arvoinen, equals-metodin käyttö kaataa ohjelman.
         // Tarkistetaan ettei näin ole ja sitten mikäli listan alkio vastaa
         // korvattavaa arvoa, niin korvataan alkio
         else if (alkio != null && alkio.equals(korvattava)) {
            set(i, korvaava);
            korvatut += 1;
         }
      }
      return korvatut;
   }
   
   /*
    *                             TEHTÄVÄÄN 3
    * Metodi tutkii, ovatko listan tietoalkiot nousevassa järjestyksessä. Metodi
    * palauttaa true-arvon, jos tietoalkiot ovat nousevassa järjestyksessä.
    * Paluuarvo on false, jos järjestys ei ole nouseva, tai listalla on vähemmän
    * kuin kaksi alkiota. Metodi voi heittää NullPointerException-poikkeuksen, jos
    * listalla on null-arvoja tai ClassCastException-poikkeuksen, jos listan alkiota
    * ei voida muuttaa Comparable-tyyppiseksi.
    */
   @SuppressWarnings("unchecked")
   public boolean onkoNouseva() throws NullPointerException, ClassCastException {
      
      boolean nouseva = false;
      
      if (size() < 2) {
         return nouseva;
      }
      
      for (int i=0; i < size() - 1; i++) {
         // Asetetaan tietoalkioihin compareTo-metodin kutsun mahdollistavat
         // apuviitteet.
         Comparable nykyinen = (Comparable) get(i);
         Comparable seuraava = (Comparable) get(i + 1);
         if (seuraava.compareTo(nykyinen) == 1 || seuraava.compareTo(nykyinen) == 0) {
            nouseva = true;
         }
         else {
            return false;
         }
      }
      return nouseva;
   }
}
