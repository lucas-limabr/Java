package instancias;

import modelo.Assalariado;
import modelo.Cliente;
import modelo.Contrato;
import modelo.Servico;

public class TesteDescricao {

	public static void main(String[] args) {

		Cliente c1 = new Cliente("Ana", "Carolina", "ana@gmail.com", "F");

		Assalariado f1 = new Assalariado("Lucas", "Lima", "lucas@gmail.com", "M", 1500);

		Servico s1 = new Servico("Pintura", 50.0, 5, 6);

		Contrato contrato1 = new Contrato(c1, f1, s1);

		// vendo todas as informações de um determinado cliente
		System.out.println(c1.toString());

		// vendo todas as informações de um determinado funcionário
		System.out.println(f1.toString());

		// vendo todas as informações de um determinado serviço
		System.out.println(s1.toString());

		// vendo todas as informações de um determinado contrato
		System.out.println(contrato1.toString());
	}

}
