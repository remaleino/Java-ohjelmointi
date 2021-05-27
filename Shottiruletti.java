import java.util.Scanner;
public class Shottiruletti {

	public static void ruletti() {
		// Alkutervehdys
		System.out.println();
		System.out.print("Tervetuloa Shottiruletti-peliin!\n");
		String[] nimet;
		String nimi;
		int pelajaMäärä = 0;
		int arvo = 0;
		// Kirjoitetaan pelaajien määrä
		Scanner lukija = new Scanner(System.in);
		System.out.print("Kirjoittakaa pelaajien määrä: ");
		// Jos kirjoitetaan muu arvo kuin numero, 
		// ja numero suurempi kuin 1 tai pienempi kuin 6, pelajaMäärä saa pMäärä:n (pseudo määrä) arvon.
		// Jos ilmestyy virhe, ilmestyy virheen korvaava teksti ja silmukka alkaa alusta.
		while (true) {
			Scanner lukija2 = new Scanner(System.in);
			try {
				int pMäärä = lukija2.nextInt();
				if (pMäärä > 0 && pMäärä < 6) {
					pelajaMäärä = pMäärä;
					break;
				}
			} catch (Exception ex) {
			}
			System.out.print("Kyseinen määrä ei käy, kirjoita uudelleen: ");
		}
		// Mikäli pelaaja on vain yksi, hän pysty pelaa yksin koneen kanssa :)
		if (pelajaMäärä == 1) {
			System.out.print("Kerro nimesi: ");
			nimi = lukija.next();
			System.out.println("Moi " + nimi + "!");
			// Itse peli, annetaan arvo 1-5.
			while (true) {
				System.out.print(nimi + ", anna arvo (1-5): ");
				Scanner lukija2 = new Scanner(System.in);
				// Kokeillaan syöttää arvoja. Luodaan pseudo arvon (pArvo), 
				// annetaan pArvo:lle uuden arvon 1 ja 5 välillä.
				// Mikäli arvo ei vastaa asetetuille rajoituksille, pyydämme käyttäjä syöttää uuden arvon.
				// Jos arvo on 1 ja 5 välillä, kutsumme pelimetodin.
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
		// Jos pelaajaMäärä on suurempi kuin 1
		// Kirjoitamme pelaajien nimet for-silmukan avulla
		// Kutsumme pelaajienSekoittaminen(nimet) metodi
		} else if (pelajaMäärä > 1) {
			nimet = new String[pelajaMäärä];
			for (int i = 0; i < nimet.length; i++) {
				System.out.print("Anna " + (i + 1) + ". pelaajan nimi: ");
				nimet[i] = lukija.next();
			}
			pelaajienSekoittaminen(nimet);
			/* 
			while-silmukassa tapahtuu pelin kulku.
			for-silmukka hoitaa pelaajien vaihtaamisen
			toisessa while-silmukassa kysytään pelaajalta lukua ja varaudutaan väärin syötteisiin (try catch).
			*/
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
		// metodi peli, mikäli osuma toteutuu, kyseisen metodin kutsutaan
		if (arvo == luoti()) {
			System.out.println("Juo!");
		}
		int osuma = 0;
		Scanner lukija = new Scanner(System.in);
	}

	public static int luoti() {
		// luoti metodi palauttaa yhden luvun 1-5 välillä. Luku on satunnainen.
		int a = 1;
		int b = 5;
		return (int) ((Math.random() * (b - a)) + a);
	}

	public static void pelaajienSekoittaminen(String[] nimet) {
		// Sekoitetaan listaalla olevat pelaajat. 
		Shottiruletti.shuffle(nimet);
	}
	
	// Metodissa "sekoitetaan" alkioita.
	public static void shuffle(Object[] array) {
		
		// Elements saa arvokseen saadun listan koon		
		int elements = array.length;
		// Saadaan for-lausekeella tarvittavat i:n arvot, jotka määräytyvät listan pituuden mukaan.
		for (int i = 0; i < elements; i++) {
			// Saadaan randomi numero listaan koon mukaan.
			int s = 1 + (int) (Math.random() * (elements - 1));
			// temp saa listan[s] arvon.
			Object temp = array[s];
			// Vaihdetaan lista[s] ja lista[i] alkioita.
			array[s] = array[i];
			array[i] = temp;
		}
	}
}
