package School;
import java.util.Scanner;
public class Opiskelu {
	
	// satunnainen jono
	public static void shuffle(Object[] array) {
		
		int elements = array.length;
		
		for (int i = 0; i < elements; i++) {
			int s = 1 + (int)(Math.random() * (elements - 1));
			
				Object temp = array[s];
				array[s] = array[i];
				array[i] = temp;
		}
	}

	public static void main(String[] args) {
	
		// pieni intro peliin, säännöt
				System.out.print("Hei, tämä on Vesiputouspeli!"
						+ "\nKirjoittakaa pelaajien määrä (1-6): ");
				
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
				Opiskelu.shuffle(nimet);
				
				System.out.print("Pelaajien järjestys:\n");
				
					for (int i = 0; i < nimet.length; i++) {
						System.out.print((i + 1) + ". pelaaja " + nimet[i] + "\n");
					
					}
				}	
		// pakassa on 52 korttia, jolloin siirtoja on myös 52
		int siirtoja = 52;

		while (true) {
			
		for (int i = 0; i < nimet.length; i++) {
			
			System.out.print("\nPelaaja " + nimet[i] + " otatko kortin? (true/false) ");
			boolean ottaaKortin = lukija.nextBoolean();
			
			if (ottaaKortin != true && ottaaKortin != false) {
				System.out.print("Tämä ei ole boolean arvo, yritä uudelleen ");
				ottaaKortin = lukija.nextBoolean();
			}
			else
			if (ottaaKortin == true) {
				siirtoja--;
				// TÄNNE PELIMETODI.
				System.out.print(siirtoja + " PELIMETODI");	
			} 
			
			else if (ottaaKortin == false) {
				System.out.print("Kiitos pelistä!");
				return; 
			}
		}
		}
		
	}
}