package harjoitustyo.tiedot;

import harjoitustyo.omalista.OmaLista;
import harjoitustyo.apulaiset.Sailova;
import harjoitustyo.iteraattorit.HakemistoIteraattori;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Hakemistoa mallintava konkreettinen luokka.
 * 
 * @author Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public class Hakemisto extends Tieto implements Sailova<Tieto>, Iterable<Tieto> {
   
   /** Hakemistoerotinta mallintava merkki luokkavakiona. */
   public static final String EROTIN = "/";
   
   /** Hakemiston sisältö OmaLista-tyyppiseen olioon säilöttynä. */
   private OmaLista<Tieto> sisalto;
   
   /** Ylihakemiston sisältävä tieto. */
   private Hakemisto ylihakemisto;
   
   /**
    * Oletusrakentaja, jossa nimeksi asetetaan tyhjä merkkijono,
    * sisalto-attribuuttiin liitetään tyhjä OmaLista-tyyppinen olio ja
    * ylihakemiston viitteelle asetetaan null-arvo.
    */
   public Hakemisto() {
      super();
      sisalto = new OmaLista<Tieto>();
      ylihakemisto = null;
   }
   
   /**
    * Parametrillinen rakentaja, jossa hakemistolle annetaan ulkoisen tahon
    * määrittelemä nimi, hakemisto liitetään suoraan ylihakemistoonsa ja 
    * sisalto-attribuuttiin liitetään tyhjä OmaLista-tyyppinen olio.
    * 
    * @param n StringBuilder-tyyppinen olio hakemiston nimelle.
    * @param yh Hakemisto-tyyppinen olio ylihakemiston viitteeksi.
    * @throws IllegalArgumentException heitetään, jos parametri n on virheellinen.
    * Parametrin tarkistus tapahtuu yliluokassa.
    */
   public Hakemisto(StringBuilder n, Hakemisto yh) throws IllegalArgumentException {
      super(n);
      sisalto = new OmaLista<Tieto>();
      ylihakemisto(yh);
   }
   
   /**
    * Palauttaa viitteen hakemiston sisällön säilövään listaan.
    * 
    * @return sisalto-listan viite.
    */
   public OmaLista<Tieto> sisalto() {
      return sisalto;
   }
   
   /**
    * Asettaa sisalto-attribuutille uuden viitteen.
    * 
    * @param uusi viite OmaLista-tyyppiseen listaan.
    */
   public void sisalto(OmaLista<Tieto> uusi) {
      sisalto = uusi;
   }
   
   /**
    * Palauttaa viitteen ylihakemistoon.
    * 
    * @return ylihakemiston viite.
    */
   public Hakemisto ylihakemisto() {
      return ylihakemisto;
   }
   
   /**
    * Asettaa uuden viitteen ylihakemistoon.
    * 
    * @param yh viite Hakemisto-tyyppiseen olioon.
    */
   public void ylihakemisto(Hakemisto yh) {
      ylihakemisto = yh;
   }
   
   /**
    * Object-luokan toString-metodin korvaus.
    * <p>
    * Yläluokan metodia kutsumalla saadaan hakemiston nimi ja tähän perään
    * lisätään tiedostoerotin, välilyönti ja tieto siitä, montako tiedostoa ja
    * alihakemistoa hakemisto sisältää.
    * 
    * @return merkkijonoesitys hakemiston tiedoista muodossa ("nimi/ koko")
    */
   @Override
   public String toString() {
      return super.toString() + EROTIN + " " + sisalto.size();
   }
   
   /**
    * Hakee hakemistosta tiedostoja ja alihakemistoja, joiden nimi vastaa annettua
    * hakusanaa. Hakusana voi olla tiedon nimi sellaisenaan (esimerkiksi
    * "grumpy_cat.jpeg") tai yhden tai kahden jokerimerkin avulla muodostettu ilmaus
    * (esimerkiksi "*.jpeg").
    * <p>
    * Paluuarvona palautettavalla listalla on yksi viite, jos parametri on hakemistossa
    * olevan tiedon nimi. Jokerimerkkien avulla voidaan löytää useampia tietoja.
    * <p>
    * Hyödyntää Tieto-luokassa toteutettavaa {@link harjoitustyo.apulaiset.Tietoinen#equals(String)}
    * -metodia siten, että palautettavalle listalle lisätään jokainen hakemiston
    * listalla oleva viite x = get(ind), jolle lauseke "x.equals(hakusana)" on totta.
    * Haku alkaa hakemiston ensimmäisestä alkiosta ja päättyy hakemiston viimeiseen
    * alkioon. Viitteet löydettyihin alkioihin ovat palautettavalla listalla samassa
    * järjestyksessä kuin hakemiston listalla.
    * <p>
    * @param hakusana nimi tai ilmaus, johon hakemiston tiedostojen ja alihakemistojen
    * nimiä verrataan.
    * @return lista, jolla on viitteet löydettyihin tietoihin, joiden nimet vastaavat
    * parametria. Lista on tyhjä eli nolla viitettä sisältävä lista, jos hakemistossa
    * ei ole tietoja, joiden nimet vastavat parametria, parametri on null-arvoinen,
    * ilmauksessa on käytetty jokerimerkkejä väärin tai hakemisto on tyhjä.
    */
   @Override
   public LinkedList<Tieto> hae(String hakusana) {
      LinkedList<Tieto> loydetyt = new LinkedList<>();
      for (int i = 0; i < sisalto.size(); i++) {
         if (sisalto.get(i).equals(hakusana)) {
            loydetyt.add(sisalto.get(i));
         }
      }
      return loydetyt;
   }
   
   /**
    * Lisää hakemistoon tiedoston tai alihakemiston. Kutsuu hakemiston listan
    * toteuttamaa Ooperoiva-rajapinnan lisaa-metodia, jolla tieto saadaan lisätyksi
    * oikeaan paikkaan listalla. Lisäys onnistuu, jos parametri liittyy olioon,
    * jonka luokalla on Comparable-rajapinnan compareTo-metodin toteutus. Null-arvon
    * lisäys epäonnistuu aina.
    *
    * @param lisattava viite lisättävään tietoon.
    * @return true, jos lisäys onnistui. False, jos lisäys epäonnistui.
    */
   @Override
   public boolean lisaa(Tieto lisattava) {
      return sisalto.lisaa(lisattava);
   }
   
   /**
    * Poistaa hakemistosta tiedoston tai alihakemiston. Kutsuu hakemiston listan
    * toteuttamaa Ooperoiva-rajapinnan poista-metodia.
    *
    * @param poistettava viite poistettavaan tietoon.
    * @return true, jos alkio poistettiin. False, jos poistettavaa alkiota ei löydetty
    * tai parametri on null.
    */
   @Override
   public boolean poista(Tieto poistettava) {
      int poistettujenLkm = sisalto.poista(poistettava);
      return poistettujenLkm != 0;
   }
   
   /**
    * Luo hakemistolle iteraattorin ja palauttaa viitteen siihen.
    * 
    * @return viite hakemiston iteraattoriin.
    */
   @Override
   public Iterator<Tieto> iterator() {
      return new HakemistoIteraattori(this);
   }
   
}
