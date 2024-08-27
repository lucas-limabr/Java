package modelo;

public class Candidato implements Comparable<Candidato> {
	
	private String nome;
	private double pontos;
	private int inscricao;

	public Candidato(String nome, float pontos, int inscricao) {
		this.nome = nome;
		this.pontos = pontos;
		this.inscricao = inscricao;
	}

	@Override
	public String toString() {
		return pontos + " - " + nome + " = " + inscricao;
	}

	//quero ordenar por n critérios aplicados SIMULTANENAMENTE à lista. Os critérios 
	//de ordenação precisam respeitar essa ordem: ordenar por pontos (asc), nome (asc) 
	//e inscrição (desc)
	//toda esta implementação poderia ser feita utilizando o método compare
	//da interface Comparator também
	public int compareTo(Candidato candidato) {
		
		int compare_pontos = Double.compare(this.pontos, candidato.pontos);
		if(compare_pontos != 0) {
			return compare_pontos;
		}
		
		int compare_nome = this.nome.compareTo(candidato.nome);
		if(compare_nome != 0) {
			return compare_nome;
		}
		
		int compare_inscricao = Integer.compare(this.inscricao, candidato.inscricao);
		return compare_inscricao * -1;
	}

	
}
