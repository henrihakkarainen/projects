// Liitetään pakkaukseen.
package pino;

/*
 * Luento 12.
 *
 * Olio-ohjelmoinnin perusteet I, Jorma Laurikkala.
 *
 * Määrittelee liittymän abstraktille tietotyypille pino.
 *
 * Alkion tyyppi on parametrisoitu.
 *
 * Null-arvoiset alkiot voivat olla joko sallittuja tai kiellettyjä
 * rajapinnan toteuttavan luokan tarpeiden mukaan.
 *
 */

public interface Pino<E> {

   /*
    * Pinon operaatiot.
    *
    */

   /* Lisää alkion o pinon päälle, mikäli pinoon mahtuu vielä 
    * uusi alkio. Paluuarvo on false, jos pino on täynnä.
    */
   public abstract boolean lisaa(E o);

   /* Palauttaa ja poistaa pinon päällimmäisen alkion, mikäli pinossa
    * on alkioita. Paluuarvo on null, jos pino on tyhjä.
    */
   public abstract E poista();

   /* Palauttaa alkioiden lukumäärän (>=0) pinossa.
    */
   public abstract int koko();

   /* Palauttaa totuusarvon true, jos pino on tyhjä ja totuusarvon false,
    * jos pinossa on ainakin yksi alkio.
    */
   public abstract boolean onkoTyhja();

   /* Palauttaa pinon päällimmäisen alkion sitä poistamatta,
    * mikäli pino ei ole tyhjä. Paluuarvo on null, jos pino on tyhjä.
    */
   public abstract E ylin();
}
