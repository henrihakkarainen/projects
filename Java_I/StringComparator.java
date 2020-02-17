/*
 * 
 * StringComparator - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 5 - Tehtävä 4
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class StringComparator {
	public static void main(String[] args) {
		
		System.out.println("Hello! I compare strings.");
		// Alustetaan lippumuuttuja do-while silmukalle
		boolean lopetus;
		
		do {
			// Kysytään käyttäjältä kaksi lausetta vertailtaviksi
			System.out.println("Please, enter the first string:");
			String ekaLause = In.readString();
			System.out.println("Please, enter the second string:");
			String tokaLause = In.readString();
			
			// Testataan, halutaanko lopettaa
			if (ekaLause.equals("stop") && tokaLause.equals("stop")) {
				// Muutetaan lippumuuttujan arvoksi true, jolloin silmukka päättyy
				lopetus = true;
			}
			// Jos ei lopeteta, niin testataan ovatko lauseet samanlaiset
			else if (ekaLause.equals(tokaLause)) {
				System.out.println("\"" + ekaLause+ "\" is equal to \""
				+ tokaLause + "\".");
				lopetus = false;
			}
			// Tässä tapauksessa lauseet eivät täsmää
			else {
				System.out.println("\"" + ekaLause + "\" is different from \""
				+ tokaLause + "\".");
				lopetus = false;
			}
		}
		// Jatketaan, kunnes lopetus-lippumuuttujan arvoksi asetetaan true
		while (lopetus == false);
	}
}
