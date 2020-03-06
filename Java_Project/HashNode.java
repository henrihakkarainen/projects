/**
 * Oman hajautustaulun yksittäistä alkiota kuvaava luokka.
 */
public class HashNode {
  /** Alkiolla on kokonaislukutyyppinen arvo, joka toimii hajautustaulussa
      myös alkion avaimena hajautustaulussa. */
  private Integer value;
  
  /** Viittaus seuraavaan alkioon hajautustaulun samassa lokerossa. */
  private HashNode next;

  public HashNode(Integer value) {
    setValue(value);
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }

  public void setNext(HashNode next) {
    this.next = next;
  }

  public HashNode getNext() {
    return next;
  }

}