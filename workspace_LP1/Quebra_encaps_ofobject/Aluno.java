
public class Aluno {
	private String nome;
	private Curso curso;

	public Aluno(String nome, Curso curso) {
		this.nome = nome;
		this.curso = curso;
	}

	@Override
	public String toString() {
		return nome + " - " + curso;
	}

	public Curso getCurso() {
		//passo o objeto a ser retornado para o construtor da classe deste
		//objeto e a palavra chave new, que enviará para quem está chamando este 
		//método uma CÓPIA do objeto curso. Assim os atributos da Classe curso
		//estarão devidamente encapsulados
		return new Curso(curso);
	}
}
