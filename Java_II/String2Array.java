/*
 * 
 * String2Array - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 4 - Tehtävä 3
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class String2Array {
   /*
    * Operaatio vastaanottaa merkkijonon sekä luo taulukon, jonka alkiot
    * täytetään merkkijonon muodostavilla merkeillä. Operaatio palauttaa viitteen
    * luotuun taulukkoon.
    */
   public static char[] muutaTaulukoksi(String mjono) {
      char[] taulukko = new char[mjono.length()];
      for (int i = 0; i < taulukko.length; i++) {
         taulukko[i] = mjono.charAt(i);
      }
      return taulukko;
   }
   /*
    * Operaatio vastaanottaa taulukon, joka sisältää char-tyyppisiä alkioita
    * ja tulostaa kaikki taulukon alkiot näytölle.
    */
   public static void printCharacterArray(char[] alkiot) {
      if (alkiot != null) {
         System.out.print("{ ");
         for (int j = 0; j < alkiot.length; j++) {
               System.out.print(alkiot[j] + " ");
         }
         System.out.println("}");
      }
   }
   
   public static void main(String[] args) {
      System.out.println("Hello! I convert a string to an array.");
      System.out.println("Please, enter the string:");
      String lause = In.readString();
      char[] merkit = muutaTaulukoksi(lause);
      printCharacterArray(merkit);
   }
}
