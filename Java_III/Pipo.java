/* 
 * Viikkoharjoitus 2, tehtävä 2.
 *  
 * Olio-ohjelmoinnin perusteet I, kevät 2019. Jorma Laurikkala, jorma.laurikkala@uta.fi.
 *
 * Talvipakkasilla tarvittavaa vaatekappaletta mallintava rikkonainen luokka.
 * 
 * Korjannut: Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 *
 */

public class Pipo {

   /* 
    * Koon sallitut arvot julkisina luokkavakioina.
    *
    */

   // XXSmall.
   public static final String XXS = "XXS";

   // XSmall.
   public static final String XS = "XS";

   // Small.
   public static final String S = "S";

   // Medium.
   public static final String M = "M";

   // Large.
   public static final String L = "L";

   // XLarge
   public static final String XL = "XL";

   // XXLarge
   public static final String XXL = "XXL";

   /* 
    * Ilmentymäattribuutit.
    *
    */

   // Pipon koko.
   // ** Tässä oli käytetty static-määrettä, jolloin attribuutista
   // tuli luokka-attribuutti, eli kaikki oliot jakavat saman arvon. Testiluokassa
   // viimeisimmäksi luotu pipo-olio siis määritti jokaisen pipo-olion koon (XS).
   // Poistettu static-määre. **
   private String koko;

   /* 
    * Rakentajat.
    *
    */

   public Pipo(String uusiKoko) {
      koko(uusiKoko);
   }

   /* 
    * Aksessorit.
    *
    */

   public String koko() {
      return koko;
   }

   public void koko(String uusiKoko) {
      if (kokoOK(uusiKoko)) {
         koko = uusiKoko;
      }
   }

   /* 
    * Apuoperaatiot.
    *
    */

   /* Palauttaa arvon true, jos uudeksi kooksi tarjottu arvo on tunnettu.
    */
   private boolean kokoOK(String uusiKoko) {
      return uusiKoko != null && (uusiKoko.equals(XXS) || uusiKoko.equals(XS)
      || uusiKoko.equals(S) || uusiKoko.equals(M) || uusiKoko.equals(L)
      || uusiKoko.equals(XL) || uusiKoko.equals(XXL));
   }
}
