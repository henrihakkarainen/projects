/*
 * 
 * Levy - luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 7 - Tehtävä 4
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class Levy {
   
   /*
    * Attribuutit
    */
    
   private int vuosi;
   
   private int kappaleidenLkm;
   
   /*
    * Rakentajat
    */
   
   // Oletusrakentajassa luodaan levy, jonka julkaisuvuosi on 1900 ja kappaleiden
   // lukumäärä on 1.
   public Levy() {
      vuosi = 1900;
      kappaleidenLkm = 1;
   }
   
   public Levy(int v, int lkm) {
      vuosi(v);
      kappaleidenLkm(lkm);
   }
   
   /*
    * Aksessorit
    */
    
   public int vuosi() {
      return vuosi;
   }
   
   public void vuosi(int v) {
      if (v >= 1900) {
         vuosi = v;
      }
   }
   
   public int kappaleidenLkm() {
      return kappaleidenLkm;
   }
   
   public void kappaleidenLkm(int lkm) {
      if (lkm >= 1) {
         kappaleidenLkm = lkm;
      }
   }
   
}
