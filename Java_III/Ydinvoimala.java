/*
 * 
 * Ydinvoimala - luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 3 - Tehtävä 3
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class Ydinvoimala extends Voimala {
   
   /*
    * Rakentajat
    */
   
   public Ydinvoimala(double mw) {
      super(mw);
   }
   
   /*
    * Yliluokan metodien toteutus
    */
   
   @Override
   public void hajoa() {
      System.out.println("Näin ydinvoimala tuhoutuu...");
   }
   
}
