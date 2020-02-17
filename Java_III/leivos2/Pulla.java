/*
 * 
 * Pulla - luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 4 - Tehtävä 2
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

package leivos2;

public class Pulla extends Leivos {
   
   /*
    * Attribuutit
    */
   
   private boolean laktoositon;
   
   /*
    * Rakentajat
    */
   
   // Oletusrakentajassa pullan paino haetaan Leivos-luokan rakentajasta ja pullasta
   // tehdään laktoositon.
   public Pulla() {
      laktoositon = true;
   }
   
   // Parametrillisessa rakentajassa asetetaan pullalle ulkoisen tahon määrittelemä
   // paino (uusiPaino) kutsumalla yliluokan rakentajaa, sekä tieto onko pulla
   // laktoositon (onkoLaktoositon).
   public Pulla(double uusiPaino, boolean onkoLaktoositon) {
      super(uusiPaino);
      laktoositon(onkoLaktoositon);
   }
   
   /*
    * Aksessorit
    */
   
   public boolean laktoositon() {
      return laktoositon;
   }
   
   public void laktoositon(boolean v) {
      laktoositon = v;
   }
   
   /*
    * Korvatut metodit
    */
   
   @Override
   public boolean onkoVanha() {
      return ika > 4;
   }
   
}
