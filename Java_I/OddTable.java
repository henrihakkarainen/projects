/*
 * 
 * OddTable - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Aktivoiva tehtävä
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class OddTable {
	public static void main(String args[]) {
		
		System.out.println("Moi! I print an odd table.");
		// Kysytään käyttäjältä luku, jota kerrotaan
		System.out.println("Please, enter an integer:");
		int kerrottava = In.readInt();
		
		// For-silmukka
		for (int i = 1; i <= 21; i = i+2) {
			int tulo = i * kerrottava;
			System.out.println(i + " x " + kerrottava + " = " + tulo);
		}
	}
}
