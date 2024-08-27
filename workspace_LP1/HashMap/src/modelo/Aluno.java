package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Aluno implements Comparable<Aluno> {

	private int matricula;
	private String nome;
	private double nota;
	
	//hashmap: chave e valor, aqui, são dois objetos
	private static Map<Aluno, Trabalho> divisao = new HashMap<Aluno, Trabalho>();
	
	//injeção de dependência
	public Aluno(int matricula, String nome, double nota) {
		this.matricula = matricula;
		this.nome = nome;
		this.nota = nota;
	}
	
	public static boolean estaVazia() {
		return divisao.isEmpty();
	}
	
	public void add(Trabalho trabalho) {
		divisao.put(this, trabalho);
	}
	
	public Trabalho getTrabalho(Aluno chave) {
		return divisao.get(chave);
	}
	
	public static Set<Aluno> getLista(){
		//crio um conjunto de todas e apenas as chaves do meu hashmap, já que, 
		//eu não consigo iterar um hasmap, mas um set sim
		Set<Aluno> conjunto = divisao.keySet();
		
		//não consigo ordenar um Set, para isso, preciso convertê-lo para uma lista
		//o ArrayList tem um construtor que aceita um argumento do tipo Set,
		//e internamente ele converte este Set em um ArrayList
		List<Aluno> lista_chaves = new ArrayList<>(conjunto);
		Collections.sort(lista_chaves);
		
		//retornando a lista para um tipo genérico Set, com a inserção respeitando a 
		//ordem da lista. Para isso, o objeto precisa ser um LinkedHashSet, pois,
		//o Set não insere os elementos respeitando a ordem da lista 
		return new LinkedHashSet<>(lista_chaves);
	}
	
	@Override
	public int compareTo(Aluno aluno) {
		return (this.nome.compareTo(aluno.nome));
	}
	
	//getters and setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMatricula() {
		return matricula;
	}
	public double getNota() {
		return nota;
	}
}
