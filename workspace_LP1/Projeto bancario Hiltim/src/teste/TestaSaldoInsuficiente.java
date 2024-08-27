package teste;

import java.util.ArrayList;

import excecao.SaldoInsuficienteException;
import modelo.Cliente;
import modelo.Conta;
import modelo.ContaEspecial;

public class TestaSaldoInsuficiente {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente(1, "José1", "jose1@email.com", 99991111, true);

		// operações com uma conta especial
		Conta c1 = new ContaEspecial(1000.0, cliente1);
		c1.deposita(1000);
		try {
			c1.saca(1400);
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getHistorico());
		}

		try {
			c1.saca(1400);
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getHistorico());
		}

		try {
			c1.saca(1000);
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getHistorico());
		}

		try {
			c1.saca(1200);
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getHistorico());
		}

		ArrayList lista = SaldoInsuficienteException.getHistorico();
		System.out.println("Histórico dos saques inválidos:");
		for (Object item : lista) {
			System.out.println(item);
		}
	}
}