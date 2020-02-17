/* 
 * Viikkoharjoitus 1, tehtävä 2.
 *  
 * Olio-ohjelmoinnin perusteet, kevät 2019, Jorma Laurikkala.
 *
 * Mallinnetaan hyvin yleisellä tasolla oppilaitosta.
 *
 */

public class Oppilaitos {

   /* 
    * Attribuutin sallitut arvot julkisina vakioina.
    *
    * Vakiot on esitelty public-määreellä, koska niistä voi olla hyötyä
    * luokan ulkopuolella. Esittelyssä on käytetty static-määrettä,
    * jolla vakiot saadaan käyttöön nopeasti ilman oliota.
    *
    */

   // Esikoulu.
   public static final int ESIASTE = 0;

   // Peruskoulu.
   public static final int PERUSASTE = 1;

   // Lukio ja ammattikoulu.
   public static final int TOINENASTE = 2;

   // Yliopisto ja ammattikorkeakoulu.
   public static final int KORKEAASTE = 3;

   /* 
    * Attribuutit.
    *
    */

   // Oppilaitoksen opiskelijoiden lukumäärä.
   private int opiskelijoita;

   // Oppilaitoksen aste.
   private int aste;

   /* 
    * Aksessorit.
    *
    */
    
   public int opiskelijoita() {
      return opiskelijoita;
   }
   
   public void opiskelijoita(int lkm) {
      if (lkm >= 0) {
         opiskelijoita = lkm;
      }
   }
   
   public int aste() {
      return aste;
   }
   
   public void aste(int a) {
      if (a == ESIASTE || a == PERUSASTE || a == TOINENASTE || a == KORKEAASTE) {
         aste = a;
      }
   }
}
