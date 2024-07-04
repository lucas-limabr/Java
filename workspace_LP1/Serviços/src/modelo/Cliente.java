package modelo;

public class Cliente {

	private static int num_sequencial = 0;
	private static String letra_codigo = "C";

	// composição
	private Pessoa cliente;
	private String codigo;

	// construtor
	public Cliente(Pessoa cliente) {
		this.cliente = cliente;
		this.codigo = gerarCodigo();
	}

	private String gerarCodigo() {
		Cliente.num_sequencial++;

		return letra_codigo + num_sequencial;
	}

	public String toString() {

		return "Nome: " + cliente.getNome() + "\nSobrenome: " + cliente.getSobrenome() + "\nEmail: "
				+ getCliente().getEmail() + "\nSexo: " + getCliente().getSexo() + "\nCódigo: " + getCodigo()
				+ "\n-----------------";
	}

	// getter
	public Pessoa getCliente() {
		// objeto encapsulado
		return new Pessoa(cliente);
	}

	public String getCodigo() {
		return codigo;
	}
}
