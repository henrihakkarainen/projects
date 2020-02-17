package harjoitustyo.tiedot;

import harjoitustyo.apulaiset.Tietoinen;
import java.io.Serializable;

/**
 * Tietoa mallintava abstrakti luokka.
 * 
 * @author Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public abstract class Tieto implements Tietoinen, Comparable<Tieto>, Serializable {

   /** Tiedon nimi muuttuvana oliona. */
   private StringBuilder nimi;

   /**
    * Oletusrakentajassa liitetään tiedon nimeen StringBuilder-tyyppinen olio,
    * joka sisältää tyhjän merkkijonon.
    */
   public Tieto() {
      nimi = new StringBuilder("");
   }
   
   /**
    * Parametrillinen rakentaja, jossa annetaan tiedolle ulkoisen tahon
    * määrittelemä nimi kutsumalla nimen asettavaa konstruktoria.
    * <p>
    * @param n StringBuilder-tyyppinen olio tiedon nimelle.
    * @throws IllegalArgumentException heitetään jos parametri on virheellinen.
    * Parametrin tarkastus tapahtuu nimen asettavassa aksessorissa.
    */
   public Tieto(StringBuilder n) throws IllegalArgumentException {
      nimi(n);
   }
   
   /**
    * Palauttaa tiedon nimen.
    * 
    * @return tiedon nimi.
    */
   
   public StringBuilder nimi() {
      return nimi;
   }
   
   /**
    * Asettaa tiedolle uuden nimen.
    * <p>
    * Nimessä saa olla merkkejä väleiltä a-z, A-Z, 0-9 sekä alaviivamerkkejä
    * (_) ja pisteitä (.), mutta nimi ei saa koostua pelkästään pisteistä tai
    * olla tyhjä merkkijono. Nimeksi ei voida myöskään asettaa null-arvoista
    * parametria. Mikäli parametrina saatava nimi (n) ei täytä vaatimuksia,
    * heitetään IllegalArgumentException - poikkeus.
    * 
    * @param n mahdollinen tiedon uusi nimi.
    * @throws IllegalArgumentException heitetään, jos nimi on virheellinen.
    */
   public void nimi(StringBuilder n) throws IllegalArgumentException {
      if (n != null && n.toString().matches("^[\\w\\.]+$") &&
         !n.toString().matches("^[\\.]*$")) {
         nimi = n;
      }
      else {
         throw new IllegalArgumentException();
      }
   }

   /**
    * Object-luokan toString-metodin korvaus.
    * 
    * @return tiedon nimi String-muodossa.
    */ 
   @Override
   public String toString() {
      return nimi.toString();
   }
   
   /**
    * Object-luokan equals-metodin korvaus.
    * <p>
    * Metodissa tutkitaan vastaavatko olioiden nimet toisiaan.
    * 
    * @param obj vertailtava olio Object-tyyppisenä.
    * @return true, jos vertailtavien olioiden tiedot ovat samat, false jos
    * olioilla eri tiedot tai olion muunnos Tieto-tyyppiseksi ei onnistu.
    */
   @Override
   public boolean equals(Object obj) {
      try {
         Tieto toinen = (Tieto)obj;
         return nimi.toString().equals(toinen.nimi().toString());
      }
      catch (Exception e) {
         return false;
      }
   }
   
   /**
    * Tutkii vastaako tiedon nimi parametrina annettua nimeä tai ilmausta.
    * <p>
    * Ilmaus on muodostettu käyttämällä yhtä tai kahta jokerimerkkiä. Jokerimerkki
    * voi olla ilmauksen alussa tai lopussa tai sekä alussa että lopussa. Ilmauksen
    * alussa oleva jokerimerkki kohdistaa vertailun nimen loppuun. Lopussa oleva
    * jokerimerkki toimii päinvastoin. Ilmauksen alussa ja lopussa olevat
    * jokerimerkit kohdistavat vertailun nimen keskelle. Kaikkein laajin ilmaus
    * on jokerimerkki itsessään, joka vastaa aina tiedon nimeä.
    * 
    * @param hakusana nimi tai ilmaus, johon tiedon nimeä verrataan.
    * @return true, jos tiedon nimi vastaa parametria ja false, jos tiedon nimi
    * ei vastaa parametria, parametrina saatu ilmaus on muodoltaan virheellinen
    * (esimerkiksi kolme tähteä) tai parametri on null-arvoinen.
    */
   @Override
   public boolean equals(String hakusana) {
      // Apumerkkijono, josta poistetaan jokerimerkit ennen vertailua
      String etsittava = "";
      // Null-arvoinen parametri ei kelpaa
      if (hakusana == null) {
         return false;
      }
      // Pelkkä jokerimerkki vastaa aina tiedon nimeä
      else if (hakusana.equals("*")) {
         return true;
      }
      // Hakusana alkaa jokerimerkillä
      else if (hakusana.matches("^\\*{1}[\\w\\.]+\\*?")) {
         // Myös hakusanan lopussa jokerimerkki
         if (hakusana.charAt(hakusana.length() - 1) == '*') {
            etsittava = hakusana.substring(1, hakusana.length() - 1);
            return nimi.toString().matches("^.*" + etsittava + ".*");
         }
         else {
            etsittava = hakusana.substring(1);
            return nimi.toString().matches("^.*" + etsittava);
         }
      }
      // Vain hakusanan lopussa on jokerimerkki
      else if (hakusana.matches("^[\\w\\.]+\\*{1}")) {
         etsittava = hakusana.substring(0, hakusana.length() - 1);
         // Etsittävä osuus sisältää vain pisteitä (vastaa RegExp mitä tahansa merkkiä).
         if (etsittava.matches("\\.{1,}")) {
            int pisteidenLkm = etsittava.length();
            return nimi.toString().matches("^\\.{" + pisteidenLkm + "}.*");
         }
         else {
            return nimi.toString().matches(etsittava + ".*");
         }
      }
      // Hakusanassa ei ole jokerimerkkejä, eli katsotaan vastaako nimeä suoraan
      else if (nimi.toString().equals(hakusana)) {
         return true;
      }
      // Parametrina saatu ilmaus on virheellinen tai ei vastaa tiedon nimeä
      else {
         return false;
      }
   }
   
   /**
    * Comparable-rajapinnan compareTo-metodin toteutus.
    * <p>
    * Metodissa vertaillaan tietojen nimiä kutsumalla String-luokan
    * compareTo-metodia, jonka paluuarvolle tehdään pieniä muutoksia.
    * 
    * @param verrattava toinen tieto-tyyppinen olio, johon tietoa vertaillaan.
    * @return palauttaa luvun 1, jos tiedon nimi on vertailtavan tiedon
    * nimeä suurempi, luvun 0 jos tietojen nimet ovat yhtä suuret tai luvun -1,
    * mikäli tiedon nimi on vertailtavan tiedon nimeä pienempi.
    */
   @Override
   public int compareTo(Tieto verrattava) {
      int tulos = nimi.toString().compareTo(verrattava.nimi().toString());
      if (tulos > 0) {
         return 1;
      }
      else if (tulos < 0) {
         return -1;
      }
      else {
         return 0;
      }
   }
   
}
