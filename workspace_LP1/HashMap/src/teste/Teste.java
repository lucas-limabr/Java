package teste;

import java.util.List;
import java.util.Set;
import modelo.Aluno;
import modelo.Trabalho;

public class Teste {

	public static void main(String[] args) {
		
		Aluno a1 = new Aluno(111, "Lucas", 10);
		Aluno a2 = new Aluno(222, "Ana", 8);
		Aluno a3 = new Aluno(333, "Guilherme", 7);
		Aluno a4 = new Aluno(444, "Luis", 5);
		
		Trabalho t1 = new Trabalho("Paradigmas da POO");
		Trabalho t2 = new Trabalho("Estudo da linguagem Java");
		
		if(Aluno.estaVazia()) {
			System.out.println("Os trabalhos ainda não foram distribuídos");
		}
		else {
			System.out.println("Já tem alunos associado a um trabalho");
		}
		
		a1.add(t1);
		a2.add(t2);
		a3.add(t1);
		a4.add(t1);
		//hashmap não aceita duplicidade de chave, quando é passada uma chave
		//duplicada, ele sobrescreve o valor antigo pelo novo valor
		a1.add(t2);
		
		if(Aluno.estaVazia()) {
			System.out.println("Os trabalhos ainda não foram distribuídos");
		}
		else {
			System.out.println("Já tem alunos associado a um trabalho");
		}
		
		Set<Aluno> conjuntoKeys =  Aluno.getLista();
		
		for(Aluno item : conjuntoKeys) {
			System.out.println("Nome do aluno: "+item.getNome()+" / Trabalho: "
					+ item.getTrabalho(item).getDescricao());
		}
	}

}
