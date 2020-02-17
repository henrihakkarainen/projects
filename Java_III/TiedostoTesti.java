/* 
 * Viikkoharjoitus 2, tehtävä 1.
 *  
 * Olio-ohjelmoinnin perusteet I, kevät 2019. Jorma Laurikkala, jorma.laurikkala@uta.fi.
 *
 * Tiedosto-luokkaa testaava luokka.
 *
 */

public class TiedostoTesti {
   public static void main(String[] args) {
      // Moikataan käyttäjää ja kerrotaan ohjelmasta.
      System.out.println("Hello! I test files.");

      // Esitellään viite, luodaan olio ja alustetaan se sekä liitetään viite olioon.
      Tiedosto sorsa = new Tiedosto();

      // Luetaan attribuuttien arvot.
      String nimi = sorsa.nimi();
      int koko = sorsa.koko();

      // Näytölle tulostuu: State is "x" and 0.
      System.out.println("State is \"" + nimi + "\" and " + koko + ".");

      // Esitellään viite, luodaan olio ja alustetaan se sekä liitetään viite olioon.
      Tiedosto ht2 = new Tiedosto("LakiHT2.java", 26170);

      // Luetaan attribuuttien arvot.
      nimi = ht2.nimi();
      koko = ht2.koko();

      // Näytölle tulostuu: State is "StringStats.java" and 26170.
      System.out.println("State is \"" + nimi + "\" and " + koko + ".");
   }
}
