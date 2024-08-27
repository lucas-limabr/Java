package modelo;
import java.util.ArrayList;

public class Banco {
	private ArrayList<Conta> listaContas = new ArrayList<>();
	
	public boolean adicionaConta(Conta c) {
		this.listaContas.add(c);		
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
		ArrayList<Conta> lista_copia = new ArrayList<>();
		
		for(Conta item : listaContas) {
			lista_copia.add(item.encapsulaContas(item));
		}
		
		return lista_copia;
	}
}