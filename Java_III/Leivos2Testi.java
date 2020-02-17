/*
 * Viikkoharjoitus 4, tehtävä 2.
 *
 * Olio-ohjelmoinnin perusteet I, kevät 2019. Jorma Laurikkala, jorma.laurikkala@tuni.fi.
 *
 * Vanhentuvia pullia ja munkkeja testaava luokka.
 *
 */

// Otetaan käyttöön vanhentuvat leivokset.
import leivos2.*;

public class Leivos2Testi {
   public static void main(String[] args) {
      // Esitellään viite, luodaan ja alustetaan olio sekä liitetään viite olioon.
      // Pullat ja munkit ovat myös vanhentuvia, koska yliluokka toteuttaa rajapinnan.
      Vanhentuva pulla = new Pulla();
      Vanhentuva munkki = new Munkki();

      // Tarkistetaan, että uudet leivokset ovat tuoreita.
      System.out.println(pulla.onkoVanha());       // false
      System.out.println(munkki.onkoVanha());      // false

      // Vanhennetaan molempia leivoksia neljän päivän verran.
      for (int paiva = 1; paiva <= 4; paiva++) {
         pulla.vanhennu();
         munkki.vanhennu();
      }

      // Tarkistetaan, että leivokset eivät ole vielä vanhoja.
      System.out.println(pulla.onkoVanha());       // false
      System.out.println(munkki.onkoVanha());      // false

      // Vanhennetaan molempia leivoksia vielä yhden päivän verran.
      pulla.vanhennu();
      munkki.vanhennu();

      // Tarkistetaan, että pulla meni vanhaksi (ikää yli neljä päivää).
      System.out.println(pulla.onkoVanha());       // true
      System.out.println(munkki.onkoVanha());      // false

      // Vanhennetaan molempia leivoksia edelleen yhden päivän verran.
      pulla.vanhennu();
      munkki.vanhennu();

      // Tarkistetaan, että myös munkki meni vanhaksi (ikää yli viisi päivää).
      System.out.println(pulla.onkoVanha());       // true
      System.out.println(munkki.onkoVanha());      // true
   }
}
