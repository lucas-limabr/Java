package teste;

import modelo.Cliente;
import modelo.Conta;

public class ContaUniversitaria extends Conta {

	public ContaUniversitaria(Cliente cliente) {
		super(cliente);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getIdentificacao() {
		return "Trata-se de uma conta Universitaria!";
	}

}
