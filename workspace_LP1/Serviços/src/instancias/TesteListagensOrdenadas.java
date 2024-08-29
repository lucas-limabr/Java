package instancias;

import java.util.ArrayList;
import java.util.List;

import criterios.NomeClienteAsc;
import criterios.NomeClienteDesc;
import criterios.ValorServicoAsc;
import excecao.LimiteHoras;

import java.util.Collections;

import modelo.Cliente;
import modelo.Servico;

public class TesteListagensOrdenadas {

	public static void main(String[] args) {
		
		//testando clientes
		Cliente c1 = new Cliente("Lucas", "Lima", "lucas@gmail.com", "M");
		Cliente c2 = new Cliente("Ana", "Carolina", "ana@gmail.com", "F");
		Cliente c3 = new Cliente("Miguel", "Ferreira", "miguel@gmail.com", "M");
		Cliente c4 = new Cliente("Miguel", "Farias", "miguel@gmail.com", "M");
		
		List<Cliente> lista_clientes = new ArrayList<>();
		
		lista_clientes.add(c1);
		lista_clientes.add(c2);
		lista_clientes.add(c3);
		lista_clientes.add(c4);
		
		NomeClienteAsc nome_cliente_asc = new NomeClienteAsc();
		
		Collections.sort(lista_clientes, nome_cliente_asc );
		
		System.out.println("Lista ordenada ascendente por nomes de clientes:\n");
		for(Cliente item : lista_clientes) {
			System.out.println(item.getNome()+" "+item.getSobrenome());
		}
		
		NomeClienteDesc nome_cliente_desc = new NomeClienteDesc();
		
		Collections.sort(lista_clientes, nome_cliente_desc);
		
		System.out.println("\nLista ordenada descendente por nomes de clientes:\n");
		for(Cliente item : lista_clientes) {
			System.out.println(item.getNome()+" "+item.getSobrenome());
		}
		
		//testando serviços
		List<Servico> lista_servico = new ArrayList<>();
		
		try {
			Servico s1 = new Servico("Pintura", 50.0, 5, 6);
			lista_servico.add(s1);
		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Servico s2 = new Servico("Encanamento", 70.0, 3, 4);
			lista_servico.add(s2);
		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Servico s3 = new Servico("Elétrico", 120.0, 5, 7);
			lista_servico.add(s3);
		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());
		}
		
		ValorServicoAsc valor_servico_asc = new ValorServicoAsc();
		
		Collections.sort(lista_servico, valor_servico_asc);
		
		System.out.println("\nLista ordenada ascendente por valor de serviço prestado:\n");
		for(Servico item : lista_servico) {
			System.out.println("Serviço "+item.getCodigo()+": R$ "+ item.valorPago());
		}
	}

}
