/*
 * 
 * Seasons2 - ohjelma (Switch-case rakenne)
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 3 - Tehtävä 5
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class Seasons2 {
	public static void main(String args[]) {
		
		// Esitellään ohjelma
		System.out.println("Hello! I read and tell.");
		
		// Esitellään case muuttujat
		final int WINTER = 1;
		final int SPRING = 2;
		final int SUMMER = 3;
		final int AUTUMN = 4;
		
		// Pyydetään käyttäjää tekemään valinta, talletetaan se int-tyyppiseen
		// muuttujaan valinta
		System.out.println("Which do you like most: 1) winter, 2) spring, 3) summer, 4) autumn?");
		int valinta = In.readInt();
		
		// Verrataan käyttäjän valintaa ja tulostetaan oikea lopputeksti
		switch (valinta) {
			case WINTER:
			System.out.println("Your favourite season of the year is winter.");
			break;
			
			case SPRING:
			System.out.println("Your favourite season of the year is spring.");
			break;
			
			case SUMMER:
			System.out.println("Your favourite season of the year is summer.");
			break;
			
			case AUTUMN:
			System.out.println("Your favourite season of the year is autumn.");
			break;
			
			// Jos valinta ei mikään yllä olevista (luku ei väliltä 1-4)...
			default:
			System.out.println("Your favourite season of the year is unknown.");
			break;
		}
		
	}
}
