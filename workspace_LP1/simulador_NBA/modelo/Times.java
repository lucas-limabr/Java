package modelo;

import java.util.Scanner;

public class Times {
	private String nome;
	// oeste: true/ leste: false
	private boolean conferencia;
	static Scanner scanner = new Scanner(System.in);

	public Times(String nome, boolean conf) {
		this.nome = nome;
		this.conferencia = conf;
	}

	public static int escolha() {
		int escolha = 0;

		while (escolha < 1 || escolha > 2) {
			System.out.println("Vc quer começar pela qual conferência? ");
			System.out.println("[1] - oeste \n[2] - leste");
			escolha = scanner.nextInt();
		}
		return escolha;
	}

	//getters and setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isConferencia() {
		return conferencia;
	}

	public void setConferencia(boolean conferencia) {
		this.conferencia = conferencia;
	}
}
