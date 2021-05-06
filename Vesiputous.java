package School;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Laatikko {

	public static void main(String[] args) {
	
		// pieni intro peliin, säännöt
		System.out.print("Hei, tämä on Vesiputouspeli!" + "\nKirjoittakaa pelaajien määrä (1-6): ");
		boolean totuus = true;		
		// tätä voidaan pelata joko yksin tai kaveriporukassa
		String nimi;
		String[] nimet;		
		Scanner lukija = new Scanner(System.in);
				
		// kysytään pelaajien määrä
		int määrä = lukija.nextInt();	
		
		do {
			if (määrä < 1 || määrä > 6) {
				System.out.print("\nValitettavasti kyseinen lukumäärä ei käy, yritä uudestaan: ");
				määrä = lukija.nextInt(); 
			} else
				break;
			}
		while (totuus);
		nimet = new String[määrä];	
		if (määrä == 1) {
			System.out.print("Kerro nimesi: ");
			nimi = lukija.next();
		}	
		// randomisoidaan pelaajat ja luodaan loogisen järjestyksen
		else  {
			for (int i = 0; i < määrä; i++) {
				System.out.print("Anna " + (i + 1) + ". pelaajan nimi: ");
				nimet[i] = lukija.next();
			}
			Laatikko.shuffle(nimet);
				
			System.out.print("Pelaajien järjestys:\n");
				
			for (int i = 0; i < nimet.length; i++) {
				System.out.print((i + 1) + ". pelaaja " + nimet[i] + "\n");
						
			}
		}
		
		// pakassa on 52 korttia, jolloin siirtoja on myös 52
		ArrayList<String> kortit = new ArrayList<>();
		lisaaKortit(kortit);
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
					System.out.print("Tämä ei ole boolean arvo, yritä uudelleen (true/false) ");
					continue;
				}
					
				if (ottaaKortin == true) {
					String kortti = kortinValitsin(kortit);
					kortinTehtava(kortti);
					kortit.remove(kortti);
					System.out.print(kortit.size() + " PELIMETODI");
					siirtoja--;
				} 
				else if (ottaaKortin == false || kortit.size() > 1) {
					System.out.print("Kiitos pelistä!");
					return; 
				}
			}
		} while (siirtoja > 0);
	}
	
	public static void lisaaKortit(List<String> kortit) {
		int[] paka = new int[52];
        String[] maa = {"Pata", "Hertta", "Risti", "Ruutu"};
        String[] arvo = {"Ässä", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jätka", "Kuningatar", "Kuningas"};

        for (int i = 0; i < paka.length; i++) {
            paka[i] = i;
        }

        for (int i = 0; i < 52; i++) {
            String maaK = maa[paka[i] / 13];
            String arvoK = arvo[paka[i] % 13];
            kortit.add(arvoK + " " + maaK);
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
	private static void kortinTehtava(String kortti) {
		System.out.println("Korttisi on " + kortti);
		String[] lista = kortti.split(" ", 2);
		String arvo = lista[0];
		switch (arvo) {
			case "1":
				System.out.println("Juo 1 tuoppi2!");
				break;
			case "2":
				System.out.println("Juo 2 tuoppia!");
				break;
			case "3":
				System.out.println("Juo 3 tuoppia!");
				break;
			case "4":
				System.out.println("Juo 4 tuoppia!");
				break;
			case "5":
				System.out.println("Juo 5 tuoppia!");
				break;
			case "6":
				System.out.println("Juo 6 tuoppia!");
				break;
			case "7":
				System.out.println("Juo 7 tuoppia!");
				break;
			case "8":
				System.out.println("Juo 8 tuoppia!");
				break;
			case "9":
				System.out.println("Juo 9 tuoppia!");
				break;
			case "10":
				System.out.println("Juo 10 tuoppia!");
				break;
			case "Ässä":
				System.out.println("Juo 13 tuoppia!");
				break;
			case "Jätkä":
				System.out.println("Juo 11 tuoppia!");
				break;
			case "Kuningas":
				System.out.println("Juo 12 tuoppia!");
				break;
			case "Kuningatar":
				System.out.println("Juo 13 tuoppia!");
				break;
		}
	}
	
	private static String kortinValitsin(List<String> kortit) {
		Random r=new Random();
		return kortit.get(r.nextInt(kortit.size()));
	}
}





