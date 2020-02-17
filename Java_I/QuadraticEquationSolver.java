/*
 * 
 * QuadraticEquationSolver - ohjelman sisennys
 * Rivit sisennetty tabulaattorilla
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 5 - Tehtävä 1
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

// Import the Scanner class from the java.util package.
import java.util.Scanner;

/*
* Viikkoharjoitus 5, tehtävä 1.
*
* Lausekielinen ohjelmointi I, syksy 2018.
*
* Jorma Laurikkala, jorma.laurikkala@uta.fi.
*
* A program for a solving a quadratic equation ax^2 + bx + c = 0, where a != 0.
* Only real roots are provided. The Scanner class with no associated error handling is used
* to facilitate the speedy compilation of the code.
*
*/

public class QuadraticEquationSolver {
	public static void main(String[] args) {
		// Constants for user's answers.
		final char YES = 'y';
		final char NO = 'n';

		// Some information to the user.
		System.out.println("Hello! I solve the quadratic equation ax^2 + bx + c = 0.");
		
		// Create a scanner (an object) for reading the inputs and attach to it
		// a variable (a reference).
		Scanner myScanner = new Scanner(System.in);
		
		// Flag for controlling the main loop.
		boolean doMainLoop = true;
		
		// The main loop.
		do {
			// Guess that user's input is invalid.
			boolean isZero = true;
			
			// Read the quadratic coefficient (a) from the user and make sure that
			// the coefficient cannot be equal to zero.
			double a;
			do {
				// Read the coefficient from the user.
				System.out.println("Please, enter a:");
				a = myScanner.nextDouble();

				// Set the flag, in the input is not zero.
				if (a != 0) {
					isZero = false;
				}
				// Respond to an erroneous input.
				else {
					System.out.println("This coefficient cannot be zero!");
				}
			}
			while (isZero);
		
			// Read the linear coefficient (b) from the user.
			System.out.println("Please, enter b:");
			double b = myScanner.nextDouble();
			
			// Read the constant (c) from the user.
			System.out.println("Please, enter c:");
			double c = myScanner.nextDouble();
			
			// Compute the discriminant (d).
			double d = b * b - 4 * a * c;
			
			// Real roots.
			if (d >= 0) {
				// Compute the roots.
				double x1 = (-b + Math.sqrt(d)) / (2 * a);
				double x2 = (-b - Math.sqrt(d)) / (2 * a);
				
				// Two roots.
				if (d > 0) {
					// Print two decimals after the decimal point and separate line.
					System.out.printf("The roots are %.2f and %.2f.%n", x1, x2);
				}
				// One root.
				else {
					// Print two decimals after the decimal point and separate line.
					System.out.printf("The root is %.2f.%n", x1);
				}
			}
			// Complex roots are not provided.
			else {
				System.out.println("The roots are imaginary!");
			}
			
			// Enquire user's wishes.
			System.out.println("Continue (" + YES + "/" + NO + ")?");
			char decision = myScanner.next().charAt(0);
			
			// Set flag the flag, if user answers no.
			if (decision == NO) {
				doMainLoop = false;
			}
		}
		while (doMainLoop);

		// Remember to be nice and close the scanner.
		myScanner.close();
	}
}
