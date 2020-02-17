import java.util.LinkedList;

/*
 * 
 * Varasto - luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 7 - Tehtävä 5
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class Varasto {
   
   /*
    * Attribuutit
    */
    
   private int numero;
   
   private LinkedList<Akku> akut;
   
   /*
    * Rakentajat
    */
   
   public Varasto(int n) {
      numero(n);
      akut = new LinkedList<Akku>();
   }
   
   /*
    * Aksessorit
    */
    
   public int numero() {
      return numero;
   }
   
   public void numero(int n) {
      if (n > 0) {
         numero = n;
      }
   }
   
   public LinkedList<Akku> akut() {
      return akut;
   }
   
   /*
    * Omat metodit
    */
   
   // Lisätään parametrina saatava akku-tyyppinen olio listaan. Jos parametri on
   // null, niin lisäystä ei tehdä.
   public void lisaa(Akku a) {
      if (a != null) {
         akut.add(a);
      }
   }
   
   /*
    * Korvatut metodit
    */
   
   @Override
   public String toString() {
      String luokka = getClass().getSimpleName();
      
      return luokka + " " + numero;
   }
   
}
