/*
 * 
 * Laite - luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 5 - Tehtävä 5
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public class Laite implements Ohjattava {
   
   /*
    * Ilmentymäattribuutit
    */
   
   private int tila;
   
   private Akku akku;
   
   /*
    * Rakentajat
    */
   
   public Laite() {
      akku = new Akku(Akku.HYVA);
      tila = Ohjattava.SAMMUTETTU;
   }
   
   public Laite(int t) throws IllegalArgumentException {
      akku = new Akku(Akku.HYVA);
      
      if (t != Ohjattava.KAYNNISSA && t != Ohjattava.NUKKUU &&
          t != Ohjattava.SAMMUTETTU) {
         throw new IllegalArgumentException();
      }
      
      tila = t;
   }
   
   /*
    * Aksessorit
    */
   
   public Akku akku() {
      return akku;
   }
   
   public void akku(Akku muutos) throws IllegalArgumentException {
      if (muutos == null) {
         throw new IllegalArgumentException();
      }
      akku = muutos;
   }
   
   /*
    * Rajapinnasta toteutetut metodit
    */
    
   public void kaynnisty() {
      if (tila == Ohjattava.SAMMUTETTU) {
         tila = Ohjattava.KAYNNISSA;
      }
   }
   
   public void nuku() {
      if (tila == Ohjattava.KAYNNISSA) {
         tila = Ohjattava.NUKKUU;
      }
   }
   
   public void heraa() {
      if (tila == Ohjattava.NUKKUU) {
         tila = Ohjattava.KAYNNISSA;
      }
   }
   
   public void sammu() {
      if (tila == Ohjattava.KAYNNISSA) {
         tila = Ohjattava.SAMMUTETTU;
      }
   }
   
   public int tila() {
      return tila;
   }
   
   /*
    * Korvatut metodit
    */
   
   @Override
   public String toString() {
      String luokka = getClass().getSimpleName();
      return luokka + " " + tila + " " + akku.toString();
   }
   
   // Palauttaa true, jos laitteen tila ja akku on sama kuin vertailtavassa oliossa
   @Override
   public boolean equals(Object obj) {
      try {
         Laite apu = (Laite)obj;
         
         return tila == apu.tila() && akku.equals(apu.akku());
      }
      catch (Exception e) {
         return false;
      }
   }
   
   @Override
   public int hashCode() {
      int tulos = 17;
      tulos = 31 * tulos + Integer.hashCode(tila);
      tulos = 31 * tulos + akku.hashCode();
      return tulos;
   }
   
}
