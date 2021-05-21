package School;

import java.util.Scanner;

public class Shottiruletti {

	public static void ruletti() {
		System.out.println();
		System.out.print("Tervetuloa Shottiruletti-peliin!\n");
		String[] nimet;
		String nimi;
		int pelajaMäärä = 0;
		int arvo = 0;

		Scanner lukija = new Scanner(System.in);

		System.out.print("Kirjoittakaa pelaajien määrä: ");
		pelajaMäärä = lukija.nextInt();

		if (pelajaMäärä == 1) {
			System.out.print("Kerro nimesi: ");
			nimi = lukija.next();
			System.out.println("Moi " + nimi + "!");
			while (true) {
				System.out.print(nimi + ", anna arvo (1-5): ");
				arvo = lukija.nextInt();
				while (arvo > 5) {
					System.out.print("Luku ei käy, kirjoita uusi luku (1-5): ");
					arvo = lukija.nextInt();
					
				} if (arvo < 1) {
					System.out.print("Kiitos pelistä!");
					return;
				}
				peli(arvo);
			}
		} else if (pelajaMäärä > 1) {
			nimet = new String[pelajaMäärä];
			for (int i = 0; i < nimet.length; i++) {
				System.out.print("Anna " + (i + 1) + ". pelaajan nimi: ");
				nimet[i] = lukija.next();
			}
			pelaajienSekoittaminen(nimet);

			while (true) {
				for (int i = 0; i < nimet.length; i++) {
					System.out.print(nimet[i] + " anna arvo (1-5): ");
					while (true) {
						arvo = lukija.nextInt();
						
						if (arvo > 5) {
							System.out.print("Luku ei käy, kirjoita uusi luku (1-5): ");
							continue;
						} else if (arvo < 1) {
							System.out.print("Kiitos pelistä!");
							return;
						} else if (arvo < 6 && arvo > 0) {
							peli(arvo);
							break;
						}
					}
					
				}
			}
		}
	}
	
	public static void peli(int arvo) {
		if (arvo == luoti()) {
			System.out.println("Juo!");
		}
		int osuma = 0;
		Scanner lukija = new Scanner(System.in);
	}

	public static int luoti() {
		int a = 1;
		int b = 5;
		return (int) ((Math.random() * (b - a)) + a);
	}

	public static void pelaajienSekoittaminen(String[] nimet) {
		Shottiruletti.shuffle(nimet);
	}

	public static void shuffle(Object[] array) {
		int elements = array.length;
		for (int i = 0; i < elements; i++) {
			int s = 1 + (int) (Math.random() * (elements - 1));
			Object temp = array[s];
			array[s] = array[i];
			array[i] = temp;
		}
	}
}
