import java.util.Arrays;
/*
 * 
 * CharacterFinder3 - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 4 - Tehtävä 5
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class CharacterFinder3 {
   /*
    * Operaatio vastaanottaa parametreinaan etsittävän merkin ja yksiulotteisen
    * char-tyyppisen taulukon. Etsittävää merkkiä etsitään taulukosta ja operaatio
    * palauttaa arvon true, mikäli merkin esiintymä löydetään taulukon alkioiden
    * joukosta. Mikäli taulukko = null tai etsittävää merkkiä ei löydy, palautetaan
    * arvo false.
    */
   public static boolean findCharacter(char merkki, char[] merkit) {
      if (merkit != null) {
         Arrays.sort(merkit);
         if (Arrays.binarySearch(merkit, merkki) >= 0) {
            return true;
         }
         else {
            return false;
         }
      }
      else {
         return false;
      }
   }
   /*
    * Operaatio täyttää parametrinaan saamansa taulukon käyttäjän
    * antamilla merkeillä.
    */
   public static void fillCharacterArray(char[] alkiot) {
      if (alkiot != null) {
         for (int i = 0; i < alkiot.length; i++) {
            int arrayIndex = i + 1;
            System.out.println("Please, enter element value " + arrayIndex + ":");
            char alkio = In.readChar();
            alkiot[i] = alkio;
         }
      }
   }
   
   public static void main(String[] args) {
      System.out.println("Hello! I try to find a character.");
      System.out.println("Please, enter array size:");
      int koko = In.readInt();
      if (koko <= 0) {
         System.out.println("Error!");
      }
      else {
         char[] tutkittavat = new char[koko];
         fillCharacterArray(tutkittavat);
         System.out.println("Please, enter a character:");
         char etsittava = In.readChar();
         boolean loytyi = findCharacter(etsittava, tutkittavat);
         if (loytyi) {
            System.out.println("Character '" + etsittava + "' was found.");
         }
         else {
            System.out.println("Character '" + etsittava + "' was not found.");
         }
      }
   }
}
