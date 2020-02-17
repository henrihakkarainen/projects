/*
 * 
 * OddCounter - ohjelman korjaus
 * 
 * Lausekielinen ohjelmointi 1
 * 
 * Harjoitus 5 - Tehtävä 2
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */

// Import the Scanner class from the java.util package.
import java.util.Scanner;

/*
 * Viikkoharjoitus 5, tehtävä 2.
 *
 * Lausekielinen ohjelmointi I, syksy 2018.
 *
 * Jorma Laurikkala, jorma.laurikkala@uta.fi.
 *
 * A program for counting odd integers. The program contains some syntax
 * errors and logical errors exist as well. The Scanner class with no associated
 * error handling is used to facilitate the speedy compilation of the code.
 *
 */

public class OddCounter {
   public static void main(String[] args) {
      // Give some information to the user.
      System.out.println("Hello! I count odd integers.");
      
      // Create a scanner (an object) for reading the inputs and attach to it
      // a variable (a reference).
      Scanner myScanner = new Scanner(System.in);
      
      // Set flag. *** Lippumuuttujan alustus siirretty ulompaan lohkoon ***
      boolean inputOK = false;
      
      // *** Esitellään muuttuja numOfInts täällä, jotta se on käytettävissä myös
      // ensimmäisen do-while silmukan jälkeen ohjelman main-lohkossa ***
      int numOfInts;
      
      // Read the number of integers.
      do {
         // Assuming integers as inputs.
         System.out.println("Please, enter the number of integers:");
         numOfInts = myScanner.nextInt();
         if (numOfInts > 0)
            inputOK = true;
         
         // Respond to the erroneous input.
         // *** else-lohko ympäröity aaltosuluilla, koska se sisältää enemmän
         // kuin yhden lauseen ***
         else {
            inputOK = false;
            System.out.println("The number must be at least one!");
         }
      }
      // *** while-ehto korjattu, ettei pyöri ikuisessa silmukassa ***
      while (inputOK == false);
      
      // Read the integers and count the odd ones.
      int numOfOddInts = 0;
      
      // *** for-silmukan ehdon perästä poistetaan ; ***
      for (int i = 0; i < numOfInts; i++) {
         // Again, assuming integers as inputs.
         System.out.println("Please, enter an integer:");
         int anInt = myScanner.nextInt();

         // Detect an odd integer.
         if (anInt % 2 == 1) {
            numOfOddInts++;
         }
      // *** Suljetaan for-silmukka aaltosululla ***
      }
      
      // Distinguish between the singular and plural in the output.
      System.out.println("Found " + numOfOddInts + " odd integer"
      + (numOfOddInts == 1 ? "." : "s."));
      // *** ylhäällä laitettu ehto sulkujen sisään ***
      
      // Remember to be nice and close the scanner.
      myScanner.close();
   }
}
