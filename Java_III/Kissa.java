/*
 * Luento 5.
 *
 * Olio-ohjelmoinnin perusteet I, Jorma Laurikkala.
 *
 * Abstraktista nisäkkäästä peritty konkreettinen kissaa mallintava luokka,
 * joka osaa tervehtiä.
 * 
 * Muokannut: Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 *
 */

public class Kissa extends Nisakas implements Tervehtiva {

   /*
    * Vakiomuotoiset attribuutit.
    *
    */
   
   // Elämien lukumäärän yläraja.
   public static final int MAXELAMAT = 9;

   /*
    * Luokka-attribuutit.
    *
    */

   // Toistaiseksi luotujen kissojen lukumäärä.
   private static int lukumaara;

   /*
    * Ilmentymäattribuutit.
    *
    */

   // Kissan väri.
   private String vari;

   // Kissan hännän tyyppi (esimerkiksi "kippura").
   private String hanta;

   /*
    * Ilmentymämetodit.
    *
    */

   /* Kissa-luokan oletusrakentajassa kissaolion väriksi asetetaan musta
    * ja hännän tyypiksi kippura.
    */
   public Kissa() {
      vari = "musta";
      hanta = "kippura";
   }

   /* Parametrillinen rakentaja, jossa kissalle asetetaan ulkoisen tahon
    * määrittelemä väri (v) ja häntä (h). Annettu arvo asetetaan vain,
    * jos se on sallittu.
    */
   public Kissa(String v, String h) {
      // Koodia lyhennetty aksessoreita kutsumalla,
      // jolloin tarvitaan vähemmän if-lauseita.
      vari(v);
      hanta(h);
   }

   /* Parametrillinen rakentaja, jossa kissalle asetetaan ulkoisen tahon
    * määrittelemä tieto elossa olemisesta (e), paino (p), väri (v) ja häntä (h).
    * Annettu arvo asetetaan vain, jos se on sallittu.
    */
   public Kissa(boolean e, double p, String v, String h) {
      // Kutsutaan yliluokan rakentajaa.
      super(e, p);

      // Koodia lyhennetty aksessoreita kutsumalla,
      // jolloin tarvitaan vähemmän if-lauseita.
      vari(v);
      hanta(h);
   }

   private void hairikoi() {
      // Tavaroita hajoaa...
   }

   public String vari() { 
      return vari;
   }

   public void vari(String v) {
      if (v != null && v.length() > 0) {
         vari = v;
      }
   }

   public String hanta() {
      return hanta;
   }

   public void hanta(String h) {
      if (h != null && h.length() > 0) {
         hanta = h;
      }
   } 

   public int lukumaara() {
      return lukumaara;
   }

   public void lukumaara(int lkm) {
      if (lkm >= 0) {
         lukumaara =lkm;
      }
   }

   /* Tulostetaan parametrina (s) annettu ääniefekti.
    */
   public void aantele(String s) { 
      System.out.println(s);
   }

   /* Tulostetaan parametrina (s) annettu ääniefekti k-kertaa.
    */
   public void aantele(String s, int k) {
      for (int i = 0; i < k; i++) {
         aantele(s);
      }
   }

   /* Kissa sanoo näin tyytyväisenä.
    */
   public void kehraa() {
      aantele("murr, murrrr...");
   }

   /*
    * Toteutetut metodit.
    *
    */

   /* Kissamaista syömistä. Yliluokasta perityn metodin toteutus.
    */
   @Override
   public void syo() {
      System.out.println("Syön kuin kissa...");
      kehraa();
   }
   
   /* Kissamainen moi. Rajapinnan metodin toteutus.
    */
   @Override
   public void moikkaa() { 
      System.out.println("Miu! Pusken jalkaa..."); 
   }

   /* 
    * Kissamainen moi, jossa välitetään myös moikkauksen kohde. Metodissa moikataan
    * takaisin mikäli kohde on luotu Nisakas-luokan jälkeläisluokasta, siinä on
    * toteutettu Tervehtiva-rajapinta ja kohde on kissaa painavampi. Muille olioille
    * sähistään ilkeästi.
    */
    
   public void moikkaa(Object kohde) {
      // Kokeillaan, onko kohde luotu Nisakas-luokan jälkeläisluokasta ja onko kohde
      // myös Tervehtiva-tyyppia
      if (kohde instanceof Nisakas && kohde instanceof Tervehtiva) {
         // Asetetaan olioon viite, jotta päästään käsiksi painoon
         Nisakas apuelain = (Nisakas)kohde;
         
         // Jos olio on myös kissaa painavampi, tervehditään kutsumalla
         // aantele-operaatiota
         if (apuelain.paino() > paino()) {
            aantele("Miu!");
         }
         // Sähistään, koska tervehtimiseen vaaditut ehdot eivät ole täyttyneet
         else {
            aantele("Sahhh!");
         }
      }
      // Sähistään, koska tervehtimiseen vaaditut ehdot eivät ole täyttyneet
      else {
         aantele("Sahhh!");
      }
      
   }

   /*
    * Korvatut ilmentymametodit.
    *
    */

   /* Karkea sääntö kissan koon arviointiin.
    */
   @Override
   public boolean onkoIso() {
      return paino() > 10;
   }   
}
