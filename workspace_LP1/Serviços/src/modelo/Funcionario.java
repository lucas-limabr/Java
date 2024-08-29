package modelo;

import java.math.BigDecimal;

public abstract class Funcionario extends Pessoa implements Saudacao {

	private static int num_sequencial = 0;
	private static String letra_codigo = "F";
	private String codigo;

	// construtor
	public Funcionario(String nome, String sobrenome, String email, String sexo) {
		super(nome, sobrenome, email, sexo);
		this.codigo = gerarCodigo();
	}
	
	//assegurando o encapsulamento
	public Funcionario(Funcionario funcionario) {
		super(funcionario);
		this.codigo = funcionario.codigo;
	}
	
	public abstract Funcionario fazCopia(Funcionario f);
	
	public abstract double calculaSalario(Servico servico);
	
	public abstract String getFuncionario();

	private String gerarCodigo() {
		Funcionario.num_sequencial++;

		return letra_codigo + num_sequencial;
	}

	public String toString() {

		return "Nome: " + super.getNome() + "\nSobrenome: " + super.getSobrenome() + "\nEmail: "
				+ super.getEmail() + "\nSexo: " + super.getSexo() + "\nCódigo: " + getCodigo()
				+ "\n-----------------";
	}

	// getter
	public String getCodigo() {
		return codigo;
	}
	
	@Override
	public String saudacao() {
		String msg = "";
		
		if(super.getSexo().equalsIgnoreCase("M"))
		{
			msg = "Prezado Senhor "
;		}
		else if(super.getSexo().equalsIgnoreCase("F"))  {
			msg = "Prezada Senhora ";
		}
		
		return msg + super.getNome() +" "+ super.getSobrenome();
	}
}
