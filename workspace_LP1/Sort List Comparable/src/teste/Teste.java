package teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import modelo.Candidato;

public class Teste {

	public static void main(String[] args) {
		
		Candidato c1 = new Candidato("Walter", 400, 111);
		Candidato c2 = new Candidato("Rodrigo", 200, 222);
		Candidato c3 = new Candidato("Ana", 600, 333);
		Candidato c4 = new Candidato("Boris", 500, 444);
		
		List<Candidato> lista = new ArrayList<>();
		
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		lista.add(c4);
		
		Collections.sort(lista);
		
		for(Candidato item : lista) {
			System.out.println(item);
		}
	}

}
