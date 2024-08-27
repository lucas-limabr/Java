package modelo;

public class ContaInvestimento extends Conta {

	private double taxa;
	private final String identificacao = "Conta Investimento";

	public ContaInvestimento(Clientes cliente, double saldo, double taxa) {
		super(cliente, saldo);
		this.atualizaTaxa(taxa);
	}
	
	public ContaInvestimento(Conta c) {
		super(c);
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
		return identificacao;
	}

	@Override
	public Conta encapsulaContas(Conta c) {
		return new ContaInvestimento(c);
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
}
