/*
 * 
 * Aforismi - luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 5 - Tehtävä 3
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class Aforismi extends Ajatelma {
   
   /*
    * Attribuutit
    */
   
   private String lausuja;
   
   /*
    * Rakentajat
    */
   
   // Kaksiparametrinen rakentaja, jonka ensimmäinen parametri a on yliluokan
   // attribuutille ajatelma ja jälkimmäinen parametri l on lausujalle.
   public Aforismi(String a, String l) throws IllegalArgumentException {
      super(a);
      lausuja(l);
   }
   
   /*
    * Aksessorit
    */
   
   public String lausuja() {
      return lausuja;
   }
   
   public void lausuja(String uus) throws IllegalArgumentException {
      if (uus == null || uus.length() < 2) {
         throw new IllegalArgumentException();
      }
      lausuja = uus;
   }
   
   /*
    * Korvatut metodit
    */
   
   @Override
   public String toString() {
      return super.toString() + System.lineSeparator() + "- " + lausuja;
   }
   
   // Palautetaan true, jos lause ja lausuja ovat samat.
   @Override
   public boolean equals(Object obj) {
      try {
         Aforismi apu = (Aforismi)obj;
         return super.equals(obj) && lausuja.equals(apu.lausuja());
      }
      catch (Exception e) {
         return false;
      }
   }
   
   @Override
   public int hashCode() {
      int tulos = super.hashCode();
      tulos = 31 * tulos + (lausuja == null ? 0 : lausuja.hashCode());
      return tulos;
   }
   
}
