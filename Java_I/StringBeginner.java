/*
 * 
 * StringBeginner - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 6 - Tehtävä 2
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class StringBeginner {
	public static void main(String[] args) {
		// Esitellään ohjelma
		System.out.println("Hello! I print the beginning of a string.");
		
		System.out.println("Please, enter the string:");
		String lause = In.readString();
		int lauseenPituus = lause.length();
		System.out.println("Please, enter the number of characters:");
		int kirjaintenLkm = In.readInt();
		
		// Jos merkkien lkm <= 0 tai suurempi kuin merkkijonon pituus
		if (kirjaintenLkm <= 0 || kirjaintenLkm > lauseenPituus) {
			System.out.println("Error!");
		}
		else {
			String uusiLause = "";
			// Käydään läpi haluttu määrä merkkejä lauseen alusta ja lisätään
			// ne yksitellen peräkkäin uuteen String-muuttujaan
			for (int i = 0; i < kirjaintenLkm; i++) {
				char merkki = lause.charAt(i);
				uusiLause += merkki;
			}
			// Tulostetaan uusi merkkijono
			System.out.println(uusiLause);
		}
	}
}
