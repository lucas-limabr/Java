package modelo;
import java.util.ArrayList;
import java.util.List;

public class Banco {
	private ArrayList<Conta> listaContas = new ArrayList<>();

	public boolean adicionaConta(Conta c) {
		this.getListaContas().add(c);		
		return true;
	}

	public Conta getConta(String n) {
		for (Conta conta : listaContas) {
			if (conta.getNumero().equals(n)) {
				return conta;
			}
		}
		return null;
	}

	public int getTotalContas() {
		return this.listaContas.size();
	}
	
	public void imprime(Conta conta) {
			System.out.println("--------------");
			System.out.println("Titular da conta: " + conta.getCliente().getNome());
			System.out.println("Número : " + conta.getNumero());
			System.out.println("Saldo: " + conta.getSaldo());
	}

	public ArrayList<Conta> getListaContas() {
		return listaContas;
	}
}
