/*
 * 
 * Muuttujia - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 2 - Tehtävä 5
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class Muuttujia {
	
	public static void main(String[] args) {
		
		// Esitellään muuttuja kasvienLkm, joka on tyypiltään
		// kokonaisluku (int)
		int kasvienLkm;
		
		// Esitellään muuttuja kurssinNimi, joka on tyypiltään
		// merkkijono (String)
		String kurssinNimi;
		
		// Esitellään muuttuja rapunNimi, joka on tyypiltään
		// merkki (char)
		char rapunNimi;
		
		// Annetaan muuttujille arvot
		kasvienLkm = 2;
		kurssinNimi = "Lausekielinen ohjelmointi 1";
		rapunNimi = 'A';
		
		// Tulostetaan muuttujat lauseiden joukossa omilla riveillään
		System.out.println("Minulta löytyy kotoa " + kasvienLkm + " kasvia.");
		System.out.println("Tämän kurssin nimi on: " + kurssinNimi + ".");
		System.out.println("Kuvitteellinen osoite on nimeltään: Ohjelmointikuja 15 " + 
		rapunNimi + ".");
		
	}
}
