import java.io.*;
import java.util.*;
/*
 * 
 * FileLoader - ohjelma
 * 
 * Lausekielinen ohjelmointi II
 * 
 * Harjoitus 6 - Tehtävä 1
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class FileLoader {
   /*
    * Operaatio laskee parametrina vastaanottamansa nimisestä tiedostosta rivien
    * lukumäärän ja rivin pituuden (eli taulukon sarakkeen pituuden) ja palauttaa
    * tiedot yksiulotteisessa int-tyyppisessä taulukossa, joka luodaan operaatiossa.
    */
   public static int[] countSize(String tiedosto) {
      int rivienLkm = 0;
      int sarakeLkm = 0;
      int[] rivitJaSarakkeet;
      try {
         File tiedostonNimi = new File(tiedosto);
         Scanner lukija = new Scanner(tiedostonNimi);
         String rivi = "";
         while (lukija.hasNextLine()) {
            rivi = lukija.nextLine();
            rivienLkm += 1;
         }
         sarakeLkm = rivi.length();
         lukija.close();
         rivitJaSarakkeet = new int[] { rivienLkm, sarakeLkm };
         return rivitJaSarakkeet;
      }
      catch (Exception e) {
         return null;
      }
   }
   
   /*
    * Operaatio luo kaksiulotteisen char-tyyppisen taulukon, jonka koon se
    * päättelee parametrinaan vastaanottamansa int-tyyppisen taulukon alkioiden
    * perusteella. Tämän jälkeen operaatio lukee parametrinaan vastaanottamansa
    * nimisestä tiedostosta rivit ja tallentaa kunkin rivin merkit yksitellen
    * opertaatiossa luotavaan taulukkoon ja palauttaa viitteen luotuun taulukkoon.
    */
   public static char[][] loadToArray(String tiedosto, int[] taulukonKoko) {
      if (taulukonKoko != null) {
         char[][] rivienSisalto = new char[taulukonKoko[0]][taulukonKoko[1]];
         try {
            File tiedostonNimi = new File(tiedosto);
            Scanner lukija = new Scanner(tiedostonNimi);
            while (lukija.hasNextLine()) {
               for (int i = 0; i < rivienSisalto.length; i++) {
                  String rivi = lukija.nextLine();
                  for (int j = 0; j < rivienSisalto[i].length; j++) {
                     rivienSisalto[i][j] = rivi.charAt(j);
                  }
               }
            }
            lukija.close();
            return rivienSisalto;
         }
         catch (Exception e) {
            return null;
         }
      }
      else {
         return null;
      }
   }
   
   /*
    * Operaatio tulostaa parametrinaan vastaanottamansa kaksiulotteisen
    * taulukon alkiot näytölle, mikäli taulukolle on varattu muistia.
    */
   public static void print2DCharacterArray(char[][] alkiot) {
      if (alkiot != null) {
         for (int i = 0; i < alkiot.length; i++) {
            for (int j = 0; j < alkiot[i].length; j++) {
               System.out.print(alkiot[i][j]);
            }
            System.out.println();
         }
      }
   }
   
   public static void main(String[] args) {
      System.out.println("Hello! I load files.");
      System.out.println("Please, enter file name:");
      String tiedosto = In.readString();
      int[] taulukonKoko = countSize(tiedosto);
      char[][] rivit = loadToArray(tiedosto, taulukonKoko);
      if (rivit != null) {
         print2DCharacterArray(rivit);
      }
      else {
         System.out.println("I could not load.");
      }
   }
}
