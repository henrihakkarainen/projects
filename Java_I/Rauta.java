/*
 * 
 * Rauta - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 2 - Tehtävä 6
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class Rauta {
	public static void main(String[] args) {
		
		// Esitellään muuttujat (eri tyyppejä)
		String englanniksi = "iron";
		String tunnus = "Fe";
		char lohko = 'd';
		int jarjestysluku = 26;
		double elektronegatiivisuus = 55.845;
		double tiheys = 7.86 * (10*10*10);
		boolean onkoJalometalli = false;
		
		// Tulostetaan näytölle tietoja alkuaineesta rauta
		// kaikki tiedot tulostetaan omalle rivilleen
		System.out.println("Joitakin tietoja alkuaineesta rauta:");
		System.out.println("- In English: " + englanniksi + ".");
		System.out.println("- Tunnus jaksollisessa järjestelmässä: " + tunnus + ".");
		System.out.println("- Lohko jaksollisessa järjestelmässä: " + lohko + ".");
		System.out.println("- Järjestysluku jaksollisessa järjestelmässä: " +
		jarjestysluku + ".");
		System.out.println("- Elektronegatiivisuus Paulingin asteikolla: " +
		elektronegatiivisuus + ".");
		System.out.println("- Tiheys: " + tiheys + " kg / m^3.");
		System.out.println("- Onko jalometalli: " + onkoJalometalli + ".");
		
	}
}
