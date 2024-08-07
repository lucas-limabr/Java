package teste;

import modelo.Clientes;
import modelo.ContaEspecial;
import modelo.ContaInvestimento;
import modelo.SaldoIndisponivel;

public class TesteExcecao {

	public static void main(String[] args) {

		Clientes cl1 = new Clientes(001, "Rodrigo", "rodri@gmail.com", "32928765", true);
		Clientes cl2 = new Clientes(002, "Ana", "ana@gmail.com", "32934765", false);

		ContaEspecial contaesp = new ContaEspecial(cl1, 500, 100);
		
		ContaInvestimento containvest = new ContaInvestimento(cl2, 1000, 80);
		
		
		try {
			contaesp.saca(900);
		} catch (SaldoIndisponivel e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
