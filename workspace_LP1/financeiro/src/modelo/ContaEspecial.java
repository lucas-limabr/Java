package modelo;

public class ContaEspecial extends Conta {

	private double limite;

	public ContaEspecial(double limite, Cliente cliente) {
		super(cliente);
		this.limite = limite;
	}
	
	public boolean saca(double v) {
		if ((this.getSaldo() + this.limite) >= v) {
			this.saldo = this.saldo - v;
			return true;
		}
		return false;
	}

	public double getSaldo() {
		return super.getSaldo() ;
	}

	@Override
	public String getIdentificacao() {
		return "Trata-se de uma conta Especial!";
	}
}