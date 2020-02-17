/*
 * 
 * ValtionpaamiesTesti - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 2 - Tehtävä 5
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public class ValtionpaamiesTesti {
   
   public static void main(String[] args) {
      // Luodaan valtionpaamies-olio oletusrakentajalla
      Valtionpaamies stubb = new Valtionpaamies();
      
      // Luodaan valtionpaamies-olio yksiparametrisella rakentajalla
      Valtionpaamies soini = new Valtionpaamies(false);
      
      // Lukumetodien palauttamat arvot talteen
      boolean valinta1 = stubb.vaaleillaValittu();
      boolean valinta2 = soini.vaaleillaValittu();
      
      // Tulostetaan arvot näytölle
      System.out.println("Stubb valittu vaaleilla: " + valinta1);
      System.out.println("Soini valittu vaaleilla: " + valinta2);
      
      // Yritetään muuttaa tietoja metodeilla
      stubb.vaaleillaValittu(false);
      soini.vaaleillaValittu(true);
      
      System.out.println();
      
      // Tulostetaan arvot näytölle
      System.out.println("Stubb valittu vaaleilla: " + stubb.vaaleillaValittu());
      System.out.println("Soini valittu vaaleilla: " + soini.vaaleillaValittu());
   }
}
