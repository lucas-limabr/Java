package modelo;

public class Horista extends Funcionario {

	public Horista(String nome, String sobrenome, String email, String sexo) {
		super(nome, sobrenome, email, sexo);
	}
	
	public Horista(Horista horista) {
		super(horista);
	}

	@Override
	public double calculaSalario(Servico servico) {
		
		return servico.valorPago();
	}

	@Override
	public String getFuncionario() {
		
		return "Funcionário Horista";
	}

	@Override
	public Funcionario fazCopia(Funcionario f) {
		return new Horista((Horista) f);
	}

}
