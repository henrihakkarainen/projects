import java.io.*;
import java.util.*;
/*
 * Lausekielinen ohjelmointi II - Harjoitustyö II
 * 
 * ASCII-grafiikkana esitettyjen kuvien katseluun ja käsittelyyn
 * soveltuva Java-ohjelma.
 * 
 * Henri Hakkarainen
 * Hakkarainen.Henri.J@student.uta.fi
 * 
 */
public class LakiHT2 {
   // ASCII-merkit taulukossa, jossa ne yhdistyvät omaan indeksiarvoonsa välillä
   // 0 - 15. Taulukkoa hyödynnetään esim. ohjelman operaatioissa.
   public static final char[] ASCII = {'#', '@', '&', '$', '%', 'x', '*', 'o',
                                       '|', '!', ';', ':', '\'', ',', '.', ' '};
   // Main-operaatiossa käyttäjän tekemät valinnat vakioituna
   public static final String PRINTA = "printa";
   public static final String PRINTI = "printi";
   public static final String INFO = "info";
   public static final String FILTER = "filter";
   public static final String RESET = "reset";
   public static final String LOPETUS = "quit";
   // Keskiarvosuotimen sivujen oletuspituus
   public static final int OLETUS = 3;
   
   /*
    * Operaatiolle välitetään parametrina tiedosto-olio ja operaatio laskee tiedoston
    * rivit ja rivien pituuden ja alustaa näiden tietojen perusteella kaksiulotteisen
    * int-tyyppisen taulukon, joka välitetään paluuarvona. Jos tiedoston lukemisessa
    * tapahtuu ongelma, palautetaan null-arvoinen taulukko.
    */
   public static int[][] alustaTaulukko(File tiedosto) {
      int rivit = 0;
      int sarakkeet = 0;
      int[][] lukuTaulukko = null;
      try {
         // Käydään läpi tiedoston rivit, jotta saadaan kuvan koko selville
         Scanner lukija = new Scanner(tiedosto);
         while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            rivit += 1;
            if (rivi.length() > sarakkeet) {
               sarakkeet = rivi.length();
            }
         }
         lukija.close();
         
         // Alustetaan taulukko rivien ja sarakkeiden määrän kokoiseksi
         lukuTaulukko = new int[rivit][sarakkeet];
      }
      catch (Exception e) {
         System.out.println("Error!");
         lukuTaulukko = null;
      }
      return lukuTaulukko;
   }
   
   /*
    * Operaatiolle välitetään parametrina int-tyyppinen kaksiulotteinen taulukko ja
    * tiedosto-olio. Tiedostossa olevasta merkkimuotoisesta kuvasta muodostetaan
    * kuvan lukuesitys ja talletetaan arvot parametrina vastaanotettuun taulukkoon.
    * Lukuesitys muodostetaan käyttäen vakioitua ASCII-taulukkoa, josta etsitään
    * kullekin tiedostosta luetulle merkille niiden esiintymän indeksiarvo eli luku.
    * Operaatiota kutsutaan pääohjelman suorituksen alkuvaiheessa, mutta käyttäjä
    * voi myös halutessaan myöhemmin nollata kuvaan tehdyt muutokset ja kutsua
    * tätä operaatiota, jolloin alkuperäinen kuva ladataan uudelleen käyttöön.
    */
   public static void lataaKuva(int[][] taytettava, File tiedosto) {
      if (taytettava != null) {
         try {
            // Luetaan kuvatiedosto läpi, poimitaan merkkien esiintymät
            // ja viedään niiden lukuarvot taulukkoon
            Scanner lukija = new Scanner(tiedosto);
            for (int i = 0; i < taytettava.length; i++) {
               String rivi = lukija.nextLine();
               for (int j = 0; j < taytettava[i].length; j++) {
                  // Kutsutaan returnIndex-operaatiota, joka palauttaa tutkittavaa
                  // merkkiä vastaavan lukuarvon ASCII-taulukosta
                  taytettava[i][j] = returnIndex(rivi.charAt(j));
               }
            }
            lukija.close();
         }
         // Jos jotain menee pieleen, taulukko jätetään tyhjäksi (null)
         catch (Exception e) {
            System.out.println("Error!");
            taytettava = null;
         }
      }
   }
   
   /*
    * Operaatio etsii parametrina vastaanottamaansa merkkiä ASCII-taulukosta
    * ja palauttaa merkin esiintymän indeksiarvon. Jos merkkiä ei löydy,
    * palautetaan -1 (tässä harjoitustehtävässä tätä tilannetta ei pitäisi koskaan
    * tapahtua, koska kuvat koostuvat aina ASCII-taulukon sisältämistä merkeistä).
    */
   public static int returnIndex(char etsittava) {
      for (int i = 0; i < ASCII.length; i++) {
         if (ASCII[i] == etsittava) {
            return i;
         }
      }
      return -1;
   }
   
   /*
    * Operaatio vastaanottaa parametrinaan int-tyyppisen kaksiulotteisen taulukon
    * ja hakee kutakin taulukon lukuarvoa vastaavan merkin ASCII-taulukosta
    * ja tulostaa sen näytölle, jolloin saadaan tulostettua kuvan
    * graafinen esitys.
    */
   public static void tulostaKuvana(int[][] arvot) {
      if (arvot != null) {
         for (int i = 0; i < arvot.length; i++) {
            for (int j = 0; j < arvot[i].length; j++) {
               System.out.print(ASCII[arvot[i][j]]);
            }
            System.out.println();
         }
      }
   }
   
   /*
    * Operaatio vastaanottaa parametrinaan int-tyyppisen kaksiulotteisen taulukon
    * ja tulostaa lukuarvot näytölle välilyönneillä erotettuna, jolloin saadaan
    * tulostettua kuvan esitys lukumuodossa.
    */
   public static void tulostaLukuina(int[][] arvot) {
      if (arvot != null) {
         for (int i = 0; i < arvot.length; i++) {
            for (int j = 0; j < arvot[i].length; j++) {
               // Tulostetaan välilyönti, jos luku pienempi kuin 10 (yksinumeroinen)
               // ja luvun perään välilyönti (paitsi viimeisen sarakkeen kohdalla)
               System.out.print((arvot[i][j] < 10 ? " " : "") + arvot[i][j]
                                + (j == arvot[i].length - 1 ? "" : " "));
            }
            System.out.println();
         }
      }
   }
   
   /*
    * Operaatio tulostaa näytölle kuvan koon ja kuvassa esiintyvien merkkien
    * lukumäärät. Operaatio vastaanottaa parametrinaan int-tyyppisen kaksiulotteisen
    * taulukon ja taulukon lukuarvoja vertaillaan vakioituun ASCII-taulukkoon,
    * jotta saadaan laskettua kutakin lukuarvoa vastaavan merkin esiintymien
    * kokonaismäärä.
    */
   public static void tulostaTietoja(int[][] arvot) {
      if (arvot != null) {
         // Tulostetaan kuvan koko (rivit x sarakkeet)
         System.out.println(arvot.length + " x " + arvot[0].length);
         // Käydään läpi ASCII-taulukon merkit yksi kerrallaan
         for (int i = 0; i < ASCII.length; i++) {
            int kpl = 0;
            for (int j = 0; j < arvot.length; j++) {
               for (int k = 0; k < arvot[j].length; k++) {
                  // Jos merkkiä vastaava indeksiarvo ASCII-taulukossa on sama, kuin
                  // kaksiulotteisessa int-taulukossa esiintyvä arvo, kasvatetaan
                  // merkin esiintymien laskuria yhdellä
                  if (returnIndex(ASCII[i]) == arvot[j][k]) {
                     kpl += 1;
                  }
               }
            }
            // Tulostetaan merkin esiintymien lukumäärä kuvassa
            System.out.println(ASCII[i] + " " + kpl);
         }
      }
   }
   
   /*
    * Operaatio käsittelee kuvaa neliön muotoisella keskiarvosuotimella, jonka
    * koko (sivujen pituudet) vastaanotetaan parametrina. Lisäksi parametrina
    * saadaan kaksiulotteinen taulukko, joka sisältää suodatettavan kuvan merkkejä
    * vastaavat lukuarvot. Operaatio käy läpi taulukon jokaisen arvon, suodattaa
    * arvon niiltä paikoilta, joiden ympärille keskiarvosuodin mahtuu kokonaisena
    * ja palauttaa paluuarvonaan uuden taulukon, joka on täytetty suodatetuilla
    * arvoilla.
    */
   public static int[][] suodataLuvut(int[][] arvot, int pituus) {
      if (arvot != null) {
         // Alustetaan uusi kaksiulotteinen int-tyyppinen taulukko, johon operaation
         // tuottamat suodatetut lukuarvot sijoitetaan
         int[][] suodatettuTaulukko = new int[arvot.length][arvot[0].length];
         int width = (pituus - 1) / 2;
         for (int i = 0; i < arvot.length; i++) {
            for (int j = 0; j < arvot[i].length; j++) {
               // Sijoitetaan arvo sellaisenaan, mikäli keskiarvosuodin ei mahdu
               // taulukon alkion ympärille kokonaisena (ylimmät ja alimmat rivit)
               if (i < width || i + width > arvot.length - 1) {
                  suodatettuTaulukko[i][j] = arvot[i][j];
               }
               else {
                  // Sijoitetaan arvo sellaisenaan, mikäli keskiarvosuodin ei mahdu
                  // taulukon alkion ympärille kokonaisena (reunimmaiset sarakkeet)
                  if (j < width || j + width > arvot[i].length - 1) {
                     suodatettuTaulukko[i][j] = arvot[i][j];
                  }
                  else {
                     double summa = 0;
                     // Käydään läpi keskiarvosuotimen kattama arvoalue
                     // tarkasteltavan luvun ympäriltä (suotimen keskipiste)
                     for (int k = 0; k < pituus; k++) {
                        for (int m = 0; m < pituus; m++) {
                           summa += arvot[i+width-k][j+width-m];
                        }
                     }
                     // Lasketaan keskiarvo ja sijoitetaan arvo taulukkoon
                     long keskiarvo = Math.round(summa / (pituus * pituus));
                     suodatettuTaulukko[i][j] = (int)keskiarvo;
                  }
               }
            }
         }         
         return suodatettuTaulukko;
      }
      else {
         return null;
      }
   }
   
   public static void main(String[] args) {
      System.out.println("-------------------");
      System.out.println("| A S C I I A r t |");
      System.out.println("-------------------");
      boolean tiedostoOk;
      File kuvatiedosto = null;
      // Komentoriviparametreja on enemmän kuin yksi
      if (args.length != 1) {
         System.out.println("Invalid command-line argument!");
         tiedostoOk = false;
      }
      else {
         kuvatiedosto = new File(args[0]);
         // Komentoriviparametrina saatua tiedostoa ei löydy hakemistosta
         if (!kuvatiedosto.exists()) {
            System.out.println("Invalid command-line argument!");
            tiedostoOk = false;
         }
         else {
            tiedostoOk = true;
         }
      }
      // Jatketaan ohjelman suorittamista, jos tiedosto oli ok
      if (tiedostoOk) {
         boolean jatketaan;
         // Alustetaan int-tyyppinen kaksiulotteinen taulukko
         int[][] taulukkoLukuina = alustaTaulukko(kuvatiedosto);
         // Täytetään taulukko kuvatiedostossa olevan merkkimuotoisen esityksen
         // lukuarvoja vastaavilla arvoilla
         lataaKuva(taulukkoLukuina, kuvatiedosto);
         do {
            System.out.println("printa/printi/info/filter [n]/reset/quit?");
            // Luetaan käyttäjän syöte, kaapataan se String-tyyppiseen taulukkoon
            // jotta filter-komennon mahdollinen numerokin saadaan talteen
            String syote = In.readString();
            String[] osat = syote.split("[ ]");
            if (osat.length == 1) {
               // Suoritetaan syötettä vastaava toiminto (operaatio) ohjelmassa
               switch (syote) {
                  case PRINTA:
                     tulostaKuvana(taulukkoLukuina);
                     jatketaan = true;
                     break;
                  case PRINTI:
                     tulostaLukuina(taulukkoLukuina);
                     jatketaan = true;
                     break;
                  case INFO:
                     tulostaTietoja(taulukkoLukuina);
                     jatketaan = true;
                     break;
                  case FILTER:
                     taulukkoLukuina = suodataLuvut(taulukkoLukuina, OLETUS);
                     jatketaan = true;
                     break;
                  case RESET:
                     lataaKuva(taulukkoLukuina, kuvatiedosto);
                     jatketaan = true;
                     break;
                  case LOPETUS:
                     jatketaan = false;
                     break;
                  // Halusin lisätä koodiin mahdollisuuden antaa väärä komento,
                  // jolloin tulostuu virheilmoitus ja komentoa pyydetään uusiksi
                  default:
                     System.out.println("Command not found!");
                     jatketaan = true;
                     break;
               }
            }
            // Käyttäjä antoi kaksiosaisen komennon (eli tässä oletetaan, että se
            // on muotoa "filter n", jossa n on suotimen sivujen pituus)
            else {
               int koko = Integer.parseInt(osat[1]);
               taulukkoLukuina = suodataLuvut(taulukkoLukuina, koko);
               jatketaan = true;
            }
         }
         while (jatketaan);
      }
      System.out.println("Bye, see you soon.");
   }   
}
