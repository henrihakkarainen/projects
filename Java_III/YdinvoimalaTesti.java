/*
 * 
 * YdinvoimalaTesti - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 5 - Tehtävä 7
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class YdinvoimalaTesti {
   
   public static void main(String[] args) {
      
      // Luodaan ydinvoimalaolioita
      Ydinvoimala olkiluoto1 = new Ydinvoimala(3700.5);
      Ydinvoimala olkiluoto2 = new Ydinvoimala(4000.0);
      Ydinvoimala olkiluoto3 = new Ydinvoimala(4000.0);
      
      // Verrataan ydinvoimaloita keskenään
      System.out.println(olkiluoto1.compareTo(olkiluoto2)); // -1
      System.out.println(olkiluoto2.compareTo(olkiluoto3)); // 0
      System.out.println(olkiluoto3.compareTo(olkiluoto1)); // 1
      
      // Itseensä vertaaminen
      System.out.println(olkiluoto1.compareTo(olkiluoto1)); // 0
      
   }
}
