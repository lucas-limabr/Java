package teste;
import java.util.ArrayList;

import modelo.Banco;
import modelo.Clientes;
import modelo.Conta;

public class TestaBanco {
	public static void main(String[] args) {
		
		Clientes cl1 = new Clientes(001, "Rodrigo", "rodri@gmail.com", "32928765");
		Clientes cl2 = new Clientes(010, "Léo", "leo@gmail.com", "32928741");
		Clientes cl3 = new Clientes(011, "Bruno", "bruno@gmail.com", "32928712");
		Clientes cl4 = new Clientes(100, "Isa", "isa@gmail.com", "32928775");
		Clientes cl5 = new Clientes(011, "Lorran", "lorran@gmail.com", "32928733");
		
		Conta c1 = new Conta(cl1, 100.0);
		Conta c2 = new Conta(cl2, 500.0);
		Conta c3 = new Conta(cl3,350.0);
		Conta c4 = new Conta(cl4, 1000.0);
		Conta c5 = new Conta(cl5);

		Banco banco1 = new Banco();

		banco1.adicionaConta(c1);
		banco1.adicionaConta(c2);
		banco1.adicionaConta(c3);
		banco1.adicionaConta(c4);
		banco1.adicionaConta(c5);

		System.out.println("No Banco 1 existem " + banco1.getTotalContas() + " contas");
		
		// exibindo todas as contas do banco 1
		System.out.println("Banco 1");
		for (Conta conta : banco1.getListaContas()) {
				banco1.imprime(conta);
		}

		Banco banco2 = new Banco();

		Clientes cl6 = new Clientes(101, "Lucas", "lucas@gmail.com", "32928744");
		Clientes cl7 = new Clientes(011, "Marcos", "marcos@gmail.com", "32928781");
		Clientes cl8 = new Clientes(110, "João", "joão@gmail.com", "32928747");
		
		Conta c7 = new Conta(cl6);
		Conta c8 = new Conta(cl7, 1000.0);
		Conta c9 = new Conta(cl8, 300.0);

		banco2.adicionaConta(c7);
		banco2.adicionaConta(c8);
		banco2.adicionaConta(c9);

		// exibindo todas as contas do banco 2
		System.out.println("---------------");
		System.out.println("Banco 2");
		for (Conta conta : banco2.getListaContas()) {
			banco2.imprime(conta);
		}

		// testando getTotalContas() para banco1 e banco2
		System.out.println("");
		System.out.println("No Banco 1 existem " + banco1.getTotalContas() + " contas");
		System.out.println("No Banco 2 existem " + banco2.getTotalContas() + " contas");

		System.out.println();
		System.out.println("Busca de contas");
		// testando getConta() para o banco 1
		if (banco1.getConta("2024-2") != null) {
			banco1.imprime(banco1.getConta("2024-2"));
			
		} else {
			System.out.println("Conta não encontrada no  banco 1");
		}

		// testando getConta() para o banco 2
		if (banco2.getConta("2024-8") != null) {
			banco2.imprime(banco2.getConta("2024-8"));
		} else {
			System.out.println("Conta não encontrada no banco 2");
		}
		
		//fazendo uma copia do objeto listaContas do banco 2
		ArrayList<Conta> copia_listaContas = banco2.getListaContas();
		
		for(int i = 0; i < copia_listaContas.size(); i++) {
			copia_listaContas.get(i).setNumero("2000");
		}
		
		//imprimindo todos os números de conta do banco2 do objeto original, constatando
		//que nada foi alterado
		System.out.println("");
		System.out.println("Dados do banco 2 não foram alterados na cópia do array");
		for(Conta conta : banco2.getListaContas()) {
			banco2.imprime(conta);
		}
	}
}
