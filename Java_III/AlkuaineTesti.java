/*
 * 
 * AlkuaineTesti - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 2 - Tehtävä 4
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public class AlkuaineTesti {
   
   public static void main(String[] args) {
      System.out.println("Hello! I test chemical elements.");
      System.out.println("Please, enter the symbol of the element:");
      String alkuaine = In.readString();
      System.out.println("Please, enter the atomic number of the element:");
      int jnro = In.readInt();
      // Luodaan alkuaine-olio rakentajalla käyttäen käyttäjän antamia syötteitä
      Alkuaine random = new Alkuaine(alkuaine, jnro);
      // Metodien palauttamat arvot talteen
      String merkki = random.merkki();
      int numero = random.numero();
      // Tulostetaan metodien palauttamat arvot näytölle
      System.out.println("State is \"" + merkki + "\" and " + numero + ".");
   }
}
