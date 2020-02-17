/*
 * 
 * Separator - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 2 - Tehtävä 1
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class Separator {
   public static String tulostaJono() {
      String mjono = "----------";
      return mjono;
   }
   
   public static void main(String[] args) {
      System.out.println("Hello! I print a separating line.");
      String tuloste = tulostaJono();
      System.out.println(tuloste);
   }
}
