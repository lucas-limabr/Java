package app;

import modelo.Aluno;

public class Teste {

	public static void main(String[] args) {

		String str1 = new String("Teste");
		String str2 = new String("Teste");
		
		// operador de comparação que compara apenas se endereços de 
		//memória são iguais
		comparador(str1 == str2);
		
		//método equals da classe Object sobrescrito na classe String,
		//onde para um objeto ser igual à outro, o seu conteúdo (caracteres)
		//precisa ser idêntico
		comparador(str1.equals(str2));
		
		Aluno a1 = new Aluno("Lucas", 100);
		Aluno a2 = new Aluno("Lucas", 100);
		
		comparador(a1 == a2);

		//sobrescrevi o metodo equals da classe Object, definindo um critério para
		//comparação de igualdade entre objetos
		
		comparador(a1.equals(a2));
	}

	public static void comparador(boolean comparacao) {
		if (comparacao) {
			System.out.println("Objetos iguais");
		} else {
			System.out.println("Objetos diferentes");
		}
	}
}