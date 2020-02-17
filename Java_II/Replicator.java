/*
 * 
 * Replicator - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 2 - Tehtävä 7
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class Replicator {
   // Operaatio saa parametreinaan merkkijonon ja kokonaisluvun ja palauttaa
   // uuden merkkijonon, jossa alkuperäinen merkkijono toistuu kokonaisluvun
   // ilmoittaman määrän kertoja niin että toistot on erotettu toisistaan pilkulla
   // ja välilyönnillä. Jos lkm < 2, niin operaatio palauttaa tyhjän merkkijonon.
   public static String replicate(String lause, int lkm) {
      String paluuarvo = "";
      if (lkm < 2) {
         return paluuarvo;
      }
      else {
         for (int i = 0; i < lkm; i++) {
            // Silmukan viimeisellä kierroksella ei lisätä lauseen perään
            // pilkkua ja välilyöntiä
            paluuarvo += lause + (i == lkm - 1 ? "" : ", ");
         }
         return paluuarvo;
      }
   }
   
   public static void main(String[] args) {
      System.out.println("Hello! I replicate strings.");
      System.out.println("Please, enter a string:");
      String mjono = In.readString();
      System.out.println("Please, enter the number of replications:");
      int toistuuLkm = In.readInt();
      // Operaatiolla luodaan uusi merkkijono joka talletetaan muuttujaan
      String uusiMjono = replicate(mjono, toistuuLkm);
      // Tulostetaan monistettu merkkijono, kunhan operaatio ei ole palauttanut
      // tyhjää merkkijonoa
      if (!uusiMjono.equals("")) {
         System.out.println(uusiMjono);
      }
      // Jos merkkijono on tyhjä, niin tulostetaan virheilmoitus
      else {
         System.out.println("Error!");
      }
   }
}
