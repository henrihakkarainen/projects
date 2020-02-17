/*
 * 
 * CharacterMultiplier - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 6 - Tehtävä 4
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class CharacterMultiplier {
	public static void main(String[] args) {
		// Esitellään ohjelma
		System.out.println("Hello! I multiply characters.");
		
		System.out.println("Please, enter a string:");
		String mjono = In.readString();
		int lauseenPituus = mjono.length();
		System.out.println("Please, enter location:");
		int index = In.readInt();
		System.out.println("Please, enter multiplier:");
		int kerroin = In.readInt();
		// Jos syötteissä on jotain virheitä
		if (index < 0 || index > lauseenPituus || kerroin < 1) {
			System.out.println("Error!");
		}
		else {
			String uusiLause = "";
			for (int i = 0; i < lauseenPituus; i++) {
				char merkki = mjono.charAt(i);
				// Kun ollaan indeksiarvon kohdalla, jonka merkkiä halutaan
				// tulostaa useampaan kertaan
				if (i == index) {
					// Lisätään merkkiä kertoimen osoittama määrä uuden lauseen
					// muuttujaan uudella silmukalla
					for (int j = 0; j <= kerroin; j++) {
						uusiLause += merkki;
					}
				}
				// Muilla kierroksilla tulostetaan yksi kappale merkkiä
				else {
					uusiLause += merkki;
				}
			}
			System.out.println(uusiLause);
		}
	}
}
