// Lisätään pakkaukseen
package ajoneuvot;

/*
 * 
 * Auto - luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 5 - Tehtävä 8
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class Auto extends Ajoneuvo implements Driftaava {
   
   /*
    * Ilmentymäattribuutit
    */
    
   private String merkki;
   
   private String malli;
   
   /*
    * Rakentajat
    */
    
   // Oletusrakentajassa luodaan auto, jonka on merkiltään Volvo ja malliltaan V60
   public Auto() {
      merkki = "Volvo";
      malli = "V60";
   }
   
   // Parametrillinen rakentaja, jossa autolle asetetaan ulkoisen tahon määrittelemä
   // merkki (m), malli (n) ja kilometrit (km). Arvot asetetaan vain mikäli se on
   // sallittua, eli arvot ovat oikeelliset.
   public Auto(String m, String n, int km) {
      super(km);
      asetaMerkki(m);
      asetaMalli(n);
   }
   
   /*
    * Aksessorit
    */
    
   public String haeMerkki() {
      return merkki;
   }
   
   public void asetaMerkki(String valm) {
      if (valm != null && valm.length() > 0) {
         merkki = valm;
      }
   }
   
   public String haeMalli() {
      return malli;
   }
   
   public void asetaMalli(String m) {
      if (m != null && m.length() > 0) {
         malli = m;
      }
   }
   
   /*
    * Julkiset metodit
    */
   
   // Metodissa luodaan ja palautetaan merkkijono, johon on yhdistetty auton
   // valmistaja ja malli.
   public String merkkiJaMalli() {
      String yhdistetty = merkki + " " + malli;
      return yhdistetty;
   }
   
   /*
    * Toteutut metodit
    */
   
   // Metodi tulostaa auton käynnistyessä syntyvän äänen (kuvitellaan, että
   // jokaisessa autossa moottorista kuuluu samanlainen ääni käynnistyessään).
   @Override
   public void kaynnista() {
      System.out.println("VRUMMMmmm!");
   }
   
   // Metodissa kuvataan autolla tapahtuvaa driftaamista.
   @Override
   public void driftaa() {
      System.out.println("Takapyörät ovat \"irti\" maasta ja auto liukuu siististi..");
   }
   
   // Metodissa kuvataan autolla tapahtuvaa 360-asteen pyörähdystä käsijarrun avulla.
   @Override
   public void kasijarruPyorahdys() {
      System.out.println("Liukuu sulavan ympyrän..");
   }
   
   /*
    * Korvatut metodit
    */
   
   // Kutsutaan yliluokan toString()-metodia ja lisätään sen palauttaman
   // merkkijonon perään auton merkki ja malli.
   @Override
   public String toString() {
      return super.toString() + "\n- Merkki: " + merkki + "\n- Malli: " + malli;
   }
}
