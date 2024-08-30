public class Aluno extends Usuario {
	private String curso;

	public Aluno(String nome, String email, String sexo, String curso) {
		super(nome, email, sexo);
		this.curso = curso;
	}

	public String getCurso() {
		return curso;
	}

	@Override
	public String tratamento() {
		return (getSexo().equalsIgnoreCase("M") ? "Aluno " : "Aluna ") + getNome();
	}
}
