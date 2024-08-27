package teste;

import modelo.Clientes;
import modelo.Identificador;
import modelo.ContaInvestimento;

public class TestaContaInvestimento {

	public static void main(String[] args) {
		
		Clientes cl2 = new Clientes(010, "Léo", "leo@gmail.com", "32928741", true);
		
		ContaInvestimento containvest = new ContaInvestimento(cl2, 1000, 80);
		
		containvest.atualizaTaxa(50);
		containvest.atualizaSaldo();
		
		System.out.println(containvest.getSaldo());
		
		System.out.println(cl2);
		
		System.out.println(Identificador.identificacao(containvest));
	}

}
