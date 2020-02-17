/*
 * 
 * Array2DPrinter - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 6 - Tehtävä 2
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class Array2DPrinter {
   /*
    * Operaatio tulostaa parametrinaan vastaanottamansa kaksiulotteisen
    * taulukon alkiot näytölle, mikäli taulukolle on varattu muistia.
    */
   public static void print2DIntegerArray(int[][] alkiot, int width) {
      if (alkiot != null) {
         for (int i = 0; i < alkiot.length; i++) {
            for (int j = 0; j < alkiot[i].length; j++) {
               String muunnos = String.valueOf(alkiot[i][j]);
               int pituus = muunnos.length();
               for (int k = 0; k < width - pituus; k++) {
                  System.out.print(" ");
               }
               System.out.print(alkiot[i][j] +
                               (j == alkiot[i].length - 1 ? "" : " "));
            }
            System.out.println();
         }
      }
   }
   /*
    * Operaatio muodostaa erottimena toimivan merkkijonon ja palauttaa sen.
    */
   public static String tulostaJono() {
      String mjono = "----------";
      return mjono;
   }
   
   public static void main(String[] args) {
      int[][] eka = { { 1 } };
      int[][] toka = { { 1, 2, 3 } };
      int[][] kolmas = { { 1 }, { 22 }, { 333 } };
      int[][] neljas = { { 15, 0, 7 }, { 4, 10, 13 } };
      System.out.println(tulostaJono());
      print2DIntegerArray(null, 0);
      System.out.println(tulostaJono());
      print2DIntegerArray(eka, 1);
      System.out.println(tulostaJono());
      print2DIntegerArray(toka, 2);
      System.out.println(tulostaJono());
      print2DIntegerArray(kolmas, 3);
      System.out.println(tulostaJono());
      print2DIntegerArray(neljas, 2);
      System.out.println(tulostaJono());
   }
}
