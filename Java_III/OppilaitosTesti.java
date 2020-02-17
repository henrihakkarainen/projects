/*
 * 
 * OppilaitosTesti - ohjelma
 * 
 * Olio-ohjelmoinnin perusteet I
 * 
 * Harjoitus 1 - Tehtävä 2
 * 
 * Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public class OppilaitosTesti {
   
   public static void main(String[] args) {
      System.out.println("Hello! I test educational institutes.");
      System.out.println("Please, enter the number of students:");
      int oppilaita = In.readInt();
      System.out.println("Please, enter the type of the institution:");
      int astenro = In.readInt();
      Oppilaitos koulu = new Oppilaitos();
      // Asetetaan Oppilaitos-olion attribuuteille syötteenä vastaanotetut arvot
      koulu.opiskelijoita(oppilaita);
      koulu.aste(astenro);
      // Metodien palauttamat arvot talteen
      int opiskelijoita = koulu.opiskelijoita();
      int aste = koulu.aste();
      // Tulostetaan metodien palauttamat arvot näytölle
      System.out.println("State is " + opiskelijoita + " and " + aste + ".");
   }
}
