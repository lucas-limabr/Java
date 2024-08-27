package modelo;

public class Candidato {

	private String nome;
	private float pontos;
	private int inscricao;

	public Candidato(String nome, float pontos, int inscricao) {
		this.nome = nome;
		this.pontos = pontos;
		this.inscricao = inscricao;
	}

	@Override
	public String toString() {
		return inscricao + " - " + nome + " = " + pontos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getInscricao() {
		return inscricao;
	}

	public void setInscricao(int inscricao) {
		this.inscricao = inscricao;
	}
}
