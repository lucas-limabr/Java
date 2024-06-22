package app;
import modelo.Conferencia;
import modelo.SuperFinal;
import modelo.Times;

public class Main {

	public static void main(String[] args) {

		Times times_oeste[] = new Times[15];
		Times times_leste[] = new Times[15];

		times_oeste[0] = new Times("UTAH JAZZ", true);
		times_oeste[1] = new Times("DENVER NUGGETS", true);
		times_oeste[2] = new Times("GOLDEN STATE WARRIORS", true);
		times_oeste[3] = new Times("HOUSTON ROCKETS", true);
		times_oeste[4] = new Times("LOS ANGELES CLIPPERS", true);
		times_oeste[5] = new Times("LOS ANGELES LAKERS", true);
		times_oeste[6] = new Times("MEMPHIS GRIZZLIES", true);
		times_oeste[7] = new Times("MINESSOTA TIMBERWOLVES", true);
		times_oeste[8] = new Times("NEW ORLEANS PELICANS", true);
		times_oeste[9] = new Times("OKLAHOMA CITY THUNDER", true);
		times_oeste[10] = new Times("PHOENIX SUNS", true);
		times_oeste[11] = new Times("PORTLAND TRAIL BLAZERS", true);
		times_oeste[12] = new Times("SACRAMENTO KINGS", true);
		times_oeste[13] = new Times("SAN ANTONIO SPURS", true);
		times_oeste[14] = new Times("DALLAS MAVERICKS", true);

		times_leste[0] = new Times("WASHINGTON WIZARDS", false);
		times_leste[1] = new Times("BOSTON CELTICS", false);
		times_leste[2] = new Times("BROOKLYN NETS", false);
		times_leste[3] = new Times("CHARLOTTE HORNETS", false);
		times_leste[4] = new Times("CHICAGO BULLS", false);
		times_leste[5] = new Times("CLEVELAND CAVALIERS", false);
		times_leste[6] = new Times("DETROIT PISTONS", false);
		times_leste[7] = new Times("INDIANA PACERS", false);
		times_leste[8] = new Times("MIAMI HEAT", false);
		times_leste[9] = new Times("MILWAUKEE BUCKS", false);
		times_leste[10] = new Times("NEW YORK KNICKS", false);
		times_leste[11] = new Times("ORLANDO MAGIC", false);
		times_leste[12] = new Times("PHILADELPHIA 76ERS", false);
		times_leste[13] = new Times("TORONTO RAPTORS", false);
		times_leste[14] = new Times("ATLANTA HAWKS", false);

		Conferencia oeste = new Conferencia(times_oeste);
		Conferencia leste = new Conferencia(times_leste);

		int escolha = Times.escolha();

		if (escolha == 1) {
			System.out.println("Conferência oeste: \n");
			oeste.imprimeConf();
			oeste.classifica();

			System.out.println("\nConferência leste: \n");
			leste.imprimeConf();
			leste.classifica();

			oeste.imprimeClassificacao(escolha);
			escolha = 2;
			leste.imprimeClassificacao(escolha);

			System.out.println("\nDisputa dos play-ins");
			escolha = Times.escolha();

			if (escolha == 1) {
				oeste.play_in(escolha);
				System.out.println("\nDisputa dos play-offs");
				oeste.play_off();
				oeste.semi_final();
				oeste.Final();
				
				leste.play_in(escolha);
				System.out.println("\nDisputa dos play-offs");
				leste.play_off();
				leste.semi_final();
				leste.Final();
			} else {
				leste.play_in(escolha);
				System.out.println("\nDisputa dos play-offs");
				leste.play_off();
				leste.semi_final();
				leste.Final();
				
				oeste.play_in(escolha);
				System.out.println("\nDisputa dos play-offs");
				oeste.play_off();
				oeste.semi_final();
				oeste.Final();
			}
		} else {
			System.out.println("Conferência leste: \n");
			leste.imprimeConf();
			leste.classifica();

			System.out.println("\nConferência oeste: \n");
			oeste.imprimeConf();
			oeste.classifica();

			leste.imprimeClassificacao(escolha);
			escolha = 1;
			oeste.imprimeClassificacao(escolha);

			System.out.println("\nDisputa dos play-ins");
			escolha = Times.escolha();

			if (escolha == 1) {
				oeste.play_in(escolha);
				System.out.println("\nDisputa dos play-offs");
				oeste.play_off();
				oeste.semi_final();
				oeste.Final();
				
				escolha = 2;
				leste.play_in(escolha);
				System.out.println("\nDisputa dos play-offs");
				leste.play_off();
				leste.semi_final();
				leste.Final();
			} else {
				leste.play_in(escolha);
				System.out.println("\nDisputa dos play-offs");
				leste.play_off();
				leste.semi_final();
				leste.Final();
				
				escolha = 1;
				oeste.play_in(escolha);
				System.out.println("\nDisputa dos play-offs");
				oeste.play_off();
				oeste.semi_final();
				oeste.Final();
			}
		}
		
		SuperFinal super_campeao = new SuperFinal(leste, oeste);
		super_campeao.supercampeao();
	}
}
