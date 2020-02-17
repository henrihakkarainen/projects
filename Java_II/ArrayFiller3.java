/*
 * 
 * ArrayFiller3 - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 4 - Tehtävä 1
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class ArrayFiller3 {
   /*
    * Operaatio täyttää parametrinaan saamansa taulukon käyttäjän
    * antamilla merkeillä. Operaatio palauttaa totuusarvon true, mikäli
    * taulukon täyttäminen onnistuu (eli taulukolle on varattu muistia ja se
    * ei ole nollan alkion pituinen), muuten palautetaan false.
    */
   public static boolean fillCharacterArray(char[] alkiot) {
      if (alkiot != null && alkiot.length > 0) {
         for (int i = 0; i < alkiot.length; i++) {
            int arrayIndex = i + 1;
            System.out.println("Please, enter value " + arrayIndex + ":");
            char alkio = In.readChar();
            alkiot[i] = alkio;
         }
         return true;
      }
      else {
         return false;
      }
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
      System.out.println("Hello! I am an array filler.");
      System.out.println("Please, enter size:");
      int koko = In.readInt();
      if (koko <= 0) {
         System.out.println("Error!");
      }
      else {
         char[] taulukko = new char[koko];
         fillCharacterArray(taulukko);
         printCharacterArray(taulukko);
      }
   }
}
