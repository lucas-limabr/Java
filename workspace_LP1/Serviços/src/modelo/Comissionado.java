package modelo;

public class Comissionado extends Funcionario {

	private double comissao;
	
	public Comissionado(String nome, String sobrenome, String email, String sexo, double comissao) {
		super(nome, sobrenome, email, sexo);
		this.comissao = comissao;
	}
	
	public Comissionado(Comissionado comissionado) {
		super(comissionado);
		this.comissao = comissionado.comissao;
	}

	@Override
	public double calculaSalario(Servico servico) {
		
		return servico.valorPago() * (comissao / 100);
	}

	@Override
	public String getFuncionario() {
		return "Funcionário Comissionado";
	}

	@Override
	public Funcionario fazCopia(Funcionario f) {
		return new Comissionado((Comissionado)f);
	}

}
