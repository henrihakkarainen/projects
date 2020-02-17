/*
 * 
 * Pulla - luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 2 - Tehtävä 3
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class Pulla {
   
   /*
    * Attribuutit
    */
    
   private double paino;
   
   private boolean laktoositon;
   
   /*
    * Rakentajat
    */
   
   // Oletusrakentajassa pullan painoksi asetetaan 50 grammaa ja se on laktoositon.
   public Pulla() {
      paino = 50;
      laktoositon = true;
   }
   
   // Parametrillisessa rakentajassa asetetaan pullalle ulkoisen tahon määrittelemä
   // paino (uusiPaino) ja tieto onko laktoositon (onkoLaktoositon). Paino asetetaan
   // vain jos arvo on oikeellinen (1-1000 grammaa). Laktoosittomuusarvo asetetaan
   // suoraan attribuutin arvoksi.
   public Pulla(double uusiPaino, boolean onkoLaktoositon) {
      paino(uusiPaino);
      laktoositon(onkoLaktoositon);
   }
   
   /*
    * Aksessorit
    */
    
   public double paino() {
      return paino;
   }
   
   public void paino(double w) {
      if (w >= 1 && w <= 1000) {
         paino = w;
      }
   }
   
   public boolean laktoositon() {
      return laktoositon;
   }
   
   public void laktoositon(boolean v) {
      laktoositon = v;
   }
}
