/*
 * 
 * OmaListaTesti2 - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 6 - Tehtävä 4
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 *
 */

import java.util.LinkedList;

public class OmaListaTesti2 {
   public static void main(String[] args) {
      
      // Luodaan OmaLista-tyyppinen olio, joka varattu String-tyyppisille viitteille
      OmaLista<String> lista = new OmaLista<String>();
      
      // Lisätään listalle merkkijonoja
      lista.add("one");
      lista.add("two");
      lista.add("three");
      lista.add("four");
      
      // Tulostetaan lista alkutilanteessa
      System.out.print("[ ");
         for (String m : lista) {
            System.out.print("\"" + m + "\" ");
         }
      System.out.println("]");
      
      // Kutsutaan omaa kaanteisestiTaulukkoon-operaatiota ja talletetaan paluuarvo
      // muuttujaan
      Object[] uusiLista = lista.kaanteisestiTaulukkoon();
      
      // Tulostetaan listan käännetty järjestys
      System.out.print("[ ");
      for (int i = 0; i < uusiLista.length; i++) {
         System.out.print("\"" + uusiLista[i] + "\" ");
      }
      System.out.println("]");
   }
}
