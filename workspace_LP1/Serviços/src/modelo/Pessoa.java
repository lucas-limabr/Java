package modelo;

public class Pessoa {
	private String nome, sobrenome, email, sexo;
	
	//construtor
	public Pessoa(String nome, String sobrenome, String email, String sexo) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.sexo = sexo;
	}
	
	public Pessoa(Pessoa pessoas) {
		this.nome = pessoas.nome;
		this.sobrenome = pessoas.sobrenome;
		this.email = pessoas.email;
		this.sexo = pessoas.sexo;
	}
	
	//métodos getters
	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public String getSexo() {
		return sexo;
	}

	//métodos setters
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
