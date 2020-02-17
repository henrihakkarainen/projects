/*
 * 
 * Glass - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 3 - Tehtävä 2
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
 
public class Glass {
	public static void main(String args[]) {
		
		// Esittelyteksti käyttäjälle
		System.out.println("Hello! I tell about glasses.");
		// Kysytään käyttäjän vastaus (oletetaan, että vastaus
		// on joko 'o' tai 'p') ja talletetaan muuttujaan
		System.out.println("Are you an (o)ptimist or a (p)essimist?");
		char vastaus = In.readChar();
		
		// Jos vastaus on p eli pessimisti
		if (vastaus == 'p') {
			System.out.println("The glass is half empty.");
		}
		// Jos vastaus on joku muu, eli tässä tapauksessa o
		else {
			System.out.println("The glass is half full.");
		}
	}
}
