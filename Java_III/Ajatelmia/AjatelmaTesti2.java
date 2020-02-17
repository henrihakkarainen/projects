/*
 * Viikkoharjoitus 5, tehtävä 2.
 *
 * Olio-ohjelmoinnin perusteet I, kevät 2019. Jorma Laurikkala, jorma.laurikkala@tuni.fi.
 *
 * Ajatelman korvattuja metodeja testaava luokka.
 *
 */

public class AjatelmaTesti2 {
   public static void main(String[] args) {
      // Moikataan käyttäjää ja kerrotaan ohjelmasta.
      System.out.println("Hello! I test proverbs.");

      // Luodaan samanlaisia ja erilaisia ajatelmia.
      Ajatelma ajatelma1 = new Ajatelma("The time is always right to do what is right.");
      Ajatelma ajatelma2 = new Ajatelma("The time is always right to do what is right.");
      Ajatelma ajatelma3 = new Ajatelma("Haste makes waste.");

      // Tulostetaan ajatelmat.
      System.out.println(ajatelma1); // "The time is always right to do what is right."
      System.out.println(ajatelma2); // "The time is always right to do what is right."
      System.out.println(ajatelma3); // "Haste makes waste."

      // Vertaillaan ajatelmia.
      System.out.println(ajatelma1.equals(ajatelma1));      // true
      System.out.println(ajatelma1.equals(ajatelma2));      // true
      System.out.println(ajatelma2.equals(ajatelma1));      // true
      System.out.println(ajatelma1.equals(ajatelma3));      // false
      
      // Vertaillaan ajatelmaa olemattomaan ja väärän tyyppiseen olioon.
      System.out.println(ajatelma1.equals(null));           // false
      System.out.println(ajatelma1.equals(42));             // false

      // Tarkistetaan, että hajautuskoodi on sama, kun equals-palauttaa true-arvon.
      System.out.println(ajatelma1.hashCode());             // -1167813138
      System.out.println(ajatelma2.hashCode());             // -1167813138
      System.out.println(ajatelma3.hashCode());             // 885149235
   }
}
