/*
 * 
 * CharacterSwitcher - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 5 - Tehtävä 4
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class CharacterSwitcher {
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
      else {
         System.out.println("Error!");
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
   /*
    * Operaatio vastaanottaa kaksiulotteisen char-tyyppisen taulukon, sekä
    * kaksi merkkiä ja korvaa ensimmäisen merkin esiintymät toisella ja
    * päinvastoin.
    */
   public static boolean switchCharacters(char[][] alkiot, char eka, char toka) {
      if (alkiot != null) {
         for (int i = 0; i < alkiot.length; i++) {
            for (int j = 0; j < alkiot[i].length; j++) {
               if (alkiot[i][j] == eka) {
                  alkiot[i][j] = toka;
               }
               else if (alkiot[i][j] == toka) {
                  alkiot[i][j] = eka;
               }
            }
         }
         return true;
      }
      else {
         return false;
      }
   }
   
   public static void main(String[] args) {
      System.out.println("Hello! I am a character replacer.");
      System.out.println("Please, enter the number of rows:");
      int rows = In.readInt();
      System.out.println("Please, enter the number of columns:");
      int cols = In.readInt();
      char [][] taulukko = fill2DCharacterArray(rows, cols);
      if (taulukko != null) {
         System.out.println("Please, enter the first character:");
         char first = In.readChar();
         System.out.println("Please, enter the second character:");
         char second = In.readChar();
         switchCharacters(taulukko, first, second);
         print2DCharacterArray(taulukko);
      }
      else {
         System.out.println("Error!");
      }
   }
}
