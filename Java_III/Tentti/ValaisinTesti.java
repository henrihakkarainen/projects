/*
 * Oope1 tentti - Tehtävä 3
 * 
 * Tehnyt: Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class ValaisinTesti {
   
   public static void main(String[] args) {
      
      Valaisin kattovalaisin = new Valaisin(true);
      Valaisin lattiavalaisin = new Valaisin(false);
      
      System.out.println(kattovalaisin);
      System.out.println(lattiavalaisin);
      
      // Otetaan valaisimien lamput talteen
      Lamppu katossa = kattovalaisin.lamppu();
      Lamppu lattialla = lattiavalaisin.lamppu();
      
      // Vaihdetaan lamppu kattovalaisimeen (asetetaan enemmän valotehoa)
      katossa.valovirta(500);
      
      // Lattiavalaisimen lamppu tuhoutuu
      lattialla.kunnossa(false);
      
      // Asetetaan muutoksia kokeneet lamput takaisin valaisimiin
      
      kattovalaisin.lamppu(katossa);
      lattiavalaisin.lamppu(lattialla);
      
      System.out.println(kattovalaisin);
      System.out.println(lattiavalaisin);
   }
}
