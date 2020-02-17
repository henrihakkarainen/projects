/*
 * 
 * ArrayInitialiser - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 3 - Tehtävä 1
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class ArrayInitialiser {   
   public static void main(String[] args) {
      System.out.println("Hello! I am an array initialiser.");
      System.out.println("Please, enter size:");
      int koko = In.readInt();
      if (koko <= 0) {
         System.out.println("Error!");
      }
      else {
         int[] taulukko = new int[koko];
         System.out.println("Please, enter value:");
         int alkio = In.readInt();
         System.out.print("{ ");
         for (int i = 0; i < koko; i++) {
            taulukko[i] = alkio;
            System.out.print(taulukko[i] + " ");
         }
         System.out.println("}");
      }
   }
}
