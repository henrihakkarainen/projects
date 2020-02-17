/*
 * 
 * Valtionpaamies - luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 2 - Tehtävä 5
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class Valtionpaamies {
   
   /*
    * Attribuutit
    */
    
   private boolean vaaleillaValittu;
   
   /*
    * Rakentajat
    */
   
   // Oletusrakentajassa attribuutin vaaleillaValittu arvoksi asetetaan true.
   public Valtionpaamies() {
      vaaleillaValittu = true;
   }
   
   // Parametrillisessa rakentajassa attribuutin vaaleillaValittu arvoksi asetetaan
   // ulkoisen tahon määrittelemä arvo (v).
   public Valtionpaamies(boolean v) {
      vaaleillaValittu(v);
   }
   
   /*
    * Aksessorit
    */
    
   public boolean vaaleillaValittu() {
      return vaaleillaValittu;
   }
   
   public void vaaleillaValittu(boolean v) {
      vaaleillaValittu = v;
   }
   
}
