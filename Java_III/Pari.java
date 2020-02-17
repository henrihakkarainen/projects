/*
 * 
 * Pari - geneerinen luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 4 - Tehtävä 6
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class Pari<T, U> {
   
   /*
    * Attribuutit
    */
    
   private T ensimmainen;
   
   private U toinen;
   
   /*
    * Rakentajat
    */
   
   // Parametrillinen rakentaja, jossa alustetaan ensimmainen ja toinen attribuuttien
   // arvoksi uudet arvot, jotka voivat olla samaa tai eri tyyppiä.
   public Pari(T eka, U toka) {
      ensimmainen = eka;
      toinen = toka;
   }
   
   /*
    * Aksessorit
    */
   
   public T ensimmainen() {
      return ensimmainen;
   }
   
   public void ensimmainen(T eka) {
      ensimmainen = eka;
   }
   
   public U toinen() {
      return toinen;
   }
   
   public void toinen(U toka) {
      toinen = toka;
   }
   
}
