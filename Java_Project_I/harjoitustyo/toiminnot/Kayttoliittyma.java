package harjoitustyo.toiminnot;

import harjoitustyo.apulaiset.In;

/**
 * Ohjelman käyttäjän kanssa vuorovaikutuksessa toimiva luokka, joka on
 * vastuussa syötteiden vastaanottamisesta ja tietojen tulostamisesta näytölle.
 * 
 * @author Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 */
public class Kayttoliittyma {
   
   public static final String ERROR = "Error!";
   public static final String EXIT = "exit";
   public static final String MD = "md";
   public static final String CD = "cd";
   public static final String MF = "mf";
   public static final String LS = "ls";
   public static final String MV = "mv";
   public static final String RM = "rm";
   public static final String CP = "cp";
   public static final String FIND = "find";
   
   /**
    * Käyttöliittymän pääsilmukasta vastaava metodi. Pääsilmukassa kutsutaan
    * käyttäjän antamia komentoja vastaavia tulkkiluokan metodeja Tulkki-luokan
    * olion kautta, joka alustetaan luokan oletusrakentajalla käyttöliittymän
    * käynnistyessä.
    */
   public void kaynnista() {
      // Alustetaan komentotulkki luomalla sitä vastaava olio.
      Tulkki cmd = new Tulkki();
      // Muuttuja, jolla seurataan käyttäjän antamia komentoja.
      String komento;
      
      // Tervehditään käyttäjää.
      System.out.println("Welcome to SOS.");
      
      do {
         // Komentotulkin kehote, joka koostuu hakemistopolusta.
         System.out.print(cmd.polku() + "/>");
         String syote = In.readString();
         String[] palat = syote.split("[ ]");
         komento = palat[0];
         
         // Komentojen valintarakenne.
         switch (komento) {
            // Hakemiston luominen
            case MD:
               if (palat.length != 2 || !cmd.luoHakemisto(palat[1])) {
                  System.out.println(ERROR);
               }
               break;
               
            // Hakemiston vaihtaminen
            case CD:
               if (palat.length > 2 || !cmd.vaihdaHakemistoa(syote)) {
                  System.out.println(ERROR);
               }
               break;
            
            // Tiedoston luominen
            case MF:
               if (palat.length != 3 || !cmd.luoTiedosto(palat[1], palat[2])) {
                  System.out.println(ERROR);
               }
               break;
               
            // Hakemiston listaus
            case LS:
               StringBuilder listaus = cmd.listaa(syote);
               if (listaus == null) {
                  System.out.println(ERROR);
               }
               else {
                  System.out.print(listaus);
               }
               break;
            
            // Uudelleen nimeäminen
            case MV:
               if (palat.length != 3 || !cmd.nimeaUudelleen(palat[1], palat[2])) {
                  System.out.println(ERROR);
               }
               break;
            
            // Poisto
            case RM:
               if (palat.length != 2 || !cmd.poistaTietoja(palat[1])) {
                  System.out.println(ERROR);
               }
               break;
            
            // Kopiointi
            case CP:
               if (palat.length != 3 || !cmd.kopioi(palat[1], palat[2])) {
                  System.out.println(ERROR);
               }
               break;
            
            // Haku
            case FIND:
               if (palat.length != 1) {
                  System.out.println(ERROR);
               }
               else {
                  System.out.println(cmd.haku());
               }
               break;
               
            // Lopetus   
            case EXIT:
               break;
               
            // Tuntematon komento, ilmoitetaan käyttäjälle virheestä.
            default:
               System.out.println(ERROR);
         }
      }
      while (!komento.equals(EXIT));
      
      // Sanotaan heipat suorituksen päättyessä.
      System.out.println("Shell terminated.");
   }
   
}
