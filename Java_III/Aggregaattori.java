import java.util.*;

/*
 * 
 * Aggrogaattori - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 6 - Tehtävä 7
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public class Aggregaattori {
   
   public static void main(String[] args) {
      
      Scanner r = new Scanner(System.in);
      
      System.out.println("Hello! I count some text statistics.");
      System.out.println("Please, enter text:");
      String teksti = r.nextLine();
      
      // Pilkotaan merkkijono osiin välilyönnillä erotettuna
      String[] sanat = teksti.split("[ ]");
      
      // Muunnetaan taulukko listaksi
      LinkedList<String> sanalista = new LinkedList<String>(Arrays.asList(sanat));
      
      // Lasketaan sanojen lukumäärä
      int sanoja = (int)sanalista
         .stream()
         .count(); // Virran alkiot yhteenlaskeva pääteoperaatio
         
      System.out.println("The number of words: " + sanoja + ".");
      
      // Lasketaan sanojen pituuksien summa
      int pituuksienSumma = (int)sanalista
         .stream()
         // Muunnetaan sanojen virta niiden pituuksien muodostamaksi lukujen virraksi
         .mapToInt(e -> e.length())
         .sum(); // Virran alkioiden summan laskeva pääteoperaatio
      
      System.out.println("The sum of word lengths: " + pituuksienSumma + ".");
      
      // Lasketaan sanojen pituuksille keskiarvo
      OptionalDouble ka = sanalista
         .stream()
         // Muunnetaan sanojen virta niiden pituuksien muodostamaksi lukujen virraksi
         .mapToInt(e -> e.length())
         .average(); // Luvuista keskiarvon laskeva pääteoperaatio
      
      // Tulostetaan keskiarvo, jos sen laskemisessa on onnistuttu
      ka.ifPresent(e -> System.out.println("Average word length: " + e + "."));
   }
}
