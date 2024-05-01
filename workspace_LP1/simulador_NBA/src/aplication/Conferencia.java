package aplication;

import java.util.ArrayList;
import java.util.Scanner;

public class Conferencia {
	private String[] conferencia;
	private String[] classificacao = new String[10];
	private ArrayList<String> play_offs = new ArrayList<String>();
	private ArrayList<String> semi_finais = new ArrayList<String>();
	private ArrayList<String> Final = new ArrayList<String>(); 
	private String campeao = new String();

	public void conferenciaLeste() {
		conferencia = new String[] { "ATLANTA HAWKS", "BOSTON CELTICS", "BROOKLYN NETS", "CHARLOTTE HORNETS",
				"CHICAGO BULLS", "CLEVELAND CAVALIERS", "DETROIT PISTONS", "INDIANA PACERS", "MIAMI HEAT",
				"MILWAUKEE BUCKS", "NEW YORK KNICKS", "ORLANDO MAGIC", "PHILADELPHIA 76ERS", "TORONTO RAPTORS",
				"WASHINGTON WIZARDS" };
	}

	public void conferenciaOeste() {
		conferencia = new String[] { "DALLAS MAVERICKS", "DENVER NUGGETS", "GOLDEN STATE WARRIORS", "HOUSTON ROCKETS",
				"LOS ANGELES CLIPPERS", "LOS ANGELES LAKERS", "MEMPHIS GRIZZLIES", "MINESSOTA TIMBERWOLVES",
				"NEW ORLEANS PELICANS", "OKLAHOMA CITY THUNDER", "PHOENIX SUNS", "PORTLAND TRAIL BLAZERS",
				"SACRAMENTO KINGS", "SAN ANTONIO SPURS", "UTAH JAZZ" };
	}

	public void imprimeConferencia() {
		for (int i = 0; i < this.conferencia.length; i++) {
			System.out.print((i + 1) + ". " + this.conferencia[i] + "\n");
		}
	}

	public void classifica(int numFranquia) {

		String franquia = null;
		numFranquia--;

		for (int i = 0; i < this.conferencia.length; i++) {
			if (i == numFranquia) {
				franquia = this.conferencia[i];
				break;
			}
		}

		for (int i = (this.classificacao.length - 1); i >= 0; i--) {

			if (this.classificacao[i] == null) {
				this.classificacao[i] = franquia;
				break;
			}
		}

	}

	public void imprimeClassificacao() {
		for (int i = 0; i < this.classificacao.length; i++)
			System.out.print((i + 1) + ". " + this.classificacao[i] + "\n");
	}

	public boolean buscaFranquia(int numFranquia) {
		String franquia = null;
		numFranquia--;

		for (int i = 0; i < this.conferencia.length; i++) {
			if (i == numFranquia) {
				franquia = this.conferencia[i];
				break;
			}
		}

		if (franquia != null) {
			for (int j = 0; j < this.classificacao.length; j++) {
				if (franquia.equals(this.classificacao[j]))
					return true;
			}
			return false;
		}

		return false;
	}

