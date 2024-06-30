package modelo;

import java.util.ArrayList;
import java.util.Scanner;

import interfaces.FasesJogos;

public class Jogos implements FasesJogos {

	Scanner scanner = new Scanner(System.in);
	ArrayList<Times> dez_classificados = new ArrayList<Times>();
	ArrayList<Times> times_playin = new ArrayList<Times>();
	ArrayList<Times> times_playoff = new ArrayList<Times>();
	ArrayList<Times> semi_final = new ArrayList<Times>();
	ArrayList<Times> Final = new ArrayList<Times>();
	Times campeao;

	protected void classificadosPlay_in() {

		for (int i = 6; i <= 9; i++) {
			this.times_playin.add(dez_classificados.get(i));
		}
	}

	private void timesClassificados(ArrayList<Times> times, String fase) {
		System.out.println("\nTimes que disputarão " + fase);
		for (Times item : times) {
			System.out.println(item.getNome());
		}
	}

	public int printarDuelos(Times time1, Times time2) {
		int escolha = 0;

		while (escolha < 1 || escolha > 2) {
			System.out.println("Digite [1] - " + time1.getNome() + " / [2] - " + "" + time2.getNome());
			escolha = scanner.nextInt();
		}
		return escolha;
	}

	private void msgClassificouPlayoff(Times avancou) {
		System.out.println(avancou.getNome() + " venceu e está nos play-offs\n");
	}

	public void play_in() {
		int escolha;
		System.out.println("Disputa dos play-ins");

		this.seisClassificadosPlayOffs();
		this.classificadosPlay_in();
		Times primeiro_perdedor;

		timesClassificados(times_playin, "o play-in");

		System.out.println("\n1º duelo dos play-ins\n");
		escolha = printarDuelos(times_playin.get(0), times_playin.get(1));
		if (escolha == 1) {
			times_playoff.add(times_playin.get(0));
			primeiro_perdedor = times_playin.get(1);
			msgClassificouPlayoff(times_playin.get(0));
		} else {
			times_playoff.add(times_playin.get(1));
			primeiro_perdedor = times_playin.get(0);
			msgClassificouPlayoff(times_playin.get(1));
		}

		System.out.println("\n2º duelo dos play-ins\n");
		escolha = printarDuelos(times_playin.get(2), times_playin.get(3));
		if (escolha == 1) {
			escolha = printarDuelos(times_playin.get(2), primeiro_perdedor);
			if (escolha == 1) {
				times_playoff.add(times_playin.get(2));
				msgClassificouPlayoff(times_playin.get(2));
			} else {
				times_playoff.add(primeiro_perdedor);
				msgClassificouPlayoff(primeiro_perdedor);
			}
		} else {
			escolha = printarDuelos(times_playin.get(3), primeiro_perdedor);
			if (escolha == 1) {
				times_playoff.add(times_playin.get(3));
				msgClassificouPlayoff(times_playin.get(3));
			} else {
				times_playoff.add(primeiro_perdedor);
				msgClassificouPlayoff(primeiro_perdedor);
			}
		}
	}

	private void seisClassificadosPlayOffs() {
		for (int i = 0; i <= 5; i++) {
			this.times_playoff.add(dez_classificados.get(i));
		}
	}

	public void play_off() {
		System.out.println("\nDisputa dos play-offs");
		
		timesClassificados(times_playoff, "os play-offs");
		int escolha;

		escolha = printarDuelos(times_playoff.get(0), times_playoff.get(7));
		addSemiFinal(escolha, times_playoff.get(0), times_playoff.get(7));

		escolha = printarDuelos(times_playoff.get(1), times_playoff.get(6));
		addSemiFinal(escolha, times_playoff.get(1), times_playoff.get(6));

		escolha = printarDuelos(times_playoff.get(2), times_playoff.get(5));
		addSemiFinal(escolha, times_playoff.get(2), times_playoff.get(5));

		escolha = printarDuelos(times_playoff.get(3), times_playoff.get(4));
		addSemiFinal(escolha, times_playoff.get(3), times_playoff.get(4));
	}

	private void addSemiFinal(int escolha, Times time1, Times time2) {
		if (escolha == 1) {
			semi_final.add(time1);
			System.out.println(time1.getNome() + " avançou e está nas semi-finais\n");
		} else {
			semi_final.add(time2);
			System.out.println(time2.getNome() + " avançou e está nas semi-finais\n");
		}
	}

	public void semi_final() {
		int escolha;

		timesClassificados(semi_final, "as semi-finais");
		escolha = printarDuelos(semi_final.get(0), semi_final.get(3));
		addFinal(escolha, semi_final.get(0), semi_final.get(3));

		escolha = printarDuelos(semi_final.get(1), semi_final.get(2));
		addFinal(escolha, semi_final.get(1), semi_final.get(2));
	}

	private void addFinal(int escolha, Times time1, Times time2) {
		if (escolha == 1) {
			Final.add(time1);
			System.out.println(time1.getNome() + " avançou e está na final!\n");
		} else {
			Final.add(time2);
			System.out.println(time2.getNome() + " avançou e está na final!\n");
		}
	}

	public void Final() {
		int escolha;

		timesClassificados(Final, "a final");
		escolha = printarDuelos(Final.get(0), Final.get(1));

		if (escolha == 1) {
			System.out.println("E o grande campeão da conferência " + nomeConfFinal(Final.get(0)) + " é o "
					+ Final.get(0).getNome() + "\n");
			this.campeao = Final.get(0);
		} else {
			System.out.println("E o grande campeão da conferência " + nomeConfFinal(Final.get(1)) + " é o "
					+ Final.get(1).getNome() + "\n");
			this.campeao = Final.get(1);
		}
	}
	
	private String nomeConfFinal(Times time_campeao) {
		String conf;
		
		if(time_campeao.isConferencia()) {
			conf = "oeste";
		}
		else {
			conf = "leste";
		}
		
		return conf;
	}

	// getters and setters
	public ArrayList<Times> getDez_classificados() {
		return dez_classificados;
	}

	public void setDez_classificados(Times dez_classificados) {
		this.dez_classificados.add(dez_classificados);
	}

	public Times getCampeao() {
		return campeao;
	}
}
