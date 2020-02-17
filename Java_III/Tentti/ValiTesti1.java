/*
 * Oope1 tentti - Tehtävä 1
 * 
 * Tehnyt: Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class ValiTesti1 {
   
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
      
   }
}
