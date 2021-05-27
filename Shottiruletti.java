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
		while (true) {
			Scanner lukija2 = new Scanner(System.in);
			try {
				int pMäärä = lukija2.nextInt();
				if (pMäärä > 0) {
					pelajaMäärä = pMäärä;
					break;
				}
			} catch (Exception ex) {
			}
			System.out.print("Kyseinen määrä ei käy, kirjoita uudelleen: ");
		}

		if (pelajaMäärä == 1) {
			System.out.print("Kerro nimesi: ");
			nimi = lukija.next();
			System.out.println("Moi " + nimi + "!");
			
			while (true) {
				System.out.print(nimi + ", anna arvo (1-5): ");
				Scanner lukija2 = new Scanner(System.in);
				try {
					int pArvo;
					pArvo = lukija2.nextInt();

					if (pArvo > 0 && pArvo < 6) {
						arvo = pArvo;
					}
					else if (pArvo <= 0) {
						System.out.print("Kiitos pelistä!");
						break;
					} else if (pArvo > 5) {
						System.out.println("Liian suuri arvo.");
						
					}
				}catch (Exception ex) {	
				System.out.println("Tämä ei ole sopiva syöte, yritä uudestaan.");
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
					
					while (true) {
						int pArvo;
						System.out.print(nimet[i] + " anna arvo (1-5): ");
						Scanner lukija2 = new Scanner(System.in);
						try {
							pArvo = lukija2.nextInt();
							if (pArvo > 5) {
								System.out.println("Luku ei käy, kirjoita uusi luku.");
								continue;
							} else if (pArvo <= 0) {
								System.out.print("Kiitos pelistä!");
								return;
							} else if (pArvo < 6 && pArvo > 0) {
								arvo = pArvo;
								break;
							}	
							
						} catch(Exception ex) {
							System.out.println("Tämä ei ole sopiva syöte, yritä uudestaan.");
							
						} 
						peli(arvo);
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
