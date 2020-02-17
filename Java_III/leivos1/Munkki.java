/*
 * 
 * Munkki - luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 3 - Tehtävä 1
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

package leivos1;

public class Munkki extends Leivos {
   
   /*
    * Ilmentymäattribuutit
    */
   
   private int tayte;
   
   /*
    * Julkiset luokkavakiot
    */
   
   public static final int EITAYTETTA = 1;
   public static final int MANSIKKAHILLO = 2;
   public static final int OMENAHILLO = 3;
   public static final int MUUTAYTE = 4;
   
   /*
    * Rakentajat
    */
   
   // Oletusrakentajassa munkki saa painonsa yliluokan oletusrakentajasta ja munkin
   // täytteeksi asetetaan mansikkahillo.
   public Munkki() {
      tayte = MANSIKKAHILLO;
   }
   
   // Parametrillisessa rakentajassa munkin paino asetetaan kutsumalla yliluokan
   // rakentajaa muuttujan (p) arvolla ja täyte (t) asetetaan mikäli se on joku
   // ylhäällä määritellyistä luokkavakioista.
   public Munkki(double p, int t) {
      super(p);
      tayte(t);
   }
   
   /*
    * Julkiset aksessorit
    */
   
   public int tayte() {
      return tayte;
   }
   
   public void tayte(int t) {
      if (t == EITAYTETTA || t == MANSIKKAHILLO || t == OMENAHILLO || t == MUUTAYTE) {
         tayte = t;
      }
   }
   
   
}
