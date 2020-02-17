/* 
 * Lopputentti 6.3.2019, tehtävä 3.
 *  
 * Olio-ohjelmoinnin perusteet I, kevät 2019. Jorma Laurikkala, jorma.laurikkala@tuni.fi.
 *
 * Valaisimessa käytettävää lamppua mallintava luokka.
 *
 */

public class Lamppu {

   /*
    * Ilmentymäattribuutit.
    *
    */

   // True, kun lamppu on kunnossa eli voi tuottaa valovirtaa. False, kun lamppu
   // on rikki.
   private boolean kunnossa;

   // Lampun valovirta lumeneina mitattuna (> 0).
   private int valovirta;

   /*
    * Rakentajat.
    *
    */

   /* Luodaan toimiva 470 lm lamppu.
    */
   public Lamppu() {
      kunnossa(true);
      valovirta(470);
   }

   /* Valovirralle jää Javan antama alkuarvo (nolla), jos valovirran parametri
    * on virheellinen.
    */
   public Lamppu(boolean onko, int lm) {
      kunnossa(onko);
      valovirta(lm);
   }

   /*
    * Aksessorit.
    *
    */

   public boolean kunnossa() {
      return kunnossa;
   }

   public void kunnossa(boolean onko) {
      kunnossa = onko;
   }

   public int valovirta() {
      return valovirta;
   }

   public void valovirta(int lm) {
      if (lm > 0) {
         valovirta = lm;
      }
   }

  /*
   * Object-luokan metodien korvaukset.
   *
   */

   /* Palauttaa merkkijonon, joka koostuu lampun kunnosta, yhdestä välilyönnistä,
    * valovoimasta ja merkkijonosta " lm". Esimerkiksi "true 850 lm".
    */
   @Override
   public String toString() {
      return kunnossa + " " + valovirta + " lm";
   }
}
