// Liitetään pakkaukseen
package pino;

// Otetaan käyttöön java.util-pakkaus
import java.util.*;

/*
 * 
 * TaulukkoListaPino - luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 6 - Tehtävä 6
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class TaulukkoListaPino<E> extends AbstraktiPino<E> {
   
   /*
    * Attribuutit
    */
   
   private ArrayList<E> pino;
   
   /*
    * Rakentajat
    *
    */

   public TaulukkoListaPino(int m) {
      super(m);
      pino = new ArrayList<E>();
   }
   
   /*
    * Aksessorit
    *
    */

   // Tarvitaan, jotta pinon aksessori voi edetä.
   public ArrayList<E> pino() {
      return pino;
   }
   
   /*
    * Pinon operaatioiden korvaus
    */
   
   /*
    * Lisätään alkio o pinon päälle, jos pinoon mahtuu vielä uusi alkio. Paluuarvo
    * on false, jos pino on täynnä, muuten paluuarvo on true.
    */
   public boolean lisaa(E o) {
      if (koko() < maxKoko()) {
         pino.add(o);
         return true;
      }
      else {
         return false;
      }
   }
   
   /*
    * Mikäli pinossa on alkioita, palauttaa ja poistaa pinon päälimmäisen alkion.
    * Paluuarvo on null, jos pino on tyhjä. Poisto kohdistetaan taulukkolistan
    * viimeiseen tietoalkioon, jotta pinon käsittely olisi tehokkaampaa.
    */
   public E poista() {
      if (!onkoTyhja()) {
         // Listan viimeisen tietoalkion poisto (kohdistetaan viimeiseen indeksiin)
         return pino.remove(koko() - 1);
      }
      else {
         return null;
      }
   }
   
   /*
    * Palauttaa pinon alkioiden lukumäärän.
    */
   public int koko() {
      return pino.size();
   }
   
   /*
    * Palauttaa tiedon siitä, onko pino tyhjä (true, jos pinossa ei ole alkioita ja
    * false, jos pinossa on alkioita).
    */
   public boolean onkoTyhja() {
      return pino.isEmpty();
   }
   
   /*
    * Palauttaa tiedon pinon ylimmästä tietoalkiosta sitä poistamatta. Paluuarvo
    * on null, jos pino on tyhjä.
    */
   public E ylin() {
      if (!onkoTyhja()) {
         return pino.get(koko() - 1);
      }
      else {
         return null;
      }
   }
   
   /* 
    * Luo pinolle iteraattorin ja palauttaa viitteen siihen.
    */
   @Override
   public Iterator<E> iterator() {
      // Luodaan iteraattori tälle pinolle.
      return new TaulukkoListaPinoIteraattori<E>(this);
   }
}
