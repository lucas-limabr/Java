import java.util.ArrayList;
import java.util.List;

public class Banco {
	private List<Conta> listaContas = new ArrayList<>();

	boolean adicionaConta(Conta c) {
		this.getListaContas().add(c);		
		return true;
	}

	Conta getConta(int n) {
		for (Conta conta : listaContas) {
			if (conta.getNumero() == n) {
				return conta;
			}
		}
		return null;
	}

	int getTotalContas() {
		int tot_contas = 0;
		tot_contas = this.listaContas.size();

		return tot_contas;
	}
	
	void imprime(Conta conta) {
			System.out.println("--------------");
			System.out.println("Titular da conta: " + conta.getTitular());
			System.out.println("Número : " + conta.getNumero());
			System.out.println("Saldo: " + conta.getSaldo());
	}

	public List<Conta> getListaContas() {
		return listaContas;
	}
}
