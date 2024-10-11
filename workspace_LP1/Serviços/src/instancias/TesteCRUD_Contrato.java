package instancias;

import excecao.LimiteHoras;
import modelo.Assalariado;
import modelo.Cliente;
import modelo.Comissionado;
import modelo.Contrato;
import modelo.Funcionario;
import modelo.HistoricoContratos;

import modelo.Servico;

public class TesteCRUD_Contrato {

	public static void main(String[] args) {

		// criando as instâncias da classe Cliente
		Cliente c1 = new Cliente("Lucas", "Lima", "lucas@gmail.com", "M");
		Cliente c2 = new Cliente("Ana", "Carolina", "ana@gmail.com", "F");

		Funcionario f1 = new Assalariado("Gabriela", "Rezende", "gabriela@gmail.com", "F", 1500.0);
		Funcionario f2 = new Comissionado("Pedro", "Augusto", "pedro@gmail.com", "M", 800);

		HistoricoContratos historico = new HistoricoContratos();

		Servico s1;
		try {
			s1 = new Servico("Pintura", 50.0, 5, 6);
			Contrato contrato1 = new Contrato(c1, f1, s1);

			// testando o método adiciona da classe Historico
			System.out.println("\n-----------------");
			if (historico.adiciona(contrato1)) {
				System.out.println("Contrato adicionado com sucesso!");
			} else {
				System.out.println("Este contrato já consta na lista!");
			}

			if (historico.adiciona(contrato1)) {
				System.out.println("Contrato adicionado com sucesso!");
			} else {
				System.out.println("Este contrato já consta na lista!");
			}

			// testando o método informacoes da classe Historico
			historico.informacoes(contrato1);

			System.out.println("\n-----------------");
			// testando o método remove da classe Historico
			if (historico.remove(contrato1)) {
				System.out.println("Contrato " + contrato1.getNum_ordem() + " removido com sucesso!");
			} else {
				System.out.println("Contrato não encontrado");
			}

		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());
		}

		Servico s2;
		try {
			s2 = new Servico("Encanamento", 70.0, 3, 4);
			Contrato contrato2 = new Contrato(c2, f2, s2);

			// testando o método adiciona da classe Historico
			if (historico.adiciona(contrato2)) {
				System.out.println("Contrato adicionado com sucesso!");
			} else {
				System.out.println("Este contrato já consta na lista!");
			}

		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());
		}

		// testando o método buscaContrato da classe Historico
		String num_ordem = "2024-2";
		Contrato contrato_pesquisado = historico.buscaContrato(num_ordem);
		if (contrato_pesquisado == null) {
			System.out.println("Contrato " + num_ordem + " não encontrado");
		} else {
			System.out.println(contrato_pesquisado.toString());
		}
	}
}
