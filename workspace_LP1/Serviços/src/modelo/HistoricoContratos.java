package modelo;

import java.util.ArrayList;

public class HistoricoContratos {

	// composição
	private Agrupamento<Contrato> lista_contratos = new Agrupamento<Contrato>();

	public boolean addContrato(Contrato contrato) {
		return lista_contratos.adiciona(contrato);
	}

	public boolean removeContrato(Contrato contrato) {
		return lista_contratos.remove(contrato);
	}

	public Contrato buscaContrato(String num_ordem) {

		for (Contrato item : lista_contratos.getLista()) {
			if (item.getNum_ordem().equals(num_ordem)) {
				return item;
			}
		}

		return null;
	}

	public String informacoes(Contrato contrato) {
		String msg_formatada = new String();

		if (lista_contratos.busca(contrato) != null) {
			msg_formatada = "\n-------\nNúmero da ordem do contrato: " + contrato.getNum_ordem() + "\nAno de início: "
					+ contrato.getAno_inicio() + "\nMês de início: " + contrato.getMes_inicio();
		} else {
			msg_formatada = "Este contrato não existe";
		}

		return msg_formatada;
	}

	

	public double faturamentoTotPrevisto() {
		double faturamento_previsto = 0.0;

		for (Contrato item : lista_contratos.getLista()) {
			faturamento_previsto += item.getServico().calculaOrcamento();
		}

		return faturamento_previsto;
	}

	public double faturamentoPago() {
		double faturamento_pg = 0.0;

		for (Contrato item : lista_contratos.getLista()) {
			faturamento_pg += item.getServico().valorPago();
		}

		return faturamento_pg;
	}

	public String listaClientesTotservicos() {
		String listagem = new String();

		for (Contrato item : lista_contratos.getLista()) {
			listagem += "\nCliente " + item.getCliente().getCodigo() + ": " + item.getCliente().getNome()
					+ " -> Total de serviços contratados " + item.getCliente().getQtd_servicos()
					+ " e valor total pago: R$" + item.getCliente().getValor_total_pago();
		}
		return listagem;
	}

	public double valorTotPagoCliente(String codigo) {
		int i = 0;

		while (!(lista_contratos.getLista().get(i).getCliente().getCodigo().equals(codigo))) {
			i++;
		}

		if (i != lista_contratos.getLista().size()) {

			return lista_contratos.getLista().get(i).getCliente().getValor_total_pago();
		}

		return 0;
	}

	public String consultarCategoriaCliente(String codigo) {
		int i = 0;

		while (!(lista_contratos.getLista().get(i).getCliente().getCodigo().equals(codigo))) {
			i++;
		}

		if (i != lista_contratos.getLista().size()) {
			return Ranking.getCategoria(lista_contratos.getLista().get(i).getCliente());
		}

		return "";
	}
	
	public String pesquisaFuncionario(String codigo) {
		String msg = new String();
		
		for (Contrato item : lista_contratos.getLista()) {

			if (item.getFuncionario().getCodigo().equals(codigo)) {
				String nome = item.getFuncionario().getNome();
				String sexo_funcionario = new String();
				String ele_ela = new String();

				if (item.getFuncionario().getSexo().equalsIgnoreCase("M")) {
					sexo_funcionario = "do funcionário ";
					ele_ela = "do";
				} else {
					sexo_funcionario = "da funcionária ";
					ele_ela = "da";
				}
				if (item.getFuncionario().getFuncionario().equals("Funcionário Assalariado")) {
					msg = "O salário " + sexo_funcionario + nome + " é fixo, " + ele_ela
							+ " recebe o valor mensal de R$ " + item.consultaSalario();
				} else {
					msg = "O salário calculado " + sexo_funcionario + nome + " na prestação de serviço de código "
							+ item.getServico().getCodigo() + " do contrato " + item.getNum_ordem() + " foi de R$ "
							+ item.consultaSalario();
				}

				return msg;
			}

		}

		return msg = "Funcionário não encontrado";
	}

	// getter
	public ArrayList<Contrato> getLista_contratos() {

		ArrayList<Contrato> copia_lista = new ArrayList<Contrato>();

		for (Contrato item : lista_contratos.getLista()) {
			copia_lista.add(new Contrato(item));
		}
		// ArrayList de objetos encapsulado
		return copia_lista;
	}
}
