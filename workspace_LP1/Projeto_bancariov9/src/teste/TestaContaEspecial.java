package teste;

import modelo.Clientes;
import modelo.Conta;
import modelo.ContaEspecial;

public class TestaContaEspecial {

	public static void main(String[] args) {

		Clientes cl1 = new Clientes(001, "Rodrigo", "rodri@gmail.com", "32928765");

		ContaEspecial contaesp = new ContaEspecial(cl1, 500, 99);

		if (contaesp.saca(600)) {
			System.out.println("saque realizado");
		} else {
			System.out.println("saque não realizado");
		}

		System.out.println(contaesp.getSaldo());
	}

}
