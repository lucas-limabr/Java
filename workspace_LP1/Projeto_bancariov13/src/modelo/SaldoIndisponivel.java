package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class SaldoIndisponivel extends Exception {

	private static ArrayList<String> historico = new ArrayList<>();
	private static int num_sequencial = 0;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy 'às' HH:mm:ss.SSS");

	public SaldoIndisponivel(String mensagem, String tipo_conta) {

		super(mensagem);
		SaldoIndisponivel.num_sequencial++;
		
		historico.add("Saque inválido nº " + num_sequencial + " em uma " + tipo_conta + ": em "
				+ LocalDateTime.now().format(formatter));
	}

	public static ArrayList<String> historicoSaquesInvalidos() {
		return historico;
	}
}
