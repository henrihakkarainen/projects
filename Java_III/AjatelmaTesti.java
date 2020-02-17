/*
 * 
 * AjatelmaTesti - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 4 - Tehtävä 5
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public class AjatelmaTesti {
   
   public static void main(String[] args) {
      
      try {
         Ajatelma tyhja = new Ajatelma(null);
      }
      
      catch (Exception e) {
         System.out.println("Ajatelma ei voi olla null.");
      }
      
      try {
         Ajatelma lyhyt = new Ajatelma("Y");
      }
      
      catch (Exception e) {
         System.out.println("Liian lyhyt ajatelma.");
      }
      
      try {
         Ajatelma viisaus1 = new Ajatelma("Elämä on ihmisen parasta aikaa.");
         
         viisaus1.lause(null);
      }
      
      catch (Exception e) {
         System.out.println("Yritit asettaa tyhjää ajatelmaa.");
      }
      
      try {
         Ajatelma viisaus2 = new Ajatelma("Fifty-sixty.");
         
         viisaus2.lause("X");
      }
      
      catch (Exception e) {
         System.out.println("Muokkasit ajatelmasta liian lyhyen.");
      }
      
      try {
         Ajatelma viisaus3 = new Ajatelma("Ei tippa tapa ja ämpäriin ei huku.");
         
         System.out.println(viisaus3.lause());
      }
      
      catch (Exception e) {
         System.out.println(e.getMessage());
      }
      
   }
}
