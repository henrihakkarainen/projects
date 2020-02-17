/*
 * 
 * ElementSwapper - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 4 - Tehtävä 6
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class ElementSwapper {
   /*
    * Operaatio vastaanottaa int-tyyppisistä muuttujista koostuvan taulukon
    * ja vaihtaa kahden indeksiarvon mukaisen muuttujan paikkaa keskenään,
    * mikäli indeksiarvot ovat järkeviä. Indeksiarvot saadaan parametreina a ja b.
    * Operaatio palauttaa totuusarvon true, mikäli paikkojen vaihto onnistuu,
    * muuten palautetaan false.
    */
   public static boolean swapElements(int[] luvut, int a, int b) {
      if (luvut != null && a >= 0 && a < luvut.length
      && b >= 0 && b < luvut.length) {
         int luku1 = luvut[a];
         int luku2 = luvut[b];
         luvut[a] = luku2;
         luvut[b] = luku1;
         return true;
      }
      else {
         return false;
      }
   }
   /*
    * Operaatio vastaanottaa taulukon, joka sisältää int-tyyppisiä alkioita
    * ja tulostaa kaikki taulukon alkiot näytölle.
    */
   public static void printIntegerArray(int[] luvut) {
      if (luvut != null) {
         System.out.print("{ ");
         for (int j = 0; j < luvut.length; j++) {
               System.out.print(luvut[j] + " ");
         }
         System.out.println("}");
      }
   }
   /*
    * Operaatio täyttää parametrinaan saamansa taulukon käyttäjän
    * antamilla kokonaisluvuilla.
    */
   public static void fillIntegerArray(int[] luvut) {
      if (luvut != null) {
         for (int i = 0; i < luvut.length; i++) {
            int arrayIndex = i + 1;
            System.out.println("Please, enter element value " + arrayIndex + ":");
            int luku = In.readInt();
            luvut[i] = luku;
         }
      }
   }
   
   public static void main(String[] args) {
      System.out.println("Hello! I swap element values.");
      System.out.println("Please, enter array size:");
      int koko = In.readInt();
      if (koko <= 0) {
         System.out.println("Error!");
      }
      else {
         int[] tutkittavat = new int[koko];
         fillIntegerArray(tutkittavat);
         printIntegerArray(tutkittavat);
         System.out.println("Enter the first index value:");
         int ind1 = In.readInt();
         System.out.println("Enter the second index value:");
         int ind2 = In.readInt();
         boolean vaihtui = swapElements(tutkittavat, ind1, ind2);
         if (vaihtui) {
            System.out.println("The element values were swapped.");
         }
         else {
            System.out.println("The element values were not swapped.");
         }
         printIntegerArray(tutkittavat);
      }
   }
}
