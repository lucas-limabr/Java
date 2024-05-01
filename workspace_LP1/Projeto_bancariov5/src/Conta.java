
import java.util.Random;

public class Conta {
	private int numero;
	private String titular;
	private double saldo;

	//3 Construtores
	Conta(int numero, String titular, double saldo) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	Conta(String titular, double saldo) {
		Random aleatorio = new Random();
		this.numero = aleatorio.nextInt(10000);
		this.titular = titular;
		this.saldo = saldo;
	}
	
	Conta(String titular) {
		Random aleatorio = new Random();
		this.numero = aleatorio.nextInt(10000);
		this.titular = titular;
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
		System.out.println("Titular da conta: " + this.titular);
		System.out.println("Número : " + this.numero);
		System.out.println("Saldo: " + this.saldo);
	}

	public int getNumero() {
		return numero;
	}

	public String getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}
}
