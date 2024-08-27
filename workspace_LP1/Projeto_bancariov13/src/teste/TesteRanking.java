package teste;

import modelo.Clientes;
import modelo.Conta;
import modelo.ContaEspecial;
import modelo.ContaInvestimento;

public class TesteRanking {

	public static void main(String[] args) {
			
		Clientes cl1 = new Clientes(001, "Rodrigo", "rodri@gmail.com", "32928765", true);
		Clientes cl2 = new Clientes(002, "Ana", "ana@gmail.com", "32934765", false);
		Clientes cl3 = new Clientes(003, "Gabriela", "gabs@gmail.com", "32937765", false);
		
		ContaEspecial contaesp = new ContaEspecial(cl1, 10.001, 100);
		ContaInvestimento containvest = new ContaInvestimento(cl2, 20.000, 80);
		ContaEspecial contaesp2 = new ContaEspecial(cl3, 60.000, 100);
		
		System.out.println(cl1.equals(cl2));
		
		System.out.println(contaesp.consultarCategoria(001));
		System.out.println(containvest.consultarCategoria(002));
		System.out.println(contaesp2.consultarCategoria(003));
		
		System.out.println(Conta.listarClientesCategorias());
	}

}
