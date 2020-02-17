/*
 * 
 * Array2DFiller - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 5 - Tehtävä 3
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class Array2DFiller {
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
    * Operaatio vastaanottaa parametreinaan kaksiulotteisen taulukon rivien
    * ja sarakkaiden lukumäärän, luo taulukon ja täyttää sen käyttäjän syötteiden
    * mukaisesti.
    */
   public static char[][] fill2DCharacterArray(int rivit, int sarakkeet) {
      if (rivit > 0 && sarakkeet > 0) {
         char[][] alkiot = new char[rivit][sarakkeet];
         for (int i = 0; i < rivit; i++) {
            System.out.println("Please, enter row " + (i + 1) + ":");
            String merkit = In.readString();
            for (int j = 0; j < sarakkeet; j++) {
               char alkio = merkit.charAt(j);
               alkiot[i][j] = alkio;
            }
         }
         return alkiot;
      }
      else {
         return null;
      }
   }
   
   public static void main(String[] args) {
      System.out.println("Hello! I am an array filler.");
      System.out.println("Please, enter the number of rows:");
      int rows = In.readInt();
      System.out.println("Please, enter the number of columns:");
      int cols = In.readInt();
      char [][] taulukko = fill2DCharacterArray(rows, cols);
      if (taulukko != null) {
         print2DCharacterArray(taulukko);
      }
      else {
         System.out.println("Error!");
      }
   }
}
