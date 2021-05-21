package School;

import java.util.Scanner;

public class peli {
		public static void main(String[] args) {
			
			System.out.print("\n********************************************\n"
							+ "Tervetuloa juomapelivalikkoon, valitse peli:\n"
							+ "----------1:\t\tVesiputous----------\n"
							+ "----------2:\t\tShottiruletti-------\n"
							+ "----------3: \t\tPeliohjeet---------\n"
							+ "********************************************\n");
			System.out.print("*************** peli on : ");
			int valikko = 0;
			int ohjeet = 0;
			Scanner lukija = new Scanner(System.in);
			valikko = lukija.nextInt();
			
			while (valikko > 3 || valikko < 1) {
				System.out.print("Väärä luku, yritä uudestaan: ");
				valikko = lukija.nextInt();
			}  if (valikko == 1) {
				Vesiputous VesiputousObject = new Vesiputous();
				VesiputousObject.Vesiputous();
			} else if (valikko == 2) {
				Shottiruletti ShottirulettiObject = new Shottiruletti();
				ShottirulettiObject.ruletti();
			} else if (valikko == 3) {
				System.out.print("Vesiputos-ohjeet(1) Shottiruletti-ohjeet(2)\n");
				ohjeet = lukija.nextInt();
				if (ohjeet > 2 || ohjeet < 1) {
					System.out.print("Kyseinen luku ei käy, kokeile uudestaan: ");
					ohjeet = lukija.nextInt();
				}
				else if (ohjeet == 1) {
					System.out.print("Tässä on vesiputouspeliohjeet");
				} else if (ohjeet == 2) {
					System.out.print("tässä on shottirulettiohjeet");
					
				}
				
			}	
	}
}

