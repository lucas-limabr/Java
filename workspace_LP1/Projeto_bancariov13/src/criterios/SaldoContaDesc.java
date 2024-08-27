package criterios;

import java.util.Comparator;

import modelo.Conta;

public class SaldoContaDesc implements Comparator<Conta> {

	@Override
	public int compare(Conta c1, Conta c2) {
		
		return Double.compare(c1.getSaldo(), c2.getSaldo()) * -1;
	}

}
