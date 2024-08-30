package modelo;

import java.util.ArrayList;

public class HistoricoContratos {

	// composição
	private ArrayList<Contrato> lista_contratos = new ArrayList<Contrato>();

	public String informacoes(Contrato contrato) {
		String msg_formatada = new String();

		if (lista_contratos.contains(contrato)) {
			msg_formatada = "\n-------\nNúmero da ordem do contrato: " + contrato.getNum_ordem() + "\nAno de início: "
					+ contrato.getAno_inicio() + "\nMês de início: " + contrato.getMes_inicio();
		} else {
			msg_formatada = "Este contrato não existe";
		}

		return msg_formatada;
	}

	public double faturamentoTotPrevisto() {
		double faturamento_previsto = 0.0;

		for (Contrato item : lista_contratos) {
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
		if (lista_contratos.contains(contrato)) {
			return false;
		} else {
			return lista_contratos.add(contrato);
		}
	}

	public boolean removeContrato(Contrato contrato) {
		if (lista_contratos.remove(contrato)) {
			return true;
		} else {
			return false;
		}
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
					+ " -> Total de serviços contratados " + item.getCliente().getQtd_servicos()
					+ " e valor total pago: R$" + item.getCliente().getValor_total_pago();
		}
		return listagem;
	}

	public double valorTotPagoCliente(String codigo) {
		int i = 0;

		while (!(lista_contratos.get(i).getCliente().getCodigo().equals(codigo))) {
			i++;
		}

		if (i != lista_contratos.size()) {

			return lista_contratos.get(i).getCliente().getValor_total_pago();
		}

		return 0;
	}

	public String consultarCategoriaCliente(String codigo) {
		int i = 0;

		while (!(lista_contratos.get(i).getCliente().getCodigo().equals(codigo))) {
			i++;
		}

		if (i != lista_contratos.size()) {
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
