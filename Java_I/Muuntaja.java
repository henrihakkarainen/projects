public class Muuntaja {

	public static void main(String[] args) {
	
		System.out.println("Moi! Tällä ohjelmalla muunnetaan jaardit metreiksi.");
		double jaardit;
		double metrit;
		System.out.print("Anna jaardit: ");
		jaardit = In.readDouble();
		metrit = 0.9144 * jaardit;
		System.out.println("Tulos: " + metrit + " metriä.");
	}
}
