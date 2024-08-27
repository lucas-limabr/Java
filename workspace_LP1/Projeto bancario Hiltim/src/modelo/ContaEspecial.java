package modelo;

import excecao.SaldoInsuficienteException;

public class ContaEspecial extends Conta {

	private double limite;

	public ContaEspecial(double limite, Cliente cliente) {
		super(cliente);
		this.limite = limite;
	}
	
	public ContaEspecial(Conta c) {
		super(c);
	}
	
	public boolean saca(double v) throws SaldoInsuficienteException {
		if ((this.getSaldo() + this.limite) >= v) {
			this.saldo = this.saldo - v;
			return true;
		}
		throw new SaldoInsuficienteException(this.getIdentificacao());
	}

	@Override
	public String getIdentificacao() {
		return "conta Especial!";
	}
	
	@Override
	public Conta fazCopia(Conta c) {
		return new ContaEspecial(c);
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
}