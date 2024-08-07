package modelo;

public class ContaInvestimento extends Conta{

	private double taxa;
	
	public ContaInvestimento(double taxa, Cliente cliente) {
		super(cliente);
		this.atualizaTaxa(taxa);
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
		return "Trata-se de uma conta Investimento!";
	}

}
