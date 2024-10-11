package modelo;

import java.util.ArrayList;
import java.util.List;

public class HistoricoContratos extends Agrupamento<Contrato> {

	public String informacoes(Contrato contrato) {
		String msg_formatada = new String();

		if (this.busca(contrato) != null) {
			msg_formatada = "\n-------\nNúmero da ordem do contrato: " + contrato.getNum_ordem() + "\nAno de início: "
					+ contrato.getAno_inicio() + "\nMês de início: " + contrato.getMes_inicio();
		} else {
			msg_formatada = "Este contrato não existe";
		}

		return msg_formatada;
	}

	public double faturamentoTotPrevisto() {
		double faturamento_previsto = 0.0;

		for (Contrato item : this.getLista()) {
			faturamento_previsto += item.getServico().calculaOrcamento();
		}

		return faturamento_previsto;
	}

	public double faturamentoPago() {
		double faturamento_pg = 0.0;

		for (Contrato item : this.getLista()) {
			faturamento_pg += item.getServico().valorPago();
		}

		return faturamento_pg;
	}

	public Contrato buscaContrato(String num_ordem) {

		for (Contrato item : this.getLista()) {
			if (item.getNum_ordem().equals(num_ordem)) {
				return item;
			}
		}

		return null;
	}

	public String listaClientesTotservicos() {
		String listagem = new String();

		for (Contrato item : this.getLista()) {
			listagem += "\nCliente " + item.getCliente().getCodigo() + ": " + item.getCliente().getNome()
					+ " -> Total de serviços contratados " + item.getCliente().getQtd_servicos()
					+ " e valor total pago: R$" + item.getCliente().getValor_total_pago();
		}
		return listagem;
	}

	public double valorTotPagoCliente(String codigo) {
		int i = 0;

		List<Contrato> lista = this.getLista();
		
		while (!(lista.get(i).getCliente().getCodigo().equals(codigo))) {
			i++;
		}

		if (i != lista.size()) {

			return lista.get(i).getCliente().getValor_total_pago();
		}

		return 0;
	}

	public String consultarCategoriaCliente(String codigo) {
		int i = 0;

		List<Contrato> lista = this.getLista();
		
		while (!(lista.get(i).getCliente().getCodigo().equals(codigo))) {
			i++;
		}

		if (i != lista.size()) {
			return Ranking.getCategoria(lista.get(i).getCliente());
		}

		return "";
	}

	// getter
	public ArrayList<Contrato> getLista_contratos() {

		ArrayList<Contrato> copia_lista = new ArrayList<Contrato>();

		for (Contrato item : this.getLista()) {
			copia_lista.add(new Contrato(item));
		}
		// ArrayList de objetos encapsulado
		return copia_lista;
	}
}
