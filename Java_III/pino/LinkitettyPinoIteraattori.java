// Liitetään pakkaukseen.
package pino;

// Otetaan käyttöön Iterator-rajapinta ja poikkeus.
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Luento 12.
 *
 * Olio-ohjelmoinnin perusteet I, Jorma Laurikkala.
 *
 * Pinon iteraattori, joka käy pinon läpi päällimmäisestä alkiosta alimmaiseen
 * alkioon.
 *
 * Tyyppiparametri on sama kuin pinon alkion parametri.
 *
 */

public class LinkitettyPinoIteraattori<E> implements Iterator<E> {
   // Viite iteroitavaan pinoon.
   private LinkitettyPino<E> pino;
   
   // Nykyisen paikan indeksiarvo.
   private int nykyisenPaikanIndeksi;
   
   /* Rakentaja, joka saa parametrinaan viitteen iteroitavaan pinoon. Heitetään
    * poikkeus, jos parametri on null.
    */
   public LinkitettyPinoIteraattori(LinkitettyPino<E> iteroitava) throws IllegalArgumentException {
      // Reagoidaan virheelliseen parametrin.
      if (iteroitava == null) {
         throw new IllegalArgumentException("Null-arvoinen pino!");
      }
      
      // Liitetään attribuutti listaolioon.
      pino = iteroitava;
      
      // Aloitetaan ensimmäisestä paikasta.
      nykyisenPaikanIndeksi = 0;
   }
   
   @Override
   public boolean hasNext() {
      // Listalla on vielä käsittelemätön alkio.
      if (nykyisenPaikanIndeksi < pino.koko()) {
         return true;
      }
      // Koko lista on iteroitu.
      else {
         return false;
      }
   }
   
   @Override
   public E next() throws NoSuchElementException {
      // Alkio on saatavilla.
      if (hasNext()) {
         // Asetetaan apuviite nykyiseen alkioon.
         E alkio = pino.alkiot().get(nykyisenPaikanIndeksi);

         // Siirrytään seuraavaan paikkaan.
         nykyisenPaikanIndeksi++;
         
         // Palautetaan viite nykyiseen alkioon.
         return alkio;
      }
      
      // Kaikki alkiot on käsitelty.
      else {
         throw new NoSuchElementException("Pino on käyty läpi!");
      }
   }   
}
