package modelo;

import java.util.ArrayList;
import java.util.List;

public class Teste {

	private static List<Aluno> lista = new ArrayList();
	private static List<Aluno> lista2 = new ArrayList();
	
	public static void main(String[] args) {

		Aluno a1 = new Aluno(111, "Ariel", 100.0);
		Aluno a2 = new Aluno(222, "Bia", 100.0);
		Aluno aluno = new Aluno(111, "Ariel", 100.0);

		lista.add(a1); // adiciona um elemento
		lista.add(a2); // adiciona outro elemento
		lista.add(a1); // ArrayList aceita duplicidade.

		
		//o método remove utiliza o método equals para, primeiro, saber se aquele objeto existe 
		//na lista. Aqui, o método equals foi sobrescrito na classe Aluno e a comparação que
		//ele está fazendo é por número de matrícula. Então, quando eu mando remover aluno,
		//mesmo que este objeto nem esteja na lista, o objeto a1 é removido, porque aluno tem o
		//mesmo n° de matrícula que a1, assim, o equals encontra na lista um objeto(a1) com este nº
		//e o remove
		lista.remove(aluno);
		
		for (Aluno a : lista) {
			System.out.println(a);

		}
		
		//testando o método equals
		a2 = a1;
		
		lista.add(a1);
		
		System.out.println(lista.contains(a1));
		System.out.println(lista.contains(a2));
		System.out.println(lista.contains(aluno));
	}
}
