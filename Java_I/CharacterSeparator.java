/*
 * Aktivoiva tehtävä - CharacterSeparator.java
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Henri Hakkarainen
 * 
 */


public class CharacterSeparator {
	public static void main(String[] args) {
		
		System.out.println("Hello! I separate characters.");
		System.out.println("Please, enter an string:");
		String syote = In.readString();
		int sananPituus = syote.length();
		
		// Jos sanan pituus on 1 merkki
		if (sananPituus == 1) {
			System.out.println(syote);
		}
		// Jos sanassa enemmän kuin 1 merkkiä
		else {
			for (int i = 0; i < sananPituus; i++) {
				// Talletetaan seuraava merkki muuttujaan nextChar
				char nextChar = syote.charAt(i);
				// Tulostetaan viimeisin merkki ja jos ei olla viimeisellä kierroksella
				// niin tulostetaan perään myös miinusmerkki "-"
				System.out.print((i == sananPituus - 1 ? nextChar : nextChar + "-"));
			}
			System.out.println();
		}
	}
}
