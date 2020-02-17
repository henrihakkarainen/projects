/*
 * 
 * SawTeeth1 - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 4 - Tehtävä 2
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class SawTeeth1 {
	public static void main(String[] args) {
		
		// Esitellään ohjelma
		System.out.println("Hello! I print saw teeth.");
		
		// Pyydetään käyttäjältä sahahammaskuvion rivin pituus
		System.out.println("Please, enter the number of characters:");
		int merkkienLkm = In.readInt();
		
		// Alustetaan muuttuja jakomerkki, kun arvo = true, niin tulostetaan
		// näytölle "/" ja kun arvo on false, niin tulostetaan näytölle "\"
		// Tulostaminen tehdään silmukassa
		boolean jakomerkki = true;
		
		// Jos merkkien lukumäärä on 1 tai suurempi
		if (merkkienLkm > 0) {
			// While-silmukka
			while (merkkienLkm > 0) {
				// Tulostetaan peräkkäin "/" ja "\" merkkejä näytölle,
				// ei siis tulosteta rivinvaihtoja välissä
				if (jakomerkki == true) {
					System.out.print("/");
					jakomerkki = false;
				}
				else {
					System.out.print("\\");
					jakomerkki = true;
				}
				// Pienennetään laskuria
				merkkienLkm = merkkienLkm - 1;
			}
			// Tulostetaan viimeinen rivinvaihto
			System.out.println();
		}
		// Jos rivin pituus on 0 tai alle
		else {
			System.out.println("Error!");
		}
	}
}
