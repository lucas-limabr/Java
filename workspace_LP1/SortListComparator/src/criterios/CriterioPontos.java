package criterios;

import java.util.Comparator;

import modelo.Candidato;

public class CriterioPontos implements Comparator<Candidato> {


	@Override
	public int compare(Candidato cand1, Candidato cand2) {
		
		if(cand1.getInscricao() < cand2.getInscricao()) {
			return -1;
		}
		else if(cand1.getInscricao() > cand2.getInscricao()) {
			return 1;
		}
		return 0;
	}
}
