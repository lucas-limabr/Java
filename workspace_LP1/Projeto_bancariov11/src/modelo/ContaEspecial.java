package modelo;

public class ContaEspecial extends Conta {
	
	private double limite;
	private String identificacao;

	public ContaEspecial(Clientes cliente, double saldo, double limite) {
		super(cliente, saldo);
		this.limite = limite;
	}
	
	@Override
	public boolean saca(double v) throws SaldoIndisponivel
	{
		if(this.getSaldo() + limite >= v)
		{
			super.saca(v);
			return true;
			
		}
		else
		{
			return false;
		}
	}
	
	public String getIdentificacao()
	{
		this.identificacao = "Conta Especial";
		return identificacao;
	}
}
