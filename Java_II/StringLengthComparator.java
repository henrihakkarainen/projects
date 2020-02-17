/*
 * 
 * StringLengthComparator - ohjelma
 * 
 * Lausekielinen ohjelmointi 2
 * 
 * Harjoitus 2 - Tehtävä 4
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class StringLengthComparator {
    // Operaatio tutkii merkkijonojen pituuksia ja palauttaa kokonaisluvun
    public static int compareLengths(String ekaMjono, String tokaMjono) {
        int ekanPituus = ekaMjono.length();
        int tokanPituus = tokaMjono.length();
        if (ekanPituus > tokanPituus) {
            return 1;
        }
        else if (ekanPituus < tokanPituus) {
            return -1;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello! I compare the lengths of two strings.");
        System.out.println("Please, enter the first string:");
        String ensimmainen = In.readString();
        System.out.println("Please, enter the second string:");
        String toinen = In.readString();
        int tulos = compareLengths(ensimmainen, toinen);
        if (tulos == 1) {
            System.out.println("\"" + ensimmainen + "\" is longer than \"" +
                               toinen + "\".");
        }
        else if (tulos == -1) {
            System.out.println("\"" + ensimmainen + "\" is shorter than \"" +
                               toinen + "\".");
        }
        else {
            System.out.println("\"" + ensimmainen + "\" is as long as \"" +
                               toinen + "\".");
        }
    }
}
