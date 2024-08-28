package modelo;

public class Horista extends Funcionario {

	//composição
	private Servico servico;
	
	public Horista(String nome, String sobrenome, String email, String sexo, Servico s) {
		super(nome, sobrenome, email, sexo);
		this.servico = s;
	}

	@Override
	public double calculaSalario() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getFuncionario() {
		
		return "Funcionário Horista";
	}

}
