/*
 * 
 * Interrogator - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 6 - Tehtävä 6
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class Interrogator {
	public static void main(String[] args) {
		// Esitellään ohjelma
		System.out.println("Hello! I ask a mandatory question.");
		// Pyydetään käyttäjältä kysymys ja vastaukset
		System.out.println("Please, enter the question:");
		String kysymys = In.readString();
		System.out.println("Please, enter the first answer:");
		char oikea1 = In.readChar();
		System.out.println("Please, enter the second answer:");
		char oikea2 = In.readChar();
		// Lippumuuttuja do-while silmukalle
		boolean vastausOk;
		do {
			System.out.println(kysymys);
			char vastaus = In.readChar();
			// Jos vastaus hyväksytään, asetetaan lippumuuttujan arvoksi true
			if (vastaus == oikea1 || vastaus == oikea2) {
				vastausOk = true;
			}
			// Muutoin tulostetaan virheilmoitus ja lippumuuttuja saa arvon false
			else {
				System.out.println("Error!");
				vastausOk = false;
			}
		}
		// Silmukkaa toistetaan niin kauan, kunnes vastausOk saa arvon true
		while (!vastausOk);
		// Poistutaan silmukasta ja tulostetaan lopetusteksti
		System.out.println("See you soon.");
	}
}
