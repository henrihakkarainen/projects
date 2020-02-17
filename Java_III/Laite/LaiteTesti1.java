/*
 * 
 * LaiteTesti1 - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 5 - Tehtävä 5
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class LaiteTesti1 {
   public static void main(String[] args) {
      
      System.out.println("Hello! I test machines.");
      
      // Luodaan laitteita testausta varten.
      Laite kaynnissa = new Laite(1);
      Laite nukkumassa = new Laite(2);
      Laite sammunut = new Laite(3);
      Laite sammutettu = new Laite(3);

      // Tulostetaan laitteiden alkutilanne.
      System.out.println(kaynnissa);
      System.out.println(nukkumassa);
      System.out.println(sammunut);
      System.out.println(sammutettu);

      // Vertaillaan laitteita.
      System.out.println(kaynnissa.equals(kaynnissa));      // Verrataan itseensä
      System.out.println(kaynnissa.equals(sammutettu));
      System.out.println(kaynnissa.equals(nukkumassa));
      System.out.println(sammunut.equals(sammutettu));
      
      // Tarkistetaan, että hajautuskoodi on sama, kun equals-palauttaa true-arvon.
      System.out.println(sammutettu.hashCode());
      System.out.println(sammunut.hashCode());
      System.out.println(kaynnissa.hashCode());
      
      // Vaihdetaan toiseen sammutettuun laitteeseen toinen akku.
      Akku romu = new Akku('A');
      sammutettu.akku(romu);
      
      // Vertaillaan uudestaan.
      System.out.println(sammunut.equals(sammutettu));
      
      // Tarkistetaan, että hajautuskoodi ei ole enää sama, koska equals palautti
      // false-arvon.
      System.out.println(sammutettu.hashCode());
      System.out.println(sammunut.hashCode());
      
      // Vertaillaan akkua olemattomaan ja väärän tyyppiseen olioon.
      System.out.println(kaynnissa.equals(null));
      System.out.println(kaynnissa.equals("abc"));
   }
}
