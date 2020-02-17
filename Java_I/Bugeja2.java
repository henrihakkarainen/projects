/*
 * Viikkoharjoitus 2, tehtävä 4.
 *
 * Lausekielinen ohjelmointi I, syksy 2018.
 *
 * Jorma Laurikkala (jorma.laurikkala@uta.fi).
 *
 * Pieni muuttujiin liittyviä kielioppivirheitä sisältävä ohjelma.
 * 
 * Korjannut: Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 *
 */

public class Bugeja2 {
   public static void main(String[] args) {
      // Esitellään ja alustetaan muuttuja pituudelle (m).
      // Korjataan pituus-muuttujalle tyyppi (double) ja
      // korjataan välimerkki pilkun tilalle piste.
      double pituus = 2.5;

      // Esitellään ja alustetaan muuttuja leveydelle (m).
      // Korjataan muuttujan tyyppi float -> double
      double leveys = 1.5;

      // Esitellään ja alustetaan muuttuja korkeudelle (m).
      double korkeus;
      // Muuttuja korkeus on jo alustettu ylemmällä rivillä,
      // joten poistetaan tyyppi double alla olevalta riviltä,
      // jossa korkeus-muuttujalle annetaan uusi arvo 3.
      korkeus = 3;

      // Kerrotaan käyttäjälle mitä ohjelma tekee.
      System.out.println("Moi! Lasken suorakulmaisen särmiön tilavuuden.");

      // Lasketaan tilavuus ja sijoitetaan tulos muuttujaan.
      // Esitellään ennen tätä muuttuja tilavuudelle
      double tilavuus;
      tilavuus = pituus * leveys * korkeus;

      // Tulostetaan tilavuus näytölle.
      // Korjataan muuttujan pintaAla tilalle muuttuja tilavuus, sillä
      // ohjelmassa ei ole edes esitetty pintaAla-nimistä muuttujaa.
      // Lisäksi hienosäädetään näytölle tulostuvaa lausetta, poistetaan
      // "," tuosta tilavuuden ja m^3 välistä ja siirretään ennen kun -sanaa.
      System.out.print("Tilavuus on " + tilavuus + " m^3, kun pituus on ");
      System.out.print(pituus + " m, leveys on " + leveys + " m ja korkeus ");
      System.out.println(korkeus + " m.");
      // Hienosäätönä lisätty yksi välilyönti korkeuden ja sitä
      // seuraavan m-kirjaimen perään, koska muutkin arvot oli
      // erotettu välilyönnillä (3.0m vs. 3.0 m)

      // Esitellään muuttuja tilavuudelle.
      // Tämä tehty jo ylempänä, joten kommentoidaan alla oleva rivi
      // double tilavuus;
   }
}
