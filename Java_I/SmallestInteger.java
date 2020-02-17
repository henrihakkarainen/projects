/*
 * 
 * SmallestInteger - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 6 - Tehtävä 7
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class SmallestInteger {
	public static void main(String[] args) {
		// Esitellään ohjelma
		System.out.println("Hello! I determine the smallest integer.");
		// Pyydetään käyttäjältä lukujen kokonaismäärä
		System.out.println("Please, enter the number of integers:");
		int lkm = In.readInt();
		// Alustetaan muuttuja pienimmän luvun vertailuun
		int pieninLuku;
		// Jos lukujen lukumäärä on 0 tai pienempi, niin tulostetaan virheilmoitus
		if (lkm <= 0) {
			System.out.println("Error!");
		}
		else {
			System.out.println("Please, enter an integer:");
			pieninLuku = In.readInt();
			int laskuri = 1;
			// Silmukassa kysytään kokonaislukuja, kunnes haluttu lukumäärä on
			// saavutettu (jos lkm oli 1, niin silmukkaan ei mennä kertaakaan)
			while (laskuri < lkm) {
				System.out.println("Please, enter an integer:");
				int luku = In.readInt();
				// Jos luku on pienempi kuin edellinen pienin luku niin päivitetään
				if (luku < pieninLuku) {
					pieninLuku = luku;
				}
				// Muistetaan päivittää laskuria
				laskuri += 1;
			}
			// Tulostetaan pienin luku näytölle
			System.out.println("The smallest integer is " + pieninLuku + ".");
		}
	}
}
