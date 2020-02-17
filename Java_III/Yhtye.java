/*
 * 
 * Yhtye - luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 7 - Tehtävä 4
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class Yhtye {
   
   /*
    * Attribuutit
    */
    
   private String nimi;
   
   private Levy esikoislevy;
   
   /*
    * Rakentajat
    */
   
   public Yhtye(String n) {
      nimi(n);
   }
   
   /*
    * Aksessorit
    */
    
   public String nimi() {
      return nimi;
   }
   
   public void nimi(String n) {
      if (n != null && n.length() >= 1) {
         nimi = n;
      }
   }
   
   public Levy esikoislevy() {
      return esikoislevy;
   }
   
   public void esikoislevy(Levy albumi) {
      if (albumi != null) {
         esikoislevy = albumi;
      }
      // Jos yhtyeen esikoisalbumiksi yritetään asettaa null-arvoa, niin alustetaan
      // esikoislevy Levy-luokan oletusrakentajalla ettei ohjelma ainakaan kaadu.
      else {
         esikoislevy = new Levy();
      }
   }
   
}
