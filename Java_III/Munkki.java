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
public class Munkki {
   
   /*
    * Ilmentymäattribuutit
    */
   
   private double paino;
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
   
   // Oletusrakentajassa painoksi asetetaan 100 grammaa ja täytteeksi mansikkahillo.
   public Munkki() {
      paino = 100;
      tayte = MANSIKKAHILLO;
   }
   
   // Parametrillisessa rakentajassa annetaan attribuuteille ulkoisen tahon määräämät
   // arvot, mikäli ne ovat oikeelliset.
   public Munkki(double p, int t) {
      paino(p);
      tayte(t);
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
   
   public int tayte() {
      return tayte;
   }
   
   public void tayte(int t) {
      if (t == EITAYTETTA || t == MANSIKKAHILLO || t == OMENAHILLO || t == MUUTAYTE) {
         tayte = t;
      }
   }
   
   
}
