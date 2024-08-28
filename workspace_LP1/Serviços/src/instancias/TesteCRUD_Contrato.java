package instancias;

import modelo.Assalariado;
import modelo.Cliente;
import modelo.Comissionado;
import modelo.Contrato;
import modelo.Funcionario;
import modelo.Historico;
import modelo.Horista;
import modelo.Pessoa;
import modelo.Servico;

public class TesteCRUD_Contrato {

	public static void main(String[] args) {

		// criando as instâncias da classe Cliente
		Cliente c1 = new Cliente("Lucas", "Lima", "lucas@gmail.com", "M");
		Cliente c2 = new Cliente("Ana", "Carolina", "ana@gmail.com", "F");
		
		// criando as instâncias da classe Serviço
		Servico s1 = new Servico("Pintura", 50.0, 5, 6);
		Servico s2 = new Servico("Encanamento", 70.0, 3, 4);
		Servico s3 = new Servico("Eletricista", 90.0, 4, 5);

		// criando as instâncias da classe Funcionario
		Funcionario f1 = new Assalariado("Gabriela", "Rezende", "gabriela@gmail.com", "F", 1500.0);
		Funcionario f2 = new Comissionado("Pedro", "Augusto", "pedro@gmail.com", "M", 800, s2);
		Funcionario f3 = new Horista("Pedro", "Augusto", "pedro@gmail.com", "M", s3);
		
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
