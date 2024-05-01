package instancias;

import modelo.Servico;

public class TesteOrcamento_ValorPago {

	public static void main(String[] args) {

		// criando as instâncias da classe Serviço
		Servico s1 = new Servico("Pintura", 50.0, 5, 6, "S1");
		Servico s2 = new Servico("Encanamento", 70.0, 3, 4, "S2");
		Servico s3 = new Servico("Reparo em eletrodomésticos", 100.0, 4, 6, "S3");
		Servico s4 = new Servico("Fiação elétrica", 110.0, 5, 5, "S4");
		Servico s5 = new Servico("Obras e reparos na casa", 80.0, 6, 8, "S5");

		// testando o método calculaOrçamento e valorPago da classe Serviço
		System.out.println("O orçamento do serviço de código " + s3.getCodigo() + " foi de R$" + s3.calculaOrcamento());

		System.out.println("O valor pago pelo serviço de código " + s3.getCodigo() + " foi de R$" + s3.valorPago());
	}

}
