/*
 * Viikkoharjoitus 5, tehtävä 7.
 *
 * Olio-ohjelmoinnin perusteet I, kevät 2019. Jorma Laurikkala, jorma.laurikkala@tuni.fi.
 *
 * Abstrakti voimalaa mallintava luokka.
 * 
 * Muokannut: Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 */

public abstract class Voimala implements Comparable<Voimala> {

   /*
    * Attribuutit.
    *
    */

   // Voimalan teho megawatteina.
   private double teho;

   /*
    * Rakentajat.
    *
    */

   public Voimala(double mw) {
      teho(mw);
   }

   /*
    * Aksessorit.
    *
    */

   public double teho() {
      return teho;
   }

   public void teho(double mw) {
      if (mw >= 0) {
         teho = mw;
      }
   }
   
   /*
    * Rajapinnasta toteutetut metodit
    */
   
   @Override
   public int compareTo(Voimala v) {
      // Voimalan teho on pienempi kuin parametrina saadulla oliolla
      if (teho < v.teho()) {
         return -1;
      }
      // Voimala oliot ovat yhtä tehokkaita
      else if (teho == v.teho()) {
         return 0;
      }
      // Voimalan teho on suurempi kuin parametrina saadulla oliolla
      else {
         return 1;
      }
   }

   /*
    * Abstraktit metodit.
    *
    */

   /* Luonnehtii näytölle tulostamalla kuinka voimala hajoaa.
    */
   public abstract void hajoa();
}
