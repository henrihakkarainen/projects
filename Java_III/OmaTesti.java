// Otetaan käyttöön ajoneuvot-pakkaus
import ajoneuvot.*;

/*
 * 
 * OmaTesti - ohjelma, jossa luodaan autoja ja testataan niiden toiminnallisuutta
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 6 - Tehtävä 8
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public class OmaTesti {
   
   public static void main(String[] args) {
      System.out.println("Hello! I test cars.");
      
      // Luetaan käyttäjältä syötteet (merkki, malli, kilometrit)
      System.out.println("What is the manufacturer of this car?");
      String merkki = In.readString();
      System.out.println("What is the model of this car?");
      String malli = In.readString();
      System.out.println("How many kilometers has been driven with this car?");
      int km = In.readInt();
      
      // Luodaan testiauto oletusrakentajalla ja tulostetaan tiedot näytölle
      Auto testiauto = new Auto();
      System.out.println("\nSuosituin malli (oletus):\n" + 
                         "Auton valmistaja: " + testiauto.haeMerkki() + "\n" + 
                         "Auton malli: " + testiauto.haeMalli() + "\n" + 
                         "Ajetut kilometrit: " + testiauto.haeKilometrit());
      System.out.println();
      
      // Asetetaan testiauto-olion attribuuttien arvoiksi käyttäjän antamat syötteet
      // (mielivaltaisesti korvataan testiauto käyttäjän syöttämillä auton tiedoilla)
      testiauto.asetaMerkki(merkki);
      testiauto.asetaMalli(malli);
      testiauto.asetaKilometrit(km);
      
      // Tulostetaan auton muuttuneet tiedot näytölle
      System.out.println("Auton valmistaja: " + testiauto.haeMerkki() + "\n" + 
                         "Auton malli: " + testiauto.haeMalli() + "\n" + 
                         "Ajetut kilometrit: " + testiauto.haeKilometrit());
      System.out.println();
      
      // Luodaan auto-olio (bemari) parametrillisella rakentajalla
      Auto bemari = new Auto("BMW", "M6", 1900);
      
      // Testataan merkkiJaMalli - metodin toimivuutta
      String auto = bemari.merkkiJaMalli();
      System.out.println("Unelma-auto: " + auto + "." + "\n" +
                         "Kilometrit: " + bemari.haeKilometrit());
      System.out.println();
      
      // Luodaan viallinen auto-olio, jonka parametrilliseen rakentajaan annetaan
      // virheelliset arvot ja tulostetaan auton tiedot näytölle
      Auto viallinen = new Auto(null, "", -1);
      System.out.println("Rikkinäinen auto:\n" +
                         "Auton valmistaja: " + viallinen.haeMerkki() + "\n" + 
                         "Auton malli: " + viallinen.haeMalli() + "\n" + 
                         "Ajetut kilometrit: " + viallinen.haeKilometrit());
      System.out.println();
                         
      // Käynnistetään bemari ja driftataan sillä hieman
      bemari.kaynnista();
      bemari.driftaa();
      
      // Luodaan driftaava auto
      Driftaava amis = new Auto("Toyota", "Corolla", 195865);
      
      // Testataan driftaavan ammattikoululaisen ajotaidot
      amis.kasijarruPyorahdys();
      amis.driftaa();
      
      // Testataan toString()-metodien toimivuutta
      System.out.println();
      System.out.println(bemari);
      System.out.println();
      System.out.println(amis);
   }
}
