package teste;

import modelo.Clientes;
import modelo.ContaInvestimento;

public class TestaContaInvestimento {

	public static void main(String[] args) {
		
		Clientes cl2 = new Clientes(010, "Léo", "leo@gmail.com", "32928741");
		
		ContaInvestimento containvest = new ContaInvestimento(cl2, 1000, 80);
		
		containvest.atualizaTaxa(50);
		containvest.atualizaSaldo();
		
		System.out.println(containvest.getSaldo());
	}

}
