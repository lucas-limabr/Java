package instancias;

import excecao.LimiteHoras;
import modelo.Assalariado;
import modelo.Cliente;
import modelo.Comissionado;
import modelo.Contrato;
import modelo.HistoricoContratos;
import modelo.Horista;
import modelo.Servico;

public class TesteFuncionariosSalario {

	public static void main(String[] args) {

		Cliente c1 = new Cliente("Tião", "Almeida", "tiao@gmail.com", "M");
		Cliente c2 = new Cliente("Laura", "Diniz", "laura@gmail.com", "F");
		Cliente c3 = new Cliente("Paulo", "Souza", "paulo@gmail.com", "F");

		Comissionado f1 = new Comissionado("Rodrigo", "Guedes", "rodrigo@gmail.com", "M", 20);
		Horista f2 = new Horista("Maria", "Tereza", "maria@gmail.com", "F");
		Assalariado f3 = new Assalariado("Hilton", "Marins", "hilton@gmail.com", "M", 20000);

		HistoricoContratos historico = new HistoricoContratos();
		
		Servico s1;
		try {
			s1 = new Servico("Fiação elétrica", 110.0, 5, 5);

			Contrato contract1 = new Contrato(c1, f1, s1);
			
			historico.addContrato(contract1);

			System.out.println("\n" + historico.pesquisaFuncionario("F1"));

		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());
		}
		Servico s2;
		try {
			s2 = new Servico("Reparo em eletrodomésticos", 100.0, 4, 6);

			Contrato contract2 = new Contrato(c2, f2, s2);
			
			historico.addContrato(contract2);
			
			System.out.println("\n" + historico.pesquisaFuncionario("F6"));
			

		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());
		}
		Servico s3;
		try {
			s3 = new Servico("Encanador", 70.0, 3, 4);

			Contrato contract3 = new Contrato(c3, f3, s3);

			historico.addContrato(contract3);
			
			System.out.println("\n" + historico.pesquisaFuncionario("F3"));

		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());
		}
	}

}
