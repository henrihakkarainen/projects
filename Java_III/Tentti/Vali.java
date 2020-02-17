/*
 * Oope1 tentti - Tehtävä 1
 * 
 * Tehnyt: Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class Vali {
   
   public static final int SULJETTU = 1;
   public static final int AVOIN = 2;
   public static final int OIKEALTAPUOLIAVOIN = 3;
   public static final int VASEMMALTAPUOLIAVOIN = 4;
   
   private int alaraja;
   private int ylaraja;
   private int tyyppi;
   
   public Vali(int ar, int yr, int t) throws IllegalArgumentException {
      if ((t == AVOIN || t == OIKEALTAPUOLIAVOIN || t == VASEMMALTAPUOLIAVOIN)
          && ar >= yr) {
         throw new IllegalArgumentException();
      }
      else if (t == SULJETTU && ar > yr) {
         throw new IllegalArgumentException();
      }
      tyyppi(t);
      alaraja(ar);
      ylaraja(yr);
   }
   
   public int alaraja() {
      return alaraja;
   }
   
   public void alaraja(int n) {
      alaraja = n;
   }
   
   public int ylaraja() {
      return ylaraja;
   }
   
   public void ylaraja(int n) {
      ylaraja = n;
   }
   
   public int tyyppi() {
      return tyyppi;
   }
   
   public void tyyppi(int t) throws IllegalArgumentException {
      if (t != SULJETTU && t != AVOIN && t != OIKEALTAPUOLIAVOIN && t != VASEMMALTAPUOLIAVOIN) {
         throw new IllegalArgumentException();
      }
      tyyppi = t;
   }
   
}
