/*
 * 
 * OmaLista - luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 6 - Tehtävät 3 & 4
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

import java.util.LinkedList;

public class OmaLista<E> extends LinkedList<E> {
   
   /*
    *                         !!! Tehtävään 3 !!!
    * Metodi vaihtaa listan ensimmäisen ja viimeisen tietoalkion keskenään. Metodi
    * palauttaa totuusarvon true, jos vaihto onnistuu ja totuusarvon false, mikäli
    * lista on vaikkapa tyhjä ja vaihtoa ei voida tehdä.
    */
   public boolean vaihdaEkaJaVika() {
      try {
         // Listan ensimmäisen tietoalkion arvo
         E eka = getFirst();
         // Listan viimeisen tietoalkion arvo
         E vika = getLast();
         
         // Muutetaan ensimmäisen ja viimeisen tietoalkion arvot päikseen
         set(0, vika);
         set((size() - 1), eka);
         
         return true;
      }
      // Jos lista on tyhjä ja vaihto ei onnistu, niin palautetaan false
      catch (Exception e) {
         return false;
      }
   }
   
   /*
    *                         !!! Tehtävään 4 !!!
    * Metodi luo yksiulotteisten Object-tyyppisten viitteiden taulukon, jonka koko
    * on sama kuin listan koko. Metodissa asetetaan taulukon viitteet siten, että
    * taulukon ensimmäinen alkio viittaa listan viimeiseen tietoalkioon, taulukon
    * toinen alkio viittaa listan toiseksi viimeiseen tietoalkioon ja niin edelleen.
    * Lopuksi palautetaan viite taulukkoon. Jos lista on tyhjä, niin paluuarvo on
    * nollan alkion mittainen tyhjä taulukko.
    */
   public Object[] kaanteisestiTaulukkoon() {
      
      // Taulukko saa koon listan koon perusteella
      Object[] kaannetty = new Object[size()];
      
      // Käydään listan alkiot läpi ja sijoitetaan niiden arvot taulukkoon
      // käänteisessä järjestyksessä
      for (int i = 0; i < size(); i++) {
         kaannetty[i] = get(size() - i - 1);
      }
      
      return kaannetty;
   }
   
}
