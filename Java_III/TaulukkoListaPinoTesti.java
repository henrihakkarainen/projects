// Otetaan käyttöön oma pino.
import pino.*;

/*
 * 
 * TaulukkoListaPinoTesti - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 6 - Tehtävä 6
 * 
 * Alkuperäinen koodin toteutus: Jorma Laurikkala
 * 
 * Muokannut harjoituksen testaukseen: Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class TaulukkoListaPinoTesti {

   /* 
    * Apuoperaatio pinon sisällön tulostamiseen. Tulostus tapahtuu päälimmäisestä
    * alkiosta pohjimmaiseen.
    */
   private static void tulosta(TaulukkoListaPino pino) {
      if (pino != null) {
         for (Object alkio : pino) {
            System.out.println(alkio);
         }
      }
   }
   
   public static void main(String[] args) {
      // Luodaan viiden alkion kokoinen pino ja kiinnitetään alkioiden tyypiksi
      // String-tyypinen merkkijono.
      TaulukkoListaPino<String> pino = new TaulukkoListaPino<String>(5);

      // lisää(A)
      System.out.println("lisää(A)");
      pino.lisaa("A");
      tulosta(pino);

      // koko() = 1
      System.out.print("koko() = ");
      System.out.println(pino.koko());

      // onkoTyhjä() = false
      System.out.print("onkoTyhjä() = ");
      System.out.println(pino.onkoTyhja());

      // Tulostetaan pino.
      tulosta(pino);

      // lisää(B)
      System.out.println("lisää(B)");
      pino.lisaa("B");

      // koko() = 2
      System.out.print("koko() = ");
      System.out.println(pino.koko());

      // Tulostetaan pino.
      tulosta(pino);

      // lisää(C)
      System.out.println("lisää(C)");
      pino.lisaa("C");

      // koko() = 3
      System.out.print("koko() = ");
      System.out.println(pino.koko());

      // lisää(D)
      System.out.println("lisää(D)");
      pino.lisaa("D");

      // koko() = 4
      System.out.print("koko() = ");
      System.out.println(pino.koko());

      // Tulostetaan pino.
      tulosta(pino);

      // lisää(E)
      System.out.println("lisää(E)");
      pino.lisaa("E");

      // Pino täynnä: koko() = 5
      System.out.print("koko() = ");
      System.out.println(pino.koko());

      // Tulostetaan pino.
      tulosta(pino);
      
      // Yritetään lisätä vielä yksi kirjain, vaikka pino täynnä
      System.out.println("lisää(F)");
      pino.lisaa("F");
      
      System.out.print("koko() = ");
      System.out.println(pino.koko());

      // Tulostetaan pino.
      tulosta(pino);

      // poista() = E
      System.out.print("poista() = ");
      System.out.println(pino.poista());

      // koko() = 4
      System.out.print("koko() = ");
      System.out.println(pino.koko());

      // ylin() = D
      System.out.print("ylin() = ");
      System.out.println(pino.ylin());

      // koko() = 4
      System.out.print("koko() = ");
      System.out.println(pino.koko());

      // Tulostetaan pino.
      tulosta(pino);

      // poista() = D
      System.out.print("poista() = ");
      System.out.println(pino.poista());

      // koko() = 3
      System.out.print("koko() = ");
      System.out.println(pino.koko());

      // poista() = C
      System.out.print("poista() = ");
      System.out.println(pino.poista());

      // koko() = 2
      System.out.print("koko() = ");
      System.out.println(pino.koko());

      // poista() = B
      System.out.print("poista() = ");
      System.out.println(pino.poista());

      // koko() = 1
      System.out.print("koko() = ");
      System.out.println(pino.koko());

      // Tulostetaan pino.
      tulosta(pino);

      // poista() = A
      System.out.print("poista() = ");
      System.out.println(pino.poista());

      // Pino tyhjä: koko() = 0
      System.out.print("koko() = ");
      System.out.println(pino.koko());

      // onkoTyhjä() = true
      System.out.print("onkoTyhjä() = ");
      System.out.println(pino.onkoTyhja());
   }
}
