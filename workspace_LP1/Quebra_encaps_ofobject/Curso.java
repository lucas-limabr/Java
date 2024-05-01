
public class Curso {
	private int codigo;
	private String descricao;

	public Curso(int codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	//crio um construtor que receberá um objeto dele mesmo e manterá todos
	//os valores para os atributos
	public Curso(Curso curso) {
		this.codigo = curso.codigo;
		this.descricao = curso.descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
