// Liitetään pakkaukseen
package pino;

// Otetaan käyttöön java.util-pakkaus
import java.util.*;

/*
 * 
 * TaulukkoListaPinoIteraattori - luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 6 - Tehtävä 6
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class TaulukkoListaPinoIteraattori<E> implements Iterator<E> {
   
   // Viite iteroitavaan pinoon.
   private TaulukkoListaPino<E> pino;
   
   // Nykyisen paikan indeksiarvo.
   private int nykyisenPaikanIndeksi;
   
   /* 
    * Rakentaja, joka saa parametrinaan viitteen iteroitavaan pinoon. Heitetään
    * poikkeus, jos parametri on null.
    */
   public TaulukkoListaPinoIteraattori(TaulukkoListaPino<E> iteroitava)
      throws IllegalArgumentException {
         
      // Reagoidaan virheelliseen parametrin.
      if (iteroitava == null) {
         throw new IllegalArgumentException("Null-arvoinen pino!");
      }
      
      // Liitetään attribuutti listaolioon.
      pino = iteroitava;
      
      // Aloitetaan viimeisestä paikasta, eli pinon päälimmäisestä alkiosta.
      nykyisenPaikanIndeksi = pino.koko();
   }
   
   @Override
   public boolean hasNext() {
      // Listalla on käsittelemätön alkio
      if (nykyisenPaikanIndeksi > 0) {
         return true;
      }
      // Koko lista on käyty läpi
      else {
         return false;
      }
   }

   @Override
   public E next() throws NoSuchElementException {
      // Alkio on saatavilla.
      if (hasNext()) {
         // Asetetaan apuviite nykyiseen alkioon.
         E alkio = pino.pino().get(nykyisenPaikanIndeksi - 1);

         // Siirrytään seuraavaan paikkaan.
         nykyisenPaikanIndeksi--;
         
         // Palautetaan viite nykyiseen alkioon.
         return alkio;
      }
      
      // Kaikki alkiot on käsitelty.
      else {
         throw new NoSuchElementException("Pino on käyty läpi!");
      }
   }   
}
