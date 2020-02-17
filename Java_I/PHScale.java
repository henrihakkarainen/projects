/*
 * 
 * PHScale - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 3 - Tehtävä 3
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class PHScale {
	public static void main(String args[]) {
		
		// Tulostetaan esittelyteksti
		System.out.println("Hello! I classify solutions using the pH scale.");
		// Pyydetään käyttäjältä pH arvo (tulos voi olla kokonais- tai liukuluku)
		System.out.println("Enter a pH value:");
		double arvo = In.readDouble();
		
		// Jos pH arvo on suurempi kuin seitsemän
		if (arvo > 7) {
			System.out.println("Solution is alkaline.");
		}
		else {
			// Jos pH arvo on pienempi kuin seitsemän
			if (arvo < 7) {
				System.out.println("Solution is acid.");
			}
			// Jos pH arvo on tasan seitsemän (eli ei pienempi eikä suurempi)
			else {
				System.out.println("Solution is neutral.");
			}
		}
	}
}
