/*
 * 
 * TwoUp - ohjelman sisentäminen
 * Rivit sisennetty tabulaattorilla
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 6 - Tehtävä 1
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
 
// Import the Scanner class from the java.util package.
import java.util.Scanner;

/*
 * Viikkoharjoitus 6, tehtĆ¤vĆ¤ 1.
 *
 * Lausekielinen ohjelmointi I, syksy 2018.
 *
 * Jorma Laurikkala, jorma.laurikkala@uta.fi.
 *
 * A Java program which simulates a gambling game played by tossing two coins
 * into the air. Player wins, if the coins fall heads up and loses, if the coins
 * fall tails up. If the coins fall one coin heads up and the other tails up,
 * or vice versa, the player is allowed to toss the coins again. The program uses
 * random numbers to simulate the game. Before the simulation, the number of turns
 * is read from the user, until a valid input (> 0) is given. Please, note that
 * a turn may involve one of more tosses, because there may be rethrows,
 * until the turn ends into win or loss. The Scanner class with no associated
 * error handling is used to facilitate speedy compilation of the code.
 */

public class TwoUp {
	public static void main(String[] args) {
		// Outcomes as constants.
		final boolean HEADS = true;
		final boolean TAILS = false;

		// The minimum number of turns.
		final int MINTURNS = 1;

		// The number of turns.
		int nturns;

		// Turn counter.
		int turn = 1;

		// Coins are tossed until this flag is raised.
		boolean isWinOrLoss;

		// Counters for wins and losses.
		int nwins = 0, nlosses = 0;

		// Create a scanner (an object) for reading the inputs and attach to it
		// a variable (a reference).
		Scanner myScanner = new Scanner(System.in);

		// Information for the user.
		System.out.println("Hello! I shall gamble on your behalf.");

		// Read until the user enters a valid input.
		do {
			// Read the number of turns.
			System.out.println("Please enter the number of turns (>" + (MINTURNS - 1) + "):");
			nturns = myScanner.nextInt();

			// Print an error message.
			if (nturns < MINTURNS) {
				System.out.println("Error!");
			}
		}
		while (nturns < MINTURNS);

		// Let us gamble.
		do {
			// One turn.
			System.out.println("- Turn " + turn + " ---");
			do {
				// Initialise the flag.
				isWinOrLoss = false;

				// Toss the coins.
				boolean coin1 = Math.random() < 0.5;
				boolean coin2 = Math.random() < 0.5;

				// Report the result.
				if (coin1 == HEADS && coin2 == HEADS) {
					nwins = nwins + 1;
					isWinOrLoss = true;
					System.out.println("Win!");
				}
				else {
					if (coin1 == TAILS && coin2 == TAILS) {
						nlosses = nlosses + 1;
						isWinOrLoss = true;
						System.out.println("Loss!");
					}
					else {
						System.out.println("New toss.");
					}
				}
			}
			while (!isWinOrLoss);

			// It is time for the next turn.
			turn = turn + 1;
		}
		while (turn <= nturns);

		// Report the results.
		System.out.println("There were " + nwins + " wins and " + nlosses + " losses.");

		// Remember to be nice and close the scanner.
		myScanner.close();
	}
}
