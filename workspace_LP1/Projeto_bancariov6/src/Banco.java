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
		return this.listaContas.size();
	}
	
	void imprime(Conta conta) {
			System.out.println("--------------");
			System.out.println("Titular da conta: " + conta.getCliente().getNome());
			System.out.println("Número : " + conta.getNumero());
			System.out.println("Saldo: " + conta.getSaldo());
	}

	public List<Conta> getListaContas() {
		return listaContas;
	}
}
