/*
 * Viikkoharjoitus 3, tehtävä 4.
 *
 * Olio-ohjelmoinnin perusteet I, kevät 2019. Jorma Laurikkala, jorma.laurikkala@tuni.fi.
 *
 * Ohjattavaa laitetta testaava luokka.
 *
 */

public class LaiteTesti {
   public static void main(String[] args) {
      // Esitellään viite, luodaan sekä alustetaan olio ja asetetaan viite olioon.
      // Laitteeseen voidaan liittää Ohjattava-tyyppinen viite, koska Laite toteuttaa
      // Ohjattava-rajapinnan ja on siten myös Ohjattava-tyyppiä. Olioon voidaan
      // toki edelleen liittää myös Laite-tyyppinen viite, mutta koska rajapinnan tyyppiä
      // käyttäen testistä saadaan tiukempi, tehdään kutsut ovelasti Ohjattava-tyyppiä
      // hyödyntäen.
      Ohjattava ohjattavaLaite = new Laite();

      // Tarkistetaan lähtötila.
      System.out.println(ohjattavaLaite.tila());   // 3

      /*
       * Tutkitaan, että sallitut tilasiirtymät onnistuvat ja että tila ei muutu,
       * kun siirtymä on kielletty.
       *
       */

      // Komentoja sammutetulle.
      ohjattavaLaite.nuku();
      System.out.println(ohjattavaLaite.tila());   // 3
      ohjattavaLaite.heraa();
      System.out.println(ohjattavaLaite.tila());   // 3
      ohjattavaLaite.sammu();
      System.out.println(ohjattavaLaite.tila());   // 3
      ohjattavaLaite.kaynnisty();
      System.out.println(ohjattavaLaite.tila());   // 1

      // Komentoja käynnissä olevalle.
      ohjattavaLaite.kaynnisty();
      System.out.println(ohjattavaLaite.tila());   // 1
      ohjattavaLaite.heraa();
      System.out.println(ohjattavaLaite.tila());   // 1
      ohjattavaLaite.nuku();
      System.out.println(ohjattavaLaite.tila());   // 2

      // Komentoja nukkuvalle.
      ohjattavaLaite.nuku();
      System.out.println(ohjattavaLaite.tila());   // 2
      ohjattavaLaite.kaynnisty();
      System.out.println(ohjattavaLaite.tila());   // 2
      ohjattavaLaite.sammu();
      System.out.println(ohjattavaLaite.tila());   // 2
      ohjattavaLaite.heraa();
      System.out.println(ohjattavaLaite.tila());   // 1

      // Viimeinen komento käynnissä olevalle.
      ohjattavaLaite.sammu();
      System.out.println(ohjattavaLaite.tila());   // 3
   }
}
