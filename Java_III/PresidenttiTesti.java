/*
 * 
 * PresidenttiTesti - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 2 - Tehtävä 6
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public class PresidenttiTesti {
   
   public static void main(String[] args) {
      System.out.println("Hello! I test the sanity of presidents.");
      System.out.println("Is the president elected?");
      boolean vaalivalinta = Boolean.parseBoolean(In.readString());
      System.out.println("The number of terms?");
      int kausia = In.readInt();
      
      // Luodaan presidentti-olio oletusrakentajalla
      Presidentti isokiho = new Presidentti();
      
      // Asetetaan presidentti-olion attribuuteille syötteenä saadut arvot
      isokiho.vaaleillaValittu(vaalivalinta);
      isokiho.kaudet(kausia);
      
      // Lukumetodien palauttamat arvot talteen
      boolean valinta = isokiho.vaaleillaValittu();
      int kaudet = isokiho.kaudet();
      
      // Tulostetaan metodien palauttamat arvot näytölle
      System.out.println("State is " + valinta + " and " + kaudet + ".");
   }
}
