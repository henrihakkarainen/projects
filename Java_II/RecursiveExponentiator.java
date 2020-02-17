/*
 * 
 * RecursiveExponentiator - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 6 - Tehtävä 5
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class RecursiveExponentiator {
   /*
    * Operaatiossa lasketaan luvun (m) potenssi. Lukua kerrotaan itsellään
    * eksponentin (n) osoittama määrä kertoja ja palautetaan lopputulos.
    * Jos eksponentti on negatiivinen, niin palautetaan Double-luokan NaN-vakio.
    */
   public static double exponentiate(int m, int n) {
      if (n >= 0) {
         if (n < 1) {
            return 1;
         }
         else {
            return m * exponentiate(m, n - 1);
         }
      }
      else {
         return Double.NaN;
      }
   }
   
   public static void main(String[] args) {
      System.out.println("Hello! I am a recursive exponentiator.");
      System.out.println("Please, enter base:");
      int base = In.readInt();
      System.out.println("Please, enter exponentiator:");
      int expo = In.readInt();
      double potenssi = exponentiate(base, expo);
      if (!Double.isNaN(potenssi)) {
         System.out.println(base + " ^ " + expo + " = " + (int)potenssi + ".");
      }
      else {
         System.out.println("Error!");
      }
   }
}
