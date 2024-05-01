
public class TestaBanco {
	public static void main(String[] args) {
		
		// 1
		Conta c1 = new Conta(2030, "João", 100.0);
		Conta c2 = new Conta("Daniel", 500.0);
		Conta c3 = new Conta(4025, "André", 350.0);
		Conta c4 = new Conta("Pedro", 1000.0);
		Conta c5 = new Conta("Rafael");

		// 2
		Banco banco1 = new Banco();

		// 3
		banco1.adicionaConta(c1);
		banco1.adicionaConta(c2);
		banco1.adicionaConta(c3);
		banco1.adicionaConta(c4);
		banco1.adicionaConta(c5);

		// 4
		Conta c6 = new Conta("Jhon");

		if (banco1.adicionaConta(c6)) {
			System.out.println("Conta c6 adicionada com sucesso");
		} else {
			System.out.println("A conta c6 não pôde ser adicionada, pois, o tamanho limite de contas foi excedido");
		}
		
		System.out.println("No Banco 1 existem " + banco1.getTotalContas() + " contas");
		
		// exibindo todas as contas do banco 1
		System.out.println("Banco 1");
		for (Conta conta : banco1.getListaContas()) {
				banco1.imprime(conta);
		}

		// 5
		Banco banco2 = new Banco();

		// 6
		Conta c7 = new Conta("Lucas");
		Conta c8 = new Conta("Rodrigo", 1000.0);
		Conta c9 = new Conta(2070, "Léo", 300.0);

		banco2.adicionaConta(c7);
		banco2.adicionaConta(c8);
		banco2.adicionaConta(c9);

		Conta c10 = new Conta("Isabela");

		System.out.println("");
		if (banco2.adicionaConta(c10)) {
			System.out.println("Conta c10 adicionada com sucesso");
		} else {
			System.out.println("A conta c10 não pôde ser adicionada, pois, o tamanho limite de contas foi excedido");
		}

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
		if (banco1.getConta(2030) != null) {
			banco1.imprime(banco1.getConta(2030));
			
		} else {
			System.out.println("Conta não encontrada no  banco 1");
		}

		// testando getConta() para o banco 2
		if (banco2.getConta(2070) != null) {
			banco2.imprime(banco2.getConta(2070));
		} else {
			System.out.println("Conta não encontrada no banco 2");
		}
	}
}
