/*
 * Luento 5.
 *
 * Olio-ohjelmoinnin perusteet I, Jorma Laurikkala.
 *
 * Abstrakti nisäkästä mallintava luokka.
 *
 */

public abstract class Nisakas {

   /*
    * Attribuutit.
    *
    */

   // true = elää, false = edesmennyt.
   private boolean elossa;

   // Nisäkkään paino (> 0) kiloina.
   private double paino;

   /*
    * Rakentajat.
    *
    */

   public Nisakas() {
      paino = 0.1;
      elossa = true;
   }

   public Nisakas(boolean e, double p) {
      elossa(e);
      paino(p);
   }

   /*
    * Aksessorit.
    *
    */

   public boolean elossa() {
      return elossa;
   }

   public void elossa(boolean e) {
      elossa = e;
   }

   public double paino() {
      return paino;
   }

   public void paino(double kg) {
      if (kg > 0) {
         paino = kg;
      }
   }

   /*
    * Muut oliometodit.
    *
    */

   /* Syömistä, jonta konkreettisen aliluokan on pakko tarkentaa toteuttamalla
    * tämä metodi.
    */
   public abstract void syo();

   /* Oletetaan suurin osa nisäkkäistä "pieniksi".
    */
   public boolean onkoIso() {
      return false;
   }
}
