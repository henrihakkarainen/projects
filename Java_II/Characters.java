// Import Scanner.
import java.util.*;

/*
 * Exercise 5, Question 1.
 *  
 * Lausekielinen ohjelmointi II, syksy 2017.
 *
 * Jorma Laurikkala, jorma.laurikkala@uta.fi.
 *
 * A very poorly written structural program that finds out the characteristics
 * of a character. The program needs to be reworked so that the values are is
 * passed between the operations by using parameter lists and return values
 * instead of attributes. No attributes should remain in the fixed program.
 *
 * Korjannut: Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 * Attribuutit poistettu ja tietojen välitys operaatioihin ja niistä pois
 * korvattu parametreilla ja paluuarvoilla.
 */

public class Characters {
   /* Determines if the character is a digit.
    */
   public static boolean isDigit(char achar) {
      if (achar >= '0' && achar <= '9') {
         return true;
      }
      else {
         return false;
      }
   }

   /* Determines if the character is a lowercase letter.
    */
   public static boolean isLowercaseLetter(char achar) {
      if ((achar >= 'a' && achar <= 'z') || (achar == 'å') || (achar == 'ä') || (achar == 'ö')) {
         return true;
      }
      else {
         return false;
      }
   }

   /* Determines if the character is a uppercase letter.
    */
   public static boolean isUppercaseLetter(char achar) {
      if ((achar >= 'A' && achar <= 'Z') || (achar == 'Å') || (achar == 'Ä') || (achar == 'Ö')) {
         return true;
      }
      else {
         return false;
      }
   }

   /* Determines if the character is a letter in the Finnish alphabet.
    */
   public static boolean isLetter(char achar) {
      // A letter can be a lowercase or an uppercase one.
      if (isLowercaseLetter(achar) || isUppercaseLetter(achar)) {
         return true;
      }
      else {
         return false;
      }
   }

   /* Prints the results to the screen.
    */
   public static void printResults(char achar, boolean digit,
                                   boolean lowercaseLetter, boolean uppercaseLetter,
                                   boolean letter) {
      System.out.println("Character \'" + achar + "\':");
      System.out.println("- " + (digit ? "is" : "is not") + " a number,");
      System.out.println("- " + (lowercaseLetter ? "is" : "is not") + " a lowercase letter,");
      System.out.println("- " + (uppercaseLetter ? "is" : "is not") + " an uppercase letter and");
      System.out.println("- " + (letter ? "is" : "is not") + " a letter.");
   }

   public static void main(String[] args) {
      // Info to the user.
      System.out.println("Hello! I examine characters.");

      // Read the input as a string.
      Scanner scanner = new Scanner(System.in);
      String aline = scanner.nextLine();

      // Call the operations only if a single character was given as input.
      if (aline.length() == 1) {
         // Input from the user.
         char achar = aline.charAt(0);
         // Evaluate the attribute value in operations.
         
         // True, if the character is a decimal digit.
         boolean digit = isDigit(achar);
         // True, if the character is a lowercase letter.
         boolean lowercaseLetter = isLowercaseLetter(achar);
         // True, if the character is an uppercase letter.
         boolean uppercaseLetter = isUppercaseLetter(achar);
         // True, if the character is a letter.
         boolean letter = isLetter(achar);

         // Print the results.
         printResults(achar, digit, lowercaseLetter, uppercaseLetter, letter);
      }
      // Inform the user of an erroneus input.
      else {
         System.out.println("Bad character!");
      }
   } 
}
