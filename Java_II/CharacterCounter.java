/*
 * 
 * CharacterCounter - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 5 - Tehtävä 5
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class CharacterCounter {
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
    * Operaatio laskee montako esiintymää kullakin yksiulotteisessa char-tyyppisessä
    * taulukossa olevalla merkillä on kaksiulotteisessa char-tyyppisessä taulukossa.
    * Taulukot välitetään operaatiolle parametreina. Operaatio luo ja palauttaa
    * yksiulotteisen int-tyyppisen taulukon, joka sisältää laskettavien merkkien
    * lukumäärät samassa järjestyksessä, kuin merkit ovat parametrina saadussa
    * yksiulotteisessa merkkien taulukossa (char[] merkit).
    */
   public static int[] frequencyCounter(char[][] etsittavat, char[] merkit) {
      if (etsittavat != null && merkit != null) {
         int[] esiintymia = new int[merkit.length];
         for (int i = 0; i < etsittavat.length; i++) {
            for (int j = 0; j < etsittavat[i].length; j++) {
               for (int k = 0; k < merkit.length; k++) {
                  if (merkit[k] == etsittavat[i][j]) {
                     esiintymia[k] += 1;
                  }
               }
            }
         }
         return esiintymia;
      }
      else {
         return null;
      }
   }
   
   public static void main(String[] args) {
      System.out.println("Hello! I am a character counter.");
      System.out.println("Please, enter the number of rows:");
      int rows = In.readInt();
      System.out.println("Please, enter the number of columns:");
      int cols = In.readInt();
      char [][] taulukko2D = fill2DCharacterArray(rows, cols);
      if (taulukko2D != null) {
         System.out.println("Please, enter characters to be counted:");
         String mjono = In.readString();
         char[] taulukko1D = mjono.toCharArray();
         int[] esiintymat = frequencyCounter(taulukko2D, taulukko1D);
         System.out.print("{");
         for (int i = 0; i < esiintymat.length; i++) {
            System.out.print(" " + esiintymat[i]);
         }
         System.out.println(" }");
      }
      else {
         System.out.println("Error!");
      }
   }
}
