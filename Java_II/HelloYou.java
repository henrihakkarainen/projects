/*
 * 
 * HelloYou - ohjelma
 * 
 * Lausekielinen ohjelmointi 2
 * 
 * Harjoitus 1 - Tehtävä 3
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class HelloYou {
    // Operaatio tulostaa tervehdyksen käyttäjälle
    public static void tulostaTervehdys(String tervehdys) {
        System.out.println("Hello " + tervehdys + "!");
    }

    public static void main(String[] args) {
        System.out.println("Hello! I shall say hello to you.");
        System.out.println("Please, enter your name:");
        String nimi = In.readString();
        tulostaTervehdys(nimi);
    }
}
