package modelo;

public class Funcionario{
	//composição
	private Pessoas funcionario;
	
	private String codigo;

	//construtor
	public Funcionario(Pessoas funcionario, String codigo) {
		this.codigo = codigo;
		this.funcionario = funcionario;
	}
	
	public String toString() {
		
		return "Nome: " + funcionario.getNome() + "\nSobrenome: " + 
				funcionario.getSobrenome() + "\nEmail: "+ getFuncionario().getEmail()+ 
				"\nSexo: " + getFuncionario().getSexo() + "\nCódigo: " + getCodigo()+
				"\n-----------------";
	}
	
	//getter
	public String getCodigo() {
		return codigo;
	}
	
	public Pessoas getFuncionario() {
		//objeto encapsulado
		return new Pessoas(funcionario);
	}
}
