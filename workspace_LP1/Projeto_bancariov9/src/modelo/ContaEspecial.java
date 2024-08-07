package modelo;

public class ContaEspecial extends Conta {
	
	private double limite;

	public ContaEspecial(Clientes cliente, double saldo, double limite) {
		super(cliente, saldo);
		this.limite = limite;
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
}
