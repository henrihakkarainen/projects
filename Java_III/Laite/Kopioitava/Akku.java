/* 
 * Viikkoharjoitus 5, tehtävä 4.
 *  
 * Olio-ohjelmoinnin perusteet I, kevät 2019. Jorma Laurikkala, jorma.laurikkala@tuni.fi.
 *
 * Akkua yleisellä tasolla mallintava luokka.
 *
 * Muokannut: Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 */

import java.io.*;

public class Akku implements Serializable {

   /* 
    * Vakiomuotoiset attribuutit.
    *
    */

   // Akun varaustasossa on toivomisen varaa.
   public static final char ALHAINEN = 'A';

   // Vielä virtaa.
   public static final char KOHTUULLINEN = 'K';

   // Akussa on hyvin virtaa.
   public static final char HYVA = 'H';

   /* 
    * Attribuutit.
    *
    */

   // Akun varaustaso. Sallitut arvot ovat ALHAINEN, KOHTUULLINEN ja HYVA.
   private char varaustaso;

   /*
    * Rakentajat.
    *
    */

   /* Luodaan uusi akku.
    */
   public Akku() {
      varaustaso = HYVA;
   }

   /* Heittää poikkeuksen, jos uusi taso ei ole ALHAINEN, KOHTUULLINEN tai HYVA.
    */ 
   public Akku(char uusiTaso) throws IllegalArgumentException {
      // Yritetään asettaa. Asettajan heittämän poikkeuksen annetaan mennä
      // omia aikojaan rakentajaa kutsuvalle metodille. Otsikossa vain
      // mainitaan kyseinen poikkeus, jotta luokan käyttäjä tietää,
      // että rakentaja voi heittää poikkeuksen.
      varaustaso(uusiTaso);
   }

   /* 
    * Aksessorit.
    *
    */

   public char varaustaso() {
      return varaustaso;
   }

   /* Heittää poikkeuksen, jos uusi taso ei ole ALHAINEN, KOHTUULLINEN tai HYVA.
    */ 
   public void varaustaso(char uusiTaso) throws IllegalArgumentException {
      // Heitetään poikkeus, jos parametrin arvo on virheellinen. 
      if (ALHAINEN != uusiTaso && uusiTaso != KOHTUULLINEN && uusiTaso != HYVA) {
         throw new IllegalArgumentException();
      }

      // Asetetaan arvo, jos poikkeusta ei heitetty.
      varaustaso = uusiTaso;
   }
   
   /*
    * Ilmentymämetodit
    */
   
   public Akku copy() {
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
         
         // Palautetaan Akku-tyyppinen viite
         return (Akku)kopio;
      }
      catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }
   
   /*
    * Korvatut metodit
    * 
    */
   
   // Merkkijonoesitykseen otetaan luokan nimi ja varaustaso.
   @Override
   public String toString() {
      String luokka = getClass().getSimpleName();
      return luokka + " " + varaustaso;
   }
   
   // Palauttaa true, jos varaustasot ovat samat.
   @Override
   public boolean equals(Object obj) {
      try {
         Akku apu = (Akku)obj;
         return varaustaso == apu.varaustaso();
      }
      catch (Exception e) {
         return false;
      }
   }
   
   @Override
   public int hashCode() {
      int tulos = 17;
      tulos = 31 * tulos + Character.hashCode(varaustaso);
      return tulos;
   }
}
