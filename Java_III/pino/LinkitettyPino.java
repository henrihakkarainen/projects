// Liitetään pakkaukseen.
package pino;

// Otetaan käyttöön javan linkitetty lista.
import java.util.LinkedList;

// Iterable-rajapinnan metodin korvauksen vuoksi.
import java.util.Iterator;

/*
 * Luento 12.
 *
 * Olio-ohjelmoinnin perusteet I, Jorma Laurikkala.
 *
 * Pino-rajapinnan täydellinen toteutus konkreettisessa luokassa.
 *
 * Alkion tyyppi on parametrisoitu.
 *
 * Pinon koolle asetetaan yläraja. Null-arvot sallitaan.
 *
 * Tietorakenteeksi on valittu LinkedList, koska se on tuttu ja toteuttaa
 * tehokkaasti Deque-rajapinnan pinossa käytetyksi tarkoitetut metodit.
 *
 */

public class LinkitettyPino<E> extends AbstraktiPino<E> {

   /*
    * Attribuutit.
    *
    */

   // Tietorakenne alkioiden tallentamiseen. Listan tietoalkion tyyppiparametrina
   // käytetään pinon tyyppiparametria.
   private LinkedList<E> alkiot;

   /*
    * Rakentajat.
    *
    */

   public LinkitettyPino(int m) {
      super(m);
      alkiot = new LinkedList<E>();
   }

   /*
    * Aksessorit.
    *
    */

   // Tarvitaan, jotta pinon aksessori voi edetä.
   protected LinkedList<E> alkiot() {
      return alkiot;
   }

   /*
    * Pinon operaatioiden kunnollinen korvaus.
    *
    */

   /* Lisää alkion o pinon päälle, mikäli pinoon mahtuu vielä 
    * uusi alkio. Paluuarvo on false, jos pino on täynnä.
    */
   public boolean lisaa(E o) {
      if (koko() < maxKoko()) {
         // Listan alku vastaa pinon päällystä.
         alkiot.push(o);
         return true;
      }
      else {
         return false;
      }
   }

   /* Palauttaa ja poistaa pinon päällimmäisen alkion, mikäli pinossa
    * on alkioita. Paluuarvo on null, jos pino on tyhjä.
    */
   public E poista() {
      // Listan alku vastaa pinon päällystä.
      if (!onkoTyhja()) {
         return alkiot.pop();
      }
      else {
         return null;
      }
   }

   /* Palauttaa alkioiden lukumäärän (>= 0) pinossa.
    */
   public int koko() {
      return alkiot.size();
   }
   
   /* Palauttaa totuusarvon true, jos pino on tyhjä ja totuusarvon false,
    * jos pinossa on ainakin yksi alkio.
    */
   public boolean onkoTyhja() {
      return alkiot.isEmpty();
   }

   /* Palauttaa pinon päällimmäisen alkion sitä poistamatta,
    * mikäli pino ei ole tyhjä. Paluuarvo on null, jos pino on tyhjä.
    */
   public E ylin() {
      // Listan alku vastaa pinon päällystä.
      return alkiot.peek();
   }

   /*
    * Iterable-korvaus.
    *
    */

   /* Luo pinolle iteraattorin ja palauttaa viitteen siihen.
    */
   @Override
   public Iterator<E> iterator() {
      // Luodaan iteraattori tälle pinolle.
      return new LinkitettyPinoIteraattori<E>(this);
   }
}
