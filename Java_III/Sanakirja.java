/*
 * 
 * Sanakirja - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 6 - Tehtävä 2
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

// Importataan java.util-pakkaus kokonaisuudessaan
import java.util.*;

public class Sanakirja {
   
   public static void main(String[] args) {
      
      System.out.println("Hello! Welcome to a tiny English-Finnish dictionary.");
      
      // Luodaan Scanner-olio syötteiden lukua varten
      Scanner r = new Scanner(System.in);
      
      // Alustetaan hajautustaulun muuttuja ja liitetään siihen olio
      HashMap<String, String> sanakirja = new HashMap<String, String>();
      
      // Lippumuuttuja silmukoita varten
      boolean jatkuu;
      
      do {
         System.out.println("Please, say it in English:");
         String enkuks = r.nextLine();
         System.out.println("Please, say it in Finnish:");
         String suomeks = r.nextLine();
         // Lisätään englannin kielinen sana ja sen suomenkielinen vastine sanakirjaan
         sanakirja.put(enkuks, suomeks);
         // Lopetetaan silmukka (sanojen kysely) jos käyttäjä syötti saman sanaparin
         if (enkuks.equals(suomeks)) {
            jatkuu = false;
         }
         else {
            jatkuu = true;
         }
      }
      while (jatkuu);
      
      do {
         System.out.println("Please, enter a word:");
         String sana = r.nextLine();
         // Haetaan englannin kieliselle sanalle suomenkielistä vastinetta.
         // get-operaatio palauttaa null-arvon jos se ei löydä haettua avainta.
         String vastine = sanakirja.get(sana);
         // Lopetetaan silmukointi, jos syöte on sana, jota ei löydy sanakirjasta
         if (vastine == null) {
            jatkuu = false;
         }
         // Tulostetaan englanninkielistä sanaa vastaava suomennos
         else {
            System.out.println(vastine);
            jatkuu = true;
         }
         
      }
      while (jatkuu);
      
      System.out.println("Bye, bye!");
   }
}
