package instancias;

import modelo.Cliente;
import modelo.Contrato;
import modelo.Funcionario;
import modelo.Pessoa;
import modelo.Servico;

public class TesteDescricao {

	public static void main(String[] args) {

		// criando as instâncias da classe Pessoas
		Pessoa p1 = new Pessoa("Lucas", "Lima", "lucas@gmail.com", "M");
		Pessoa p2 = new Pessoa("Ana", "Carolina", "ana@gmail.com", "F");

		// criando instância da classe Cliente
		Cliente c1 = new Cliente(p1);

		// criando as instâncias da classe Funcionario
		Funcionario f1 = new Funcionario(p2);

		// criando instância da classe Serviço
		Servico s1 = new Servico("Pintura", 50.0, 5, 6);

		// instanciando a classe Contrato
		Contrato contrato1 = new Contrato(c1, f1, s1);

		// vendo todas as informações de um determinado cliente
		System.out.println(c1.toString());

		// vendo todas as informações de um determinado funcionário
		System.out.println(f1.toString());

		// vendo todas as informações de um determinado serviço
		System.out.println(s1.toString());

		// vendo todas as informações de um determinado contrato
		System.out.println(contrato1.toString());
	}

}
