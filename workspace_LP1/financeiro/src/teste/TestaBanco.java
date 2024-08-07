package teste;

import java.util.ArrayList;

import modelo.Banco;
import modelo.Cliente;
import modelo.Conta;

public class TestaBanco {
	public static void main(String[] args) {
		Cliente cliente1 = new Cliente(1, "Jo�o", "joao@gmail.com", 99945334);
		Cliente cliente2 = new Cliente(2, "Ana", "ana@gmail.com", 9935);
		Cliente cliente3 = new Cliente(3, "Z�", "ze@gmail.com", 888);

		Conta c1 = new Conta(100, cliente1);
		Conta c2 = new Conta(200, cliente2);
		Conta c3 = new Conta(300, cliente3);

		Banco banco = new Banco();

		banco.adicionaConta(c1);
		banco.adicionaConta(c2);
		banco.adicionaConta(c3);

		System.out.println("Listagem 1 das contas: ");
		for (Conta c : banco.getContas()) {
			System.out.println(c.getNumero()+"-"+c.getCliente().getNome() + " - " + c.getSaldo());
		}
		//testa busca de conta pelo numero
		Conta conta = (banco.getConta("2024-2"));
		if (conta == null) {
			System.out.println("Conta de n�mero 2024-2 Inexistente!");
		}else {
			System.out.println("Conta de n�mero 2024-2 - "+conta.getCliente().getNome() + " - " + conta.getSaldo());
			
		}
		
		// c�digo em que testamos a quebra de encapsulamento
		ArrayList<Conta> lista = banco.getContas();
		lista.get(0).getCliente().setNome("Nome alterado");
		lista.get(1).deposita(100000);
		

		System.out.println("Listagem 2 das contas: ");
		for (Conta c : banco.getContas()) {
			System.out.println(c.getNumero()+"-"+c.getCliente().getNome() + " - " + c.getSaldo());
		}
	}
}
