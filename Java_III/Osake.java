/* 
 * Viikkoharjoitus 1, tehtävä 1.
 *  
 * Olio-ohjelmoinnin perusteet, kevät 2019, Jorma Laurikkala.
 *
 * Mallinnetaan karkeasti osakeyhtiön yhtä osaketta.
 *
 */

public class Osake {

   /* 
    * Attribuutit.
    *
    */

   // Osakkeen arvo euroina.
   private double arvo;

   // Osakkeen liikkeelle laskeneen yhtiön nimi.
   private String yhtio;

   /* 
    * Aksessorit.
    *
    */

   public double arvo() {
      return arvo;
   }

   public void arvo(double e) {
      if (e >= 0) {
         arvo = e;
      }
   }

   public void yhtio(String nimi) {
      // Tarkistetaan, että viitteeseen liittyy merkkijono ja että merkkijonossa
      // on vähintään yksi merkki. Huomaa ehdollinen AND. Lausekkeen laskenta
      // lopetetaan heti, kun lopputulos on selvä. Näin jälkimmäistä ehtoa ei
      // lasketa eikä ohjelma kaadu, kun parametri on null-arvoinen.
      if (nimi != null && nimi.length() > 0) {
         yhtio = nimi;
      }
   }

   public String yhtio() {
      return yhtio;
   }
}
