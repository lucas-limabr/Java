package modelo;

public class Funcionario {

	private static int num_sequencial = 0;
	private static String letra_codigo = "F";

	// composição
	private Pessoa funcionario;

	private String codigo;

	// construtor
	public Funcionario(Pessoa funcionario) {
		this.funcionario = funcionario;
		this.codigo = gerarCodigo();
	}

	private String gerarCodigo() {
		Funcionario.num_sequencial++;

		return letra_codigo + num_sequencial;
	}

	public String toString() {

		return "Nome: " + funcionario.getNome() + "\nSobrenome: " + funcionario.getSobrenome() + "\nEmail: "
				+ getFuncionario().getEmail() + "\nSexo: " + getFuncionario().getSexo() + "\nCódigo: " + getCodigo()
				+ "\n-----------------";
	}

	// getter
	public String getCodigo() {
		return codigo;
	}

	public Pessoa getFuncionario() {
		// objeto encapsulado
		return new Pessoa(funcionario);
	}
}
