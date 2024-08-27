package teste;

import java.util.HashSet;
import java.util.Set;

import modelo.Aluno;

public class Teste {

	public static void main(String[] args) {

		//Um conjunto (set) não aceita duplicata, um valor repetido
		//no conjunto não é adicionado denovo
		
		Aluno a1 = new Aluno("Lucas");
		Aluno a2 = new Aluno("Gabriela");
		Aluno a3 = new Aluno("Mauro");
		
		Set<Aluno> conjunto = new HashSet<Aluno>();
		
		conjunto.add(a1);
		conjunto.add(a2);
		
		if(conjunto.add(a1)) {
			System.out.println("Adicionado");
		}
		else {
			System.out.println("Não foi pssível adicionar");
		}
		
		for(Aluno item : conjunto) {
			System.out.println(item);
		}
		
		
		a3 = a1;
		System.out.println(conjunto.contains(a3));
	}

}
