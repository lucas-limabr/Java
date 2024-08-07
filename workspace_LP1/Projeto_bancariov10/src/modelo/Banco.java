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
			System.out.println("N�mero : " + conta.getNumero());
			System.out.println("Saldo: " + conta.getSaldo());
	}

	public ArrayList<Conta> getListaContas() {
		//declarei o arrayList que ser� a c�pia do original
		ArrayList<Conta> copia_lista = new ArrayList<Conta>();
		
		//for para varrer cada objeto do tipo Conta do meu arrayList original
//		for(Conta item : listaContas) {
//			//para cada objeto eu dou um new (garanto endere�o de mem�ria 
//			//exclusivo para cada objeto Conta, diferente do original) chamando o construtor da classe
//			//do objeto e passando os objetos do arrayList um por um. Ap�s, adiciono na c�pia 
//			copia_lista.add(new Conta(item));
//		}
		
		return copia_lista;
	}
}