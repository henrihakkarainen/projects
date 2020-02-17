/*
 * Viikkoharjoitus 4, tehtävä 6.
 *
 * Olio-ohjelmoinnin perusteet I, kevät 2019. Jorma Laurikkala, jorma.laurikkala@tuni.fi.
 *
 * Testejä geneerisille pareille.
 *
 */

public class PariTesti {
   public static void main(String[] args) {
      // Kiinnitetään molempien tyyppiparametrien arvoiksi String.
      Pari<String, String> pari1 = new Pari<String, String>("first", "second");
      String arvo11 = pari1.ensimmainen();
      String arvo12 = pari1.toinen();
      System.out.println(arvo11);                     // first
      System.out.println(arvo12);                     // second
      pari1.ensimmainen(arvo12);
      pari1.toinen(arvo11);
      System.out.println(pari1.ensimmainen());        // second
      System.out.println(pari1.toinen());             // first

      // Kiinnitetään ensimmäisen tyyppiparametrin arvoksi Integer ja toisen
      // tyyppiparametrin arvoksi Double. Java muuntaa rakentajalle ja asettaville
      // aksessoreille annetut alkeistyyppiset arvot automaattisesti kääretyyppisiksi
      // olioiksi ja purkaa kääreoliot alkeistyyppisiksi arvoiksi, kun lukuaksessoreiden
      // arvot sijoitetaan alkeistyyppisiin arvoihin.
      Pari<Integer, Double> pari2 = new Pari<Integer, Double>(1, 2.0);
      int arvo21 = pari2.ensimmainen();
      double arvo22 = pari2.toinen();
      System.out.println(arvo21);                     // 1
      System.out.println(arvo22);                     // 2.0
      pari2.ensimmainen(3);
      pari2.toinen(4.0);
      System.out.println(pari2.ensimmainen());        // 3
      System.out.println(pari2.toinen());             // 4.0

      // Tarkistetaan, että null-arvot kelpaavat.
      Pari<Float, Long> pari3 = new Pari<Float, Long>(1F, 2L);
      pari3.ensimmainen(null);
      pari3.toinen(null);
      System.out.println(pari3.ensimmainen());        // null
      System.out.println(pari3.toinen());             // null
   }
}
