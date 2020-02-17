/*
 * 
 * MunkkiTesti - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 3 - Tehtävä 1
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public class MunkkiTesti {
   
   public static void main(String[] args) {
      System.out.println("Hello! I test filled donuts.");
      System.out.println("What is the weight of the donut?");
      double paino = In.readDouble();
      System.out.println("1) no filling, 2) strawberry, 3) apple or 4) other?");
      int tayte = In.readInt();
      // Luodaan munkki-olio rakentajalla käyttäen käyttäjän antamia syötteitä
      Munkki maistuva = new Munkki(paino, tayte);
      // Metodien palauttamat arvot talteen
      double luePaino = maistuva.paino();
      int lueTayte = maistuva.tayte();
      // Tulostetaan metodien palauttamat arvot näytölle
      System.out.println("State is " + luePaino + " and " + lueTayte + ".");
   }
}
