/*
 * 
 * CharacterComparator - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 5 - Tehtävä 6
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class CharacterComparator {
	public static void main(String[] args) {
		// Esitellään ohjelma
		System.out.println("Hello! I compare two characters of a string.");
		// Pyydetään käyttäjältä merkkijono tutkittavaksi
		System.out.println("Please, enter string:");
		String tutkittava = In.readString();
		// Talletetaan merkkijonon suurimman indeksin arvo muuttujaan
		int maxIndex = tutkittava.length() - 1;
		// Pyydetään kaksi indeksiarvoa, joita vertaillaan
		System.out.println("Please, enter the first position:");
		int ekaIndex = In.readInt();
		System.out.println("Please, enter the second position:");
		int tokaIndex = In.readInt();
		
		// Jos indeksiarvo on virheellinen, niin tulostetaan virheilmoitus
		if ((ekaIndex > maxIndex || ekaIndex < 0) || 
		(tokaIndex > maxIndex || tokaIndex < 0)) {
			System.out.println("Error!");
		}
		// Indeksiarvot ovat sallittujen rajojen puitteissa
		else {
			// Etsitään indeksiarvoja vastaavat merkit tutkittavasta merkkijonosta
			char ekaMerkki = tutkittava.charAt(ekaIndex);
			char tokaMerkki = tutkittava.charAt(tokaIndex);
			// Jos merkit ovat samat
			if (ekaMerkki == tokaMerkki) {
				System.out.println("'" + ekaMerkki + "' is equal to '"
				+ tokaMerkki + "'.");
			}
			// Merkit eivät ole samat
			else {
				System.out.println("'" + ekaMerkki + "' is different from '"
				+ tokaMerkki + "'.");
			}
		}
	}
}
