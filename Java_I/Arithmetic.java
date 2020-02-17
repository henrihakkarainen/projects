/*
 * 
 * Arithmetic - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 3 - Tehtävä 1
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
 
public class Arithmetic {
	public static void main(String args[]) {
		
		// Tulostetaan esittelyteksti käyttäjälle
		System.out.println("Hello! I do some basic arithmetic.");
		// Pyydetään käyttäjää syöttämään kaksi kokonaislukua
		System.out.println("Please, enter the first integer:");
		int ekaluku = In.readInt();
		System.out.println("Please, enter the second integer:");
		int tokaluku = In.readInt();
		// Alla suoritetaan laskutoimitukset ja talletetaan muuttujiin
		int summa = ekaluku + tokaluku;
		int erotus = ekaluku - tokaluku;
		int tulo = ekaluku * tokaluku;
		double osamaara = (double)ekaluku / (double)tokaluku;
		int jakojaannos = ekaluku % tokaluku;
		// Tulostetaan tulokset näytölle
		System.out.println(ekaluku + " + " + tokaluku + " = " + summa);
		System.out.println(ekaluku + " - " + tokaluku + " = " + erotus);
		System.out.println(ekaluku + " * " + tokaluku + " = " + tulo);
		System.out.printf("%d / %d = %.2f%n", ekaluku, tokaluku, osamaara);
		System.out.println(ekaluku + " % " + tokaluku + " = " + jakojaannos);
		
	}	
}
