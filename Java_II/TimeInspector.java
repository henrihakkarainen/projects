/*
 * 
 * TimeInspector - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 2 - Tehtävä 6
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class TimeInspector {
   // Operaatio vastaanottaa kolme parametria: h = tunnit, m = minuutit ja
   // s = sekunnit. Operaatio palauttaa totuusarvon true jos tunnit ovat välillä
   // 0-23 ja minuutit ja sekunnit ovat välillä 0-59, muuten paluuarvo on false
   public static boolean inspectTime(int h, int m, int s) {
      if ((h >= 0 && h <= 23) && (m >= 0 && m <= 59) && (s >= 0 && s <= 59)) {
         return true;
      }
      else {
         return false;
      }
   }
   
   public static void main(String[] args) {
      System.out.println("Hello! I inspect a 24-hour time.");
      System.out.println("Please, enter hours:");
      int tunnit = In.readInt();
      System.out.println("Please, enter minutes:");
      int minuutit = In.readInt();
      System.out.println("Please, enter seconds:");
      int sekunnit = In.readInt();
      boolean laillinen = inspectTime(tunnit, minuutit, sekunnit);
      if (laillinen) {
         System.out.println("Time is valid.");
      }
      else {
         System.out.println("Time is invalid.");
      }
   }
}
