package project;

import aplication.Conferencia;
import aplication.SuperFinal;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Conferencia leste = new Conferencia();
		Conferencia oeste = new Conferencia();

		leste.conferenciaLeste();
		oeste.conferenciaOeste();

		System.out.print("Por qual conferência vamos começar?\n");
		System.out.print("1. Leste\n2. Oeste ");
		int conf = scanner.nextInt();

		while (conf != 1 && conf != 2) {
			System.out.print("VALOR INVÁLIDO, INSIRA NOVAMENTE: ");
			conf = scanner.nextInt();
		}

		if (conf == 1) {

			System.out.print("\n");
			leste.imprimeConferencia();
			System.out.print("\n");

			for (int i = 0; i < 10; i++) {
				int num = 10 - i;
				System.out.print("Insira o " + num + "° colocado: ");
				int numFranquia = scanner.nextInt();

				while (numFranquia < 0 || numFranquia > 15) {
					System.out.print("VALOR INVÁLIDO, INSIRA NOVAMENTE: ");
					numFranquia = scanner.nextInt();
				}

				while (leste.buscaFranquia(numFranquia)) {
					System.out.print("ESSA FRANQUIA JÁ FOI SELECIONADA, INSIRA NOVAMENTE: ");
					numFranquia = scanner.nextInt();
				}

				leste.classifica(numFranquia);
			}

			System.out.print("\n");
			oeste.imprimeConferencia();
			System.out.print("\n");

			for (int i = 0; i < 10; i++) {
				int num = 10 - i;
				System.out.print("Insira o " + num + "° colocado: ");
				int numFranquia = scanner.nextInt();

				while (numFranquia < 0 || numFranquia > 15) {
					System.out.print("VALOR INVÁLIDO, INSIRA NOVAMENTE: ");
					numFranquia = scanner.nextInt();
				}

				while (oeste.buscaFranquia(numFranquia)) {
					System.out.print("ESSA FRANQUIA JÁ FOI SELECIONADA, INSIRA NOVAMENTE: ");
					numFranquia = scanner.nextInt();
				}

				oeste.classifica(numFranquia);
			}
			System.out.print("\n");
		}

		else {

			System.out.print("\n");
			oeste.imprimeConferencia();
			System.out.print("\n");

			for (int i = 0; i < 10; i++) {
				int num = 10 - i;
				System.out.print("Insira o " + num + "° colocado: ");
				int numFranquia = scanner.nextInt();

				while (numFranquia < 0 || numFranquia > 15) {
					System.out.print("VALOR INVÁLIDO, INSIRA NOVAMENTE: ");
					numFranquia = scanner.nextInt();
				}

				while (oeste.buscaFranquia(numFranquia)) {
					System.out.print("ESSA FRANQUIA JÁ FOI SELECIONADA, INSIRA NOVAMENTE: ");
					numFranquia = scanner.nextInt();
				}

				oeste.classifica(numFranquia);
			}

			System.out.print("\n");
			leste.imprimeConferencia();
			System.out.print("\n");

			for (int i = 0; i < 10; i++) {
				int num = 10 - i;
				System.out.print("Insira o " + num + "° colocado: ");
				int numFranquia = scanner.nextInt();

				while (numFranquia < 0 || numFranquia > 15) {
					System.out.print("VALOR INVÁLIDO, INSIRA NOVAMENTE: ");
					numFranquia = scanner.nextInt();
				}

				while (leste.buscaFranquia(numFranquia)) {
					System.out.print("ESSA FRANQUIA JÁ FOI SELECIONADA, INSIRA NOVAMENTE: ");
					numFranquia = scanner.nextInt();
				}

				leste.classifica(numFranquia);
			}
			System.out.print("\n\n");
		}

		if (conf == 1) {
			leste.imprimeClassificacao();
			System.out.print("\n");
			oeste.imprimeClassificacao();
		}

		else {
			oeste.imprimeClassificacao();
			System.out.print("\n");
			leste.imprimeClassificacao();
		}

		// código novo
		System.out.println("-------------------");
		System.out.println("Simulador da disputa dos Play-ins");

		System.out.println("Vc quer começar por qual conferência" + "[1]-Leste / [2]-Oeste");
		conf = scanner.nextInt();

		if (conf == 1) {
			System.out.println("Conferência leste");
			leste.play_in();

			System.out.println("--------------");
			System.out.println("Disputa dos play-offs, vamo separar os" + " homens dos meninos");

			leste.play_offs();
			leste.semi_finais();

			System.out.println("------------");
			System.out.println("Grande final!");
			leste.Final("leste");

			System.out.println("\nConferência oeste");
			oeste.play_in();

			System.out.println("--------------");
			System.out.println("Disputa dos play-offs, vamo separar os" + " homens dos meninos");
			oeste.play_offs();
			oeste.semi_finais();

			System.out.println("------------");
			System.out.println("Grande final!");
			oeste.Final("oeste");
		} else if (conf == 2) {
			System.out.println("\nConferência oeste");
			oeste.play_in();

			System.out.println("--------------");
			System.out.println("Disputa dos play-offs, vamo separar os" + " homens dos meninos");
			oeste.play_offs();
			oeste.semi_finais();

			System.out.println("------------");
			System.out.println("Grande final!");
			oeste.Final("oeste");
			
			System.out.println("Conferência leste");
			leste.play_in();

			System.out.println("--------------");
			System.out.println("Disputa dos play-offs, vamo separar os" + " homens dos meninos");

			leste.play_offs();
			leste.semi_finais();

			System.out.println("------------");
			System.out.println("Grande final!");
			leste.Final("leste");
		}
		
		String campeao_leste = leste.campeaoConferencia();
		String campeao_oeste = oeste.campeaoConferencia();
		
		SuperFinal superfinal = new SuperFinal(campeao_leste, campeao_oeste);

		scanner.close();
	}

}
