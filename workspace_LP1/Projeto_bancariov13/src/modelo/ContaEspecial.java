package modelo;

public class ContaEspecial extends Conta {

	private double limite;
	private final String identificacao = "Conta Especial";

	public ContaEspecial(Clientes cliente, double saldo, double limite) {
		super(cliente, saldo);
		this.limite = limite;
	}

	public ContaEspecial(Conta c) {
		super(c);
	}

	@Override
	public boolean saca(double valor) throws SaldoIndisponivel {
		if (valor > (this.getSaldo() + limite)) {
			throw new SaldoIndisponivel("Um saque inválido foi registrado!", this.getIdentificacao());
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}

	public String getIdentificacao() {
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
