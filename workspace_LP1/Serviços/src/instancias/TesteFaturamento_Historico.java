package instancias;

import excecao.LimiteHoras;
import modelo.Assalariado;
import modelo.Cliente;
import modelo.Contrato;
import modelo.Historico;
import modelo.Servico;

public class TesteFaturamento_Historico {

	public static void main(String[] args) {

		Cliente c1 = new Cliente("Tião", "Almeida", "tiao@gmail.com", "M");
		Cliente c2 = new Cliente("Rodrigo", "Guedes", "rodrigo@gmail.com", "M");

		Assalariado f1 = new Assalariado("Caio", "Junior", "caio@gmail.com", "M", 1500.0);
		Assalariado f2 = new Assalariado("Julia", "Lima", "julia@gmail.com", "F", 1700.0);

		Historico historico = new Historico();

		Servico s1;
		try {
			s1 = new Servico("Pintura", 50.0, 5, 6);

			Contrato contrato1 = new Contrato(c1, f1, s1);

			// add contratos no Historico
			if (historico.addContrato(contrato1)) {
				System.out.println("Contrato adicionado com sucesso!");
			} else {
				System.out.println("Este contrato já consta na lista!");
			}

		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());
		}

		Servico s2;
		try {
			s2 = new Servico("Encanamento", 70.0, 3, 4);

			Contrato contrato2 = new Contrato(c2, f2, s2);

			if (historico.addContrato(contrato2)) {
				System.out.println("Contrato adicionado com sucesso!");
			} else {
				System.out.println("Este contrato já consta na lista!");
			}

		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());

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
