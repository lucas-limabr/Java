import java.util.Arrays;

public class Banco {
	Conta[] listaContas;

	Banco(int n) {
		listaContas = new Conta[n];
	}

	Banco() {
		listaContas = new Conta[50];

	}

	boolean adicionaConta(Conta c) {

		for (int i = 0; i < listaContas.length; i++) {
			if (listaContas[i] == null) {
				listaContas[i] = c;

				return true;
			}
		}
		return false;
	}

	Conta getConta(int n) {
		for (Conta conta : listaContas) {
			if (conta != null && conta.numero == n) {

				return conta;
			}
		}
		return null;
	}

	int getTotalContas() {
		int tot_contas = 0;

		for (Conta c : listaContas) {
			if (c != null) {
				tot_contas++;
			} else {
				break;
			}
		}
		return tot_contas;
	}

	void imprime(Conta conta) {
		System.out.println("--------------");
		System.out.println("Titular da conta: " + conta.titular);
		System.out.println("Número : " + conta.numero);
		System.out.println("Saldo: " + conta.saldo);
	}

	public Conta[] getlistaContas() {
		//retornando uma cópia do array original
		return Arrays.copyOf(listaContas, listaContas.length);
	}
}
