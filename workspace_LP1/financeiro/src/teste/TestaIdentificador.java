package teste;

import modelo.Cliente;
import modelo.Conta;
import modelo.ContaEspecial;
import modelo.ContaInvestimento;
import modelo.Identificador;

public class TestaIdentificador {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente(1, "João", "joao@gmail.com", 99945334, false);

		Conta c1 = new ContaEspecial(100, cliente1);
		Conta c2 = new ContaInvestimento(200, cliente1);
		Conta c3 = new ContaUniversitaria(cliente1);

		System.out.println(Identificador.identificaConta(c1));
		System.out.println(Identificador.identificaConta(c2));
		System.out.println(Identificador.identificaConta(c3));

	}
}
