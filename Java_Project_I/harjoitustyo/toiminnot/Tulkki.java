package harjoitustyo.toiminnot;

import harjoitustyo.tiedot.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Komentotulkin toiminnot toteuttava luokka.
 *
 * @author Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public class Tulkki {
   
   /** Komentotulkin juurihakemiston sisältävä tieto. */
   private final Hakemisto juuri;
   
   /** Komentotulkin nykyhakemiston, eli työhakemiston sisältävä tieto. */
   private Hakemisto nykyhakemisto;
   
   /** Komentokehotteen hakemistopolun tieto muuttuvana oliona. */
   private StringBuilder polku;
   
   /**
    * Oletusrakentajassa luodaan pelkästään juurihakemiston sisältävä
    * hakemistopuu.
    * <p>
    * Juurihakemisto alustetaan Hakemisto-olion oletusrakentajalla ja
    * sen viite liitetään nykyhakemistolle. Hakemistopoluksi annetaan
    * nykyhakemiston nimi (juurihakemiston nimi) eli tyhjä merkkijono.
    */
   public Tulkki() {
      juuri = new Hakemisto();
      nykyhakemisto = juuri;
      polku = new StringBuilder("");
   }
   
   /**
    * Palauttaa hakemistopolun tiedon.
    * 
    * @return hakemistopolku juurihakemistosta nykyiseen hakemistoon.
    */
   public StringBuilder polku() {
      return polku;
   }
   
   /**
    * Tekee muutokset hakemistopolun nimeen kun hakemistopuussa siirrytään
    * yli-, ali- tai juurihakemistoon.
    * 
    * @param kohde kokonaisluku jonka perusteella tiedetään mihin suuntaan
    * hakemistorakenteessa on siirrytty ja päivitetään polku sen mukaisesti.
    * 0 = siirrytään juurihakemistoon, 
    * 1 = siirrytään ylihakemistoon,
    * 2 = siirrytään alihakemistoon.
    */
   private void paivitaPolku(int kohde) {
      // Hakemistopolun muuttaminen sen mukaan, minne suuntaan on siirrytty.
      switch (kohde) {
         // Paluu juurihakemistoon, eli hakemistopolku palautuu alkupisteeseen.
         case 0:
            polku = new StringBuilder("");
            break;
         
         // Siirrytään ylihakemistoon, eli poistetaan edellisen alihakemiston
         // nimi ja välissä oleva /-merkki hakemistopolusta.
         case 1:
            int alku = polku.lastIndexOf(Hakemisto.EROTIN);
            polku.replace(alku, polku.length(), "");
            break;
            
         // Siirrytään alihakemistoon, eli lisätään hakemistopolkuun /-merkki
         // ja alihakemiston (nykyhakemisto) nimi.
         case 2:
            polku.append(Hakemisto.EROTIN).append(nykyhakemisto.nimi());
            break;
         
         // Ei tehdä muutoksia polkuun.
         default:
            break;
      }
   }
   
   /**
    * Luo uuden hakemiston ja lisää sen nykyhakemiston alihakemistoksi.
    * Hakemiston luominen epäonnistuu jos hakemistossa on jo parametrina
    * saadun niminen tiedosto tai hakemisto tai jos nimi on virheellinen.
    * 
    * @param luotava luotavalle hakemistolle annettava nimi merkkijonona.
    * @return true, jos hakemiston luominen onnistuu, muuten false.
    */
   public boolean luoHakemisto(String luotava) {
      // Nykyhakemistossa ei saa olla samannimistä tiedostoa tai hakemistoa kuin
      // mitä ollaan luomassa.
      if (nykyhakemisto.hae(luotava).isEmpty()) {
         try {
            // Luodaan alihakemisto ja liitetään nykyhakemisto sen ylihakemistoksi.
            Hakemisto uusi = new Hakemisto(new StringBuilder(luotava), nykyhakemisto);
            // Liitetään nykyhakemisto luotuun alihakemistoon.
            nykyhakemisto.lisaa(uusi);
            return true;
         }
         // Alihakemistolle annettu nimi oli virheellinen.
         catch (IllegalArgumentException e) {
            return false;
         }
      }
      // Hakemistossa on saman niminen tiedosto tai hakemisto, kuin mitä
      // yritetään luoda.
      else {
         return false;
      }
   }
   
   /**
    * Luo uuden tiedoston nykyhakemistoon. Tiedoston luominen epäonnistuu, jos
    * hakemistossa on jo samanniminen tiedosto tai alihakemisto. Tiedostoa ei
    * voida luoda myöskään mikäli kumpikaan parametreista on virheellinen.
    * 
    * @param nimi luotavalle tiedostolle asetettava nimi merkkijonona.
    * @param koko tiedostolle asetettava koko merkkijonona.
    * @return true, jos tiedoston luonti hakemistoon onnistui, false jos
    * tiedoston luonti epäonnistui.
    */
   public boolean luoTiedosto(String nimi, String koko) {
      // Nykyhakemistossa ei saa olla samannimistä tiedostoa tai hakemistoa kuin
      // mitä ollaan luomassa.
      if (nykyhakemisto.hae(nimi).isEmpty()) {
         try {
            // Yritetään muuttaa merkkijono "koko" kokonaisluvuksi.
            int k = Integer.parseInt(koko);
            // Luodaan tiedosto.
            Tiedosto uusi = new Tiedosto(new StringBuilder(nimi), k);
            // Liitetään tiedosto nykyhakemistoon.
            nykyhakemisto.lisaa(uusi);
            return true;
         }
         // Tapahtui virhe joko tiedoston koon muuttamisessa Integeriksi tai
         // sitten tiedostolle annettu nimi oli virheellinen.
         catch (IllegalArgumentException e) {
            return false;
         }
      }
      // Hakemistossa on saman niminen tiedosto tai hakemisto, kuin mitä
      // yritetään luoda.
      else {
         return false;
      }
   }
   
   /**
    * Vaihtaa nykyhakemiston sijaintia hakemistopuussa.
    * Hakemistoa voidaan vaihtaa vain nykyhakemiston välittömään yli- tai
    * alihakemistoon, eli kerrallaan vain yksi taso ylös tai alas. Tähän on
    * poikkeuksena suoraan juurihakemistoon siirtyminen, joka onnistuu mistä
    * tahansa hakemistosta.
    * <p>
    * Hakemiston vaihtamisen suunta nähdään cd-komennon parametrista.
    * Parametri on virheellinen jos alihakemistoa ei löydetä, parametriksi on
    * annettu tiedoston nimi tai kahden tai useamman hakemiston polku. Virhe
    * tapahtuu myös jos juurihakemistossa yritetään siirtyä ylihakemistoon.
    * <p>
    * Hakemiston vaihdon onnistuessa komentokehotteen polku päivitetään ennen
    * metodista poistumista.
    * 
    * @param parametri käyttäjän antama komento, joka jaetaan osiin jotta
    * saadaan tietoon mihin suuntaan hakemistopuussa yritetään siirtyä.
    * @return true, mikäli hakemiston vaihto onnistuu, false jos parametri
    * on virheellinen ja hakemiston vaihtaminen epäonnistuu.
    */
   public boolean vaihdaHakemistoa(String parametri) {
      // Parametri jaetaan osiin, jotta tiedetään miten komennon halutaan
      // käyttäytyvän. Tiedetään, että osat[0] == "cd".
      String[] osat = parametri.split("[ ]");
      
      // Siirrytään juurihakemistoon (komento: "cd")
      if (osat.length == 1) {
         nykyhakemisto = juuri;
         paivitaPolku(0);
         return true;
      }
      // Siirrytään ylihakemistoon (komento: "cd ..")
      // Ylihakemisto ei saa olla null, eli komennon antaminen juurihakemistossa
      // aiheuttaa virheen.
      else if (osat[1].equals("..") && nykyhakemisto.ylihakemisto() != null) {
         nykyhakemisto = nykyhakemisto.ylihakemisto();
         paivitaPolku(1);
         return true;
      }
      // Siirrytään alihakemistoon (komento: "cd alihakemiston_nimi")
      // Tarkistetaan että parametrissa ei ole jokerimerkkiä ja että
      // nykyhakemistosta löytyy parametrina annetun niminen alihakemisto.
      else if (!osat[1].contains("*") && !nykyhakemisto.hae(osat[1]).isEmpty()
               && nykyhakemisto.hae(osat[1]).get(0) instanceof Hakemisto) {
         nykyhakemisto = (Hakemisto) nykyhakemisto.hae(osat[1]).get(0);
         paivitaPolku(2);
         return true;
      }
      else {
         return false;
      }
   }
   
   /**
    * Nykyhakemiston tietojen listaaminen. Listattavaksi voidaan määrittää
    * yksittäinen tiedosto tai hakemisto tai myös useampia tietoja yksi tai
    * kaksi jokerimerkkiä (*) sisältävän ilmauksen avulla.
    * <p>
    * Kun komennolla ei ole parametreja tai parametri on pelkkä jokerimerkki,
    * niin listataan kaikki nykyhakemiston tiedot. Listaus ei tulosta
    * alihakemiston sisältöä eikä sitä voida kohdistaa ylihakemistoon.
    * <p>
    * Metodi tuottaa listattavista tiedoista StringBuilder-tyyppisen muuttuvan
    * merkkijono-olion jossa tiedot ovat erotettuna toisistaan rivinvaihdoilla.
    * 
    * @param komento käyttäjän antama komento muodossa "ls parametri"
    * @return viite StringBuilder-tyyppiseen olioon joka sisältää listattavien
    * tietojen merkkijonoesityksen.
    */
   public StringBuilder listaa(String komento) {
      // Parametri jaetaan osiin, jotta tiedetään miten komennon halutaan
      // käyttäytyvän. Tiedetään, että osat[0] == "ls".
      String[] osat = komento.split("[ ]");
      
      // Komennossa on virheellinen määrä parametreja.
      if (osat.length > 2) {
         return null;
      }
      
      // Alustetaan merkkijonomuuttuja johon listauksen tulos säilötään.
      StringBuilder tulos = new StringBuilder("");
      
      // Listataan nykyhakemiston koko sisältö, kun komennolla ei ole
      // parametreja tai parametrina (osat[1]) on pelkkä jokerimerkki (*).
      if (osat.length == 1 || osat[1].equals("*")) {
         // Etsitään kaikki tiedostot ja alihakemistot nykyhakemistosta.
         LinkedList<Tieto> listaus = nykyhakemisto.hae("*");
         
         // Lisätään muuttuvaan merkkijonoon tiedot erotettuna rivinvaihdolla.
         for (Tieto t : listaus) {
            tulos.append(t.toString()).append("\n");
         }
         
         return tulos;
      }
      
      // Listataan nykyhakemistosta ne tiedostot ja hakemistot, jotka vastaavat
      // parametrina (osat[1]) annettua ilmausta.
      else {
         // Etsitään, löytyykö komennon parametria (osat[1]) vastaavaa tietoa tai
         // useampia tietoja, jos ilmauksessa on käytetty myös jokerimerkkejä (*).
         LinkedList<Tieto> listaus = nykyhakemisto.hae(osat[1]);
         
         // Parametria vastaavia tietoja ei löytynyt yhtään kappaletta.
         if (listaus.isEmpty()) {
            return null;
         }
         // Lisätään muuttuvaan merkkijonoon tiedot erotettuna rivinvaihdolla.
         else {
            for (Tieto t : listaus) {
               tulos.append(t.toString()).append("\n");
            }
            
            return tulos;
         }
      }
   }
   
   /**
    * Nykyhakemiston sisältämän tiedoston tai hakemiston uudelleen nimeäminen.
    * Yli- tai alihakemistossa olevan tiedon nimeä ei voida vaihtaa.
    * <p>
    * Nimen vaihto epäonnistuu, jos ensimmäisellä parametrilla määritellyn
    * nimistä tiedostoa tai alihakemistoa ei ole olemassa tai jos toisena
    * parametrina annettua nimeä vastaava tieto on jo olemassa tai parametrina
    * annettu uusi nimi on virheellinen.
    * 
    * @param vanhaNimi korvattavan tiedon nimeä vastaava merkkijono
    * @param uusiNimi nimi, jolla tiedon vanha nimi korvataan
    * @return true, jos tiedon nimen muuttaminen onnistui, muuten false.
    */
   public boolean nimeaUudelleen(String vanhaNimi, String uusiNimi) {
      // Etsitään löytyykö nykyhakemistosta tietoa, joka vastaa ensimmäistä
      // parametria. Tarkistetaan myös, että nykyhakemistosta ei saa löytyä
      // tietoa, joka vastaa toista parametria.
      if (!vanhaNimi.contains("*") && !nykyhakemisto.hae(vanhaNimi).isEmpty() &&
          nykyhakemisto.hae(uusiNimi).isEmpty()) {
         try {
            // Tieto jota yritetään nimetä uudelleen, on tyypiltään hakemisto.
            if (nykyhakemisto.hae(vanhaNimi).get(0) instanceof Hakemisto) {
               Hakemisto vanha = (Hakemisto) nykyhakemisto.hae(vanhaNimi).get(0);   
               // Yritetään luoda hakemisto uudella nimellä.
               Hakemisto korvaava = new Hakemisto(new StringBuilder(uusiNimi), vanha.ylihakemisto());
               nykyhakemisto.lisaa(korvaava);
               nykyhakemisto.poista(vanha);
            }
            // Tieto jota yritetään nimetä uudelleen, on tyypiltään tiedosto.
            else {
               Tiedosto vanha = (Tiedosto) nykyhakemisto.hae(vanhaNimi).get(0);
               // Yritetään luoda tiedosto uudella nimellä.
               Tiedosto korvaava = new Tiedosto(new StringBuilder(uusiNimi), vanha.koko());
               nykyhakemisto.lisaa(korvaava);
               nykyhakemisto.poista(vanha);
            }
            return true;
         }
         // Tänne päädytään, jos korvaavan tiedon luominen uudella nimellä
         // epäonnistuu koska parametrina annettu uusi nimi on virheellinen.
         catch (IllegalArgumentException e) {
            return false;
         }
      }
      else {
         return false;
      }
   }
   
   /**
    * Yksittäisen tai useampien tietojen poistaminen hakemistosta.
    * Poistettavaksi voidaan määritellä yksittäinen tiedosto tai hakemisto
    * jonka nimi vastaa parametria tai parametrina voidaan saada jokerimerkkejä
    * sisältävä ilmaus, jolloin kaikki ilmausta vastaavat tiedot poistetaan
    * nykyhakemistosta. Mikäli ilmaus koostuu pelkästä jokerimerkistä (*),
    * poistetaan kaikki nykyhakemiston tiedostot ja alihakemistot.
    * <p>
    * Poisto epäonnistuu, jos parametrina annetulla nimellä tai ilmauksella ei
    * löydetä poistettavaa tai jos hakemisto on tyhjä.
    * 
    * @param parametri nimi tai ilmaus, jolla haetaan poistettavaksi halutut
    * tiedot nykyhakemistosta.
    * @return true, jos tietojen poistaminen onnistuu, muuten false.
    */
   public boolean poistaTietoja(String parametri) {
      // Haetaan parametrina saatua ilmausta vastaavat tiedot nykyhakemistosta.
      LinkedList<Tieto> poistettavat = nykyhakemisto.hae(parametri);
      // Parametrina annetulla nimellä tai ilmauksella ei löytynyt mitään.
      if (poistettavat.isEmpty()) {
         return false;
      }
      // Poistetaan haulla löydetyt tiedot (viitteet) nykyhakemistosta.
      else {
         for (Tieto t : poistettavat) {
            nykyhakemisto.poista(t);
         }
         return true;
      }
   }
   
   /**
    * Apuoperaatio tiedostojen kopioimiseksi ali- tai ylihakemistoon.
    * Tarkistetaan ensin että kohdehakemistossa ei ole yhtään saman nimistä
    * tiedostoa, joita on kopioitavat-viitteen sisältävällä listalla ja sitten
    * kopioidaan listan sisältämät tiedostot kohdehakemistoon. Listalla ei saa
    * myöskään olla Hakemisto-tyyppisiä viitteitä tai kopiointia ei suoriteta.
    * 
    * @param kopioitavat lista joka sisältää kopioitavien tietojen viitteet
    * @param kohde viite ali- tai ylihakemistoon, jonne tiedostoja ollaan kopioimassa
    * 
    * @return true jos kopiointi onnistuu, false jos parametri kohde on null
    * tai kopiointi epäonnistuu.
    */
   private boolean teeKopio(LinkedList<Tieto> kopioitavat, Hakemisto kohde) {
      // Kohde ei voi olla null.
      if (kohde == null) {
         return false;
      }
      // Käydään kopioitavaksi tahdotut tiedot läpi ja mikäli kohdehakemistosta
      // löytyy jo saman niminen tieto, ei kopiointia voida tehdä. Myöskin,
      // mikäli joku listalta löytyvistä tiedoista on Hakemisto-tyyppinen, ei
      // kopiointia voida suorittaa.
      for (Tieto t : kopioitavat) {
         if (!kohde.hae(t.nimi().toString()).isEmpty() || t instanceof Hakemisto) {
            return false;
         }
      }
      // Kopioidaan listalla olevat tiedostot yksitellen kohdehakemistoon.
      for (Tieto t : kopioitavat) {
         Tiedosto kopio = ((Tiedosto) t).kopioi();
         kohde.lisaa(kopio);
      }
      return true;
   }
   
   /**
    * Nykyhakemiston tiedostojen kopiointi. Yksittäinen tiedosto voidaan
    * kopioida nykyhakemistoon uudella nimellä tai sen välittömään yli- tai
    * alihakemistoon samalla nimellä. Yhden tai kahden jokerimerkin
    * avulla muodostettua ilmausta hyödyntäen voidaan myös kopioida useita
    * tiedostoja samanaikaisesti yli- tai alihakemistoon.
    * <p>
    * Tiedoston kopiointi nykyhakemistoon uudella nimellä onnistuu, jos
    * kopiolle asetettava nimi on oikeellinen eikä hakemistossa ole vielä saman
    * nimistä tiedostoa.
    * <p>
    * Tiedoston tai tiedostojen kopiointi yli- tai alihakemistoon onnistuu, jos
    * parametrina saadun niminen hakemisto on olemassa ja hakemistossa
    * ei ole vielä tiedostoa minkään kopioitavan tiedoston nimellä.
    * <p>
    * Jos kopiointi epäonnistuu, niin kunkin hakemiston sisältö jää entiselleen.
    * 
    * @param kopioitavat nimi tai ilmaus, jolla etsitään poistettavia tietoja
    * @param kohde tiedoston kopiolle annettava nimi, tai kohteena olevan
    * yli- tai alihakemiston nimi.
    * @return true, jos tiedostojen kopiointi onnistuu, muuten false.
    */
   public boolean kopioi(String kopioitavat, String kohde) {
      LinkedList<Tieto> kopioidaan = nykyhakemisto.hae(kopioitavat);
      // Löytyykö nykyhakemistosta parametrina annettua nimeä tai ilmausta
      // vastaavia tiedostoja kopioitavaksi
      if (kopioidaan.isEmpty()) {
         return false;
      }
      else {
         // Mikäli parametri kohde niminen tieto löytyy hakemistosta, tarkistetaan
         // että kyseessä on alihakemisto eikä tiedosto
         if (!kohde.contains("*") && !nykyhakemisto.hae(kohde).isEmpty()) {
            if (nykyhakemisto.hae(kohde).get(0) instanceof Hakemisto) {
               Hakemisto alihakemisto = (Hakemisto) nykyhakemisto.hae(kohde).get(0);
               // Kopiointia yritetään apuoperaatiossa ja paluuarvona on true
               // tai false sen mukaan, onnistuuko kopiointi.
               return teeKopio(kopioidaan, alihakemisto);
            }
            // Kopion nimeä vastaava tiedosto on jo olemassa = ei voida kopioida.
            else {
               return false;
            }
         }
         // Hakemistosta ei löytynyt parametria kohde vastaavia tietoja.
         else {
            // Parametri kohde viittaa nykyhakemiston ylihakemistoon
            if (kohde.equals("..")) {
               Hakemisto ylihakemisto = nykyhakemisto.ylihakemisto();
               // Kopiointia yritetään apuoperaatiossa ja paluuarvona on true
               // tai false sen mukaan, onnistuuko kopiointi.
               return teeKopio(kopioidaan, ylihakemisto);
            }
            // Kopioidaan kopioitava tiedosto nykyhakemistoon uudella nimellä,
            // mikäli parametri kopioitavat ei sisällä jokerimerkkejä.
            else {
               if (!kopioitavat.contains("*")) {
                  try {
                     Tiedosto kopio = ((Tiedosto) kopioidaan.get(0)).kopioi();
                     kopio.nimi(new StringBuilder(kohde));
                     nykyhakemisto.lisaa(kopio);
                     return true;
                  }
                  // Kopioitavan tiedon muuntaminen tiedostoksi epäonnistuu, eli
                  // yritetään kopioida hakemistoa ja tämä ei ole mahdollista.
                  // Tänne joudutaan myös mikäli asetettava nimi on virheellinen.
                  catch (Exception e) {
                     return false;
                  }
               }
               // Kopioitavan tiedoston nimi (parametri) oli virheellinen.
               else {
                  return false;
               }
            }
         }
      }
   }
   
   /**
    * Hakemistopuun rekursiivinen listaus. Metodissa luodaan nykyhakemistolle
    * iteraattori ja kuljetaan hakemiston ja sen alihakemistojen ja edelleen
    * näiden alihakemistojen läpi iteraattorilla ja tallennetaan iteraattorin
    * palauttamat viitteet listalle. Viitteiden listasta muodostetaan lopulta
    * merkkijonoesitys, joka voidaan tulostaa näytölle.
    * 
    * @return rekursiivisen listauksen tuottama merkkijono, jossa tiedot on
    * erotettuna toisistaan rivinvaihdoilla.
    */
   public String haku() {
      // Alustetaan iteraattori nykyhakemistolle.
      Iterator<Tieto> iteraattori = nykyhakemisto.iterator();
      // Alustetaan lista, johon talletetaan iteraattorin palauttamat viitteet.
      ArrayList<Tieto> viitteet = new ArrayList<>();
      int ind = 0;
      // Haetaan kaikki viitteet listalle.
      while (iteraattori.hasNext()) {
         viitteet.add(iteraattori.next());
      }
      // Muodostetaan viitteiden listasta merkkijono
      String mjonoTaulukko = Arrays.toString(viitteet.toArray())
                              // Poistetaan merkkijonosta taulukon sulkeet.
                             .replaceAll("[\\[\\]]", "");
      
      // Erotetaan merkkijonon pilkulla toisistaan erotellut tiedot listan alkioiksi.
      String[] list = mjonoTaulukko.split(", ");
      // Yhdistetään listan tiedot takaisin merkkijonoksi,
      // eroteltuna toisistaan rivinvaihdolla.
      mjonoTaulukko = String.join("\n", list);
      return mjonoTaulukko;
   }
   
}
