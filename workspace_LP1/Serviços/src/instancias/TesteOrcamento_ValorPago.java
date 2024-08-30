package instancias;

import excecao.LimiteHoras;
import modelo.Servico;

public class TesteOrcamento_ValorPago {

	public static void main(String[] args) {

		Servico s1;
		try {
			s1 = new Servico("Reparo em eletrodomésticos", 100.0, 4, 6);

			// testando o método calculaOrçamento e valorPago da classe Serviço
			System.out.println(
					"O orçamento do serviço de código " + s1.getCodigo() + " foi de R$" + s1.calculaOrcamento());

			System.out.println("O valor pago pelo serviço de código " + s1.getCodigo() + " foi de R$" + s1.valorPago());

		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());
		}

		Servico s2;
		try {
			s2 = new Servico("Fiação elétrica", 110.0, 5, 5);

			System.out.println(
					"O orçamento do serviço de código " + s2.getCodigo() + " foi de R$" + s2.calculaOrcamento());

			System.out.println("O valor pago pelo serviço de código " + s2.getCodigo() + " foi de R$" + s2.valorPago());

		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());

		}

	}

}
