/*
 * 
 * Presidentti - luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 2 - Tehtävä 6
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class Presidentti extends Valtionpaamies {
   
   /*
    * Attribuutit
    */
    
   private int kaudet;
   
   /*
    * Aksessorit
    */
   
   public int kaudet() {
      return kaudet;
   }
   
   public void kaudet(int k) {
      if (k >= 0) {
         kaudet = k;
      }
   }
}
