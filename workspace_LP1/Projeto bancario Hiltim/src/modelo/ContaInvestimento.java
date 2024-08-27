package modelo;

import excecao.SaldoInsuficienteException;

public class ContaInvestimento extends Conta{

	private double taxa;
	
	public ContaInvestimento(double taxa, Cliente cliente) {
		super(cliente);
		this.atualizaTaxa(taxa);
	}
	
	public ContaInvestimento(Conta c) {
		super(c);
	}
	
	public void atualizaSaldo() {
		this.deposita(this.getSaldo() * taxa/100);
	}
	
	public void atualizaTaxa(double t) {
		if (t < 0) {
			this.taxa = 0;
		}else {
			this.taxa = t;
		}
	}

	@Override
	public String getIdentificacao() {
		return "conta Investimento!";
	}

	public boolean saca(double v) throws SaldoInsuficienteException {
		if (v <= this.getSaldo() && v > 0) {
			this.saldo = this.saldo - v;
			return true;
		}
		throw new SaldoInsuficienteException(this.getIdentificacao());
	}
	
	@Override
	public Conta fazCopia(Conta c) {
		return new ContaInvestimento(c);
	}

}
