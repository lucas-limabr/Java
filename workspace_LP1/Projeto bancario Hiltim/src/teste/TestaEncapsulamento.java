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
		
		//a linha abaixo n�o executa, pois, copia_lista � do tipo Conta
		//e o m�todo setLimite est� definido em sua subclasse, a superclasse
		//n�o tem acesso aos m�todos de sua subclasse e sim o contr�rio
		//System.out.println(copia_lista.get(0).setLimite(100)); 
	}

}
