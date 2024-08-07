package teste;

import modelo.Cliente;
import modelo.Conta;
import modelo.ContaEspecial;

public class TestaTratamento {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente(1, "João", "joao@gmail.com", 99945334, false);
		Cliente cliente2 = new Cliente(2, "Ana", "ana@gmail.com", 9935, true);
		
		Conta c1 = new ContaEspecial(100, cliente1);
		Conta c2 = new ContaEspecial(200, cliente2);
		
		System.out.println(c1.getCliente());
		System.out.println(c2.getCliente());
		
	
	}

}
