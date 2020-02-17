/*
 * 
 * AssosiaatioTesti1 - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 7 - Tehtävä 4
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public class AssosiaatioTesti1 {
   
   public static void main(String[] args) {
      
      // Luodaan levy-olio
      Levy rokkia = new Levy(1995, 8);
      
      // Luodaan yhtye-olio
      Yhtye hassuttelijat = new Yhtye("Hassuttelijat");
      
      System.out.println("Yhtyeen nimi: " + hassuttelijat.nimi());
      
      // Asetetaan hassuttelijat-yhtyeelle esikoislevyksi rokkia-albumi
      hassuttelijat.esikoislevy(rokkia);
      
      Levy testiviite = hassuttelijat.esikoislevy();
      
      System.out.println("Esikoisalbumin julkaisuvuosi: " + testiviite.vuosi() +
                         "\nEsikoisalbumin kappalemäärä: " + testiviite.kappaleidenLkm());
      
      // Testataan rakentajia ja aksessoreita
      
      Levy tyhjyys = new Levy(1800, -1);
      
      System.out.println("Tyhjyys-levyn julkaisuvuosi: " + tyhjyys.vuosi() +
                         "\nTyhjyys levyllä on " + tyhjyys.kappaleidenLkm() + " kappaletta.");
      
      Yhtye alakulo = new Yhtye("");
      alakulo.esikoislevy(null);
      
      System.out.println("Yhtyeen nimi: " + alakulo.nimi() +
                         "\nEsikoisalbumin julkaisuvuosi: " + alakulo.esikoislevy().vuosi());
      
      rokkia.vuosi(0);
      
      System.out.println("Rokkia-levyn julkaisuvuosi: " + rokkia.vuosi());
      
   }
}
