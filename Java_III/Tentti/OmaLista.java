import java.util.LinkedList;

/*
 * Oope1 tentti - Tehtävä 4
 * 
 * Tehnyt: Henri Hakkarainen (henri.hakkarainen@tuni.fi)
 * 
 */

public class OmaLista<E> extends LinkedList<E> {
   
   public boolean korvaa(int ekaInd, LinkedList<E> korvaavat) {
      
      if (ekaInd >= 0 && korvaavat != null && korvaavat.size() > 0 &&
          ekaInd + korvaavat.size() - 1 < size()) {
         
         int korvaavaIndeksi = 0;
         while (korvaavaIndeksi < korvaavat.size()) {
            E alkio = korvaavat.get(korvaavaIndeksi);
            set(ekaInd, alkio);
            ekaInd++;
            korvaavaIndeksi++;
         }
         return true;

      }
      else {
         return false;
      }
      
   }
   
}
