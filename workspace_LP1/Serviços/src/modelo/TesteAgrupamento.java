package modelo;

public class TesteAgrupamento {

	public static void main(String[] args) {

		Cliente c1 = new Cliente("Lucas", "Lima", "lucas@gmail.com", "M");
		Cliente c2 = new Cliente("Ana", "Carolina", "ana@gmail.com", "F");

		// criação da lista de clientes
		Agrupamento<Cliente> agrupamento_cliente = new Agrupamento<>();

		if (agrupamento_cliente.adiciona(c1)) {
			System.out.println("Cliente adicionado!");
		} else {
			System.out.println("Não foi possível adicionar o cliente!");
		}

		if (agrupamento_cliente.adiciona(c2)) {
			System.out.println("Cliente adicionado!");
		} else {
			System.out.println("Não foi possível adicionar o cliente!");
		}

		System.out.println("\nListagem de clientes");
		System.out.println(agrupamento_cliente.listagem());

		System.out.println("\nBusca de cliente");
		System.out.println(agrupamento_cliente.busca(c2));

		Funcionario f1 = new Assalariado("Gabriela", "Rezende", "gabriela@gmail.com", "F", 1500.0);
		Funcionario f2 = new Comissionado("Pedro", "Augusto", "pedro@gmail.com", "M", 800);

		// criação da lista de funcionários
		Agrupamento<Funcionario> agrupamento_funcionario = new Agrupamento<>();

		if (agrupamento_funcionario.adiciona(f1)) {
			System.out.println("\nFuncionário adicionado!");
		} else {
			System.out.println("Não foi possível adicionar o cliente!");
		}

		if (agrupamento_funcionario.adiciona(f2)) {
			System.out.println("Funcionário adicionado!");
		} else {
			System.out.println("Não foi possível adicionar o cliente!");
		}

		System.out.println("\nListagem de funcionários");
		System.out.println(agrupamento_funcionario.listagem());

		System.out.println("\nBusca de funcionários");
		System.out.println(agrupamento_funcionario.busca(f1));

		// remoção de clientes e de funcionários

		if (agrupamento_cliente.remove(c2)) {
			System.out.println("\nCliente removido!");
		} else {
			System.out.println("\nNão foi possível remover o cliente");
		}

		if (agrupamento_funcionario.remove(f1)) {
			System.out.println("\nFuncionário removido!");
		} else {
			System.out.println("\nNão foi possível remover o funcionário");
		}

		System.out.println("\nListagem de clientes");
		System.out.println(agrupamento_cliente.listagem());

		System.out.println("\nListagem de funcionários");
		System.out.println(agrupamento_funcionario.listagem());
	}
}
