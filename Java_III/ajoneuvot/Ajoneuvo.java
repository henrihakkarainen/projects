// Lisätään pakkaukseen
package ajoneuvot;

/*
 * 
 * Ajoneuvo - abstrakti luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 5 - Tehtävä 8
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public abstract class Ajoneuvo {
   
   /*
    * Ilmentymäattribuutit
    */
   
   // Ajoneuvolla ajetut kilometrit
   private int kilometrit;
   
   /*
    * Rakentajat
    */
   
   // Oletusrakentajassa jokaiselle ajoneuvolle asetetaan ajokilometreiksi 15000 km.
   public Ajoneuvo() {
      kilometrit = 15000;
   }
   
   // Parametrillinen rakentaja, jossa asetetaan kilometrit ulkoisen tahon määrittämän
   // arvon perusteella. Kilometrit asetetaan vain, mikäli se on sallittua.
   public Ajoneuvo(int km) {
      asetaKilometrit(km);
   }
   
   /*
    * Aksessorit
    */
   
   public int haeKilometrit() {
      return kilometrit;
   }
   
   // Kilometrit oltava yhden ja miljoonan väliltä (1 - 1000000)
   public void asetaKilometrit(int km) {
      if (km >= 0 && km < 1000000) {
         kilometrit = km;
      }
   }
   
   /*
    * Abstraktit metodit
    */
   
   // Metodissa mallinnetaan ajoneuvon moottorin käynnistymisestä syntyvää ääntä.
   public abstract void kaynnista();
   
   /*
    * Korvatut metodit
    */
   
   // Palautetaan luokan nimi ja ajoneuvolla ajetut ajokilometrit merkkijonona.
   @Override
   public String toString() {
      String luokanNimi = getClass().getSimpleName();
      return luokanNimi + ":\n- Kilometrit: " + kilometrit;
   }
   
}
