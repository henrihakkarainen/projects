/*
 * 
 * EndsChopper - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 6 - Tehtävä 3
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class EndsChopper {
	public static void main(String[] args) {
		// Esitellään ohjelma
		System.out.println("Hello! I chop the ends of a string.");
		
		System.out.println("Please, enter the string:");
		String lause = In.readString();
		int lauseenPituus = lause.length();
		System.out.println("Shall I chop the (f)irst or the (l)ast character?");
		char poistettava = In.readChar();
		// Tarkistus, onko syöte oikein
		if (poistettava == 'f' || poistettava == 'l') {
			String uusiLause = "";
			for (int i = 0; i < lauseenPituus; i++) {
				char merkki = lause.charAt(i);
				// Poistetaan ensimmäinen merkki, eli ei lisätä sanasta löytyvää
				// merkkiä uuteen muuttujaan silmukan ensimmäisellä kierroksella
				if (poistettava == 'f' && i != 0) {
					uusiLause += merkki;
				}
				// Poistetaan viimeinen merkki, eli ei lisätä sanasta löytyvää
				// merkkiä uuteen muuttujaan silmukan viimeisellä kierroksella
				else if (poistettava == 'l' && i != lauseenPituus - 1) {
					uusiLause += merkki;
				}
			}
			System.out.println("The chopped string is \"" + uusiLause + "\".");
		}
		// Tulostetaan virheilmoitus, jos syöte ei ollut 'f' tai 'l'
		else {
			System.out.println("Error!");
		}
	}
}
