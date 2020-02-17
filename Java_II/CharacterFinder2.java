/*
 * 
 * CharacterFinder2 - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 3 - Tehtävä 6
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class CharacterFinder2 {
   /*
    * Operaatio vastaanottaa parametreinaan etsittävän merkin ja yksiulotteisen
    * char-tyyppisen taulukon. Etsittävää merkkiä etsitään taulukosta ja operaatio
    * palauttaa arvon true, mikäli merkin esiintymä löydetään taulukon alkioiden
    * joukosta. Mikäli taulukko = null tai etsittävää merkkiä ei löydy, palautetaan
    * arvo false.
    */
   public static boolean findCharacter(char merkki, char[] merkit) {
      if (merkit != null) {
         for (int i = 0; i < merkit.length; i++) {
            if (merkit[i] == merkki) {
               return true;
            }
         }
         return false;
      }
      else {
         return false;
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
         for (int i = 0; i < tutkittavat.length; i++) {
            int nro = i + 1;
            System.out.println("Please, enter element value " + nro + ":");
            char merkki = In.readChar();
            tutkittavat[i] = merkki;
         }
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