	// código novo
	public void play_in() {
		Scanner scanner = new Scanner(System.in);
		int primeiro_duelo, segundo_duelo, vida_or_morte;
		String primeiro_derrotado = "";

		// os 6 primeiros classificados já é certo que estarão nos
		// playoffs, aqui estou adicionando-os
		for (int i = 0; i <= 5; i++) {
			play_offs.add(i, classificacao[i]);
		}

		System.out.println("Palpite para o 1º duelo do play-in:");
		System.out.println(this.classificacao[6] + " x " + this.classificacao[7] + ": ");
		System.out.println("Digite [1] - " + this.classificacao[6] + " / [2] - " + this.classificacao[7]);
		primeiro_duelo = scanner.nextInt();

		if (primeiro_duelo == 1) {
			System.out.println(this.classificacao[6] + " avançou e está nos play offs!");
			primeiro_derrotado = this.classificacao[7];
			play_offs.add(6, this.classificacao[6]);
		} else {
			System.out.println(this.classificacao[7] + " avançou e está nos play offs!");
			primeiro_derrotado = this.classificacao[6];
			play_offs.add(6, this.classificacao[7]);
		}

		System.out.println();
		System.out.println("Palpite para o 2º duelo do play-in:");
		System.out.println(this.classificacao[8] + " x " + this.classificacao[9] + ": ");
		System.out.println("Digite [1] - " + this.classificacao[8] + " / [2] - " + this.classificacao[9]);
		segundo_duelo = scanner.nextInt();

		System.out.println("Disputa da última vaga para os playoffs");
		if (segundo_duelo == 1) {
			System.out.println(this.classificacao[8] + " x " + primeiro_derrotado + ": ");
			System.out.println("Digite [1] - " + this.classificacao[8] + " / [2] - " + primeiro_derrotado);
			vida_or_morte = scanner.nextInt();

			if (vida_or_morte == 1) {
				System.out.println(this.classificacao[8] + " avançou e está nos play offs!");
				play_offs.add(7, this.classificacao[8]);
			} else {
				System.out.println(primeiro_derrotado + " avançou e está nos play offs!");
				play_offs.add(7, primeiro_derrotado);
			}
		} else {
			System.out.println(this.classificacao[9] + " x " + primeiro_derrotado + ": ");
			System.out.println("Digite [1] - " + this.classificacao[9] + " / [2] - " + primeiro_derrotado);
			vida_or_morte = scanner.nextInt();

			if (vida_or_morte == 1) {
				System.out.println(this.classificacao[9] + " avançou e está nos play offs!");
				play_offs.add(7, this.classificacao[9]);
			} else {
				System.out.println(primeiro_derrotado + " avançou e está nos play offs!");
				play_offs.add(7, primeiro_derrotado);
			}
		}
	}

	public void play_offs() {
		System.out.println("Times classificados");

		String fase = " semi-final!";
		int i = 1;
		for (String item : play_offs) {
			System.out.println(i + ". " + item);
			i++;
		}

		System.out.println("Dê seu palpite nos jogos abaixo: ");
		msgConfrontos(play_offs.get(0), play_offs.get(7), fase);
		msgConfrontos(play_offs.get(1), play_offs.get(6), fase);
		msgConfrontos(play_offs.get(2), play_offs.get(5), fase);
		msgConfrontos(play_offs.get(3), play_offs.get(4), fase);
	}

	private void msgConfrontos(String time1, String time2, String fase) {
		Scanner scanner = new Scanner(System.in);
		int vitorioso;

		System.out.println("Digite [1] - " + time1 + " / [2] - " + time2);
		vitorioso = scanner.nextInt();

		if (vitorioso == 1) {
			System.out.println(time1 + " avançou e está na"+fase);
			if(fase.equals(" semi-final!")) {
				semi_finais.add(time1);
			}
			else {
				Final.add(time1);
			}
		} else {
			System.out.println(time2 + " avançou e está na"+fase);;
			if(fase.equals(" semi-final!")) {
				semi_finais.add(time2);
			}
			else {
				Final.add(time2);
			}
		}
		System.out.println();
	}

	public void semi_finais() {
		System.out.println("--------------");
		System.out.println("Times classificados para as semi-finais");

		String fase = " final!";
		int i = 1;
		for (String item : semi_finais) {
			System.out.println(i + ". " + item);
			i++;
		}
		
		msgConfrontos(semi_finais.get(0), semi_finais.get(3), fase);
		msgConfrontos(semi_finais.get(1), semi_finais.get(2), fase);
	}
	
	public void Final(String conferencia) {
		Scanner scanner = new Scanner(System.in);
		int vitorioso;
		
		System.out.println("Digite [1] - " +Final.get(0)+ " / [2] - " +Final.get(1));
		vitorioso = scanner.nextInt();
		
		if(vitorioso == 1) {
			System.out.println("E o campeão da conferência "+
					conferencia +" da NBA é o "+Final.get(0));
			campeao = Final.get(0);
		}
		else if (vitorioso == 2) {
			System.out.println("E o campeão da conferência "+
		conferencia +" da NBA é o "+Final.get(1));
			campeao = Final.get(1);
		}
	}

	public String campeaoConferencia() {
		return campeao;
	}
}
