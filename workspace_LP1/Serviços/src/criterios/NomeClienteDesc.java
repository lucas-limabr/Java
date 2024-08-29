package criterios;

import java.util.Comparator;

import modelo.Cliente;

public class NomeClienteDesc implements Comparator<Cliente> {

	@Override
	public int compare(Cliente c1, Cliente c2) {
		
		int nome = c1.getNome().compareTo(c2.getNome()) * -1;
		if(nome != 0) {
			return nome;
		}
		
		return c1.getSobrenome().compareTo(c2.getSobrenome()) * -1;
	}

}
