package School;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Vesiputous {

	public static void Vesiputous() {

		System.out.print("Tervetuloa Vesiputouspeliin!" + "\nKirjoittakaa pelaajien määrä (2-10): ");
		// tätä voidaan pelata vain kaveriporukassa
		String[] nimet;
		Scanner lukija = new Scanner(System.in);
		int määrä;
		boolean loop = true;
		// kysytään pelaajien määrä

		// ?????

		
		while (true) {
			Scanner lukija2 = new Scanner(System.in);
			try {
			int aMäärä = lukija2.nextInt();
			if (aMäärä > 2 && aMäärä < 11) {
				määrä = aMäärä;
				break;
			}
		
			} catch (Exception ex) {
			}
			System.out.print("\nValitettavasti kyseinen lukumäärä ei käy, yritä uudestaan: ");
				
			}
			
		nimet = new String[määrä];
		for (int i = 0; i < määrä; i++) {
			System.out.print("Anna " + (i + 1) + ". pelaajan nimi: ");
			nimet[i] = lukija.next();
		}

		// Sekoitetaan pelaajat ja ilmoitetaan järjestys.
		pelaajienSekoittaminen(nimet);
		// Luodaan korttien lista.
		ArrayList<String> kortit = new ArrayList<>();
		lisaaKortit(kortit);
		// Rajataan mahdollisia siirtoja 52.
		int siirtoja = 52;
		// Olio-luokka Vuorot, jonka tarkoituksena on hoitaa pelaajien haihdon siirtojen aikana. Annetaan luokalle alku paikka ja nimet-lista.
		Vuorot vuoro = new Vuorot(0, nimet);
		// do-lauseke mahdollistaa siirtojen rajoittamisen
		do {
			// Luodaan boolean arvo, joka hallitsee vuorojen siirtoja
			boolean ottaaKortin = false;
			/* try-lauseke on toimivin tapa varautua pelaajien virheellisiin syöttöihin.
			Tässä mikäli pelaaja syöttää virheellisen arvon (muun kuin boolean-arvon), ohjelma palaa alkuun. Mikäli arvo on oikea siirrytään eteenpäin.
			*/
			try {
				Scanner lukija2 = new Scanner(System.in);
				//Tässä tärkeintä on olio-kutsu mikaPelaaja, joka tulostaa vuorossa olevan pelaajan nimen
				System.out.print("\nPelaaja " + vuoro.mikaPelaaja() + " otatko kortin? (true/false) ");
				ottaaKortin = lukija2.nextBoolean();
			} catch (Exception e) {
				System.out.print("Tämä ei ole boolean arvo, yritä uudelleen.");
				continue;
			}
			// Jos arvo on tosi, siirytään if-lausekkeeseen.
			if (ottaaKortin == true) {
				// Metodi valitsee randomisti kortin kortti-listalta
				String kortti = kortinValitsin(kortit);
				// Metodi tulostaa tehtävän kortin mukaan
				kortinTehtava(kortti);
				// poistetaan valittu kortti kortti-listalta, jotta se ei toistuisi
				kortit.remove(kortti);
				// Olio vaihtaa pelaajien vuoroa
				vuoro.seuraava();
				// Vähennetään siirot yhdellä
				siirtoja--;
			// jos ottaaKortin arvo pysyy falsena (eli pelaaja syöttää false-arvon) tai kortti-listan koko on
			} else if (ottaaKortin == false || kortit.size() > 1) {
				System.out.print("Kiitos pelistä!");
				return;
			}
		// Jos siirtoja on vähemmän kuin 1, ohjelma lopettaa toiminnansa
		} while (siirtoja > 0);
		System.out.print("Kiitos pelistä!");
	}
	// Olio-luokka Vuorot on luotu pelaajien vaihtumista varten
	public static class Vuorot {
		// Kaksi yhteistä arvoa: paikka (eli nykyinen vuoro) ja lista (päämetodin nimet-lista).
		private int paikka;
		private String[] lista;
		// Liitetään paikka ja alku (lähetetty arvo oli 0) sekä lista ja nimet (lähetetty nimet-lista)
		public Vuorot(int alku, String[] nimet) {
			this.paikka = alku;
			this.lista = nimet;
		}
		/*seuraava-metodin tarkoituksena on vaihtaa pelaaja. 
		Mikäli paikka on sama kuin listan pituus (eli maksimi pelaajien määtä), ohjelma nolla paikka-arvon, 
		eli siirrytään takaisin ensimmäiseen pelaajan*/
		public void seuraava() {
			if (this.paikka == (this.lista.length - 1)) {
				this.paikka = 0;
			} else {
				this.paikka += 1;
			}
		}
		//Metodi lähettää listassa olevan alkion paikan, eli vuorossa olevan pelaajan nimen
		public String mikaPelaaja() {
			return this.lista[this.paikka];
		}
	}

	public static void pelaajienSekoittaminen(String[] nimet) {
		Vesiputous.shuffle(nimet);
		System.out.print("Pelaajien järjestys:\n");
		for (int i = 0; i < nimet.length; i++) {
			System.out.print((i + 1) + ". pelaaja " + nimet[i] + "\n");
		}
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

	public static void lisaaKortit(List<String> kortit) {
		int[] paka = new int[52];
		String[] maa = { "Pata", "Hertta", "Risti", "Ruutu" };
		String[] arvo = { "Ässä", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jätkä", "Kuningatar", "Kuningas" };

		for (int i = 0; i < paka.length; i++) {
			paka[i] = i;
		}

		for (int i = 0; i < 52; i++) {
			String maaK = maa[paka[i] / 13];
			String arvoK = arvo[paka[i] % 13];
			kortit.add(arvoK + " " + maaK);
		}
	}

	private static String kortinValitsin(List<String> kortit) {
		Random r = new Random();
		return kortit.get(r.nextInt(kortit.size()));
	}

	private static void kortinTehtava(String kortti) {
		System.out.println("Korttisi on " + kortti);
		String[] lista = kortti.split(" ", 2);
		String arvo = lista[0];
		switch (arvo) {
		case "1":
			System.out.println("VESIPUTOUS!");
			System.out.println("Kaikki pelaajat aloittavat juomaan yhtä aikaa. ");
			System.out.print("Kortin saaneella pelaajalla on oikeus lopettaa ensin. ");
			System.out.print(
					"Muut pelaajat voivat lopettaa juomisen vasta, kun vasemmalla seisova pelaaja on lopettanut juomisen.");
			break;
		case "2":
			System.out.println("Juo 2 tuoppia!");
			break;
		case "3":
			System.out.println("Juo 3 tuoppia!");
			break;
		case "4":
			System.out.println("Java!");
			System.out.println("Viimeinen pelaaja joka huuttaa Java juo!");
			break;
		case "5":
			System.out.println("123!");
			System.out.println("Kortin nostaja juo yhden hörpyn, seuraava kaksi, ja niin edespäin.");
			break;
		case "6":
			System.out.println("Kategoria!");
			System.out.println(
					"Kortin saanut pelaaja valitsee kategorian, ja kaikkien on sanottava vuorotellen siihen kuuluvia asioita.");
			break;
		case "7":
			System.out.println("Peukalopaini!");
			System.out.println("Kortin nostaja haasta toiseen pelaajan peukalopainiin. Häviäjä juo 3 hörppyä.");
			break;
		case "8":
			System.out.println("Sääntö!");
			System.out.println(
					"Kortin nostaja päättää säännön, jonka kaikkien pelaajien on noudatettava. Muuten joutuu juoman.");
			break;
		case "9":
			System.out.println("Kysymyspeli!");
			System.out.println(
					"Aloittaen kortin nostaneesta henkilöstä, pelaajat esittävät toisilleen vuorotellen kysymyksiä. Jos pelaaja ei vasta kysymyksen kysymyksellä, hän joutuu juomaan.");
			break;
		case "10":
			System.out.println("Tarina!");
			System.out.println(
					"Keksikkää yhdessä tarina. Jokainen toistaa tarinan ja saa täydentää sitä yhdellä sanalla. Pelaaja joka unohtaa tarinan juo yhden hörpyn.");
			break;
		case "Ässä":
			System.out.println("Ylös!");
			System.out.println("Kaikki pelaajat nousevat seisomaan. Viimeinen noussut juo yhden höroyn.");
			break;
		case "Jätkä":
			System.out.println("Kysymysmestari!");
			System.out.println(
					"Kortin nostaja on kysymysmestari, jonka kysymyksiin ei saa vastata tai joutuu juomaan yhden hörpyn.");
			break;
		case "Kuningas":
			System.out.println("Kuningashörppy!");
			System.out.println("Pelaaja maistelee kaikkien juomia.");
			break;
		case "Kuningatar":
			System.out.println("Huora!");
			System.out.println("Pelaaja valitsee itselleen henkilön, joka juo aina hänen juodessa.");
			break;
		}
	}
}
