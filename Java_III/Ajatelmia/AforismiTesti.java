/*
 * Viikkoharjoitus 5, tehtävä 3.
 *
 * Olio-ohjelmoinnin perusteet I, kevät 2019. Jorma Laurikkala, jorma.laurikkala@tuni.fi.
 *
 * Aforismia ja sen korvattuja metodeja testaava luokka.
 *
 */

public class AforismiTesti {
   public static void main(String[] args) {
      // Ilmoitus ajatusvirheestä vakiona.
      final String VIRHE = "Faulty reasoning!";

      // Yritetään luoda olio käyttäen virheellistä tietoa.
      try {
         Aforismi epaonnistunutAforismi1 = new Aforismi("Haste makes waste.", null);
      }
      catch (IllegalArgumentException e) {
         System.out.println(VIRHE);          // Faulty reasoning!
      }

      // Yritetään luoda olio käyttäen erilaista virheellistä tietoa.
      try {
         Aforismi epaonnistunutAforismi2 = new Aforismi("Haste makes waste.", "-");
      }
      catch (IllegalArgumentException e) {
         System.out.println(VIRHE);          // Faulty reasoning!
      }

      // Luodaan olio antaen oikeellista tietoa ja yritetään asettaa attribuutille
      // virheellistä tietoa.
      try {
         Aforismi onnistunutAforismi1 = new Aforismi("Haste makes waste.", "Anonymous");
         onnistunutAforismi1.lausuja(null);
      }
      catch (IllegalArgumentException e) {
         System.out.println(VIRHE);          // Faulty reasoning!
      }

      // Luodaan olio antaen oikeellista tietoa ja yritetään asettaa attribuutille
      // virheellistä tietoa.
      try {
         Aforismi onnistunutAforismi2 = new Aforismi("Haste makes waste.", "Anonymous");
         onnistunutAforismi2.lausuja("-");
      }
      catch (IllegalArgumentException e) {
         System.out.println(VIRHE);          // Faulty reasoning!
      }

      // Luodaan samanlaisia ja erilaisia aforismeja antaen oikeellista tietoa.
      Aforismi aforismi1 = new Aforismi("The time is always right to do what is right.", "Martin Luther King");
      Aforismi aforismi2 = new Aforismi("The time is always right to do what is right.", "Martin Luther King");
      Aforismi aforismi3 = new Aforismi("The time is always right to do what is right.", "Anonymous");
      Aforismi aforismi4 = new Aforismi("Haste makes waste.", "Anonymous");

      // Tulostetaan aforismit.
      System.out.println(aforismi1); // "The time is always right to do what is right."
                                     // - Martin Luther King
      System.out.println(aforismi2); // "The time is always right to do what is right."
                                     // - Martin Luther King
      System.out.println(aforismi3); // "The time is always right to do what is right."
                                     // - Anonymous
      System.out.println(aforismi4); // "Haste makes waste."
                                     // - Anonymous

      // Vertaillaan aforismeja.
      System.out.println(aforismi1.equals(aforismi1));      // true
      System.out.println(aforismi1.equals(aforismi2));      // true
      System.out.println(aforismi2.equals(aforismi1));      // true
      System.out.println(aforismi1.equals(aforismi3));      // false
      System.out.println(aforismi3.equals(aforismi4));      // false
      
      // Vertaillaan aforismia olemattomaan ja väärän tyyppiseen olioon.
      System.out.println(aforismi1.equals(null));           // false
      System.out.println(aforismi1.equals(42));             // false

      // Tarkistetaan, että hajautuskoodi on sama, kun equals-palauttaa true-arvon.
      System.out.println(aforismi1.hashCode());             // 1652369562
      System.out.println(aforismi2.hashCode());             // 1652369562
      System.out.println(aforismi3.hashCode());             // -1934312417
      System.out.println(aforismi4.hashCode());             // 1577979002
   }
}
