package harjoitustyo.tiedot;

import harjoitustyo.apulaiset.Syvakopioituva;
import java.io.*;

/**
 * Tiedostoa mallintava konkreettinen luokka.
 * 
 * @author Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public class Tiedosto extends Tieto implements Syvakopioituva<Tiedosto>, Serializable {
   
   /** Tiedoston kokoa mallintava attribuutti. */
   private int koko;
   
   /**
    * Oletusrakentajassa asetetaan tiedoston nimeksi tyhjä merkkijono ja kooksi 0.
    */
   public Tiedosto() {
      super();
      koko = 0;
   }
   
   /**
    * Parametrillinen rakentaja, jossa tiedostolle annetaan ulkoisen tahon
    * määrittelemä nimi ja koko.
    * 
    * @param n StringBuilder-tyyppinen olio tiedoston nimelle.
    * @param k int-tyyppinen muuttuja tiedoston koolle.
    * @throws IllegalArgumentException heitetään, mikäli jompi kumpi
    * (tai molemmat) parametrit ovat virheellisiä. Nimen virhetarkistus ja
    * asettaminen tehdään yliluokan rakentajassa. Koon tarkistus tehdään koon
    * asettavassa aksessorissa.
    */
   public Tiedosto(StringBuilder n, int k) throws IllegalArgumentException {
      super(n);
      koko(k);
   }
   
   /**
    * Palauttaa tiedoston koon.
    * 
    * @return tiedoston koko.
    */
   public int koko() {
      return koko;
   }
   
   /**
    * Asetetaan tiedostolle uusi koko, mikäli se on suurempi tai yhtä suuri
    * kuin nolla.
    * 
    * @param k tiedostolle asetettava koko.
    * @throws IllegalArgumentException heitetään, mikäli parametri on
    * virheellinen, eli pienempi kuin nolla.
    */
   public void koko(int k) throws IllegalArgumentException {
      if (k < 0) {
         throw new IllegalArgumentException();
      }
      koko = k;
   }
   
   /**
    * Object-luokan toString-metodin korvaus.
    * <p>
    * Yläluokan metodia kutsumalla saadaan tiedoston nimi ja tähän perään
    * lisätään välilyönnillä erotettuna tiedoston koko. Metodi palauttaa
    * yhdistetyn merkkijonoesityksen näistä kahdesta.
    */
   @Override
   public String toString() {
      return super.toString() + " " + koko;
   }
   
   /**
    * Syväkopioi tiedoston ja palauttaa viitteen siitä muodostettuun kopioon.
    *
    * @return viite syväkopioituun tiedostoon. Paluuarvo on null, jos tiedoston
    * kopioiminen epäonnistuu.
    */
   @Override
   public Tiedosto kopioi() {
      try {
         // Byte-tyyppisten alkioiden taulukkoon kirjoittava virta
         ByteArrayOutputStream bos = new ByteArrayOutputStream();
         
         // Olion tavuiksi muuntava virta, liittyy taulukkoon kirjoittavaan virtaan
         ObjectOutputStream oos = new ObjectOutputStream(bos);
         
         // Kirjoitetaan olio tavumuodossa taulukkoon
         oos.writeObject(this);
         
         // Tyhjennetään puskuri ja suljetaan virta
         oos.flush();
         oos.close();
         
         // Liitetään taulukkoon tavuja lukeva syötevirta
         ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
         
         // Tavut olioiksi muuttava virta, liittyy taulukosta lukevaan virtaan
         ObjectInputStream ois = new ObjectInputStream(bis);
         
         // Kopio muodostetaan lukemalla olion tavut taulukosta
         Object kopio = ois.readObject();
         
         // Palautetaan Tiedosto-tyyppinen viite
         return (Tiedosto)kopio;
      }
      catch (Exception e) {
         return null;
      }
   }
   
}
