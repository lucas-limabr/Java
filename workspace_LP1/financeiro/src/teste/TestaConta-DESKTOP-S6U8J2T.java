package teste;

import modelo.Cliente;
import modelo.Conta;

public class TestaConta {
	public static void main(String[] args) {
		Cliente cliente1 = new Cliente(1, "João", "joao@gmail.com", 99945334);
		Cliente cliente2 = new Cliente(2, "Ana", "ana@gmail.com", 9935);
				
		Conta c1 = new Conta(100, cliente1);
		Conta c2 = new Conta(200, cliente2);
		
		System.out.println("Saldo do " + c1.getCliente().getNome() + ": " + c1.getSaldo());
		System.out.println("Saldo do " + c2.getCliente().getNome() + ": " + c2.getSaldo());
		
		
		while() {
			
			Conta c = new Conta():
				
		}
	}
}
