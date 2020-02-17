/*
 * 
 * Laite - luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 3 - Tehtävä 4
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public class Laite implements Ohjattava {
   
   /*
    * Ilmentymäattribuutit
    */
   
   private int tila;
   
   /*
    * Rakentajat
    */
   
   public Laite() {
      tila = Ohjattava.SAMMUTETTU;
   }
   
   /*
    * Rajapinnasta toteutetut metodit
    */
    
   public void kaynnisty() {
      if (tila == Ohjattava.SAMMUTETTU) {
         tila = Ohjattava.KAYNNISSA;
      }
   }
   
   public void nuku() {
      if (tila == Ohjattava.KAYNNISSA) {
         tila = Ohjattava.NUKKUU;
      }
   }
   
   public void heraa() {
      if (tila == Ohjattava.NUKKUU) {
         tila = Ohjattava.KAYNNISSA;
      }
   }
   
   public void sammu() {
      if (tila == Ohjattava.KAYNNISSA) {
         tila = Ohjattava.SAMMUTETTU;
      }
   }
   
   public int tila() {
      return tila;
   }
   
}
