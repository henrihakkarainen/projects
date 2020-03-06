import java.util.ArrayList;

/**
 * Omaa hajautustaulua mallintava luokka.
 * 
 * Kapasiteetti, eli montako alkiota hajautustauluun enintään mahtuu kerrallaan alustetaan
 * arvoksi 10 ja tuo koko tuplaantuu aina kun hajautustauluun on lisätty alkioita siten,
 * että taulukon täyttöaste kasvaa yli 0.75:n. Täten hajautustaulu säilöö alkioita melko
 * tehokkaasti tuhlaamatta tilaa ja hajautus leviää keskimäärin melko tasaisesti jolloin
 * alkoiden käsittely on tehokasta.
 */
public class HashTable {

  // Lista, joka säilöö alkioiden solmut hajautustauluun (avaimena toimii alkio itse)
  private ArrayList<HashNode> bucket;
  // Montako lokeroa tällä hetkellä enintään käytössä (kapasiteetti)
  private int capacity;
  // Hajautustaulun koko
  private int size;

  public HashTable() {
    bucket = new ArrayList<>();
    capacity = 10;
    size = 0;

    // Alustetaan lokerot tyhjillä solmuilla
    for (int i = 0; i < capacity; i++) {
      bucket.add(null);
    }
  }

  /**
   * Palauttaa tiedon siitä, onko hajautustaulu tyhjä.
   * 
   * @return palautetaan true, jos hajautustaulu on tyhjä, muuten false.
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Palauttaa hajautustaulun koon.
   * 
   * @return palautetaan hajautustaulun koko.
   */
  public int size() {
    return size;
  }

  /**
   * Palauttaa alkiota vastaavan lokeron paikan eli indeksin taulukosta.
   * 
   * @param val haettavaa alkiota kuvaava avain/arvo.
   * @return palautetaan avainta vastaava indeksin paikka taulukosta.
   * Indeksi haetaan hajautusfunktion avulla.
   */
  public int getIndex(Integer val) {
    int index = val % capacity;
    return index;
  }

  /**
   * Poistetaan alkio taulukosta, avaimenaan alkio itse.
   * 
   * @param val haettavaa alkiota kuvaava avain/arvo.
   * @return jos parametria val vastaava alkio löytyy, poistetaan sen ensimmäinen esiintymä
   * taulukosta ja palautetaan se. Muussa tapauksessa palautetaan null.
   */
  public Integer remove(Integer val) {
    int index = getIndex(val);
    HashNode head = bucket.get(index);
    HashNode prev = null;

    while (head != null && head.getValue().equals(val) == false) {
      prev = head;
      head = head.getNext();
    }

    // Avainta ei löytynyt
    if (head == null) {
      return null;
    }

    // Hajautustaulun koko pienenee yhdellä
    size--;

    if (prev != null) {
      prev.setNext(head.getNext());
    }
    else {
      bucket.set(index, head.getNext());
    }

     return head.getValue();
  }

  /**
   * Poistetaan hajautustaulusta kaikki alkiot, joiden avain eli arvo on annettu parametrina.
   * Palautetaan poistettujen alkioiden luettelo taulukkolistana.
   * 
   * @param val haettavaa alkiota kuvaava avain/arvo.
   * @return jos parametria vastaava alkio (yksi tai useampia) löytyy, poistetaan
   * ne hajautustaulusta ja palautetaan ne taulukkolistana. Jos yhtään esiintymää
   * ei löydy, palautetaan null.
   */
  public ArrayList<Integer> removeAll(Integer val) {
    ArrayList<Integer> values = new ArrayList<>();

    while (findElement(val) != null) {
      values.add(remove(val));
    }

    if (values.size() == 0) {
      return null;
    }

    return values;
  }

  /**
   * Etsii ja palauttaa taulukkolistassa kaikki hajautustaulusta löytyvät avaimet, eli luvut.
   * 
   * @return taulukkolista, joka sisältää kaikki hajautustaulusta löytyvät avaimet siten,
   * että kukin avain esiintyy enintään kerran.
   */
  public ArrayList<Integer> findAllKeys() {
    ArrayList<Integer> keys = new ArrayList<>();
    for (int i = 0; i < capacity; i++) {
      HashNode head = bucket.get(i);
      while (head != null) {
        if (!keys.contains(head.getValue())) {
          keys.add(head.getValue());
        }
        head = head.getNext();
      }
    }
    return keys;
  }

  /**
   * Haetaan alkiota taulukosta, avaimenaan alkio itse, ja palautetaan se.
   * 
   * @param val haettavaa alkiota kuvaava avain/arvo.
   * @return jos parametria val vastaava alkio löytyy, palautetaan se.
   * Muussa tapauksessa palautetaan null.
   */
  public Integer findElement(Integer val) {
    int index = getIndex(val);
    HashNode head = bucket.get(index);

    while (head != null) {
      if (head.getValue().equals(val)) {
        return head.getValue();
      }
      head = head.getNext();
    }
    // Avainta ei löytynyt
    return null;
  }

