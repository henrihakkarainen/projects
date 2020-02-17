/* 
 * Viikkoharjoitus 3, tehtävä 6.
 *  
 * Olio-ohjelmoinnin perusteet I, kevät 2018. Jorma Laurikkala, jorma.laurikkala@tuni.fi.
 *
 * Eri tavoin tervehtivää kissaa testaava luokka.
 *
 */

public class KissaTesti {
   public static void main(String[] args) {
      // Luodaan kissa.
      Kissa psyko = new Kissa(true, 2, "harmaa", "levoton");

      // Tervehdyksen mahdollisia kohteita.
      Kissa suurempi = new Kissa(true, 5, "musta", "kippura");
      Kissa pienempi = new Kissa(true, 1, "valkoinen", "töpö");
      String jotainIhanMuuta = "K.I.S.S.A";

      // Käsketään kissaa tervehtimään.
      psyko.moikkaa(suurempi);            // Miu!
      psyko.moikkaa(pienempi);            // Sahhh!
      psyko.moikkaa(psyko);               // Sahhh!
      psyko.moikkaa(jotainIhanMuuta);     // Sahhh!
      psyko.moikkaa(null);                // Sahhh!
   }
}
