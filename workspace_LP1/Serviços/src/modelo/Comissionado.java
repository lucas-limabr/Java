package modelo;

public class Comissionado extends Funcionario {

	private double comissao;
	
	//composição
	private Servico servico;
	
	public Comissionado(String nome, String sobrenome, String email, String sexo, double comissao, Servico s) {
		super(nome, sobrenome, email, sexo);
		this.comissao = comissao;
		this.servico = s;
	}

	@Override
	public double calculaSalario() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getFuncionario() {
		return "Funcionário Comissionado";
	}

}
