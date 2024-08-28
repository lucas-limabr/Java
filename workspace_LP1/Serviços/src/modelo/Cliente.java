package modelo;

public class Cliente extends Pessoa implements Saudacao {

	private static int num_sequencial = 0;
	private static String letra_codigo = "C";
	private String msg;
	private String codigo;

	// construtor
	public Cliente(String nome, String sobrenome, String email, String sexo) {
		super(nome, sobrenome, email, sexo);
		this.codigo = gerarCodigo();
	}

	private String gerarCodigo() {
		Cliente.num_sequencial++;

		return letra_codigo + num_sequencial;
	}

	public String toString() {

		return "Nome: " + super.getNome() + "\nSobrenome: " + super.getSobrenome() + "\nEmail: "
				+ super.getEmail() + "\nSexo: " + super.getSexo() + "\nCódigo: " + getCodigo()
				+ "\n-----------------";
	}

	public String getCodigo() {
		return codigo;
	}

	@Override
	public String saudacao() {
		
		
		if(super.getSexo() == "M" || super.getSexo() == "m")
		{
			msg = "Prezado Senhor "
;		}
		else  {
			msg = "Prezada Senhora ";
		}
		
		return msg + super.getSobrenome();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	//TESTANDO
	
}
