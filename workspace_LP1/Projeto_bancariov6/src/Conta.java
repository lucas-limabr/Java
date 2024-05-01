
import java.util.Random;

public class Conta {
	private int numero;
	private Clientes cliente;
	private double saldo;

	//3 Construtores
	Conta( Clientes cliente, int numero, double saldo) {
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = saldo;
	}
	
	Conta(Clientes cliente, double saldo) {
		Random aleatorio = new Random();
		this.numero = aleatorio.nextInt(10000);
		this.cliente = cliente;
		this.saldo = saldo;
	}
	
	Conta(Clientes cliente) {
		Random aleatorio = new Random();
		this.numero = aleatorio.nextInt(10000);
		this.cliente = cliente;
	}

	//métodos
	boolean deposita(double valor) {
		if (valor > 0) {
			this.saldo = this.saldo + valor;
			return true;
		}
		return false;
	}

	boolean saca(double valor) {
		if (this.saldo >= valor) {
			this.saldo = this.saldo - valor;
			return true;
		}
		return false;
	}

	boolean transfere(Conta destino, double valor) {
		if (this.saca(valor)) {
			if (destino.deposita(valor)) {
				return true;
			} else {
				this.deposita(valor); //estorno do valor
				return false;
			}
		}
		return false;
	}
	
	void imprime() {
		System.out.println("--------------");
		System.out.println("Titular da conta: " + this.cliente.getNome());
		System.out.println("Número : " + this.numero);
		System.out.println("Saldo: " + this.saldo);
	}

	public int getNumero() {
		return numero;
	}
	
	public Clientes getCliente() {
		return cliente;
	}

	public double getSaldo() {
		return saldo;
	}
}
