package modelo;

public class ContaInvestimento extends Conta {

	private double taxa;
	private String identificacao;

	public ContaInvestimento(Clientes cliente, double saldo, double taxa) {
		super(cliente, saldo);
		this.atualizaTaxa(taxa);
	}
	
	public void atualizaSaldo()
	{
		this.setSaldo(this.getSaldo() * (taxa + 100)/100);
	}
	
	public void atualizaTaxa(double t)
	{
		if(t <= 0)
		{
			this.taxa = 0;
		}
		else {
			this.taxa = t;
		}
	}

	@Override
	public String getIdentificacao() {
		this.identificacao = "Conta Investimento";
		return identificacao;
	}
}
