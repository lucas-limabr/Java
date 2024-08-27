package teste;

import modelo.Banco;
import modelo.Clientes;
import modelo.ContaEspecial;
import modelo.ContaInvestimento;

import java.util.ArrayList;
import modelo.Conta;

public class TesteEncapsulamento {

	public static void main(String[] args) {

		Clientes cl1 = new Clientes(001, "Rodrigo", "rodri@gmail.com", "32928765", true);
		Clientes cl2 = new Clientes(010, "Léo", "leo@gmail.com", "32928741", true);

		ContaEspecial contaesp = new ContaEspecial(cl1, 500, 100);

		Banco b1 = new Banco();

		b1.adicionaConta(contaesp);

		ArrayList<Conta> copia = b1.getListaContas();

		copia.get(0).setSaldo(1);

		System.out.println("Saldo: " + contaesp.getSaldo());
		
		//--------------

		ContaInvestimento containvest = new ContaInvestimento(cl2, 1000, 80);
		
		Banco b2 = new Banco();

		b2.adicionaConta(containvest);

		ArrayList<Conta> copia2 = b2.getListaContas();

		copia2.get(0).setSaldo(1);;
		
		System.out.println("Saldo: " + containvest.getSaldo());
	}

}
