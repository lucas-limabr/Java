package teste;

import java.util.ArrayList;

import modelo.Banco;
import modelo.Cliente;
import modelo.Conta;
import modelo.ContaEspecial;

public class TestaEncapsulamento {

	public static void main(String[] args) {

		Cliente cliente2 = new Cliente(001, "Ana", "ana@gmail.com", 9935, true);

		ContaEspecial ce = new ContaEspecial(500, cliente2);
		
		Banco b1 = new Banco();
		
		b1.adicionaConta(ce);
		
		ArrayList<Conta> copia_lista = b1.getContas();
		
		//a linha abaixo não executa, pois, copia_lista é do tipo Conta
		//e o método setLimite está definido em sua subclasse, a superclasse
		//não tem acesso aos métodos de sua subclasse e sim o contrário
		//System.out.println(copia_lista.get(0).setLimite(100)); 
	}

}
