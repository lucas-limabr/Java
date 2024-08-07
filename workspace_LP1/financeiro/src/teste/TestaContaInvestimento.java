package teste;

import modelo.Cliente;
import modelo.ContaInvestimento;

public class TestaContaInvestimento {
	public static void main(String[] args) {
		Cliente cliente1 = new Cliente(1, "João", "joao@gmail.com", 99945334);
		
		ContaInvestimento ci = new ContaInvestimento(10.0, cliente1);
		ci.deposita(100);
		
		System.out.println("Saldo: " + ci.getSaldo());
		ci.atualizaSaldo();
		System.out.println("Saldo: " + ci.getSaldo());
		
		ci.atualizaTaxa(20.0);
		ci.atualizaSaldo();
		System.out.println("Saldo: " + ci.getSaldo());
	}
}