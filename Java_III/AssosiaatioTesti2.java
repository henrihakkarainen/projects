/*
 * 
 * AssosiaatioTesti2 - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 7 - Tehtävä 5
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public class AssosiaatioTesti2 {
   
   public static void main(String[] args) {
      
      // Luodaan varasto
      Varasto sailo = new Varasto(10);
      
      System.out.println(sailo);
      
      // Luodaan muutama akku
      Akku uusi = new Akku('H');
      Akku vanha = new Akku('A');
      Akku kaytetty = new Akku('K');
      
      // Lisätään akut varastoon
      sailo.lisaa(uusi);
      sailo.lisaa(vanha);
      sailo.lisaa(kaytetty);
      
      // Tulostetaan varastossa olevien akkujen tiedot
      System.out.println("Varastossa on " + sailo.akut().size() + " kpl akkuja.");
      for (int i = 0; i < sailo.akut().size(); i++) {
         System.out.println(sailo.akut().get(i));
      }
      
      // Poistetaan varaston "päälimmäisin" eli sinne ensimmäisenä tullut akku
      sailo.akut().remove();
      
      // Tulostetaan varastossa olevien akkujen tiedot uudelleen
      System.out.println("Varastossa on " + sailo.akut().size() + " kpl akkuja.");
      for (int i = 0; i < sailo.akut().size(); i++) {
         System.out.println(sailo.akut().get(i));
      }
      
   }
}
