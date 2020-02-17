/*
 * 
 * Ajatelma - luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 5 - Tehtävä 2
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
   
   // Palautetaan true, jos lauseet ovat samat (vertailu String-luokan
   // equals - metodilla).
   @Override
   public boolean equals(Object obj) {
      try {
         Ajatelma apu = (Ajatelma)obj;
         return lause.equals(apu.lause());
      }
      catch (Exception e) {
         return false;
      }
   }
   
   @Override
   public int hashCode() {
      int tulos = 17;
      tulos = 31 * tulos + (lause == null ? 0 : lause.hashCode());
      return tulos;
   }
   
}
