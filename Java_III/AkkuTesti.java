/*
 * 
 * AkkuTesti - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 5 - Tehtävä 4
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class AkkuTesti {
   public static void main(String[] args) {
      System.out.println("Hello! I test batteries.");

      // Luodaan akkuja testausta varten.
      Akku uusi = new Akku('H');
      Akku kaytetty = new Akku('K');
      Akku heikko = new Akku('A');
      Akku uudehko = new Akku('H');

      // Tulostetaan akut.
      System.out.println(uusi);
      System.out.println(kaytetty);
      System.out.println(heikko);
      System.out.println(uudehko);

      // Vertaillaan akkuja.
      System.out.println(uusi.equals(kaytetty));
      System.out.println(uusi.equals(uudehko));
      System.out.println(heikko.equals(kaytetty));
      System.out.println(heikko.equals(heikko));      // Verrataan itseensä
      
      // Vertaillaan akkua olemattomaan ja väärän tyyppiseen olioon.
      System.out.println(uusi.equals(null));
      System.out.println(uusi.equals(5));

      // Tarkistetaan, että hajautuskoodi on sama, kun equals-palauttaa true-arvon.
      System.out.println(uusi.hashCode());
      System.out.println(uudehko.hashCode());
      System.out.println(heikko.hashCode());
   }
}
