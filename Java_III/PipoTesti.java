/* 
 * Viikkoharjoitus 2, tehtävä 2.
 *  
 * Olio-ohjelmoinnin perusteet I, kevät 2019. Jorma Laurikkala, jorma.laurikkala@uta.fi.
 *
 * Testataan pipoa.
 *
 */

public class PipoTesti { 
   public static void main(String[] args) {
      // Moikataan käyttäjää ja kerrotaan ohjelmasta.
      System.out.println("Hello! I test knitted caps.");

      // Luodaan eri kokoisia pipoja.
      Pipo pipo1 = new Pipo(Pipo.S);
      Pipo pipo2 = new Pipo("L");
      Pipo pipo3 = new Pipo("XS");

      // Luetaan attribuutin arvot.
      String koko1 = pipo1.koko();
      String koko2 = pipo2.koko();
      String koko3 = pipo3.koko();

      // Tulostetaan olioiden tilat näytölle.
      System.out.println("State is \"" + koko1 + "\"."); // State is "S".
      System.out.println("State is \"" + koko2 + "\"."); // State is "L".
      System.out.println("State is \"" + koko3 + "\"."); // State is "XS".
   } 
}
