package harjoitustyo;

import harjoitustyo.toiminnot.Kayttoliittyma;

/**
 * Harjoitustyön ajoluokka. Kaikki ohjelman toiminta ja vuorovaikutus tapahtuu
 * käyttöliittymässä, jonka kaynnista-operaatiota kutsutaan tästä luokasta
 * Kayttoliittyma-olion kautta.
 * 
 * @author Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */
public class Oope2HT {
   
   public static void main(String[] args) {
      Kayttoliittyma shell = new Kayttoliittyma();
      shell.kaynnista();
   }
   
}
