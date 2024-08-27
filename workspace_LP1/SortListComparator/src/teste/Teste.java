package teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import criterios.CriterioNome;
import criterios.CriterioPontos;
import modelo.Candidato;

public class Teste {

	public static void main(String[] args) {

		Candidato c1 = new Candidato("Walter", 400, 111);
		Candidato c2 = new Candidato("Rodrigo", 200, 222);
		Candidato c3 = new Candidato("Ana", 300, 333);
		Candidato c4 = new Candidato("Jubileu", 600, 333);
		Candidato c5 = new Candidato("Boris", 500, 444);
		Candidato c6 = new Candidato("Fred", 250, 111);
		
		List<Candidato> lista = new ArrayList<>();
		
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		lista.add(c4);
		lista.add(c5);
		lista.add(c6);
		
		CriterioPontos criterio_ponto = new CriterioPontos();
		CriterioNome criterio_nome = new CriterioNome();
		
		Collections.sort(lista, criterio_ponto);
		
		for(Candidato item : lista) {
			System.out.println(item);
		}
		
		Collections.sort(lista, criterio_nome);
		
		System.out.println();
		for(Candidato item : lista) {
			System.out.println(item);
		}
	}
}
