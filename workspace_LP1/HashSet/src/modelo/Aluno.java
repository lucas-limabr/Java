package modelo;

public class Aluno {

	private String nome;
	
	public Aluno(String n) {
		this.nome = n;
	}

	@Override
	public String toString() {
		return "Nome=" + nome;
	}
}
