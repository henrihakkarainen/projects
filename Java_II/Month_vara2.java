/*
 * 
 * Month - ohjelma
 * 
 * Lausekielinen ohjelmointi 2
 * 
 * Harjoitus 2 - Tehtävä 3
 * 
 * Henri Hakkarainen (Hakkarainen.Henri.J@student.uta.fi)
 * 
 */
public class Month {
    // Operaatio palauttaa kuukauden nimen
    public static String giveName(int kk) {
        String kuukausi;
        if (kk == 1)
            kuukausi = "January";
        else if (kk == 2)
            kuukausi = "February";
        else if (kk == 3)
            kuukausi = "March";
        else if (kk == 4)
            kuukausi = "April";
        else if (kk == 5)
            kuukausi = "May";
        else if (kk == 6)
            kuukausi = "June";
        else if (kk == 7)
            kuukausi = "July";
        else if (kk == 8)
            kuukausi = "August";
        else if (kk == 9)
            kuukausi = "September";
        else if (kk == 10)
            kuukausi = "October";
        else if (kk == 11)
            kuukausi = "November";
        else if (kk == 12)
            kuukausi = "December";
        else
            kuukausi = "?";
        return kuukausi;
    }

    public static void main(String[] args) {
        System.out.println("Hello! I verbalise your input.");
        System.out.println("Please, enter a number:");
        int luku = In.readInt();
        String kuukausi = giveName(luku);
        System.out.println("It is " + kuukausi + ".");
    }
}
