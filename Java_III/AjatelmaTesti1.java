/*
 * Viikkoharjoitus 5, tehtävä 1.
 *  
 * Olio-ohjelmoinnin perusteet I, kevät 2019. Jorma Laurikkala, jorma.laurikkala@tuni.fi.
 *
 * Ajatelman korvattuja metodeja testaava luokka.
 *
 */

public class AjatelmaTesti1 {
   public static void main(String[] args) {
      // Moikataan käyttäjää ja kerrotaan ohjelmasta.
      System.out.println("Hello! I test proverbs.");

      // Luetaan ajatelma käyttäjältä.
      System.out.println("Please, enter a proverb:");
      String lause = In.readString();
      
      // Luodaan syötteestä olio.
      Ajatelma ajatelma = new Ajatelma(lause);
      
      // Tulostetaan olio.
      System.out.println(ajatelma);
   }
}
