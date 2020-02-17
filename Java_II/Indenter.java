/*
 * 
 * Indenter - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 5 - Tehtävä 2
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class Indenter {
   public static void main(String[] args) {
      // Komentoriviparametreja on vähintään kaksi
      if (args.length >= 2) {
         // Viimeinen komentoriviparametri muuntuu kokonaisluvuksi
         try {
            int syvyys = Integer.parseInt(args[args.length - 1]);
            // Käydään läpi komentoriviparametrit yksitellen
            for (int i = 0; i < args.length - 1; i++) {
               // Tulostetaan sisennys (syvyyden osoittama määrä välilyöntejä)
               for (int j = 0; j < syvyys; j++) {
                  System.out.print(" ");
               }
               // Tulostetaan komentoriviparametri ja vaihdetaan riviä
               System.out.println(args[i]);
            }
         }
         // Ilmoitetaan virheestä
         catch (NumberFormatException e) {
            System.out.println("Error!");
         }
      }
      // Ilmoitetaan virheestä
      else {
         System.out.println("Error!");
      }
   } 
}
