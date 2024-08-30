package instancias;

import modelo.Assalariado;
import modelo.Cliente;
import modelo.Comissionado;
import modelo.Horista;
import modelo.IdentificadorFuncionario;

public class TestesSaudacaoIdentificacao {

	public static void main(String[] args) {
		
		Cliente c1 =  new Cliente("Tião", "Almeida", "tiao@gmail.com", "M");
		Cliente c2 = new Cliente("Laura", "Diniz", "laura@gmail.com", "F");
		
		Comissionado f1 = new Comissionado("Rodrigo", "Guedes", "rodrigo@gmail.com", "M", 800);
		Horista f2 = new Horista("Maria", "Tereza", "maria@gmail.com", "F");
		
		System.out.println(c1.saudacao());
		System.out.println(c2.saudacao());
		System.out.println(f1.saudacao());
		System.out.println(f2.saudacao());
		
		Assalariado f3 = new Assalariado("Hilton", "Marins", "hilton@gmail.com", "M", 20.000);
		
		System.out.println("------");
		System.out.println(IdentificadorFuncionario.identificaFuncionario(f1));
		System.out.println(IdentificadorFuncionario.identificaFuncionario(f2));
		System.out.println(IdentificadorFuncionario.identificaFuncionario(f3));
	}

}
