package instancias;

import modelo.Cliente;
import modelo.Contrato;
import modelo.Funcionario;
import modelo.Historico;
import modelo.Pessoas;
import modelo.Servico;

public class TesteFaturamento_Historico {

	public static void main(String[] args) {

		// criando as instâncias da classe Pessoas
		Pessoas p1 = new Pessoas("Lucas", "Lima", "lucas@gmail.com", "M");
		Pessoas p2 = new Pessoas("Ana", "Carolina", "ana@gmail.com", "F");
		Pessoas p3 = new Pessoas("Gabriela", "Rezende", "gabriela@gmail.com", "F");
		Pessoas p4 = new Pessoas("Pedro", "Augusto", "pedro@gmail.com", "M");
		Pessoas p5 = new Pessoas("João", "Santos", "joao@gmail.com", "M");
		Pessoas p6 = new Pessoas("Tião", "Almeida", "tiao@gmail.com", "M");
		Pessoas p7 = new Pessoas("Rodrigo", "Guedes", "rodrigo@gmail.com", "M");
		Pessoas p8 = new Pessoas("Isabela", "Souza", "isabela@gmail.com", "F");
		Pessoas p9 = new Pessoas("Sabrina", "Queiroz", "sabrina@gmail.com", "M");
		Pessoas p10 = new Pessoas("Allan", "Alves", "allan@gmail.com", "M");

		// criando as instâncias da classe Cliente
		Cliente c1 = new Cliente(p1, "C1");
		Cliente c2 = new Cliente(p2, "C2");
		Cliente c3 = new Cliente(p3, "C3");
		Cliente c4 = new Cliente(p4, "C4");
		Cliente c5 = new Cliente(p5, "C5");

		// criando as instâncias da classe Funcionario
		Funcionario f1 = new Funcionario(p6, "F1");
		Funcionario f2 = new Funcionario(p7, "F2");
		Funcionario f3 = new Funcionario(p8, "F3");
		Funcionario f4 = new Funcionario(p9, "F4");
		Funcionario f5 = new Funcionario(p10, "F5");

		// criando as instâncias da classe Serviço
		Servico s1 = new Servico("Pintura", 50.0, 5, 6, "S1");
		Servico s2 = new Servico("Encanamento", 70.0, 3, 4, "S2");
		Servico s3 = new Servico("Reparo em eletrodomésticos", 100.0, 4, 6, "S3");
		Servico s4 = new Servico("Fiação elétrica", 110.0, 5, 5, "S4");
		Servico s5 = new Servico("Obras e reparos na casa", 80.0, 6, 8, "S5");

		// instanciando a classe Contrato
		Contrato contrato1 = new Contrato(c1, f1, s1);
		Contrato contrato2 = new Contrato(c2, f2, s2);
		Contrato contrato3 = new Contrato(c3, f3, s3);
		Contrato contrato4 = new Contrato(c4, f4, s4);
		Contrato contrato5 = new Contrato(c5, f5, s5);

		// instanciando a classe Historico
		Historico historico = new Historico();
		
		//add todos os contratos no Historico
		if (historico.addContrato(contrato1, contrato2, contrato3, contrato4,
				contrato5)) {
			System.out.println("Contrato(s) adicionado(s) com sucesso!");
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
