/*
 * Oope1 tentti - Tehtävä 2
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
   
   @Override
   public String toString() {
      String alku = "";
      String loppu = "";
      if (tyyppi == SULJETTU || tyyppi == OIKEALTAPUOLIAVOIN) {
         alku = "[";
         if (tyyppi == SULJETTU) {
            loppu = "]";
         }
         else {
            loppu = ")";
         }
      }
      else {
         alku = "(";
         if (tyyppi == AVOIN) {
            loppu = ")";
         }
         else {
            loppu = "]";
         }
      }
      return alku + alaraja + ", " + ylaraja + loppu;
      
   }
   
   @Override
   public boolean equals(Object o) {
      try {
         Vali apu = (Vali)o;
         
         return alaraja == apu.alaraja() && ylaraja == apu.ylaraja() && tyyppi == apu.tyyppi();
      }
      catch (Exception e) {
         return false;
      }
   }
   
   @Override
   public int hashCode() {
      int tulos = 17;
      tulos = 31 * tulos + Integer.hashCode(alaraja);
      tulos = 31 * tulos + Integer.hashCode(ylaraja);
      tulos = 31 * tulos + Integer.hashCode(tyyppi);
      return tulos;
   }
   
}
