package modelo;
import java.time.LocalDate;

import excecao.SaldoInsuficienteException;

public abstract class Conta {
	private String numero;
	protected double saldo;
	private Cliente cliente;
	private static int numeroSequencial = 0;
	private static LocalDate dataAtual = LocalDate.of(2024, 3, 27);
	
	public Conta(double saldo, Cliente cliente) {
		this.numero = geraNumeroConta();
		this.cliente = cliente;
		this.saldo = saldo;
	}
	
	public Conta(Cliente cliente) {
		this.numero = geraNumeroConta();
		this.cliente = cliente;
	}
	
	public Conta(Conta conta) {
		this.numero = conta.numero;
		this.cliente = conta.cliente;
		this.saldo = conta.saldo;
	}
		
	public boolean deposita(double valor) {
		if (valor > 0) {
			this.saldo = this.saldo + valor;
			return true;
		}
		return false;
	}

	public abstract boolean saca(double valor)throws SaldoInsuficienteException;

	boolean transfere(Conta destino, double valor) throws SaldoInsuficienteException {
		if (this.saca(valor)) {
			if (destino.deposita(valor)) {
				return true;
			} else {
				this.deposita(valor); //estorno do valor
				return false;
			}
		}
		return false;
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public Cliente getCliente() {
		return new Cliente(this.cliente);
	}
	
	public double getSaldo() {
		return this.saldo;
	};
	
	private String geraNumeroConta() {
		if (Conta.dataAtual.getYear() != LocalDate.now().getYear()) {
			Conta.numeroSequencial = 0;
			Conta.dataAtual = LocalDate.now();
		}
		Conta.numeroSequencial++;
		return dataAtual.getYear() + "-" + Conta.numeroSequencial;
	}

	public abstract String getIdentificacao();
	
	public abstract Conta fazCopia(Conta c);
}







