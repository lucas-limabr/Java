package instancias;

import modelo.Cliente;
import modelo.Contrato;
import modelo.Funcionario;
import modelo.Historico;
import modelo.Pessoa;
import modelo.Servico;

public class TesteFaturamento_Historico {

	public static void main(String[] args) {

		// criando as instâncias da classe Pessoas
		Pessoa p1 = new Pessoa("Lucas", "Lima", "lucas@gmail.com", "M");
		Pessoa p2 = new Pessoa("Ana", "Carolina", "ana@gmail.com", "F");
		Pessoa p6 = new Pessoa("Tião", "Almeida", "tiao@gmail.com", "M");
		Pessoa p7 = new Pessoa("Rodrigo", "Guedes", "rodrigo@gmail.com", "M");

		// criando as instâncias da classe Cliente
		Cliente c1 = new Cliente(p1);
		Cliente c2 = new Cliente(p2);

		// criando as instâncias da classe Funcionario
		Funcionario f1 = new Funcionario(p6);
		Funcionario f2 = new Funcionario(p7);

		// criando as instâncias da classe Serviço
		Servico s1 = new Servico("Pintura", 50.0, 5, 6);
		Servico s2 = new Servico("Encanamento", 70.0, 3, 4);

		// instanciando a classe Contrato
		Contrato contrato1 = new Contrato(c1, f1, s1);
		Contrato contrato2 = new Contrato(c2, f2, s2);

		// instanciando a classe Historico
		Historico historico = new Historico();

		// add contratos no Historico
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

		// testando o método faturamentoTotPrevisto da classe Historico
		System.out.println("\n-----------------");
		System.out.println("O faturamento total previsto considerando todos os" + " contratos é de R$"
				+ historico.faturamentoTotPrevisto());

		// exibindo o orçamento de serviço de cada um dos contratos que estão no
		// histórico, para certificar que o total está batendo com o valor acima
		for (Contrato item : historico.getLista_contratos()) {
			System.out.println("R$ " + item.getServico().calculaOrcamento());
		}

		// testando o método faturamentoPago da classe Historico
		System.out.println("\n-----------------");
		System.out.println(
				"O faturamento total pago considerando todos os" + " contratos é de R$" + historico.faturamentoPago());

		// mostrando o valor total pago de serviço de cada um dos contratos que
		// estão no histórico
		for (Contrato item : historico.getLista_contratos()) {
			System.out.println("R$ " + item.getServico().valorPago());
		}
	}

}
