/* 
 * Viikkoharjoitus 2, tehtävä 1.
 *  
 * Olio-ohjelmoinnin perusteet I, kevät 2019. Jorma Laurikkala, jorma.laurikkala@uta.fi.
 *
 * Tiedosto-käsitettä karkeasti mallintava luokka, jossa on virhe.
 * 
 * Korjannut: Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 *
 */

public class Tiedosto {

   /*
    * Attribuutit.
    *
    */

   // Tiedoston nimi, jossa on oltava vähintään yksi merkki.
   private String nimi;

   // Tiedoston koko tavuina.
   private int koko;

   /*
    * Rakentajat.
    *
    */
   
   // Luokasta puuttui oletusrakentaja, eli TiedostoTesti-luokassa ei voitu luoda
   // sorsa nimistä tiedostoja ilman parametreja (Java ei tarjoa oletusrakentajaa
   // jos on itse tehty parametrillinen rakentaja). Lisätty rakentaja alle.
   public Tiedosto() {
      nimi = "x";
      koko = 0;
   }

   public Tiedosto(String n, int k) {
      nimi(n);
      koko(k);
   }

   /*
    * Aksessorit.
    *
    */

   public String nimi() {
      return nimi;
   }

   public void nimi(String n) {
      if (n != null && n.length() > 0) {
         nimi = n;
      }
   }

   public int koko() {
      return koko;
   }

   public void koko(int k) {
      if (k >= 0) {
         koko = k;
      }
   }
}
