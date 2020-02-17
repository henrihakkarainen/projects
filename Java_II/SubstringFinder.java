/*
 * Lausekielinen ohjelmointi II - Harjoitustyö I
 * SubstringFinder - ohjelma
 * 
 * Henri Hakkarainen
 * Hakkarainen.Henri.J@student.uta.fi
 * 
 */
public class SubstringFinder {
    /*
     * Operaatio hakee merkkijonosta kaikki mahdolliset osamerkkijonon esiintymät.
     * Operaatiolla ei ole paluuarvoa (void) ja se tulostaa kunkin osamerkkijonon
     * esiintymän omalle rivilleen. Operaatio vastaanottaa tutkittavan merkkijonon
     * ja vertailtavan osamerkkijonon parametreinaan.
     */
    public static void teeHaku(String merkkijono, String ojono) {
        int mPituus = merkkijono.length();
        int oPituus = ojono.length();
        int indAlku;
        int indLoppu;
        String osajono = "";
        // Jos osamerkkijonon viimeinen merkki on tähti (*), pakotetaan haku
        // merkkijonon alkuun (asetetaan operaation pääsilmukan lähtö- ja lopetus-
        // arvoiksi indeksiarvo 0). Silmukalla poistetaan *-merkki osamerkkijonosta
        // ennen kuin sitä voidaan verrata vertailun kohteena olevaan merkkijonoon
        if (ojono.charAt(oPituus - 1) == '*') {
            for (int i = 0; i < oPituus - 1; i++) {
                char merkki = ojono.charAt(i);
                osajono += merkki;
            }
            oPituus -= 1;
            indAlku = 0;
            indLoppu = 0;
        }
        // Jos osamerkkijonon ensimmäinen merkki on tähti (*), pakotetaan haku
        // merkkijonon loppuun (asetetaan operaation pääsilmukan lähtö- ja lopetus-
        // arvoiksi sopiva indeksiarvo). Silmukalla poistetaan *-merkki
        // osamerkkijonosta ennen kuin sitä voidaan verrata vertailun
        // kohteena olevaan merkkijonoon
        else if (ojono.charAt(0) == '*') {
            for (int i = 1; i < oPituus; i++) {
                char merkki = ojono.charAt(i);
                osajono += merkki;
            }
            oPituus -= 1;
            indAlku = mPituus - oPituus;
            indLoppu = mPituus - oPituus;
        }
        else {
            osajono = ojono;
            indAlku = 0;
            indLoppu = mPituus - oPituus;
        }
        
        // Silmukan lähtöarvona on 0, paitsi silloin, kun osamerkkijonon esiintymien
        // haku on pakotettu merkkijonon loppuun. Mikäli tähtimerkkiä (*) on käytetty
        // osamerkkijonossa, pyörii tämä silmukka ainoastaan yhden kierroksen
        for (int i = indAlku; i <= indLoppu; i++) {
            String vertailtava = "";
            for (int j = 0; j < oPituus; j++) {
                int kohta = i + j;
                char merkki = merkkijono.charAt(kohta);
                vertailtava += merkki;
            }
            // Jos muuttuja vertailtava matchaa osamerkkijonon kanssa, tulostetaan
            // esiintymän sijainti merkkijonosta
            if (vertailtava.equals(osajono)) {
                for (int m = 0; m < i; m++) {
                    System.out.print("-");
                }
                System.out.print(osajono);
                for (int n = i + oPituus; n < mPituus; n++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args) {
        // Alustetaan ohjelman käyttämät vakiot
        final char JATKUU = 'y';
        final char LOPETUS = 'n';
        final String VIRHE = "Error!";
        
        // Tervehditään ohjelman käyttäjää
        System.out.println("Hello! I find substrings.");
        boolean jatketaan = true;
        // Ohjelman pääsilmukka
        do {
            System.out.println("Please, enter a string:");
            String mjono = In.readString();
            String ojono;
            boolean syoteOk;
            // Kysytään osamerkkijonoa niin kauan, kunnes saadaan oikeellinen syöte
            do {
                System.out.println("Please, enter a substring:");
                ojono = In.readString();
                // Liian pitkä osamerkkijonon syöte ei kelpaa
                if (ojono.length() > mjono.length()) {
                    syoteOk = false;
                }
                else {
                    // Tutkitaan vielä, ettei tähtimerkkejä (*) esiinny
                    // osamerkkijonossa kuin korkeintaan yksi kappale osamerkkijonon
                    // alussa tai lopussa
                    int jokeriMerkkeja = 0;
                    for (int i = 0; i < ojono.length(); i++) {
                        if (ojono.charAt(i) == '*') {
                            jokeriMerkkeja += 1;
                        }
                    }
                    // Enemmän kuin yksi tähtimerkki
                    if (jokeriMerkkeja > 1) {
                        syoteOk = false;
                    }
                    else if (jokeriMerkkeja == 1) {
                        // Tähtimerkkejä 1 kpl ja se esiintyy joko osamerkkijonon
                        // ensimmäisessä tai viimeisessä indeksiarvossa, sekä
                        // osamerkkijono on suurempi kuin yhden merkin pituinen
                        if ((ojono.charAt(0) == '*' ||
                        ojono.charAt(ojono.length() - 1) == '*') &&
                        ojono.length() > 1) {
                            syoteOk = true;
                        }
                        else {
                            syoteOk = false;
                        }
                    }
                    // Ei lainkaan tähtimerkkejä osamerkkijonossa
                    else {
                        syoteOk = true;
                    }
                }
                // Jos syöte ei kelvannut ohjelmalle, niin tulostetaan virheilmoitus
                if (syoteOk == false) {
                    System.out.println(VIRHE);
                }
            }
            while (!syoteOk);
            
            // Hakee mahdolliset osamerkkijonon esiintymät operaation avulla
            teeHaku(mjono, ojono);
            
            // Haluaako käyttäjä jatkaa ohjelman suorittamista
            do {
                System.out.println("Continue (y/n)?");
                char valinta = In.readChar();
                // Virheellinen syöte
                if (valinta != JATKUU && valinta != LOPETUS) {
                    syoteOk = false;
                    System.out.println(VIRHE);
                }
                // Syöte kelpaa, muutetaan pääsilmukkaa kontrolloivan lippumuuttujan
                // arvo sen mukaan, haluaako käyttäjä jatkaa vai ei
                else {
                    syoteOk = true;
                    if (valinta == JATKUU) {
                        jatketaan = true;
                    }
                    else {
                        jatketaan = false;
                    }
                }
            }
            while (!syoteOk);
        }
        while (jatketaan);
        
        // Sanotaan heipat lopuksi
        System.out.println("See you soon.");
    }
}
