import java.util.ArrayList;
import java.util.List;

public class ListaAlunos {

	public static void main(String[] args) {
		
		//arrayList
		List<Aluno> lista = new ArrayList<Aluno>();
		
		Aluno[] alunos = new Aluno[4];
		alunos[0] = new Aluno(1, "Lucas", 10);
		alunos[1] = new Aluno(2, "Léo", 9);
		alunos[2] = new Aluno(3, "Pedro", 5);
		alunos[3] = new Aluno(4, "Zé", 3);
		
		//for que varre todas as posições do objeto alunos, para adicionar cada uma na lista 
		for(int i = 0; i < alunos.length; i++) {
			lista.add(alunos[i]);
		}
		
		//percorrendo uma lista com o for normal -> uso o método get da lista
		for(int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getNome());
		}
		
		System.out.println("---------");
		
		lista.remove(alunos[3]);
		
		//percorrendo uma lista com o for each -> o método get não existe
		for(Aluno itens : lista) {
			System.out.println(itens.getNome());
		}
		
		System.out.print("Está na lista ou não: ");
		System.out.println(lista.contains(alunos[3]));
	}
}
