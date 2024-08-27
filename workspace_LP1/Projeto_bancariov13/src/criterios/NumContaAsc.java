package criterios;

import java.util.Comparator;

import modelo.Conta;

public class NumContaAsc implements Comparator<Conta> {

	
	@Override
	public int compare(Conta c1, Conta c2) {
		
		return Integer.compare(c1.converteNumConta(), c2.converteNumConta());
	}
}
