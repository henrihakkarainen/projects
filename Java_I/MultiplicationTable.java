/*
 * 
 * MultiplicationTable- ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 3 - Tehtävä 7
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class MultiplicationTable {
	public static void main(String args[]) {
		
		System.out.println("Hello! I print a multiplication table.");
		System.out.println("Please, enter an integer:");
		int luku = In.readInt();
		// Alustetaan silmukan laskuri
		int kerroin = 1;
		// Alustetaan muuttuja, johon talletetaan kertolaskun tulo
		int tulo;
		
		// Silmukka, joka laskee kertolaskun tuloksen (luku * kerroin)
		// ja tulostaa laskutoimituksen näytölle
		do {
			tulo = kerroin * luku;
			System.out.println(kerroin + " x " + luku + " = " + tulo);
			// Kasvatetaan silmukan laskuria yhdellä
			kerroin = kerroin + 1;
		}
		// Kymmenen kertotaulu
		while (kerroin <= 10);
	}
}
