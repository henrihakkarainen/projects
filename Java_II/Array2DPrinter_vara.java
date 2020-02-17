/*
 * 
 * Array2DPrinter - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 4 - Tehtävä 7
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class Array2DPrinter {
   /*
    * Operaatio tulostaa parametrinaan vastaanottamansa kaksiulotteisen
    * taulukon alkiot näytölle, mikäli taulukolle on varattu muistia.
    */
   public static void print2DCharacterArray(char[][] alkiot) {
      if (alkiot != null) {
         for (int i = 0; i < alkiot.length; i++) {
            for (int j = 0; j < alkiot[i].length; j++) {
               System.out.print(alkiot[i][j]);
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
      char[][] eka = { {'a'} };
      char[][] toka = { { 'a', 'b', 'c' } };
      char[][] kolmas = { { 'a' }, { 'b' }, { 'c' } };
      char[][] neljas = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' } };
      System.out.println(tulostaJono());
      print2DCharacterArray(null);
      System.out.println(tulostaJono());
      print2DCharacterArray(eka);
      System.out.println(tulostaJono());
      print2DCharacterArray(toka);
      System.out.println(tulostaJono());
      print2DCharacterArray(kolmas);
      System.out.println(tulostaJono());
      print2DCharacterArray(neljas);
      System.out.println(tulostaJono());
   }
}
