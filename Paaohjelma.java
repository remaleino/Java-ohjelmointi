import java.util.Scanner;

public class Alku {
	/* Eritetään pelit omakseen metodikseen,
	jotta niitä olisi helpommin kontrolloida.*/
	public static void main(String[] args) {
		pelit();
	}
	//Itse pelit ovat täällä.
	public static void pelit() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "x-ISO-2022-CN-GB"));
		/*Pelaajalla tulee olemaan valinta poistua päävalikosta ja lopettaa
		pelaamisen, mutta muuten pelaaja tulee aina palamaan
		päävalikkoon pelikertojen jälkeen.*/
		while (true) {
			//Metodi tulostaa päävalikon tekstit.
			tulostaValikko();
			int valikko = 0;
			Scanner lukija = new Scanner(System.in);
			//Try-lausekeella kysytään, minkä komennon pelaaja antaa.
			try {
				valikko = lukija.nextInt();
				/*Jos pelaajan syöttämä numero-arvo on virheellinen,
				try-lauseke heittää virheen*/
				if (valikko > 4 || valikko < 1) {
					throw new IllegalArgumentException();
				}
			//Jos pelaajan syöttö on virheelinen, ohjelma palaa while-lausekeen alkuun.
			} catch (Exception e) {
				System.out.print("Väärä arvo, yritä uudestaan: ");
				continue;
			}
			// Mahdolliset toimintavaihtoehdot:
			if (valikko == 1) {
				/*Jos pelaaja valitsee 1, ohjelma käynistää
				vesiputouspelin. Tätä varten käynistetään peli
				toisesta tiedostosta.*/
				Vesiputous VesiputousObject = new Vesiputous();
				VesiputousObject.Vesiputous();
			} else if (valikko == 2) {
				/*Jos pelaaja valitsee 2, ohjelma käynistää
				shottipelin. Tätä varten käynistetään peli
				toisesta tiedostosta.*/
				Shottiruletti ShottirulettiObject = new Shottiruletti();
				ShottirulettiObject.ruletti();
			} else if (valikko == 3) {
				/*Jos pelaaja valitsee 3, ohjelma käynistää
				siirtyy ohjeiden valikkoon, joka on erillinen
				metodi*/
				tulostaOhjeet();
			} else {
				//Ohjelman lopetus arvon olleessa 4.
				System.out.println("Mee nukkumaan...");
				break;
			}
		}
	}
	// Metodi kutsuu ohjeiden tulostuksen.
	public static void tulostaOhjeet() {
		Scanner lukija = new Scanner(System.in);
		int ohjeet = 0;
		System.out.print("Vesiputos-ohjeet(1) Shottiruletti-ohjeet(2)\n");
		boolean totuus = false;
		/*Pelaajan on annettava arvon, joka tulostaa
		tavittavat ohjeet. Siihen asti kunnes syöttö on oikea,
		hänen on annettava syötteitä. Tämänn takia pistetään 
		try-lauseke while-lausekeen sisälle.*/
		while (!totuus) {
			try {
				ohjeet = lukija.nextInt();
				if (ohjeet < 1 || ohjeet > 2) {
					throw new IllegalArgumentException();
				} else {
					//Komento lopettaa while lausekeen.
					totuus = true;
				}
			} catch (Exception e) {
				System.out.println("Väärä arvo! Syötä uudestaan!");
				lukija.next();
			}
		}
		// Jos arvo on 1, tulostetaan metodin kautta veisputouksen ohjeet.
		if (ohjeet == 1) {
			tulostaVesiputous();
		// Jos arvo on 2, tulostetaan metodin kautta ruletin ohjeet.
		} else if (ohjeet == 2) {
			tulostaRuletti();
		}
	}
	//Metodissa on vesiputoksen ohjeet.
	public static void tulostaVesiputous() {
		System.out.println("Vesiputous-juomapeliin osallistuu 1-10 pelaajaa.\n"
				+ "Pelissä jokainen pelaaja tulee vuorotelleen saamaan kortin, jossa tulee lukemaan tehtävä.\n"
				+ "Suoritettuaan tehtävästä, pelaaja ilmoittaa olevansa valmis, jolloin vuoro siirtyy seuraavalle pelaajalle\n"
				+ "ja pakasta nostetaan seuraava kortti. Peli loppuu, kun kaikki 52 korttia on käyty läpi\n"
				+ "tai pelaajat päättävät olla jatkamatta pelivuoroa.");
	}
	//Metodissa on ruletin ohjeet.
	public static void tulostaRuletti() {
		System.out.println("Shottiruletti-juomapeliin osallistuu 1-5 pelaajaa.\n"
				+ "Pelissä pelaajat tulevat vuorotellen veikkaamaan lukua yhden ja viiden välillä.\n"
				+ "Mikäli pelaajan ja tietokoneen arpomat luvut ovat samoja, niin pelaaja joutuu juomaan.\n"
				+ "Pelaajien vuorot vaihtuvat automaattisesti. Mikäli pelaajat haluavat lopettaa pelin,\n"
				+ "heidän on syötettävä negatiivinen arvo.");
	}
	//Metodissa tulostetaan päävalikon ohjeet.
	public static void tulostaValikko() {
		System.out.print("\n********************************************\n"
				+ "Tervetuloa juomapelivalikkoon, valitse peli:\n" + "----------1:\t\tVesiputous----------\n"
				+ "----------2:\t\tShottiruletti-------\n" + "----------3: \t\tPeliohjeet---------\n"
				+ "----------4: \t\tLopeta---------\n" + "********************************************\n");
		System.out.print("Valitse: ");
	}

}
