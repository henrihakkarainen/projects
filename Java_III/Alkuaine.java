/*
 * 
 * Alkuaine - luokka
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 2 - Tehtävä 4
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class Alkuaine {
   
   /*
    * Attribuutit
    */
    
   private String merkki;
   
   private int numero;
   
   /*
    * Rakentajat
    */
   
   // Oletusrakentajassa alkuaineen merkiksi asetetaan H ja numeroksi 1.
   public Alkuaine() {
      merkki = "H";
      numero = 1;
   }
   
   // Parametrillisessa rakentajassa alkuaineelle asetetaan ulkoisen tahon määrittelemä
   // merkki (m) ja numero (n). Arvot asetetaan vain, jos ne eivät ole virheellisiä.
   public Alkuaine(String m, int n) {
      merkki(m);
      numero(n);
   }
   
   /*
    * Aksessorit
    */
    
   public String merkki() {
      return merkki;
   }
   
   public void merkki(String m) {
      if (m != null && m.length() >= 1 && m.length() <= 3) {
         merkki = m;
      }
   }
   
   public int numero() {
      return numero;
   }
   
   public void numero(int nro) {
      if (nro >= 1 && nro <= 118) {
         numero = nro;
      }
   }
}
