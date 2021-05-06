package School;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Laatikko {

	public static void main(String[] args) {
	
		System.out.print("Hei, tämä on Vesiputouspeli!" + "\nKirjoittakaa pelaajien määrä (1-6): ");		
		// tätä voidaan pelata joko yksin tai kaveriporukassa
		String nimi;
		String[] nimet;		
		Scanner lukija = new Scanner(System.in);
		int määrä;
		// kysytään pelaajien määrä
		while (true) {
			määrä = lukija.nextInt();
			if (määrä < 1 || määrä > 6) {
				System.out.print("\nValitettavasti kyseinen lukumäärä ei käy, yritä uudestaan: ");
				continue;
			} else {
				break;
			}
		}	
		nimet = new String[määrä];	
		if (määrä == 1) {
			System.out.print("Kerro nimesi: ");
			nimi = lukija.next();
		} else  {
			for (int i = 0; i < määrä; i++) {
				System.out.print("Anna " + (i + 1) + ". pelaajan nimi: ");
				nimet[i] = lukija.next();
			}
		}
		// Sekoitetaan pelaajat ja ilmoitetaan järjestys.
		pelaajienSekoittaminen(nimet);
		// Luodaan korttien lista.
		ArrayList<String> kortit = new ArrayList<>();
		lisaaKortit(kortit);
		// Rajataan mahdollisia siirtoja 52.
		int siirtoja = 52;
		do {
			for (int i = 0; i < nimet.length; i++) {
				boolean ottaaKortin = false;
				try {
					Scanner lukija2 = new Scanner(System.in);
					System.out.print("\nPelaaja " + nimet[i] + " otatko kortin? (true/false) ");
					ottaaKortin = lukija2.nextBoolean();
				}
				catch(Exception e) {
					System.out.print("Tämä ei ole boolean arvo, yritä uudelleen.");
					i--;
					continue;
				}
					
				if (ottaaKortin == true) {
					String kortti = kortinValitsin(kortit);
					kortinTehtava(kortti);
					kortit.remove(kortti);
					siirtoja--;
				} 
				else if (ottaaKortin == false || kortit.size() > 1) {
					System.out.print("Kiitos pelistä!");
					return; 
				}
			}
		} while (siirtoja > 0);
		System.out.print("Kiitos pelistä!");
	}
	
	public static void pelaajienSekoittaminen(String[] nimet) {
		Laatikko.shuffle(nimet);
		System.out.print("Pelaajien järjestys:\n");
		for (int i = 0; i < nimet.length; i++) {
			System.out.print((i + 1) + ". pelaaja " + nimet[i] + "\n");		
		}
	}
	
	public static void shuffle(Object[] array) {
		
		int elements = array.length;
		for (int i = 0; i < elements; i++) {
			int s = 1 + (int)(Math.random() * (elements - 1));
				Object temp = array[s];
				array[s] = array[i];
				array[i] = temp;
		}
	}
	
	public static void lisaaKortit(List<String> kortit) {
		int[] paka = new int[52];
        String[] maa = {"Pata", "Hertta", "Risti", "Ruutu"};
        String[] arvo = {"Ässä", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jätkä", "Kuningatar", "Kuningas"};

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
		Random r=new Random();
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
				System.out.print("Muut pelaajat voivat lopettaa juomisen vasta, kun vasemmalla seisova pelaaja on lopettanut juomisen.");
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
				System.out.println("Kortin saanut pelaaja valitsee kategorian, ja kaikkien on sanottava vuorotellen siihen kuuluvia asioita.");
				break;
			case "7":
				System.out.println("Peukalopaini!");
				System.out.println("Kortin nostaja haasta toiseen pelaajan peukalopainiin. Häviäjä juo 3 hörppyä.");
				break;
			case "8":
				System.out.println("Sääntö!");
				System.out.println("Kortin nostaja päättää säännön, jonka kaikkien pelaajien on noudatettava. Muuten joutuu juoman.");
				break;
			case "9":
				System.out.println("Kysymyspeli!");
				System.out.println("Aloittaen kortin nostaneesta henkilöstä, pelaajat esittävät toisilleen vuorotellen kysymyksiä. Jos pelaaja ei vasta kysymyksen kysymyksellä, hän joutuu juomaan.");
				break;
			case "10":
				System.out.println("Tarina!");
				System.out.println("Keksikkää yhdessä tarina. Jokainen toistaa tarinan ja saa täydentää sitä yhdellä sanalla. Pelaaja joka unohtaa tarinan juo yhden hörpyn.");
				break;
			case "Ässä":
				System.out.println("Ylös!");
				System.out.println("Kaikki pelaajat nousevat seisomaan. Viimeinen noussut juo yhden höroyn.");
				break;
			case "Jätkä":
				System.out.println("Kysymysmestari!");
				System.out.println("Kortin nostaja on kysymysmestari, jonka kysymyksiin ei saa vastata tai joutuu juomaan yhden hörpyn.");
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
