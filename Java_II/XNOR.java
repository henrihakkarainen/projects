/*
 * 
 * XNOR - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 2 - Tehtävä 5
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class XNOR {
   // Operaatio vertaa parametrina saamiaan totuusarvoja a ja b keskenään
   // ja palauttaa totuustaulun mukaisen totuusarvon tuloksenaan
   public static boolean computeXNOR(boolean a, boolean b) {
      // a = false ja b = false
      if (!a && !b) {
         return true;
      }
      // a = true ja b = false TAI b = true ja a = false
      else if ((a && !b) || (b && !a)) {
         return false;
      }
      // a = true ja b = true
      else {
         return true;
      }
   }
   
   public static void main(String[] args) {
      System.out.println("Hello! I am XNOR.");
      System.out.println("Please, enter the first truth value:");
      boolean totuus1 = Boolean.parseBoolean(In.readString());
      System.out.println("Please, enter the second truth value:");
      boolean totuus2 = Boolean.parseBoolean(In.readString());
      boolean vastaus = computeXNOR(totuus1, totuus2);
      System.out.println("The result is " + vastaus + ".");
   }
}
