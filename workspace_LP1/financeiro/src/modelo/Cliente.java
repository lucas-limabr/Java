package modelo;

public class Cliente {
	private int codigo;
	private String nome;
	private String email;
	private int telefone;
	private boolean sexo;

	public Cliente(int codigo, String nome, String email, int telefone, boolean sexo) {
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.sexo = sexo;
	}

	public Cliente(Cliente cliente) {
		this(cliente.codigo,cliente.nome, cliente.email, cliente.telefone, cliente.sexo);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toString() {
		if (this.sexo) {
			return "Senhora " + this.nome;
		} else {
			return "Senhor " + this.nome;
		}
	}
}
