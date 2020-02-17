/*
 * 
 * PullaTesti - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 2 - Tehtävä 3
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public class PullaTesti {
   
   public static void main(String[] args) {
      System.out.println("Hello! I test buns.");
      System.out.println("What is the weight of the bun?");
      double pullanPaino = In.readDouble();
      System.out.println("Is the bun lactose-free?");
      boolean onkoLaktoositon = Boolean.parseBoolean(In.readString());
      // Luodaan pulla-olio rakentajalla käyttäen käyttäjän antamia syötteitä
      Pulla bulle = new Pulla(pullanPaino, onkoLaktoositon);
      // Metodien palauttamat arvot talteen
      double paino = bulle.paino();
      boolean laktoositon = bulle.laktoositon();
      // Tulostetaan metodien palauttamat arvot näytölle
      System.out.println("State is " + paino + " and " + laktoositon + ".");
   }
}
