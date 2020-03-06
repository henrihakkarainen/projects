import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Integer;

/**
 * Ohjelmassa luodaan omat hajautustaulunsa syötetiedostoista setA.txt ja setB.txt mutta
 * muuten ohjelma käsittelee näitä ikään kuin yhtä hajautustaulua, eli jos käyttäjä haluaa
 * poistaa jonkin luvun, niin se poistetaan samalla molemmista yksittäisistä hajautustauluista.
 * Tällä tavalla toteutettuna helpottuu esimerkiksi lopussa tuotettavien tulostiedostojen
 * käsittely ja lisäksi joukko-operaatioiden toteuttaminen oli yksinkertaisempaa.
 * 
 * Hajautustauluun otetaan ainoastaan positiivisia kokonaislukuja, jos syötetiedostossa on
 * negatiivisia arvoja, niin näitä ei lisätä hajautustauluihin.
 */
public class Tira2019 {
	private static Scanner reader = new Scanner(System.in);

	/**
	 * Luetaan parametrina vastaanotettava syötetiedosto ja talletetaan siinä esiintyvät
	 * kokonaisluvut hajautustaulun alkioiksi. Hajautustauluun lisätään ainoastaan positiiviset
	 * kokonaisluvut. Lopuksi palautetaan hajautustaulu.
	 * 
	 * @param fileName luettavan tiedoston nimi
	 * @return palautetaan hajautustaulu, joka sisältää syötetiedostossa esiintyvät
	 * luvut eli alkiot.
	 */
	private HashTable readInput(String fileName) {
		String line;
		HashTable result = new HashTable();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			line = br.readLine();
			while (line != null) {
				String[] values = line.split("\n");
				Integer value = Integer.parseInt(values[0]);
				// Negatiivisia lukuja ei hyväksytä hajautustauluihin
				if (value >= 0) {
					result.insertItem(value);
				}
				line = br.readLine();
			}
			return result;
		}
		catch (IOException e) {
			System.out.println("File not found.");
			return null;
		}
		catch (Exception e) {
			System.out.println("Error");
			return null;
		}
	}

	/**
	 * Muodostaa unionin (UNION) ja kirjoittaa tulostiedoston or.txt,
	 * jossa ensimmäinen sarake kertoo yksittäisen alkion arvon ja toinen sen, montako
	 * kertaa alkio on esiintynyt syötetiedostoissa setA.txt ja setB.txt. Leikkaus
	 * muodostetaan kahden parametrina saatavan hajautustaulun alkioista.
	 * 
	 * @param fileName tulostiedoston nimi
	 * @param a ensimmäinen hajautustaulu
	 * @param b toinen hajautustaulu
	 */
	private void writeOrOutput(String fileName, HashTable a, HashTable b) {
		ArrayList<Integer> union = a.getUnion(b);
		Collections.sort(union);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			String outputrow;
			int count;
			for (int i = 0; i < union.size(); i++) {
				Integer value = union.get(i);
				outputrow = value.toString();
				count = 0;
				if (a.findAllElements(value) != null) {
					count += a.findAllElements(value).size();
				}
				if (b.findAllElements(value) != null) {
					count += b.findAllElements(value).size();
				}
				outputrow += "\t" + count;
				bw.write(outputrow);
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			System.err.format("Error" + e);
		}
		System.out.print("Unioni (UNION): {");
		for (int i = 0; i < union.size(); i++) {
			System.out.print(" " + union.get(i));
		}
		System.out.println(" }, alkioiden lukumäärä: " + union.size());
	}

	/**
	 * Muodostaa leikkauksen (INTERSECTION) ja kirjoittaa tulostiedoston and.txt,
	 * jossa ensimmäinen sarake kertoo yksittäisen alkion arvon ja toisessa sarakkeessa
	 * ilmoitetaan sen rivi numero, jolla alkio on esiintynyt ensimmäistä kertaa
	 * syötetiedostossa setA.txt. Leikkaus muodostetaan kahden parametrina saatavan
	 * hajautustaulun alkioista.
	 * 
	 * @param fileName tulostiedoston nimi
	 * @param a ensimmäinen hajautustaulu
	 * @param b toinen hajautustaulu
	 */
	private void writeAndOutput(String fileName, HashTable a, HashTable b) {
		ArrayList<Integer> intersection = a.getIntersection(b);
		Collections.sort(intersection);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			String outputrow, line;
			for (int i = 0; i < intersection.size(); i++) {
				Integer value = intersection.get(i);
				outputrow = value.toString();
				// Haetaan rivin numero, jolla alkio esiintyy ensimmäistä kertaa tiedostossa setA.txt
				BufferedReader br = new BufferedReader(new FileReader("setA.txt"));
				line = br.readLine();
				int lineNumber = 1;
				while (line != null) {
					String[] values = line.split("\n");
					Integer number = Integer.parseInt(values[0]);
					// Vastaava luku löytyi tiedostosta, joten kirjoitetaan rivin numero ylös
					if (number.equals(value)) {
						outputrow += "\t" + lineNumber;
						break;
					}
					line = br.readLine();
					lineNumber++;
				}
				bw.write(outputrow);
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			System.err.format("Error" + e);
		}
		System.out.print("Leikkaus (INTERSECTION): {");
		for (int i = 0; i < intersection.size(); i++) {
			System.out.print(" " + intersection.get(i));
		}
		System.out.println(" }, alkoiden lukumäärä: " + intersection.size());
	}

	/**
	 * Muodostaa poissulkevan tain (XOR) joukon ja kirjoittaa tulostiedoston xor.txt,
	 * jossa ensimmäinen sarake kertoo yksittäisen alkion arvon ja toisessa sarakkeessa
	 * ilmoitetaan numerolla 1 tai 2 kummassako syötetiedostossa setA.txt tai setB.txt
	 * kyseinen alkio esiintyy. XOR-joukko muodostetaan kahden parametrina saatavan
	 * hajautustaulun alkioista.
	 * 
	 * @param fileName tulostiedoston nimi
	 * @param a ensimmäinen hajautustaulu
	 * @param b toinen hajautustaulu
	 */
	private void writeXorOutput(String fileName, HashTable a, HashTable b) {
		ArrayList<Integer> xor = a.getXOR(b);
		Collections.sort(xor);
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			String outputrow;
			for (int i = 0; i < xor.size(); i++) {
				Integer value = xor.get(i);
				outputrow = value.toString();
				// Jos kirjoitettava alkio löytyy hajautustaulusta a, kirjoitetaan toiseen
				// sarakkeeseen luku 1
				if (a.findElement(value) != null) {
					outputrow += "\t" + 1;
				}
				// Kirjoitettava alkio löytyy hajautustaulusta  b, joten kirjoitetaan toiseen
				// sarakkeeseen luku 2
				else {
					outputrow += "\t" + 2;
				}
				bw.write(outputrow);
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			System.err.format("Error" + e);
		}
		System.out.print("Poissulkeva tai (XOR): {");
		for (int i = 0; i < xor.size(); i++) {
			System.out.print(" " + xor.get(i));
		}
		System.out.println(" }, alkioiden lukumäärä: " + xor.size());
	}

	/**
	 * Apuoperaatio, joka kysyy käyttäjältä lukuja jotka halutaan poistaa hajautustaulusta
	 * ja mikäli syötteenä saatu luku löytyy hajautustaulusta, niin poistetaan sen kaikki
	 * esiintymät hajautustaulusta. Parametrina saadaan kaksi hajautustaulua, jotka on
	 * muodostettu syötetiedostoista setA.txt ja setB.txt, mutta ohjelmassa näitä käsitellään
	 * ikään kuin yhtä yksittäistä hajautustaulua ja siksi syötteenä annettu luku poistetaan
	 * samanaikaisesti kummastakin hajautustaulusta.
	 * 
	 * @param a ensimmäinen hajautustaulu
	 * @param b toinen hajautustaulu
	 */
	private static void deleteFromHashTable(HashTable a, HashTable b) {
		String input = "";
		while (!input.equals("exit")) {
			System.out.print("Anna poistettava luku (exit lopettaa): ");
			input = reader.nextLine();
			// Katsotaan, että syöte on numeromuotoinen, positiivinen ja muutettavissa kokonaisluvuksi
			if (input.matches("^\\d+$")) {
				int toRemove = Integer.parseInt(input);
				// Poistetaan käyttäjän syöttämä luku hajautustauluista
				if (a.removeAll(toRemove) != null | b.removeAll(toRemove) != null) {
					System.out.println("Luku " + toRemove + " poistettu.");
				}
				else {
					System.out.println("Lukua " + toRemove + " ei löytynyt hajautustaulusta.");
				}
			}
			else if (!input.equals("exit")) {
				System.out.println("Virheellinen syöte!");
			}
		}
	}

	public static void main(String[] args) {
		Tira2019 ht = new Tira2019();
		HashTable a = ht.readInput("setA.txt");
		HashTable b = ht.readInput("setB.txt");
		String input;

		// Käyttäjällä on mahdollisuus poistaa alkioita hajautustaulusta ennen joukko-operaatioiden
		// muodostamista ja tiedostojen kirjoittamista.
		do {
			System.out.print("Poistetaanko lukuja hajautustaulusta (kyllä / ei): ");
			input = reader.nextLine();
			if (input.equals("kyllä")) {
				deleteFromHashTable(a, b);
			}
			else if (!input.equals("ei")) {
				System.out.println("Virheellinen syöte!");
			}
		} while (!input.equals("ei"));

		ht.writeOrOutput("or.txt", a, b);
		ht.writeAndOutput("and.txt", a, b);
		ht.writeXorOutput("xor.txt", a, b);
	}
}