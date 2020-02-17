/*
 * 
 * StringLengthComparator - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 5 - Tehtävä 5
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class StringLengthComparator {
	public static void main(String[] args) {
		// Esitellään ohjelma
		System.out.println("Hello! I compare the lengths of two strings.");
		// Pyydetään käyttäjältä kaksi merkkijonoa vertailuun
		System.out.println("Please, enter the first string:");
		String ekaLause = In.readString();
		System.out.println("Please, enter the second string:");
		String tokaLause = In.readString();
		
		// Otetaan ylös merkkijonojen pituudet
		int ekaPituus = ekaLause.length();
		int tokaPituus = tokaLause.length();
		
		// Suoritetaan vertailu, onko ensimmäinen lause jälkimmäistä lyhyempi
		if (ekaPituus < tokaPituus) {
			System.out.println("\"" + ekaLause + "\" is shorter than \""
			+ tokaLause + "\".");
		}
		// Ovatko lauseet yhtä pitkiä
		else if (ekaPituus == tokaPituus) {
			System.out.println("\"" + ekaLause + "\" is as long as \""
			+ tokaLause + "\".");
		}
		// Jos ei edellä mainitut toteudu, on ensimmäinen lause/merkkijono
		// jälkimmäistä pidempi
		else {
			System.out.println("\"" + ekaLause + "\" is longer than \""
			+ tokaLause + "\".");
		}
	}
}
