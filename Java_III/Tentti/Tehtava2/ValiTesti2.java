/*
 * Oope1 tentti - Tehtävä 2
 * 
 * Tehnyt: Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class ValiTesti2 {
   
   public static void main(String[] args) {
      
      Vali testi = new Vali(1, 5, 3);
      
      System.out.println(testi.alaraja());
      System.out.println(testi.ylaraja());
      System.out.println(testi.tyyppi());
      
      try {
         Vali uusi = new Vali(1, 3, 5);
      }
      catch (IllegalArgumentException e) {
         e.printStackTrace();
      }
      
      Vali uusi = new Vali(-13, 13, 2);
      
      System.out.println(testi);
      System.out.println(uusi);
      
      // Verrataan olion tietoja itseensä
      if (uusi.equals(uusi)) {
         System.out.println("Ovat samat");
      }
      else {
         System.out.println("Eivät samat");
      }
      
      if (testi.equals(uusi)) {
         System.out.println("Ovat samat");
      }
      else {
         System.out.println("Eivät samat");
      }
      
      System.out.println(testi.hashCode());
      System.out.println(uusi.hashCode());
   }
}
