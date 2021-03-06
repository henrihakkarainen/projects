/*
 * 
 * LeivosTesti - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 3 - Tehtävä 2
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public class LeivosTesti {
   
   public static void main(String[] args) {
      // Luodaan pulla ja munkki oliot oletusrakentajilla
      Munkki mums = new Munkki();
      Pulla pums = new Pulla();
      
      // Tulostetaan olioiden tiedot näytölle
      System.out.println("Munkin paino: " + mums.paino() + " ja täyte: " + mums.tayte());
      System.out.println("Pullan paino: " + pums.paino() + " ja onko laktoositon: " +
                         pums.laktoositon());
      System.out.println();
      
      // Luodaan pulla ja munkki oliot parametrillisilla rakentajilla
      Munkki makea = new Munkki(140.5, 3);
      Pulla pitko = new Pulla(1001, false);
      
      // Tulostetaan olioiden tiedot näytölle
      System.out.println("Munkin paino: " + makea.paino() + " ja täyte: " + makea.tayte());
      System.out.println("Pullan paino: " + pitko.paino() + " ja onko laktoositon: " +
                         pitko.laktoositon());
      
   }
}
