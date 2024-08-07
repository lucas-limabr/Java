package teste;

import modelo.Cliente;
import modelo.ContaEspecial;

public class TestaContaEspecial {
	public static void main(String[] args) {
		Cliente cliente2 = new Cliente(2, "Ana", "ana@gmail.com", 9935);
		
		ContaEspecial ce = new ContaEspecial(200, cliente2);
				
		ce.deposita(100);
		
		System.out.println("Saldo: " + ce.getSaldo());
		if (ce.saca(300)){
			System.out.println("Saque efetuado com sucesso!");
		}else {
			System.out.println("Saldo Insuficiente!");
			
		}
		System.out.println("Saldo: " + ce.getSaldo());
	}
}
