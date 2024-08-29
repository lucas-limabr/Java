package criterios;

import java.util.Comparator;

import modelo.Servico;

public class ValorServicoAsc implements Comparator<Servico> {

	@Override
	public int compare(Servico s1, Servico s2) {
		
		return Double.compare(s1.valorPago(), s2.valorPago());
	}

}
