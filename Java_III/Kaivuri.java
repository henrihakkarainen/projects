/* 
 * Viikkoharjoitus 1, tehtävä 5.
 *  
 * Olio-ohjelmoinnin perusteet, kevät 2019, Jorma Laurikkala.
 *
 * Kaivuria mallintava rikkonainen luokka.
 * 
 * Korjannut: Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 *
 */

public class Kaivuri {

   /* 
    * Attribuutit.
    *
    */

   // Kaivurin paino tonneina.
   private double paino;

   // Tosi, jos kyseessä on teloilla liikkuva kaivuri.
   private boolean telat;

   // Kaivurin väri.
   private String vari;

   /* 
    * Aksessorit.
    *
    */

   public double paino() {
      return paino;
   }

   // Asetetaan kaivurille yhden desimaalin tarkkuudella ilmaistu paino.
   public void paino(double p) {
      /* 
       * Tässä oli käytössä saman niminen muuttuja, kuin attribuutti "paino"
       * jolloin attribuutille ei asetettu arvoa if-lauseen sijoituksessa.
       * Muokattu metodissa muuttujan nimeä sopivammaksi, ettei tule konfliktia.
       */
       // Siirretään desimaalierottimen paikkaa ja katkaistaan luku.
      double uusiPaino = (int)(10 * p);

      // Palautetaan desimaalierotin alkuperäiselle paikalle.
      p = uusiPaino / 10;

      if (p >= 1 && p <= 100) {
         paino = p;
      }
   }

   public boolean telat() {
      return telat;
   }

   public void telat(boolean t) {
      telat = t;
   }

   public void vari(String v) {
      /*
       * If-lauseessa ehdot olivat väärinpäin, eli mikäli yritetään sijoittaa null-
       * arvoa, niin ohjelma kaatuu koska null-arvoisesta String-oliosta ei voida
       * laskea sen pituutta length()-operaatiolla. Korjattu ehtolauseke, eli nyt
       * jos v = null, niin metodin käsittely pysähtyy ennen length()-operaatiota
       * ja ohjelma ei kaadu.
       */
      if (v != null && v.length() > 0) {
         vari = v;
      }
   }

   public String vari() {
      return vari;
   }
}
