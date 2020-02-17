package harjoitustyo.omalista;

// Otetaan käyttöön LinkedList java.util-pakkauksesta ja Ooperoiva-rajapinta
// apulaiset pakkauksesta.
import java.util.LinkedList;
import harjoitustyo.apulaiset.Ooperoiva;

/**
 * LinkedList-luokasta peritty OmaLista-luokka, jota käytetään harjoitustyössä
 * hakemiston sisällön säilömiseen. Luokka toteuttaa Ooperoiva-rajapinnan.
 * 
 * @author Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public class OmaLista<E> extends LinkedList<E> implements Ooperoiva<E> {
   
   /**
    * Lisää uuden alkion listalle siten, että alkio sijoittuu kaikkien itseään
    * pienempien tai yhtä suurien alkioiden jälkeen ja ennen kaikkia itseään
    * suurempia alkioita. Alkioiden suuruusjärjestys selvitetään
    * Comparable-rajapinnan compareTo-metodilla.
    * 
    * @param uusi viite olioon, jonka luokan tai luokan esivanhemman oletetaan
    * toteuttaneen Comparable-rajapinnan.
    * @return true, jos lisäys onnistui. False, jos lisäys epäonnistui, koska
    * uutta alkiota ei voitu vertailla. Vertailu epäonnistuu, kun parametri on
    * null-arvoinen tai siihen liittyvällä oliolla ei ole vastoin oletuksia
    * Comparable-rajapinnan toteutusta.
    */
   @SuppressWarnings({"unchecked"})
   @Override
   public boolean lisaa(E uusi) {
      // Jos lista on tyhjä, niin ei tarvitse vertailua, mutta null-arvoista
      // alkiota ei haluta lisätä listalle.
      if (isEmpty()) {
         if (uusi == null) {
            return false;
         }
         else {
            add(uusi);
            return true;
         }
      }
      else {
         try {
            // Yritetään asettaa lisättävälle alkiolle Comparable-apuviite
            Comparable verrattava = (Comparable) uusi;
            // Käydään listan alkiot läpi
            for (int i = 0; i < size(); i++) {
               // Asetetaan alkioon Comparable-apuviite
               Comparable nykyinen = (Comparable) get(i);
               // Lisätään parametrina saatu alkio nykyisen indeksin kohdalle,
               // mikäli siinä tällä hetkellä oleva alkio on sitä suurempi.
               if (nykyinen.compareTo(verrattava) > 0) {
                  add(i, uusi);
                  return true;
               }
            }
            // Lisättävä alkio on kaikkia listan alkioita suurempi, joten se
            // lisätään listalla viimeiseksi.
            add(uusi);
            return true;
         }
         // Lisäys epäonnistuu, jos uutta alkiota ei voitu vertailla.
         catch (Exception e) {
            System.out.println("false");
            return false;
         }
      }
   }
   
   /**
    * Poistaa listalta viitteet, jotka liittyvät tietoalkioon, johon
    * parametrina annettu viite liittyy.
    * 
    * @param poistettava viite tietoalkioon.
    * @return listalta poistettujen viitteiden lukumäärä.
    */
   @Override
   public int poista(E poistettava) {
      int poistettujenLkm = 0;
      for (int i = 0; i < size(); i++) {
         // Jos käsiteltävän tietoalkion viite vastaa parametrina annettua
         // viitettä, niin poistetaan viite listalta.
         if (get(i) == poistettava) {
            remove(i);
            i -= 1;
            poistettujenLkm += 1;
         }
      }
      return poistettujenLkm;
   }
   
}
