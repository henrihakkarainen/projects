/* 
 * Viikkoharjoitus 1, tehtävä 5.
 *  
 * Olio-ohjelmoinnin perusteet, kevät 2019, Jorma Laurikkala.
 *
 * Kaivuria testaava luokka.
 *
 */

public class KaivuriTesti { 
   public static void main(String[] args) {
      // Luodaan kaivuri.
      Kaivuri lankkari = new Kaivuri();

      // Asetaan attribuuttien arvoja.
      lankkari.paino(21.56);
      lankkari.telat(true);
      lankkari.vari("keltainen");

      // Luetaan attribuuttien arvot ja tulostetaan. Kunkin tulostuslauseen
      // jälkeinen kommentti kertoo mitä pitäisi tulostua.
      System.out.println(lankkari.paino());  // 21.5
      System.out.println(lankkari.telat());  // true
      System.out.println(lankkari.vari());   // keltainen

      // Yritetään asettaa virheellisiä arvoja ja katsotaan miten kävi.
      lankkari.paino(0);
      lankkari.vari(null);

      // Luetaan attribuuttien arvot ja tulostetaan. Kunkin tulostuslauseen
      // jälkeinen kommentti kertoo mitä pitäisi tulostua.
      System.out.println(lankkari.paino());  // 21.5
      System.out.println(lankkari.telat());  // true
      System.out.println(lankkari.vari());   // keltainen
   } 
}
