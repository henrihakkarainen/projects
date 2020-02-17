/*
 * 
 * Nopeus - ohjelma, lasketaan matkan keskinopeus
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 2 - Tehtävä 8
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class Nopeus {
	public static void main(String[] args) {
		
		// Esitellään muuttujat matka ja aika, käytetään tyyppiä
		// double koska voivat olla desimaalilukujakin
		double matka;
		double aika;
		
		// Pyydetään käyttäjää syöttämään matkan pituus kilometreinä
		System.out.print("Syötä matkan pituus (km): ");
		matka = In.readDouble();
		// Pyydetään käyttäjää syöttämään matkaan käytetty aika tunteina
		System.out.print("Syötä matkaan käytetty aika (tunteina): ");
		aika = In.readDouble();
		// Tulostetaan ylimääräinen rivinvaihto
		System.out.println();
		
		// Lasketaan matkan keskinopeus (matka / aika)
		double nopeus = matka / aika;
		
		// Tulostetaan käyttäjälle lopullinen tulos siitä, mikä
		// on matkan keskinopeus antamien tietojen perusteella
		System.out.println("Matkan keskinopeus on: " + nopeus +
		" km / h, kun matkan pituus on: " + matka + " km ja aikaa" +
		" kului: " + aika + " tuntia.");
		
	}
}
