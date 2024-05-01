package modelo;

public class Cliente {
	//composição
	private Pessoas cliente;
	private String codigo;

	// construtor
	public Cliente(Pessoas cliente, String codigo) {
		this.cliente = cliente;
		this.codigo = codigo;
	}
	
	public String toString() {

		return "Nome: " + cliente.getNome() + "\nSobrenome: " + 
		cliente.getSobrenome() + "\nEmail: "+ getCliente().getEmail() + 
		"\nSexo: " + getCliente().getSexo() + "\nCódigo: " + getCodigo()+
		"\n-----------------";
	}
	
	// getter
		public Pessoas getCliente() {
			//objeto encapsulado
			return new Pessoas(cliente);
		}

		public String getCodigo() {
			return codigo;
		}
}
