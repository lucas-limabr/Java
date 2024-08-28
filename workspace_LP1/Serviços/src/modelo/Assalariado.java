package modelo;

public class Assalariado extends Funcionario {

	private double salario;
	
	public Assalariado(String nome, String sobrenome, String email, String sexo, double salario) {
		super(nome, sobrenome, email, sexo);
		this.salario = salario;
	}

	@Override
	public double calculaSalario() {
		return salario;
	}

	@Override
	public String getFuncionario() {
		return "Funcionário Assalariado";
	}

}
