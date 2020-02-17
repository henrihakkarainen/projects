/*
 * 
 * ShortestPart - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 4 - Tehtävä 4
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class ShortestPart {
   /*
    * Operaatio vastaanottaa merkkijonon ja päättelee sen lyhimmän osan
    * pituuden ja palauttaa sen paluuarvonaan.
    */
   public static int measureShortestPart(String mjono) {
      String[] osat = mjono.split("[ ]");
      int pituus = osat[0].length();
      for (int i = 0; i < osat.length; i++) {
         if (osat[i].length() < pituus) {
            pituus = osat[i].length();
         }
      }
      return pituus;
   }
   
   public static void main(String[] args) {
      System.out.println("Hello! I find the length of the shortest substring.");
      System.out.println("Please, enter a string:");
      String lause = In.readString();
      int lyhyin = measureShortestPart(lause);
      System.out.println("The length is " + lyhyin + ".");
   }
}
