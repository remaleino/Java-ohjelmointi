package School;
import java.util.Scanner;

public class Alku {

	public static void main(String[] args) {
		pelit();
	}

	public static void pelit() {
		while (true) {
			tulostaValikko();
			int valikko = 0;
			Scanner lukija = new Scanner(System.in);
			try {
				valikko = lukija.nextInt();
				if (valikko > 4 || valikko < 1) {
					throw new IllegalArgumentException();
				}
			} catch (Exception e) {
				System.out.print("Väärä arvo, yritä uudestaan: ");
				continue;
			}
			if (valikko == 1) {
				Vesiputous VesiputousObject = new Vesiputous();
				VesiputousObject.Vesiputous();
			} else if (valikko == 2) {
				Shottiruletti ShottirulettiObject = new Shottiruletti();
				ShottirulettiObject.ruletti();
			} else if (valikko == 3) {
				tulostaOhjeet();
			} else {
				System.out.println("Mee nukkumaan...");
				break;
			}
		}
	}
	public static void tulostaOhjeet() {
		Scanner lukija = new Scanner(System.in);
		int ohjeet = 0;
		System.out.print("Vesiputos-ohjeet(1) Shottiruletti-ohjeet(2)\n");
		boolean totuus = false;
		while (!totuus) {
			try {
				ohjeet = lukija.nextInt();
				if (ohjeet < 1 || ohjeet > 2) {
					throw new IllegalArgumentException();
				} else {
					totuus = true;
				}
			} catch (Exception e) {
				System.out.println("Väärä arvo! Syötä uudestaan!");
				lukija.next();
			}
		}
		if (ohjeet == 1) {
			tulostaVesiputous();
		} else if (ohjeet == 2) {
			tulostaRuletti();
		}
	}

	public static void tulostaVesiputous() {
		System.out.println("AA");
	}

	public static void tulostaRuletti() {
		System.out.println("AA");
	}

	public static void tulostaValikko() {
		System.out.print("\n********************************************\n"
				+ "Tervetuloa juomapelivalikkoon, valitse peli:\n" + "----------1:\t\tVesiputous----------\n"
				+ "----------2:\t\tShottiruletti-------\n" + "----------3: \t\tPeliohjeet---------\n"
				+ "----------4: \t\tLopeta---------\n" + "********************************************\n");
		System.out.print("Valitse: ");
	}

}
