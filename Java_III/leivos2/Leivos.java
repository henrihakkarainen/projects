/*
 * 
 * Leivos - abstrakti luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 4 - Tehtävä 2
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

package leivos2;

public abstract class Leivos implements Vanhentuva {
   
   /*
    * Ilmentymäattribuutit
    */
   
   private double paino;
   
   protected int ika;
   
   /*
    * Rakentajat
    */
   
   // Oletusrakentajassa leivoksen painoksi asetetaan 75 grammaa. Leivoksen
   // oletetaan olevan aina tuore, joten ika attribuutin arvoksi asetetaan 0.
   public Leivos() {
      paino = 75;
      ika = 0;
   }
   
   // Parametrillisessa rakentajassa paino asetetaan ulkoisen tahon määräämän arvon
   // perusteella, mikäli arvo on oikeellinen (1-1000 grammaa). Leivoksen oletetaan
   // myös olevan aina tuore, joten ika attribuutin arvoksi asetetaan 0.
   public Leivos(double p) {
      paino(p);
      ika = 0;
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
   
   /*
    * Rajapinnasta toteutettavat metodit
    */
   
   // Metodissa vanhennetaan leivosta yhdellä päivällä.
   public void vanhennu() {
      ika += 1;
   }
   
   // Metodi palauttaa arvon true, jos leivos on yli kolme päivää vanha.
   public boolean onkoVanha() {
      return ika > 3;
   }
   
}
