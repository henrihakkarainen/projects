/*
 * 
 * ArrayFiller1 - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 3 - Tehtävä 2
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class ArrayFiller1 {   
   public static void main(String[] args) {
      System.out.println("Hello! I am an array filler.");
      System.out.println("Please, enter size:");
      int koko = In.readInt();
      if (koko <= 0) {
         System.out.println("Error!");
      }
      else {
         char[] taulukko = new char[koko];
         for (int i = 0; i < koko; i++) {
            int arrayIndex = i + 1;
            System.out.println("Please, enter value " + arrayIndex + ":");
            char alkio = In.readChar();
            taulukko[i] = alkio;
         }
         System.out.print("{ ");
         for (int j = 0; j < koko; j++) {
            System.out.print(taulukko[j] + " ");
         }
         System.out.println("}");
      }
   }
}
