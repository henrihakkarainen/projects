/*
 * 
 * AlternationCounter - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 6 - Tehtävä 5
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class AlternationCounter {
	public static void main(String[] args) {
		// Esitellään ohjelma
		System.out.println("Hello! I count character alternations.");
		// Pyydetään merkkijono ja lasketaan sen pituus
		System.out.println("Please, enter a string:");
		String mjono = In.readString();
		int pituus = mjono.length();
		int vaihdot = 0;
		
		// Tutkitaan merkkejä lauseen ensimmäisestä merkistä toiseksi viimeiseen
		for (int i = 0; i < pituus - 1; i++) {
			char merkki = mjono.charAt(i);
			char vertailtavaMerkki = mjono.charAt(i+1);
			// Vertaillaan merkkejä, jos eivät ole samat niin kasvatetaan
			// vaihdot muuttujan arvoa yhdellä
			if (merkki != vertailtavaMerkki) {
				vaihdot += 1;
			}
		}
		System.out.println("There were " + vaihdot + " alternation" +
							((vaihdot == 1) ? "." : "s."));		
	}
}
