package instancias;

import modelo.Assalariado;
import modelo.Cliente;
import modelo.Comissionado;
import modelo.Contrato;
import modelo.Horista;
import modelo.Servico;

public class TesteFuncionariosSalario {

	public static void main(String[] args) {
		
		Cliente c1 =  new Cliente("Tião", "Almeida", "tiao@gmail.com", "M");
		Cliente c2 = new Cliente("Laura", "Diniz", "laura@gmail.com", "F");
		Cliente c3 = new Cliente("Paulo", "Souza", "paulo@gmail.com", "F");
		
		Servico s1 = new Servico("Fiação elétrica", 110.0, 5, 5);
		Servico s2 = new Servico("Reparo em eletrodomésticos", 100.0, 4, 6);
		Servico s3 = new Servico("Encanador", 70.0, 3, 4);
		
		Comissionado f1 = new Comissionado("Rodrigo", "Guedes", "rodrigo@gmail.com", "M", 20);
		Horista f2 = new Horista("Maria", "Tereza", "maria@gmail.com", "F");
		Assalariado f3 = new Assalariado("Hilton", "Marins", "hilton@gmail.com", "M", 20000);
		
		Contrato contract1 = new Contrato(c1, f1, s1);
		Contrato contract2 = new Contrato(c2, f2, s2);
		Contrato contract3 = new Contrato(c3, f3, s3);
		
		System.out.println("--------");
		System.out.println("O salário calculado da funcionária "+contract1.getFuncionario().getNome()+ 
				" na prestação de serviço de código "+contract1.getServico().getCodigo() +
				" do contrato "+contract1.getNum_ordem()+" foi de R$ "+contract1.consultaSalario());

		System.out.println("\nO salário calculado da funcionária "+contract2.getFuncionario().getNome()+ 
				" na prestação de serviço de código "+contract2.getServico().getCodigo() +
				" do contrato "+contract2.getNum_ordem()+" foi de R$ "+contract2.consultaSalario());
		
		System.out.println("\nO salário do funcionário "+contract3.getFuncionario().getNome()+ 
				" é fixo, ele recebe o valor mensal de R$ "+contract3.consultaSalario());
	}

}
