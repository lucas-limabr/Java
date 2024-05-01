package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Conta {
	private String numero;
	private Clientes cliente;
	private double saldo;
	private static LocalDate data_atual = LocalDate.of(2023, 04, 01);
	private static int num_sequencial;

	// 4 Construtores
	public Conta(Clientes cliente, double saldo) {
		this.numero = gerarNumero();
		this.cliente = cliente;
		this.saldo = saldo;
	}

	public Conta(Clientes cliente) {
		this.numero = gerarNumero();
		this.cliente = cliente;
	}

	public Conta(Conta conta) {
		this.numero = conta.numero;
		this.cliente = conta.cliente;
		this.saldo = conta.saldo;
	}

	// métodos
	public boolean deposita(double valor) {
		if (valor > 0) {
			this.saldo = this.saldo + valor;
			return true;
		}
		return false;
	}

	public boolean saca(double valor) {
		if (this.saldo >= valor) {
			this.saldo = this.saldo - valor;
			return true;
		}
		return false;
	}

	public boolean transfere(Conta destino, double valor) {
		if (this.saca(valor)) {
			if (destino.deposita(valor)) {
				return true;
			} else {
				this.deposita(valor); // estorno do valor
				return false;
			}
		}
		return false;
	}

	public void imprime() {
		System.out.println("--------------");
		System.out.println("Titular da conta: " + this.cliente.getNome());
		System.out.println("Número : " + this.numero);
		System.out.println("Saldo: " + this.saldo);
	}

	public String getNumero() {
		return numero;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	private String gerarNumero() {
		if (Conta.data_atual.getYear() != LocalDate.now().getYear()) {
			Conta.num_sequencial = 0;
			data_atual = LocalDate.now();
		}

		Conta.num_sequencial++;

		return data_atual.getYear() + "-" + num_sequencial;
	}
}
