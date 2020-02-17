/*
 * 
 * StringLengthComparator - ohjelma
 * 
 * Lausekielinen ohjelmointi 2
 * 
 * Harjoitus 1 - Tehtävä 6
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class StringLengthComparator {
    // Operaatio tutkii merkkijonojen pituuksia
    public static void vertaaPituuksia(String ekaMjono, String tokaMjono) {
        int ekanPituus = ekaMjono.length();
        int tokanPituus = tokaMjono.length();
        if (ekanPituus > tokanPituus) {
            System.out.println("\"" + ekaMjono + "\" is longer than \"" +
                               tokaMjono + "\".");
        }
        else if (ekanPituus < tokanPituus) {
            System.out.println("\"" + ekaMjono + "\" is shorter than \"" +
                               tokaMjono + "\".");
        }
        else {
            System.out.println("\"" + ekaMjono + "\" is as long as \"" +
                               tokaMjono + "\".");
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello! I compare the lengths of two strings.");
        System.out.println("Please, enter the first string:");
        String ensimmainen = In.readString();
        System.out.println("Please, enter the second string:");
        String toinen = In.readString();
        vertaaPituuksia(ensimmainen, toinen);
    }
}
