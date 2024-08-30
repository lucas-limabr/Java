package modelo;

public class Assalariado extends Funcionario {

	private double salario;

	
	public Assalariado(String nome, String sobrenome, String email, String sexo, double salario) {
		super(nome, sobrenome, email, sexo);
		this.salario = salario;
	}
	
	public Assalariado(Assalariado assalariado) {
		super(assalariado);
		this.salario = assalariado.salario;
	}
	
	public Funcionario fazCopia(Funcionario f) {
		return new Assalariado((Assalariado)f);
	}

	@Override
	public double calculaSalario(Servico servico) {
		return salario;
	}

	@Override
	public String getFuncionario() {
		return "Funcionário Assalariado";
	}
}
