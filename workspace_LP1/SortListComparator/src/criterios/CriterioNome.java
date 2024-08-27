package criterios;

import java.util.Comparator;

import modelo.Candidato;

public class CriterioNome implements Comparator<Candidato> {

	@Override
	public int compare(Candidato cad1, Candidato cad2) {
		
		//método compareTo já implementando na classe String, ele faz a comparação 
		//de Strings de forma alfabética (return 1 ou -1), por default, ordem ascendente
		return cad1.getNome().compareTo(cad2.getNome()) * -1;
	}

}
