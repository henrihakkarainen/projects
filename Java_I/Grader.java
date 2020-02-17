/*
 * 
 * Grader - ohjelma
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 5 - Tehtävä 3
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

public class Grader {
	public static void main(String[] args) {
		
		System.out.println("Hello! I am a grader.");
		
		// Otetaan käyttäjältä talteen kokeen pisteet ja hyvityspisteet
		System.out.println("Please, enter exam points:");
		int examPoints = In.readInt();
		System.out.println("Please, enter bonus points:");
		int bonusPoints = In.readInt();
		
		boolean tenttiOk;
		
		// Katsotaan oliko tentti suoritettu hyväksyttävästi
		if (examPoints >= 12 && examPoints <= 24)
			tenttiOk = true;
		else
			tenttiOk = false;
		
		// Katsotaan voidaanko käyttäjän pisteet arvioida, eli tentin pisteet
		// ovat väliltä 12-24 ja hyvityspisteet väliltä 0-3
		if (tenttiOk && bonusPoints >= 0 && bonusPoints <= 3) {
			// Lasketaan yhteispisteet, joiden perusteella päätetään arvosana
			int total = examPoints + bonusPoints;
			// Alustetaan muuttuja arvosanalle
			int grade;
			// Tutkitaan, minkä arvosanan pisteillä saa ja talletetaan arvosana
			// int-muuttujaan grade
			if (total >= 12 && total <= 14)
				grade = 1;
			else if (total >= 15 && total <= 17)
				grade = 2;
			else if (total >= 18 && total <= 20)
				grade = 3;
			else if (total == 21 || total == 22)
				grade = 4;
			else
				grade = 5;
			// Aaltosulkuja ei ole käytetty ylläolevissa if-else lohkoissa koska
			// ne sisältävät kukin vain yhden lauseen -> säästyy tilaa
			
			// Tulostetaan lopullinen arvosana näytölle
			System.out.println("Your grade is " + grade + ".");
		}
		// Ilmoitetaan käyttäjälle, että pisteet olivat virheelliset
		// tai liian huonot kurssin läpäisyyn
		else {
			System.out.println("I cannot give a grade.");
		}
	}
}
