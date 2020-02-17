/*
 * 
 * Month - ohjelma
 * 
 * Lausekielinen ohjelmointi 2
 * 
 * Harjoitus 3 - Tehtävä 3
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class Month {
    // Operaatio vastaanottaa kuukauden järjestysnumeron ja etsii numeroa
    // vastaavan kuukauden nimen taulukosta ja palauttaa kuukauden nimen.
    public static String giveName(int kk) {
        String[] kuukaudet = {"January", "February", "March", "April", "May",
                              "June", "July", "August", "September", "October",
                              "November", "December"};
        kk -= 1;
        return kuukaudet[kk];
    }

    public static void main(String[] args) {
        System.out.println("Hello! I verbalise your input.");
        System.out.println("Please, enter a number:");
        int luku = In.readInt();
        String kuukausi = giveName(luku);
        System.out.println("It is " + kuukausi + ".");
    }
}
