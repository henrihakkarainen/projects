/* 
 * Viikkoharjoitus 4, tehtävä 2.
 *  
 * Olio-ohjelmoinnin perusteet I, kevät 2019. Jorma Laurikkala, jorma.laurikkala@tuni.fi.
 *
 * Rajapinta vanhentuville olioille.
 *
 */

package leivos2;

public interface Vanhentuva {

   /* Vanhennetaan oliota yhdellä aikayksiköllä.
    */
   public abstract void vanhennu();

   /* Palauttaa tiedon olion vanhuudesta. Paluuarvo on true, jos olio on vanha.
    * Muussa tapauksessa paluuarvo on false.
    */
   public abstract boolean onkoVanha();
}
