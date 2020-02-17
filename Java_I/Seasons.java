/*
 * 
 * Seasons - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 3 - Tehtävä 4
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class Seasons {
	public static void main(String args[]) {
		
		// Esitellään ohjelma
		System.out.println("Hello! I read and tell.");
		// Pyydetään käyttäjää tekemään valinta, talletetaan se int-tyyppiseen
		// muuttujaan valinta
		System.out.println("Which do you like most: 1) winter, 2) spring, 3) summer, 4) autumn?");
		int valinta = In.readInt();
		
		// Verrataan käyttäjän valintaa ja tulostetaan oikea lopputeksti
		if (valinta == 1) {
			System.out.println("Your favourite season of the year is winter.");
		}
		else if (valinta == 2) {
			System.out.println("Your favourite season of the year is spring.");
		}
		else if (valinta == 3) {
			System.out.println("Your favourite season of the year is summer.");
		}
		else if (valinta == 4) {
			System.out.println("Your favourite season of the year is autumn.");
		}
		// Jos käyttäjä ei valinnut numeroa väliltä 1-4, tulostetaan seuraava
		else {
			System.out.println("Your favourite season of the year is unknown.");
		}
	}
}
