package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import criterios.NumContaAsc;
import criterios.NumContaDesc;
import criterios.SaldoContaDesc;

public class Banco {
	private ArrayList<Conta> listaContas = new ArrayList<>();
	private static List<Conta> lista_ordenada;

	public boolean adicionaConta(Conta c) {
		this.listaContas.add(c);
		return true;
	}

	public Conta getConta(String n) {
		for (Conta conta : listaContas) {
			if (conta.getNumero().equals(n)) {
				return conta;
			}
		}
		return null;
	}

	public int getTotalContas() {

		return this.listaContas.size();
	}

	public String imprime(Conta conta) {

		String formatacao = new String();
		formatacao = "\n------\nTitular da conta: " + conta.getCliente().getNome() + "\nNúmero : " + conta.getNumero()
				+ "\nSaldo: " + conta.getSaldo()+"\nTipo de conta: "+conta.getIdentificacao();

		return formatacao;
	}
	
	private double somatorioSaldoContas() {
		
		double total = 0;
		
		for(Conta item : listaContas) {
			total += item.getSaldo();
		}
		
		return total;
	}
	
	private String exibeValorTotal() {
		
		return "\nO somatório do saldo de todas contas equivale a R$ "+this.somatorioSaldoContas();
	}

	public String relatorioContaMaiorSaldo() {

		if (this.getTotalContas() <= 0) {
			return null;
		}

		String relatorio = new String();

		double maior_saldo = listaContas.get(0).getSaldo();

		for (Conta item : listaContas) {

			if (item.getSaldo() < maior_saldo) {
				continue;
			} else if (item.getSaldo() > maior_saldo) {
				maior_saldo = item.getSaldo();
				relatorio = item.imprime();
			} else {
				relatorio += item.imprime();
			}
		}
		
		return relatorio;
	}
	
	public String relatorioContaMenorSaldo() {
		
		if (this.getTotalContas() <= 0) {
			return null;
		}

		String relatorio = new String();

		double menor_saldo = listaContas.get(0).getSaldo();

		for (Conta item : listaContas) {

			if (item.getSaldo() > menor_saldo) {
				continue;
			} else if (item.getSaldo() < menor_saldo) {
				menor_saldo = item.getSaldo();
				relatorio = item.imprime();
			} else {
				relatorio += item.imprime();
			}
		}
		
		relatorio += this.exibeValorTotal();
		return relatorio;
	}

	public ArrayList<Conta> getListaContas() {
		ArrayList<Conta> copia_lista = new ArrayList<>();

		for (Conta item : listaContas) {
			copia_lista.add(item.encapsulaContas(item));
		}

		return copia_lista;
	}

	private String ordenar(Comparator<Conta> criterio) {

		if (this.getTotalContas() <= 0) {
			return null;
		}

		Banco.lista_ordenada = this.getListaContas();
		Collections.sort(lista_ordenada, criterio);

		String contas_ordenadas = new String();

		for (Conta item : lista_ordenada) {
			contas_ordenadas += this.imprime(item);
		}

		return contas_ordenadas;
	}

	public String ordenarContasAsc() {

		NumContaAsc criterio_conta_asc = new NumContaAsc();
		return this.ordenar(criterio_conta_asc);
	}

	public String ordenarContasDesc() {
		NumContaDesc criterio_conta_desc = new NumContaDesc();
		return this.ordenar(criterio_conta_desc);
	}

	public String ordenarSaldoDesc() {

		SaldoContaDesc criterio_saldo_desc = new SaldoContaDesc();
		return this.ordenar(criterio_saldo_desc);
	}
}