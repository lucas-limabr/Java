package modelo;

public class ContaEspecial extends Conta {
	
	private double limite;
	private final String identificacao = "Conta Especial";

	public ContaEspecial(Clientes cliente, double saldo, double limite) {
		super(cliente, saldo);
		this.limite = limite;
	}
	
	public ContaEspecial(Conta ce) {
		super(ce);
	}
	
	@Override
	public boolean saca(double v)
	{
		if(this.getSaldo() + limite >= v)
		{
			this.setSaldo(this.getSaldo() - v);
			return true;
			
		}
		else
		{
			return false;
		}
	}
	
	public String getIdentificacao()
	{
		return identificacao;
	}

	@Override
	public Conta encapsulaContas(Conta c) {
		return new ContaEspecial(c);
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
}