  /**
   * Palauttaa hajautustaulun kaikki alkiot, joiden avain/arvo vastaa parametrina
   * annettua alkiota.
   * 
   * @param val haettavaa alkiota kuvaava avain/arvo.
   * @return jos parametria vastaava alkio (yksi tai useampia) löytyy, palautetaan kaikki
   * esiintymät taulukkolistana. Jos yhtään esiintymää ei löydy, palautetaan null.
   */
  public ArrayList<Integer> findAllElements(Integer val) {
    int index = getIndex(val);
    HashNode head = bucket.get(index);
    ArrayList<Integer> values = new ArrayList<>();

    while (head != null) {
      if (head.getValue().equals(val)) {
        values.add(head.getValue());
      }
      head = head.getNext();
    }
    // Avainta ei löytynyt
    if (values.size() == 0) {
      return null;
    }
    
    return values;
  }

  /**
   * Lisää alkion hajautustaulukkoon avaimenaan alkion arvo.
   * 
   * @param val lisättävää alkiota kuvaava avain/arvo.
   */
  public void insertItem(Integer val) {
    int index = getIndex(val);
    HashNode head = bucket.get(index);
    size++;
    HashNode node = new HashNode(val);
    node.setNext(head);
    bucket.set(index, node);

    // Halutaan pitää taulukon täyttöaste alle 0.75, joten jos tämä raja
    // ylitetään, niin kasvatetaan taulukon kokoa tuplasti isommaksi
    if (1.0 * size / capacity >= 0.75) {
      ArrayList<HashNode> temp = bucket;
      bucket = new ArrayList<>();
      capacity = 2 * capacity;
      size = 0;
      for (int i = 0; i < capacity; i++) {
        bucket.add(null);
      }
      for (HashNode headNode : temp) {
        while (headNode != null) {
          insertItem(headNode.getValue());
          headNode = headNode.getNext();
        }
      }
    }
  }

  /**
   * Tuottaa unionin kahden hajautustaulun luvuista ja palauttaa sen taulukkolistana.
   * 
   * @param b viite toiseen hajautustauluun, jonka arvoja otetaan mukaan unioniin
   * @return kokonaislukuja sisältävä taulukkolista, joka sisältää kahden hajautustaulun
   * arvojen unionin.
   */
  public ArrayList<Integer> getUnion(HashTable b) {
    ArrayList<Integer> union = new ArrayList<>();
    ArrayList<Integer> keys = findAllKeys();

    // Lisätään unioniin kaikki avaimet ensimmäisestä hajautustaulusta
    for (Integer key : keys) {
      Integer value = findElement(key);
      union.add(value);
    }
    // Haetaan toisen hajautustaulun avaimet
    keys = b.findAllKeys();
    // Lisätään unioniin kaikki avaimet toisesta hajautustaulusta, joita ei vielä löydy
    for (Integer key : keys) {
      Integer value = b.findElement(key);
      if (!union.contains(value)) {
        union.add(value);
      }
    }
    return union;
  }

  /**
   * Tuottaa leikkauksen kahden hajautustaulun luvuista ja palauttaa sen taulukkolistana.
   * 
   * @param b viite toiseen hajautustauluun, jonka arvoja käytetään joukon muodostamisessa.
   * @return kokonaislukuja sisältävä taulukkolista, joka sisältää kahden hajautustaulun
   * arvojen leikkauksen.
   */
  public ArrayList<Integer> getIntersection(HashTable b) {
    ArrayList<Integer> intersection = new ArrayList<>();
    ArrayList<Integer> aKeys = findAllKeys();
    ArrayList<Integer> bKeys = b.findAllKeys();

    // Jos sama avain eli luku löytyy molemmista hajautustauluista, lisätään se leikkaukseen.
    for (Integer key : aKeys) {
      if (bKeys.contains(key)) {
        Integer value = findElement(key);
        if (!intersection.contains(value)) {
          intersection.add(value);
        }
      }
    }
    return intersection;
  }

  /**
   * Tuottaa "poissulkevan tain" (XOR) kahden hajautustaulun luvuista ja palauttaa
   * sen taulukkolistana.
   * 
   * @param b viite toiseen hajautustauluun, jonka arvoja käytetään joukon muodostamisessa.
   * @return kokonaislukuja sisältävä taulukkolista, joka sisältää kahden hajautustaulun
   * arvojen XOR-joukon.
   */
  public ArrayList<Integer> getXOR(HashTable b) {
    ArrayList<Integer> xor = new ArrayList<>();
    ArrayList<Integer> aKeys = findAllKeys();
    ArrayList<Integer> bKeys = b.findAllKeys();
    Integer value;

    // Lisätään ne luvut, jotka löytyvät ensimmäisestä hajautustaulusta, mutta eivät toisesta
    for (Integer key : aKeys) {
      if (!bKeys.contains(key)) {
        value = findElement(key);
        xor.add(value);
      }
    }
    // Lisätään ne luvut, jotka löytyvät toisesta hajautustaulusta, mutta eivät ensimmäisestä
    for (Integer key : bKeys) {
      if (!aKeys.contains(key)) {
        value = b.findElement(key);
        xor.add(value);
      }
    }
    return xor;
  }

}