package instancias;

import modelo.Cliente;
import modelo.Contrato;
import modelo.Funcionario;
import modelo.Historico;
import modelo.Pessoa;
import modelo.Servico;

public class TesteCRUD_Contrato {

	public static void main(String[] args) {

		// criando as instâncias da classe Pessoas
		Pessoa p1 = new Pessoa("Lucas", "Lima", "lucas@gmail.com", "M");
		Pessoa p2 = new Pessoa("Ana", "Carolina", "ana@gmail.com", "F");
		Pessoa p3 = new Pessoa("Gabriela", "Rezende", "gabriela@gmail.com", "F");
		Pessoa p4 = new Pessoa("Pedro", "Augusto", "pedro@gmail.com", "M");

		// criando as instâncias da classe Cliente
		Cliente c1 = new Cliente(p1);
		Cliente c2 = new Cliente(p2);

		// criando as instâncias da classe Funcionario
		Funcionario f1 = new Funcionario(p3);
		Funcionario f2 = new Funcionario(p4);

		// criando as instâncias da classe Serviço
		Servico s1 = new Servico("Pintura", 50.0, 5, 6);
		Servico s2 = new Servico("Encanamento", 70.0, 3, 4);

		// instanciando a classe Contrato
		Contrato contrato1 = new Contrato(c1, f1, s1);
		Contrato contrato2 = new Contrato(c2, f2, s2);

		// testando o método addContrato da classe Historico
		Historico historico = new Historico();

		System.out.println("\n-----------------");
		if (historico.addContrato(contrato1)) {
			System.out.println("Contrato adicionado com sucesso!");
		} else {
			System.out.println("Este contrato já consta na lista!");
		}

		if (historico.addContrato(contrato2)) {
			System.out.println("Contrato adicionado com sucesso!");
		} else {
			System.out.println("Este contrato já consta na lista!");
		}

		if (historico.addContrato(contrato1)) {
			System.out.println("Contrato adicionado com sucesso!");
		} else {
			System.out.println("Este contrato já consta na lista!");
		}

		// testando o método buscaContrato da classe Historico
		System.out.println("\n-----------------");
		String num_ordem = "2024-2";
		Contrato contrato_pesquisado = historico.buscaContrato(num_ordem);
		if (contrato_pesquisado == null) {
			System.out.println("Contrato " + num_ordem + " não encontrado");
		} else {
			System.out.println(contrato_pesquisado.toString());
		}

		// testando o método informacoes da classe Historico
		System.out.println("\n-----------------");
		historico.informacoes(contrato1);

		System.out.println("\n-----------------");
		// testando o método removeContrato da classe Historico
		if (historico.removeContrato(contrato1)) {
			System.out.println("Contrato " + contrato1.getNum_ordem() + " removido com sucesso!");
		} else {
			System.out.println("Contrato não encontrado");
		}
	}
}
