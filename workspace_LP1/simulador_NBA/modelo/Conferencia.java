package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import interfaces.ExibirClassificar;

public class Conferencia extends Jogos implements ExibirClassificar {

	ArrayList<Times> times = new ArrayList<Times>();
	Scanner scanner = new Scanner(System.in);

	public Conferencia(Times[] times) {
		for (Times item : times) {
			this.times.add(item);
		}
	}
	
	public Conferencia() {
		
	}

	public void imprimeConf() {
		int i = 1;
		for (Times item : times) {
			System.out.println(i + ". " + item.getNome());
			i++;
		}
	}

	public void classifica() {
		System.out.println("\nClassifique os 15 times: \n");

		int posicao, k;
		int verifica_posicao[] = new int[10];

		for (int i = 10, j = 0; i > 0; i--, j++) {
			do {
				System.out.print("Insira o número do " + i + "º colocado: ");
				posicao = scanner.nextInt();

				for (k = 0; k < verifica_posicao[k]; k++) {
					if (verifica_posicao[k] == posicao) {
						posicao = -1;
					}
					
					if(verifica_posicao[k] == 0) {
						break;
					}
				}

			} while (posicao < 1 || posicao > 15);

			verifica_posicao[j] = posicao;
			posicao -= 1;

			// add ao arraylist da classe Jogos
			this.setDez_classificados(times.get(posicao));
		}
	}

	public void imprimeClassificacao(int escolha) {
		int i = 1;

		if (escolha == 1) {
			System.out.println("\nClassificação da Conferência oeste: \n");
		} else if (escolha == 2) {
			System.out.println("\nClassificação da Conferência leste: \n");
		}

		// inverto a ordem dos arraylists, pois, foi pedido ao usuário a ordem
		// decrescente dos times, mas eu quero classificar em ordem crescente
		Collections.reverse(dez_classificados);

		for (Times item : dez_classificados) {
			System.out.println(i + ". " + item.getNome());
			i++;
		}
	}
}
