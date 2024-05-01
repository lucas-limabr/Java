
public class Moeda {
	private double valor;
	private String descricao;
	
	public Moeda(double valor, String descricao) {
		
		this.valor = valor;
		this.descricao = descricao;
	}

	//métodos acessores e modificadores
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
