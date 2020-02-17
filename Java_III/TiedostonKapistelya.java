/*
 * Viikkoharjoitus 4, tehtävä 3.
 *
 * Olio-ohjelmoinnin perusteet I, kevät 2019. Jorma Laurikkala, jorma.laurikkala@tuni.fi.
 *
 * Luetaan komentoriviparametrina annettu tekstitiedosto Scanner-
 * luokan avulla ArrayList-tyyppiseen kokoelmaan. ArrayList on
 * Vector-luokan tapainen vaihtuvamittainen taulukko. Kokoelman
 * alkioiden tyypiksi kiinnitetään String, jotta koodi olisi 
 * turvallisempaa.
 * 
 * Muokannut: Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 *
 */

// Otetaan pakkaukset käyttöön.
import java.util.*;
import java.io.*;

public class TiedostonKapistelya {

   /* Luetaan tekstiedoston sisältö kokoelmaan. Paluuarvo on viite merkkijonojen
    * muodostamaan kokoelmaolioon. Metodi heittää poikkeuksen, jos parametrissa 
    * tai tiedostonkäsittelyssä ilmenee virhe.
    */
   public static ArrayList<String> lueTiedosto(String tiedostonNimi) throws NullPointerException, IOException {
      // Luodaan tiedostoon liittyvä tiedosto-olio.
      File tiedosto = new File(tiedostonNimi);

      // Liistetään tiedosto-olioon lukija.
      Scanner lukija = new Scanner(tiedosto);

      // Luodaan uusi ArrayList-tyyppinen olio ja liitetään siihen viite.
      // Huomaa geneeriset määreet, joilla kokoelman alkioiden tyypiksi 
      // kiinnitetään String.
      ArrayList<String> rivit = new ArrayList<String>();

      // Luetaan niin kauan kuin löytyy uusi tekstirivi.
      while (lukija.hasNext()) {
         // Lisätään kokoelmaan rivi tekstiä.
         rivit.add(lukija.nextLine());
      }

      // Palautetaan viite kokoelmaan.
      return rivit;
   }

   /* Tulostaa kokoelmaan tallennetut tekstitiedoston rivit näytölle. Heittää
    * NullPointerException-poikkeuksen, jos parametri on null-arvoinen.
    */
   public static void tulosta(ArrayList<String> rivit) throws NullPointerException {
      // Kokoelmaa voidaan selata myös for-each-lauseella (for-lauseen variaatio).
      for (String rivi : rivit) {
         System.out.println(rivi);
      }
   }

   public static void main(String[] args) {
      
      try {
         // Luetaan tekstitiedoston rivit kokoelmaan. Tiedoston nimi välitetään
         // ohjelmalle komentoriviparametrina.
         ArrayList<String> rivit = lueTiedosto(args[0]);

         // Tulostetaan tiedosto näytölle. 
         tulosta(rivit);
      }
      catch (ArrayIndexOutOfBoundsException e) {
         System.out.println("Please, remember to give a filename.");
      }
      
      catch (IOException e) {
         System.out.println("Missing file?");
      }
      
      catch (Exception e) {
         System.out.println("Error!");
      }
   }
}
