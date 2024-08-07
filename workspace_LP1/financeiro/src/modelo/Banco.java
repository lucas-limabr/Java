package modelo;
import java.util.ArrayList;

public class Banco {
	private ArrayList<Conta> listaContas;

	public Banco() {
		listaContas = new ArrayList<Conta>();
	}

	public void adicionaConta(Conta c) {
		listaContas.add(c);
	}
	
	public Conta getConta(String numeroConta) {
		for(Conta c : listaContas) {
			if (c.getNumero().equals(numeroConta)) {
				return c;
			}
		}
		return null;
	}
	
	public int getTotalContas() {
		return listaContas.size();
	}
	
//	public ArrayList<Conta> getContas(){
//		ArrayList<Conta> listaContasCopia = new ArrayList<Conta>();
//    	for (Conta c : this.listaContas) {
//    		Conta copia = new Conta(c);
//    		listaContasCopia.add(copia);
//    	}
//    	return listaContasCopia;
//	}
}
