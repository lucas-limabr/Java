package modelo;

public class Servico {

	private String descricao;
	private double valor_hora;
	private double horas_previstas;
	private double horas_trabalhadas;
	private String codigo;

	// construtor
	public Servico(String descricao, double valor_hora, double horas_previstas, double horas_trabalhadas, String codigo) {

		this.descricao = descricao;
		this.valor_hora = valor_hora;
		this.horas_previstas = horas_previstas;
		this.horas_trabalhadas = horas_trabalhadas;
		this.codigo = codigo;
	}
	
	public Servico(Servico servico) {
		this.descricao = servico.descricao;
		this.valor_hora = servico.valor_hora;
		this.horas_previstas = servico.horas_previstas;
		this.horas_trabalhadas = servico.horas_trabalhadas;
		this.codigo = servico.codigo;
	}

	public double calculaOrcamento() {

		double valor_orcamento = valor_hora * horas_previstas;
		return valor_orcamento;
	}

	public double valorPago() {

		double valor_pg = valor_hora * horas_trabalhadas;
		return valor_pg;
	}

	public String toString() {
		
		return "Descrição: " + getDescricao() + "\nValor da hora: " + 
				getValor_hora() + "\nHoras previstas do serviço: "+ getHoras_previstas() + 
				"\nHoras efetivamente trabalhadas: " + getHoras_trabalhadas()+
				"\n-----------------";
		}
	
	//getters
		public String getDescricao() {
			return descricao;
		}

		public double getValor_hora() {
			return valor_hora;
		}

		public double getHoras_previstas() {
			return horas_previstas;
		}
		public double getHoras_trabalhadas() {
			return horas_trabalhadas;
		}
		public String getCodigo() {
			return codigo;
		}

		//setters
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public void setValor_hora(double valor_hora) {
			this.valor_hora = valor_hora;
		}

		public void setHoras_previstas(double horas_previstas) {
			this.horas_previstas = horas_previstas;
		}

		public void setHoras_trabalhadas(double horas_trabalhadas) {
			this.horas_trabalhadas = horas_trabalhadas;
		}

		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
}
