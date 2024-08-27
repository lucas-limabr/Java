package teste;

import java.util.Collections;
import java.util.List;

import criterios.NumContaAsc;
import modelo.Banco;
import modelo.Clientes;
import modelo.Conta;
import modelo.ContaEspecial;
import modelo.ContaInvestimento;

public class TesteOrdenacao {

	public static void main(String[] args) {
		
		Clientes cl1 = new Clientes(001, "Rodrigo", "rodri@gmail.com", "32928765", true);
		Clientes cl2 = new Clientes(002, "Ana", "ana@gmail.com", "32934765", false);
		
		ContaEspecial contaesp = new ContaEspecial(cl1, 1350, 100);
		ContaInvestimento containvest = new ContaInvestimento(cl2, 1360, 80);
		
		containvest.converteNumConta();
		
		Banco b1 = new Banco();
		
		b1.adicionaConta(containvest);
		b1.adicionaConta(contaesp);
		
		System.out.println(b1.ordenarContasAsc());
		System.out.println(b1.ordenarContasDesc());
		System.out.println(b1.ordenarSaldoDesc());
		
		System.out.println(b1.relatorioContaMaiorSaldo());
		System.out.println(b1.relatorioContaMenorSaldo());
	}

}
