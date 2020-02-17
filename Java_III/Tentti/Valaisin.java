/*
 * Oope1 tentti - Tehtävä 3
 * 
 * Tehnyt: Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class Valaisin {
   
   private Lamppu lamppu;
   
   private boolean paalla;
   
   public Valaisin(boolean p) {
      lamppu = new Lamppu();
      paalla(p);
   }
   
   public Lamppu lamppu() {
      return lamppu;
   }
   
   public void lamppu(Lamppu uusi) {
      if (uusi != null) {
         lamppu = uusi;
      }
   }
   
   public boolean paalla() {
      return paalla;
   }
   
   public void paalla(boolean p) {
      paalla = p;
   }
   
   @Override
   public String toString() {
      return paalla + " " + lamppu.toString();
   }
   
}
