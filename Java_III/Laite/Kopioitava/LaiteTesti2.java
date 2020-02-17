/*
 * 
 * LaiteTesti2 - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 5 - Tehtävä 6
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class LaiteTesti2 {
   public static void main(String[] args) {
      
      System.out.println("Hello! I test machines.");
      
      // Luodaan laitteita testausta varten.
      Laite kaynnissa = new Laite(1);
      Laite sammunut = new Laite(3);

      // Tulostetaan laitteiden alkutilanne.
      System.out.println(kaynnissa);
      System.out.println(sammunut);
      
      // Kopioidaan sammutettu laite.
      Laite sammutettu = sammunut.copy();

      // Vertaillaan laitteita.
      System.out.println(kaynnissa.equals(sammutettu));
      System.out.println(sammunut.equals(sammutettu));
      
      // Onko sammuneilla laitteilla viite samaan akkuun
      System.out.println(sammunut.akku() == sammutettu.akku());  // false
      
      // Vaihdetaan toiseen sammutettuun laitteeseen toinen akku.
      Akku romu = new Akku('A');
      sammutettu.akku(romu);
      
      // Vertaillaan uudestaan.
      System.out.println(sammunut.equals(sammutettu));
      
      // Onko sammutetuilla laitteilla erilaiset akut
      System.out.println(sammunut.akku());
      System.out.println(sammutettu.akku());
   }
}
