/*
 * 
 * Kettu - luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 3 - Tehtävä 5
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public class Kettu extends Nisakas implements Tervehtiva {
   
   /*
    * Rakentajat
    */
   
   public Kettu() {
      super(true, 5);
   }
   
   /*
    * Korvatut metodit
    */
   
   @Override
   public boolean onkoIso() {
      return paino() > 9;
   }
   
   /*
    * Luokan toteuttamat metodit
    */
   
   public void syo() {
      System.out.println("Syön kuin kettu...");
   }
   
   public void moikkaa() {
      System.out.println("Heiluttaa häntää ujosti...");
   }
   
}
