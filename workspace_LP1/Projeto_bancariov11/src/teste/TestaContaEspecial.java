package teste;

import modelo.Clientes;
import modelo.Identificador;
import modelo.SaldoIndisponivel;
import modelo.Conta;
import modelo.ContaEspecial;

public class TestaContaEspecial {

	public static void main(String[] args) {

		Clientes cl1 = new Clientes(001, "Rodrigo", "rodri@gmail.com", "32928765", true);
		Clientes cl2 = new Clientes(002, "Ana", "ana@gmail.com", "32934765", false);
		
		ContaEspecial contaesp = new ContaEspecial(cl1, 500, 99);

		try {
			if (contaesp.saca(600)) {
				System.out.println("saque realizado");
			} else {
				System.out.println("saque não realizado");
			}
		} catch (SaldoIndisponivel e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(contaesp.getSaldo());
		
		System.out.println(cl2);
		
		System.out.println(Identificador.identificacao(contaesp));
	}

}
