package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public abstract class Conta {
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

	public abstract Conta encapsulaContas(Conta c);

	// m�todos
	public boolean deposita(double valor) {
		if (valor > 0) {
			this.saldo = this.saldo + valor;
			return true;
		}
		return false;
	}

	public boolean saca(double valor) throws SaldoIndisponivel {
		if (valor > saldo) {
			throw new SaldoIndisponivel("Um saque inv�lido foi registrado!", this.getIdentificacao());
		}

		this.saldo = this.saldo - valor;
		return true;
	}

	public boolean transfere(Conta destino, double valor) throws SaldoIndisponivel {
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

	public String imprime() {
		return "---------" + "\nTitular da conta: " + this.getCliente().getNome() + "" + "\nN�mero : "
				+ this.getNumero() + "\nSaldo: " + this.getSaldo();
	}

	public abstract String getIdentificacao();

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

	public int converteNumConta() {
		String partes[] = this.numero.split("-");

		int ano = Integer.parseInt(partes[0]);
		int num_sequencial = Integer.parseInt(partes[1]);

		return ano + num_sequencial;
	}
}
