/*
 * 
 * Divisibility - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 3 - Tehtävä 6
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class Divisibility {
	public static void main(String args[]) {
		
		System.out.println("Hello! I determine whether x is divisible by y.");
		System.out.println("Please, enter x:");
		int x = In.readInt();
		System.out.println("Please, enter y:");
		int y = In.readInt();
		
		// Nollalla ei voi jakaa, eli testataan ettei syöte ole nolla
		// ja jos on, niin tulostetaan virheilmoitus näytölle.
		if (y == 0) {
			System.out.println("Error!");
		}
		// Mikäli y ei ole 0, suoritetaan jakolasku ja katsotaan meneekö
		// jako tasan (modulo-operaattorilla)
		else {
			if (x % y == 0) {
				System.out.println(x + " is divisible by " + y + ".");
			}
			else {
				System.out.println(x + " is not divisible by " + y + ".");
			}
		}
	}
}
