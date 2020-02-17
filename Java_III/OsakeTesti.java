/*
 * 
 * OsakeTesti - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 1 - Tehtävä 1
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public class OsakeTesti {
   
   public static void main(String[] args) {
      System.out.println("Hello! I test shares.");
      System.out.println("Please, enter the share price:");
      double osakkeenArvo = In.readDouble();
      System.out.println("Please, enter the name of the company:");
      String yhtionNimi = In.readString();
      Osake yritys = new Osake();
      // Asetetaan Osake-olion attribuuteille syötteenä vastaanotetut arvot
      yritys.arvo(osakkeenArvo);
      yritys.yhtio(yhtionNimi);
      // Metodien palauttamat arvot talteen
      double arvo = yritys.arvo();
      String yhtio = yritys.yhtio();
      // Tulostetaan metodien palauttamat arvot näytölle
      System.out.println("State is " + arvo + " and \"" + yhtio + "\".");
   }
}
