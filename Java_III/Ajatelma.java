/*
 * 
 * Ajatelma - luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 5 - Tehtävä 1
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class Ajatelma {
   
   /*
    * Attribuutit
    */
    
   private String lause;
   
   /*
    * Rakentajat
    */
   
   public Ajatelma(String ajatus) throws IllegalArgumentException {
      lause(ajatus);
   }
   
   /*
    * Aksessorit
    */
    
   public String lause() {
      return lause;
   }
   
   public void lause(String l) throws IllegalArgumentException {
      if (l == null || l.length() < 2) {
         throw new IllegalArgumentException();
      }
      
      lause = l;
   }
   
   /*
    * Korvatut metodit
    */
   
   @Override
   public String toString() {
      return "\"" + lause + "\"";
   }
   
}
