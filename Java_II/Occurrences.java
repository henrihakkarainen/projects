/*
 * 
 * Occurrences - ohjelma
 * 
 * Lausekielinen ohjelmointi 2
 * 
 * Harjoitus 1 - Tehtävä 7
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class Occurrences {
    // Operaatio tutkii moniko ensimmäisen parametrin merkkijonon merkeistä
    // esiintyy toisen parametrin merkkijonossa
    public static void vertaaEsiintymia(String ekaMjono, String tokaMjono) {
        int tulos = 0;
        int ekanPituus = ekaMjono.length();
        int tokanPituus = tokaMjono.length();
        for (int i = 0; i < ekanPituus; i++) {
            int matcheja = 0;
            char merkki = ekaMjono.charAt(i);
            for (int j = 0; j < tokanPituus; j++) {
                char tutkittava = tokaMjono.charAt(j);
                if (tutkittava == merkki) {
                    matcheja += 1;
                }
            }
            if (matcheja > 0) {
                tulos += 1;
            }
        }
        System.out.println("The number of occurrences is " + tulos + ".");
    }

    public static void main(String[] args) {
        System.out.println("Hello! I count character occurrences between strings.");
        System.out.println("Enter the first string:");
        String ensimmainen = In.readString();
        System.out.println("Enter the second string:");
        String toinen = In.readString();
        vertaaEsiintymia(ensimmainen, toinen);
    }
}
