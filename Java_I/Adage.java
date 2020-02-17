/*
 * 
 * Adage - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 2 - Tehtävä 7
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class Adage {
	public static void main(String[] args) {
		
		// Lopullisen ajatelman alkuun tuleva merkkijono-osuus
		String alkuMerkit = "<< ";
		// Lopullisen ajatelman loppuun tuleva merkkijono-osuus
		String loppuMerkit = " >>";
		
		// Tulostetaan käyttäjälle muutama rivi, jotka kertovat
		// mitä ohjelma tekee
		System.out.println("Hello! I read and pretty print your thoughts.");
		System.out.println("Please, say something:");
		// Luetaan käyttäjältä ajatelma, tallennetaan se
		// muuttujaan luettuAjatelma
		String luettuAjatelma = In.readString();
		
		// Tässä yhdistetään alku- ja loppumerkit käyttäjältä
		// saadun merkkijonon etu- ja loppupäähän, tuloksena
		// yksi yhtenäinen merkkijono (String)
		String ajatelma = alkuMerkit + luettuAjatelma + loppuMerkit;
		
		// Tulostetaan ajatelma - merkkijono näytölle.
		System.out.println(ajatelma);
		
	}
}
