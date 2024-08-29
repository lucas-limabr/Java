package instancias;

import excecao.LimiteHoras;
import modelo.Assalariado;
import modelo.Cliente;
import modelo.Comissionado;
import modelo.Contrato;
import modelo.Funcionario;
import modelo.Historico;
import modelo.Ranking;
import modelo.Servico;

public class TesteRanking {

	public static void main(String[] args) {
		
		Cliente c1 = new Cliente("Lucas", "Lima", "lucas@gmail.com", "M");
		Cliente c2 = new Cliente("Ana", "Carolina", "ana@gmail.com", "F");
		
		Funcionario f1 = new Assalariado("Gabriela", "Rezende", "gabriela@gmail.com", "F", 1500.0);
		Funcionario f2 = new Comissionado("Pedro", "Augusto", "pedro@gmail.com", "M", 800);
		
		Historico historico = new Historico();
		
		try {
			Servico s1 = new Servico("Pintura", 50.0, 5, 6);
			
			Contrato contrato1 = new Contrato(c1, f1, s1);
			historico.addContrato(contrato1);
			
		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Servico s2 = new Servico("Encanamento", 5000.0, 3, 4);
			
			Contrato contrato2 = new Contrato(c2, f2, s2);
			historico.addContrato(contrato2);
			
		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());
		}
		
		//Listagem de todos os clientes e seus totais de serviços contratados
		System.out.println(historico.listaClientesTotservicos());
		
		//Consultando o valor total dos serviços contratados por um cliente
		String codigo_cliente = "C2";
		System.out.println("\nO valor total pago em serviços contratados pelo cliente de código "+
		codigo_cliente +" foi de R$ "+ historico.valorTotPagoCliente(codigo_cliente));
		
		//c)Consultando a categoria de um cliente
		codigo_cliente = "C1";
		System.out.println("\nA categoria do cliente de código "+codigo_cliente+" é "+
		Ranking.getCategoria(c1));
		
		Servico s3;
		try {
			s3 = new Servico("Mecanico", 20000, 3, 10);
			//aqui o cliente c1 contratou mais um serviço, por isso, com este valor ele subiu de categoria
			//no ranking
			Contrato contrato3 = new Contrato(c1, f1, s3);
			historico.addContrato(contrato3);
		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());
		}
		
		codigo_cliente = "C1";
		//exibindo novamente a categoria de c1 depois dele ter contratado mais um serviço
		System.out.println("\nA categoria do cliente de código "+codigo_cliente+" é "+
		historico.consultarCategoriaCliente(codigo_cliente));
		
		System.out.println("-----");
		for(Cliente item : Ranking.getKeys()) {
			System.out.println("Cliente "+item.getNome()+": Valor "+Ranking.getCategoria(item));
		}
	}

}
