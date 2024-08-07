package modelo;

public class Clientes {
	private int codigo;
	private String nome;
	private String email;
	private String telefone;
	private boolean sexo;

	public Clientes(int codigo, String nome, String email, String telefone, boolean sexo) {
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		if (sexo) {
			return "Senhor "+this.nome;
		}
		
		return "Senhora "+this.nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}
}
