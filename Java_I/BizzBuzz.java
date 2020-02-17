/*
 * 
 * BizzBuzz - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 4 - Tehtävä 7
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class BizzBuzz {
	public static void main(String[] args) {
		
		// Esitellään ohjelma
		System.out.println("Hello! This is a BizzBuzz simulation.");
		
		// Pyydetään käyttäjältä vuorojen lukumäärä
		System.out.println("Please, enter the number of turns:");
		int vuoroja = In.readInt();
		
		// Silmukkaa toistetaan vuorojen lukumäärän verran
		for (int i = 1; i <= vuoroja; i = i + 1) {
			
			// Jos ollaan viimeisellä kierroksella, niin numeron tai tekstin
			// perään tulostetaan piste ja rivinvaihto
			if (i == vuoroja) {
				if (i % 3 == 0 & i % 5 == 0) {
					System.out.println("bizz buzz.");
				}
				else if (i % 3 == 0) {
					System.out.println("bizz.");
				}
				else if (i % 5 == 0) {
					System.out.println("buzz.");
				}
				else {
					System.out.println(i + "." );
				}
			}
			// Mikäli kierroksia on vielä jäljellä, tulostetaan numeron tai tekstin
			// perään pilkku ja välilyönti ja pysytään samalla rivillä
			else {
				if (i % 3 == 0 & i % 5 == 0) {
					System.out.print("bizz buzz, ");
				}
				else if (i % 3 == 0) {
					System.out.print("bizz, ");
				}
				else if (i % 5 == 0) {
					System.out.print("buzz, ");
				}
				else {
					System.out.print(i + ", ");
				}
			}
		}
	}
}
