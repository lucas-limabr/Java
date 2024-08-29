package modelo;

import java.util.ArrayList;
import java.util.Set;

public class Historico {

	// composição
	private Agrupamento<Contrato> lista_contratos = new Agrupamento<>();
	
	public String informacoes(Contrato contrato) {
		
		String msg_formatada = new String();
		Contrato contrato_buscado = lista_contratos.busca(contrato);
		
		if(contrato_buscado == null) {
			msg_formatada = "Este contrato não existe";
		}
		else {
			msg_formatada = contrato_buscado.toString(); 
		}
		
		return msg_formatada;
	}
	
	public double faturamentoTotPrevisto(Agrupamento<Contrato> lista) {
		double faturamento_previsto = 0.0;

		
		
		for (Contrato item : lista) {
			faturamento_previsto += item.getServico().calculaOrcamento();
		}

		return faturamento_previsto;
	}

	public double faturamentoPago() {
		double faturamento_pg = 0.0;

		for (Contrato item : lista_contratos) {
			faturamento_pg += item.getServico().valorPago();
		}

		return faturamento_pg;
	}

	public boolean addContrato(Contrato contrato) {
		return lista_contratos.adiciona(contrato);
	}

	public boolean removeContrato(Contrato contrato) {
		return lista_contratos.remove(contrato);
	}

	public Contrato buscaContrato(String num_ordem) {

		for (Contrato item : lista_contratos) {
			if (item.getNum_ordem().equals(num_ordem)) {
				return item;
			}
		}

		return null;
	}

	public String listaClientesTotservicos() {
		String listagem = new String();

		for (Contrato item : lista_contratos) {
			listagem += "\nCliente " + item.getCliente().getCodigo() + ": " + item.getCliente().getNome()
					+ " -> Total de serviços contratados " + 
					item.getCliente().getQtd_servicos()+" e valor total pago: R$"+item.getCliente().getValor_total_pago();
		}
		return listagem;
	}
	
	public double valorTotPagoCliente(String codigo) {
		int i  = 0;
		
		while(!(lista_contratos.get(i).getCliente().getCodigo().equals(codigo))) {
			i++;
		}
		
		if(i != lista_contratos.size()) {
			
			return lista_contratos.get(i).getCliente().getValor_total_pago();
		}
		
		return 0;
	}
	
	public String consultarCategoriaCliente(String codigo) {
		int i = 0;
		
		while(!(lista_contratos.get(i).getCliente().getCodigo().equals(codigo))) {
			i++;
		}
		
		if(i != lista_contratos.size()) {
			return Ranking.getCategoria(lista_contratos.get(i).getCliente());
		}
		
		return "";
	}
	
	// getter
	public ArrayList<Contrato> getLista_contratos() {

		ArrayList<Contrato> copia_lista = new ArrayList<Contrato>();

		for (Contrato item : lista_contratos) {
			copia_lista.add(new Contrato(item));
		}
		// ArrayList de objetos encapsulado
		return copia_lista;
	}
}
