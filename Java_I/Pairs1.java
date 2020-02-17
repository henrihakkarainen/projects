/*
 * 
 * Pairs1 - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 4 - Tehtävä 4
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class Pairs1 {
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
		if (tulos.equals("()")) {
			pari = true;
		}
		else if (tulos.equals("{}")) {
			pari = true;
		}
		else if (tulos.equals("[]")) {
			pari = true;
		}
		else if (tulos.equals("<>")) {
			pari = true;
		}
		// Jos ei mikään yllä olevista pidä paikkaansa, niin syötteet
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
