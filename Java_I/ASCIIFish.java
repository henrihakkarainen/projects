/*
 * 
 * ASCIIFish - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 3 - Tehtävä 8
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class ASCIIFish {
	public static void main(String args[]) {
		
		// Kysytään käyttäjältä kuplien lukumäärä
		int kuplienLkm = In.readInt();
		
		// Alustetaan silmukan laskuri
		int laskuri = 1;
		
		// Alustetaan muuttujat swicth-case rakennetta varten,
		// CASE-muuttujina käytettäviksi
		final int PIENI = 1;
		final int ISO = 2;
		
		// Lisätään kuplia niin monta kertaa, kuin käyttäjä
		// ilmoittaa kuplien lukumääräksi
		while (laskuri <= kuplienLkm) {
			// Arvotaan kokonaisluku väliltä [0-2]
			int arvottu = (int)((3 * Math.random()));
			
			// Päätetään switch-case rakenteella mikä merkki tulostetaan
			// seuraavan kuplan symboliksi, rivinvaihtoa ei tulosteta
			// jotta kuplat menevät aina edellisten perään samalle riville
			switch (arvottu) {
				// Jos arvottu luku = 1
				case PIENI:
				System.out.print("o");
				break;
				// Jos arvottu luku = 2
				case ISO:
				System.out.print("O");
				break;
				// Jos arvottu luku = 0
				default:
				System.out.print("0");
				break;
			}
			// Päivitetään laskuri
			laskuri = laskuri + 1;
		}
		// Tulostetaan lopuksi ASCII-kala kuplien jatkeeksi ja
		// päätetään rivinvaihtoon
		System.out.println(">}}}`>");
	}
}
