/*
 * 
 * CharacterFinder1 - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 3 - Tehtävä 5
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class CharacterFinder1 {
   /*
    * Operaatio vastaanottaa ensimmäisenä parametrinaan etsittävän merkin
    * ja toisena parametrinaan merkkijonon, josta merkkiä etsitään.
    * Mikäli merkin esiintymiä löydetään vähintään 1, operaation paluuarvona on true,
    * muuten false.
    */
   public static boolean findCharacter(char merkki, String mjono) {
      int esiintymat = 0;
      for (int i = 0; i < mjono.length(); i++) {
         if (mjono.charAt(i) == merkki) {
            esiintymat += 1;
         }
      }
      if (esiintymat > 0) {
         return true;
      }
      else {
         return false;
      }
   }
   
   public static void main(String[] args) {
      System.out.println("Hello! I try to find a character.");
      System.out.println("Please, enter a string:");
      String tutkittava = In.readString();
      System.out.println("Please, enter a character:");
      char etsittava = In.readChar();
      boolean loytyi = findCharacter(etsittava, tutkittava);
      if (loytyi) {
         System.out.println("Character '" + etsittava + "' was found.");
      }
      else {
         System.out.println("Character '" + etsittava + "' was not found.");
      }
   }
}
