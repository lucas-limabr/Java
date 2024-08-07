package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class SaldoIndisponivel extends Exception {

	private static int num_sequencial = 0;
	private ArrayList<LocalDate> datas = new ArrayList<>();
	private ArrayList<Conta> contas = new ArrayList<>();
	private int dia;
	private int mes;
	private int ano;

	public SaldoIndisponivel(String mensagem, Conta conta) {
		
		super(mensagem);
		this.getMessage();
		datas.add(LocalDate.now());
		contas.add(conta);
	}

	public void historicoSaquesInvalidos() {
		System.out.println(this.getMessage());
		System.out.println("Histórico dos saques inválidos:");

		int i = 0;
		for (Conta item : contas) {
			dia = datas.get(i).getDayOfMonth();
			mes = datas.get(i).getMonthValue();
			ano = datas.get(i).getYear();
			
			System.out.println("Saque inválido nº " + num_sequencial + " em uma conta "
					+ item.getIdentificacao() + ": em " + dia+"/"+mes+"/"+ano);

			SaldoIndisponivel.num_sequencial++;
			i++;
		}
	}
}
