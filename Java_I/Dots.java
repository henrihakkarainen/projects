/*
 * 
 * Dots - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 4 - Tehtävä 1
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class Dots {
	public static void main(String[] args) {
		
		// Alustetaan tyhjä lause
		String lause = "";
		// Alustetaan lippumuuttuja silmukalle
		boolean jatketaan;
		
		System.out.println("Hello! I print out an acronym.");
		do {
			// Luetaan käyttäjältä syöte (yksi merkki)
			System.out.println("Please, enter a character:");
			char syote = In.readChar();
			// Jos luettu merkki on mikä tahansa muu, kuin "."
			if (syote != '.') {
				jatketaan = true;
				// Lisätään "." kirjainten väliin
				lause = lause + syote + ".";
			}
			// Jos luettu merkki oli "."
			else {
				jatketaan = false;
				// Mikäli lauseessa ei vielä ole mitään merkkejä, niin
				// lisätään tuo yksi piste (viimeisin syöte), muuten ei lisätä
				if (lause == "") {
					lause = lause + syote;
				}
			}
		}
		// Toistetaan niin kauan, kun lippumuuttuja on tosi, eli
		// käyttäjä ei syötä pistettä "."
		while (jatketaan);
		
		System.out.println(lause);
	}
}
