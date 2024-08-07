package teste;

import modelo.Banco;
import modelo.Clientes;
import modelo.ContaEspecial;
import java.util.ArrayList;
import modelo.Conta;

public class TesteEncapsulamento {

	public static void main(String[] args) {
		
		Clientes cl1 = new Clientes(001, "Rodrigo", "rodri@gmail.com", "32928765", true);
		
		ContaEspecial contaesp = new ContaEspecial(cl1, 500, 100);
		
		Banco b1 = new Banco();
		
		b1.adicionaConta(contaesp);
		
		ArrayList<Conta> copia = b1.getListaContas();
		
		copia.get(0).setSaldo(1);
		
		System.out.println("Saldo: "+contaesp.getSaldo());
	}

}
