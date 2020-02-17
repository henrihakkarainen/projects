/*
 * 
 * Pairs2 - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 4 - Tehtävä 5
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class Pairs2 {
	public static void main(String[] args) {
		
		// Esitellään ohjelma
		System.out.println("Hello! I find pairs.");
		
		// Pyydetään käyttäjältä kaksi merkkiä ja talletetaan ne
		// muuttujiin eka ja toka
		System.out.println("Enter the first character:");
		char eka = In.readChar();
		System.out.println("Enter the second character:");
		char toka = In.readChar();
		
		// Luodaan lopputulos
		String tulos = "" + eka + toka;
		
		// Alustetaan muuttuja, jolla verrataan muodostavatko
		// käyttäjän syötteet parin
		boolean pari;
		
		// muutetaan pari-muuttujan arvo todeksi, mikäli käyttäjän
		// syötteet ovat pari (), {}, [] tai <>
		if (tulos.equals("()") | tulos.equals("{}") |
			tulos.equals("[]") | tulos.equals("<>")) {
			pari = true;
		}
		// Jos ei yllä oleva ei toteudu, niin syötteet
		// eivät muodosta paria ja pari-muuttujan arvoksi tulee false
		else {
			pari = false;
		}
		
		// Jos merkit muodostavat parin, tulostetaan ilmoitus näytölle
		if (pari) {
			System.out.println("Characters '" + eka + "' and '" + toka +
			"' are a pair.");
		}
		// Jos merkit eivät ole pari, ilmoitetaan se käyttäjälle
		else {
			System.out.println("Characters '" + eka + "' and '" + toka +
			"' are not a pair.");
		}
	}
}
