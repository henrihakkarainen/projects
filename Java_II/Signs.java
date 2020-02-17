/*
 * 
 * Signs - ohjelma
 * 
 * Lausekielinen ohjelmointi 2
 * 
 * Harjoitus 1 - Tehtävä 5
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class Signs {
    // Operaatio katsoo, ovatko kaksi lukua etumerkiltään samat
    public static void ovatkoSamat(int ekaLuku, int tokaLuku) {
        if (ekaLuku >= 0 && tokaLuku >= 0) {
            System.out.println("The signs are the same.");
        }
        else if (ekaLuku < 0 && tokaLuku < 0) {
            System.out.println("The signs are the same.");
        }
        else {
            System.out.println("The signs are different.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello! I compare signs.");
        System.out.println("Enter the first integer:");
        int luku1 = In.readInt();
        System.out.println("Enter the second integer:");
        int luku2 = In.readInt();
        ovatkoSamat(luku1, luku2);
    }
}
