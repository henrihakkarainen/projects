/*
 * Viikkoharjoitus 3, tehtävä 5.
 *
 * Olio-ohjelmoinnin perusteet I, kevät 2019. Jorma Laurikkala, jorma.laurikkala@tuni.fi.
 *
 * Kettua testaava luokka.
 *
 */

public class KettuTesti {
   public static void main(String[] args) {
      // Esitellään viite, luodaan olio ja alustetaan se ja liitetään olioon viite.
      Kettu repolainen = new Kettu();
      System.out.println(repolainen.elossa());        // true
      System.out.println(repolainen.paino());         // 5.0
      System.out.println(repolainen.onkoIso());       // false

      // Vapaavalintaisesti kuvailtua syömistä ja tervehtimistä.
      repolainen.syo();
      repolainen.moikkaa();

      // Testataan vielä kierommin ja tutustutaan samalla lisää rajapintoihin.
      // Kettu toteuttaa Tervehtiva-rajapinnan ja on siten myös Tervehtiva-tyyppiä.
      // Liitetään olioon esimerkinomaisesti Tervehtiva-viite ja kutsutaan sen
      // kautta rajapinnan toteutettua metodia.
      Tervehtiva tervehtivaRepolainen = repolainen;
      tervehtivaRepolainen.moikkaa();
   }
}
