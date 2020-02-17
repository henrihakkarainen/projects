package harjoitustyo.iteraattorit;

import harjoitustyo.tiedot.Hakemisto;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Hakemiston iteraattori, joka käy hakemiston läpi ensimmäisestä alkiosta
 * viimeiseen alkioon ja tulostaa kunkin alkion hakemistorakenteen rekursiivisen
 * listauksen näytölle.
 * 
 * @author Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 * @param <E> parametri on sama kuin hakemiston sisalto-attribuutin listan
 * sisältävien alkioiden tyyppi.
 */
public class HakemistoIteraattori<E> implements Iterator<E> {
   
   /** Iteroitavan hakemiston sisältävä viite. */
   private Hakemisto hakemisto;
   
   /** Lista, johon talletetaan viitteet kaikkiin hakemistopuun tietoihin ja
       jonka alkiot iteroidaan. */
   private LinkedList<E> tiedot;
   
   /** Säilöö tiedon iteroitavan hakemiston nykyisen paikan indeksiarvosta. */
   private int nykyinenIndeksi;
   
   /**
    * Rakentaja, joka saa parametrinaan viitteen iteroitavaan hakemistoon.
    * 
    * @param iteroitava viite iteroitavaan hakemistoon.
    * @throws IllegalArgumentException heitetään, jos parametri on null.
    */
   public HakemistoIteraattori(Hakemisto iteroitava)
      throws IllegalArgumentException {
      // Parametri on virheellinen.
      if (iteroitava == null) {
         throw new IllegalArgumentException();
      }
      // Liitetään attribuutti parametrina saatuun hakemisto-olioon.
      hakemisto = iteroitava;
      
      // Alustetaan lista.
      tiedot = new LinkedList<>();
      
      // Aloitetaan ensimmäisestä paikasta.
      nykyinenIndeksi = 0;
      
      // Muodostetaan hakemistorakenteen rekursiivinen listaus.
      esijarjestys(hakemisto);
   }
   
   /**
    * Apuoperaatio, joka kulkee hakemistopuun läpi esijärjestyksessä ja lisää
    * samalla tiedot-attribuutin listalle viitteet puun tietoihin.
    * 
    * @param h viite hakemistoon jonka tietoja tutkitaan.
    */
   private void esijarjestys(Hakemisto h) {
      int ind = 0;
      while (ind < h.sisalto().size()) {
         // Asetetaan apuviite nykyiseen alkioon.
         E alkio = (E) h.sisalto().get(ind);

         tiedot.add(alkio);

         if (alkio instanceof Hakemisto) {
            esijarjestys((Hakemisto) alkio);
         }
         // Siirrytään seuraavaan paikkaan.
         ind ++;
      }
      
   }
   
   /**
    * Tarkastaa, onko listalla vielä käsittelemättömiä alkioita.
    * 
    * @return true, jos listalla on vielä käsittelemätön alkio. False, jos
    * kaikki alkiot on käyty läpi.
    */
   @Override
   public boolean hasNext() {
      // Listalla on vielä käsittelemätön alkio.
      return nykyinenIndeksi < tiedot.size();
   }
   
   /**
    * Palauttaa viitteen seuraavaan Tieto-tyyppiseen alkioon.
    * 
    * @return iteroitavan Tieto-tyyppisen alkion viite.
    * @throws NoSuchElementException heitetään, jos uutta alkiota ei ole saatavilla.
    */
   @Override
   public E next() throws NoSuchElementException {
      // Alkio saatavilla.
      if (hasNext()) {
         // Asetetaan apuviite nykyiseen alkioon.
         E alkio = (E) tiedot.get(nykyinenIndeksi);
         
         // Siirrytään seuraavaan paikkaan.
         nykyinenIndeksi ++;
         
         // Palautetaan viite nykyiseen alkioon.
         return alkio;
      }
      
      else {
         throw new NoSuchElementException();
      }
   }
}
