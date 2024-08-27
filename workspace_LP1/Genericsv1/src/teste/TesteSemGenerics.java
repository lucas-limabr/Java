package teste;

import java.util.ArrayList;
import java.util.List;

import modelo.Aluno;
import modelo.Fruta;

public class TesteSemGenerics {

	public static void main(String[] args) {
		
		//exemplo de um arraylist que não está parametrizado (sem generics), assim, ele aceita
		//objetos de qualquer tipo
		List listaSemGenerics = new ArrayList();
		
		//uma lista criada utilizando o generics (parametrizada no List) aceita
		//objetos apenas do tipo que foi definido. Dá erro de compilação tentar add objetos de 
		//outro tipo
		//List<Aluno> listaComGenerics = new ArrayList();

		Aluno a1 = new Aluno("Jose", 100, 100);
		Aluno a2 = new Aluno("Joao", 90, 90);
		Fruta f1 = new Fruta("Banana") ;
		Fruta f2 = new Fruta("Laranja") ;

		//o compilador não enxerga os valores que estão sendo adicionados, ele olha para o tipo
		//E ele considera por default tds os objetos que vão para o arraylist do tipo Object
		listaSemGenerics.add(a1);
		listaSemGenerics.add(a2);
		listaSemGenerics.add(f1);
		listaSemGenerics.add(f2);

		//casting obrigatório para sair do erro de compilação. pois, não é possível atribuir 
		//um objeto do tipo Object para um tipo Aluno
		Aluno a3 = (Aluno) listaSemGenerics.get(0);
		System.out. println(a3);
		
		//casting obrigatório, ams dará erro de execução. Pois, um objeto fruta não pode receber
		//um objeto de outra classe, fruta não é aluno
		Fruta f3 = (Fruta) listaSemGenerics.get(0);
		System.out. println(f3);
	}

}
