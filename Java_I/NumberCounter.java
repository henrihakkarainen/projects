/*
 * 
 * NumberCounter - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 4 - Tehtävä 6
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class NumberCounter {
	public static void main(String[] args) {
		
		// Alustetaan muuttuja laskuria varten
		int i;
		// Alustetaan muuttuja, joka laskee montako samaa lukua esiintyy
		int samoja = 0;
		
		// Pyydetään käyttäjältä vertailtava luku ja tallennetaan muuttujaan
		System.out.println("Anna vertailtava luku:");
		int vertailtava = In.readInt();
		
		// Pyydetään käyttäjältä lukujen kokonaismäärä ja tallennetaan muuttujaan
		System.out.println("Anna lukujen lukumäärä:");
		int lkm = In.readInt();
		
		// Silmukka, jota toistetaan niin monta kertaa, kuin oli käyttäjältä
		// pyydettyjen lukujen kokonaismäärä
		for (i = 0; i < lkm; i = i + 1) {
			// Tallennetaan yksi luku muuttujaan luku
			System.out.println("Anna luku:");
			int luku = In.readInt();
			// Verrataan lukua vertailtavaan, mikäli täsmää niin kasvatetaan
			// muuttujan samoja arvoa yhdellä
			if (luku == vertailtava) {
					samoja = samoja + 1;
			}
		}
		
		System.out.println("Samojen lukujen lukumäärä:");
		System.out.println(samoja);
	}
}
