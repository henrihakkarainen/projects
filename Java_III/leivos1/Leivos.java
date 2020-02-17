/*
 * 
 * Leivos - abstrakti luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 3 - Tehtävä 2
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

package leivos1;

public abstract class Leivos {
   
   /*
    * Ilmentymäattribuutit
    */
   
   private double paino;
   
   /*
    * Rakentajat
    */
   
   // Oletusrakentajassa leivoksen painoksi asetetaan 75 grammaa.
   public Leivos() {
      paino = 75;
   }
   
   // Parametrillisessa rakentajassa paino asetetaan ulkoisen tahon määräämän arvon
   // perusteella, mikäli arvo on oikeellinen (1-1000 grammaa).
   public Leivos(double p) {
      paino(p);
   }
   
   /*
    * Julkiset aksessorit
    */
   
   public double paino() {
      return paino;
   }
   
   public void paino(double p) {
      if (p >= 1 && p <= 1000) {
         paino = p;
      }
   }
   
   
}
