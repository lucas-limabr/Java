package app;

import modelo.Conferencia;
import modelo.SuperFinal;
import modelo.Times;

public class Main {

	static int escolha = 0;

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

		escolha = Times.escolha();

		if (escolha == 1) {
			conferenciaAtual(escolha);
			imprimeClassifica(oeste);
			inverteEscolha(escolha);
			conferenciaAtual(escolha);
			imprimeClassifica(leste);

			inverteEscolha(escolha);
			imprimeClassificacao(oeste, escolha);
			inverteEscolha(escolha);
			imprimeClassificacao(leste, escolha);

			escolha = Times.escolha();
			if (escolha == 1) {
				conferenciaAtual(escolha);
				jogos(oeste);
				inverteEscolha(escolha);
				conferenciaAtual(escolha);
				jogos(leste);
			} else {
				conferenciaAtual(escolha);
				jogos(leste);
				inverteEscolha(escolha);
				conferenciaAtual(escolha);
				jogos(oeste);
			}
		} else {
			conferenciaAtual(escolha);
			imprimeClassifica(leste);
			inverteEscolha(escolha);
			conferenciaAtual(escolha);
			imprimeClassifica(oeste);

			inverteEscolha(escolha);
			imprimeClassificacao(leste, escolha);
			inverteEscolha(escolha);
			imprimeClassificacao(oeste, escolha);

			escolha = Times.escolha();
			if (escolha == 1) {
				conferenciaAtual(escolha);
				jogos(oeste);
				inverteEscolha(escolha);
				conferenciaAtual(escolha);
				jogos(leste);
			} else {
				conferenciaAtual(escolha);
				jogos(leste);
				inverteEscolha(escolha);
				conferenciaAtual(escolha);
				jogos(oeste);
			}
		}

		Times campeao_oeste = new Times();
		Times campeao_leste = new Times();
		campeao_oeste = oeste.getCampeao();
		campeao_leste = leste.getCampeao();

		SuperFinal super_campeao = new SuperFinal(campeao_leste, campeao_oeste);
		super_campeao.supercampeao();
	}

	// métodos auxiliares para o método main, para evitar duplicidade de código
	private static void conferenciaAtual(int escolha) {
		if (escolha == 1) {
			System.out.println("\nConferência oeste\n");
		} else {
			System.out.println("\nConferência leste\n");
		}
	}

	private static void inverteEscolha(int escolha) {
		if (escolha == 1) {
			Main.escolha = 2;
		} else {
			Main.escolha = 1;
		}
	}

	private static void imprimeClassifica(Conferencia conf) {
		conf.imprimeConf();
		conf.classifica();
	}

	private static void imprimeClassificacao(Conferencia conf, int escolha) {
		conf.imprimeClassificacao(escolha);
	}

	private static void jogos(Conferencia conf) {
		conf.play_in();
		conf.play_off();
		conf.semi_final();
		conf.Final();
	}
}
