package modelo;

public class Candidato implements Comparable<Candidato> {

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
		return inscricao + " - "+ nome + " = "+ pontos;
	}

	public int compareTo(Candidato outroCandidato) {
		
		//essa ordenação de inscrição está em ordem ascendente. Caso queria uma
		//ordem descendente, apenas troque os returns, 1 e -1
		if(this.inscricao < outroCandidato.inscricao) {
			return -1;
		}
		else if(this.inscricao > outroCandidato.inscricao) {
			return 1;
		}
		//se o nº de inscrição for igual
		return 0;
	}
	
	
}
