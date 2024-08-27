package teste;

import modelo.Clientes;
import modelo.ContaEspecial;
import modelo.ContaInvestimento;
import modelo.SaldoIndisponivel;

public class TesteExcecao {

	public static void main(String[] args) {

		Clientes cl1 = new Clientes(001, "Rodrigo", "rodri@gmail.com", "32928765", true);
		Clientes cl2 = new Clientes(002, "Ana", "ana@gmail.com", "32934765", false);
		Clientes cl3 = new Clientes(003, "Leo", "leo@gmail.com", "32934665", true);

		ContaEspecial contaesp = new ContaEspecial(cl1, 500, 100);
		ContaEspecial contaesp2 = new ContaEspecial(cl3, 1000, 100);
		
		ContaInvestimento containvest = new ContaInvestimento(cl3, 1000, 80);
		
		
		try {
			contaesp.saca(601);
		} catch (SaldoIndisponivel e) {
			System.out.println(e.getMessage()); 
		}
		
		try {
			contaesp2.saca(599);
		} catch (SaldoIndisponivel e) {
			System.out.println(e.getMessage());
		}
		
		//1000 - 800 = 200
		try {
			containvest.saca(800);
		} catch (SaldoIndisponivel e) {
			System.out.println(e.getMessage());
		}
		
		try {
			containvest.transfere(contaesp, 201);
		} catch (SaldoIndisponivel e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("Testes feitos");
		}
		
		System.out.println("Histórico dos saques inválidos:");
		for(String item : SaldoIndisponivel.historicoSaquesInvalidos()) {
			System.out.println(item);
		}
	}
}
