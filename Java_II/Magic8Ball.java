/*
 * 
 * Magic8Ball - ohjelma
 * 
 * Lausekielinen ohjelmointi 2
 * 
 * Harjoitus 1 - Tehtävä 2
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class Magic8Ball {
    // Operaatio tulostaa satunnaisen vastauksen käyttäjän kysymykseen
    public static void tulostaVastaus() {
        int arvottu = (int)(20 * Math.random()) + 1;
        if (arvottu == 1)
            System.out.println("It is certain.");
        else if (arvottu == 2)
            System.out.println("It is decidedly so.");
        else if (arvottu == 3)
            System.out.println("Without a doubt.");
        else if (arvottu == 4)
            System.out.println("Yes definitely.");
        else if (arvottu == 5)
            System.out.println("You may rely on it.");
        else if (arvottu == 6)
            System.out.println("As I see it, yes.");
        else if (arvottu == 7)
            System.out.println("Most likely.");
        else if (arvottu == 8)
            System.out.println("Outlook good.");
        else if (arvottu == 9)
            System.out.println("Yes.");
        else if (arvottu == 10)
            System.out.println("Signs point to yes.");
        else if (arvottu == 11)
            System.out.println("Reply hazy try again.");
        else if (arvottu == 12)
            System.out.println("Ask again later.");
        else if (arvottu == 13)
            System.out.println("Better not tell you now.");
        else if (arvottu == 14)
            System.out.println("Cannot predict now.");
        else if (arvottu == 15)
            System.out.println("Concentrate and ask again.");
        else if (arvottu == 16)
            System.out.println("Don't count on it.");
        else if (arvottu == 17)
            System.out.println("My reply is no.");
        else if (arvottu == 18)
            System.out.println("My sources say no.");
        else if (arvottu == 19)
            System.out.println("Outlook not so good.");
        else if (arvottu == 20)
            System.out.println("Very doubtful.");
    }

    public static void main(String[] args) {
        System.out.println("Hello! I am a Magic 8 Ball.");
        System.out.println("Ask me:");
        In.readString();
        tulostaVastaus();
    }
}
