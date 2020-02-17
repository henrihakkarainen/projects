
// Liitetään pakkaukseen.
package pino;

// Iterable-toteutuksen vuoksi.
import java.util.Iterator;

/*
 * Luento 12.
 *
 * Olio-ohjelmoinnin perusteet I, Jorma Laurikkala.
 *
 * Pino-rajapinnan suppein mahdollinen toteutus abstraktissa luokassa.
 *
 * Alkion tyyppi on parametrisoitu.
 *
 * Pinon koolle asetetaan yläraja.
 *
 * Tämän luokan jälkeläisen tulee toteuttaa oma iteraattori ja korvata iterator-
 * metodi, jotta se voidaan käydä läpi for-each-rakenteella.
 *
 */

public abstract class AbstraktiPino<E> implements Pino<E>, Iterable<E> {

   /*
    * Attribuutit.
    *
    */

   // Alkioiden maksimimäärä.
   private int maxKoko;

   /*
    * Rakentajat.
    *
    */

   public AbstraktiPino(int uusiMaxKoko) {
      if (uusiMaxKoko >= 0) {
         maxKoko = uusiMaxKoko;
      }
   }

   /*
    * Aksessorit.
    *
    */

   public int maxKoko() {
      return maxKoko;
   }

   /*
    * Pinon operaatioiden korvaus toteuttamalla.
    *
    */

   public boolean lisaa(E o) {
      return false;
   }

   public E poista() {
      return null;
   }

   public int koko() {
      return 0;
   }

   public boolean onkoTyhja() {
      return true;
   }

   public E ylin() {
      return null;
   }

   /*
    * Iterable-rajapinnan toteutus.
    *
    */

   /* Luo pinolle iteraattorin ja palauttaa viitteen siihen.
    */
   @Override
   public Iterator<E> iterator() {
      return null;
   }
}
