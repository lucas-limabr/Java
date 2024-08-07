package modelo;
import java.util.ArrayList;
import java.util.List;


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
		//declarei o arrayList que será a cópia do original
		ArrayList<Conta> copia_lista = new ArrayList<Conta>();
		
		//for para varrer cada objeto do tipo Conta do meu arrayList original
//		for(Conta item : listaContas) {
//			//para cada objeto eu dou um new (garanto endereço de memória 
//			//exclusivo para cada objeto Conta, diferente do original) chamando o construtor da classe
//			//do objeto e passando os objetos do arrayList um por um. Após, adiciono na cópia 
//			copia_lista.add(new Conta(item));
//		}
		
		return copia_lista;
	}
}