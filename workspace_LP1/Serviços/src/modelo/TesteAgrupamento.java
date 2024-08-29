package modelo;

import excecao.LimiteHoras;

public class TesteAgrupamento {

	public static void main(String[] args) {

		Cliente c1 = new Cliente("Lucas", "Lima", "lucas@gmail.com", "M");
		Cliente c2 = new Cliente("Ana", "Carolina", "ana@gmail.com", "F");
		Cliente c3 = new Cliente("João", "Almeida", "joao@gmail.com", "M");

		Funcionario f1 = new Assalariado("Gabriela", "Rezende", "gabriela@gmail.com", "F", 1500.0);
		Funcionario f2 = new Comissionado("Pedro", "Augusto", "pedro@gmail.com", "M", 800);
		Funcionario f3 = new Horista("Pedro", "Augusto", "pedro@gmail.com", "M");

		// criação da lista
		Agrupamento<Contrato> lista = new Agrupamento<>();

		try {
			Servico s1 = new Servico("Pintura", 50.0, 5, 6);
			Contrato contrato1 = new Contrato(c1, f1, s1);
			lista.adiciona(contrato1);

		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());
		}

		try {
			Servico s2 = new Servico("Encanamento", 70.0, 3, 4);
			Contrato contrato2 = new Contrato(c2, f2, s2);
			lista.adiciona(contrato2);

			// buscando por um elemento da lista
			System.out.println(lista.busca(contrato2));

		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Servico s3 = new Servico("Eletricista", 90.0, 6, 7);
			Contrato contrato3 = new Contrato(c3, f3, s3);
			lista.adiciona(contrato3);
			
			//removendo um elemento da lista
			if(lista.remove(contrato3)) {
				System.out.println("\nContrato removido com sucesso");
			}
			else {
				System.out.println("\nContrato não encontrado");
			}
			
		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());
		}

		// listando todos os elementos da lista
		System.out.println(lista.listagem());
			
	}
}
