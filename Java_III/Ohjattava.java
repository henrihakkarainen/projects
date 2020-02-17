/*
 * Viikkoharjoitus 3, tehtävä 4.
 *
 * Olio-ohjelmoinnin perusteet I, kevät 2019. Jorma Laurikkala, jorma.laurikkala@tuni.fi.
 *
 * Ohjattaville olioille tyypillisiä toimintoja ja tiloja.
 *
 */

public interface Ohjattava {
   // Olio on tässä tilassa käynnissä.
   public static final int KAYNNISSA = 1;

   // Olio on tässä tilassa levossa.
   public static final int NUKKUU = 2;

   // Olio on tässä tilassa sammunut.
   public static final int SAMMUTETTU = 3;

   /* Olion tilaksi KAYNNISSA, jos olio on SAMMUTETTU. Muissa tapauksissa olion
    * tila ei muutu.
    */
   public abstract void kaynnisty();

   /* Uudeksi tilaksi NUKKUU, jos olio on KAYNNISSA.  Muissa tapauksissa olion
    * tila ei muutu.
    */
   public abstract void nuku();

   /* Uudeksi tilaksi KAYNNISSA, jos olio NUKKUU.  Muissa tapauksissa olion
    * tila ei muutu.
    */
   public abstract void heraa();

   /* Uudeksi tilaksi SAMMUTETTU, jos olio on KAYNNISSA.  Muissa tapauksissa olion
    * tila ei muutu.
    */
   public abstract void sammu();

   /* Palauttaa olion tilan, joka ilmaistaan tämän rajapinnan vakioilla.
    */
   public abstract int tila();
}
