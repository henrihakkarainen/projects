/*
 * 
 * Zorro - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 5 - Tehtävä 7
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class Zorro {
	public static void main(String[] args) {
		// Esitellään ohjelma
		System.out.println("Hola! I am Zorro.");
		// Tulostettava merkki
		System.out.println("Please, enter mark:");
		char merkki = In.readChar();	
		// Kuvion koko (rivien lkm)	
		System.out.println("Please, enter size:");
		int koko = In.readInt();
		// Alustetaan muuttuja, joka kertoo mihin kohtaan rivin viimeinen merkki
		// tulostuu, jonka jälkeen rivi vaihtuu
		int viimMerkki = koko - 1;
		
		// Koon pitää olla vähintään kolme - mikäli pienempi, niin virheilmoitus
		if (koko < 3) {
			System.out.println("No comprendo.");
		}
		else {
			// Käydään läpi (rivien lkm) kierrosta
			for (int i = 0; i < koko; i++) {
				// Ensimmäinen ja viimeinen rivi käsitellään erikseen
				if (i == 0 || i + 1 == koko) {
					// Tulostetaan (rivien lkm) x merkkiä
					for (int z = 1; z <= koko; z++) {
						System.out.print(merkki);
					}
					// Lopuksi siirrytään seuraavalle riville
					System.out.println();
				}
				// Jos ei olla ensimmäisellä tai viimeisellä rivillä
				else {
					for (int z = 1; z <= viimMerkki; z++) {
						// Tulostetaan välilyöntejä niille paikoille, missä
						// ei kuulu olla merkkiä
						if (z != viimMerkki) {
							System.out.print(" ");
						}
						// Tulostetaan riville merkki oikeaan kohtaan
						else {
							System.out.println(merkki);
							// Päivitetään viimeisen merkin paikkanumero
							viimMerkki -= 1;
						}
					}
				}
			}
		}
	}
}
