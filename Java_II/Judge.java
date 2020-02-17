/*
 * 
 * Judge - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 4 - Tehtävä 2
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class Judge {
   /*
    * Operaatio vastaanottaa parametrina kokonaisluvun (l) ja palauttaa lukua
    * vastaavan merkin taulukon mukaisesti.
    */
   public static char convertToCharacter(int l) {
      final char[] merkit = { '#', '@', '&', '$', '%', 'x', '*', 'o', '|', '!',
                        ';', ':', '\'', ',', '.', ' '};
      if (l < 0 || l >= merkit.length) {
         return Character.MAX_VALUE;
      }
      else {
         return merkit[l];
      }
   }
   
   public static void main(String[] args) {
      System.out.println("Hello! I am a judge of character.");
      System.out.println("Please, enter an integer:");
      int luku = In.readInt();
      char tuomio = convertToCharacter(luku);
      if (luku > 0 && luku <= 15) {
         System.out.println("I judge " + luku + " as '" + tuomio + "'.");
      }
      else {
         System.out.println("I cannot judge " + luku + ".");
      }
   }
}
