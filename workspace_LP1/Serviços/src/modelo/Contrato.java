package modelo;

import java.time.LocalDate;

public class Contrato {

	private static LocalDate data_atual = LocalDate.of(2023, 04, 03);
	private static int num_sequencial;

	private String num_ordem;
	private int ano_inicio;
	private int mes_inicio;

	// composição
	private Cliente cliente;
	private Funcionario funcionario;
	private Servico servico;

	// construtor
	public Contrato(Cliente cliente, Funcionario funcionario, Servico servico) {
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.servico = servico;
		this.ano_inicio = LocalDate.now().getYear();
		this.mes_inicio = LocalDate.now().getMonthValue();
		this.num_ordem = gerarNumero();
		cliente.incrementaQtd_servicos();
		cliente.setValor_total_pago(servico.valorPago());
		Ranking.categorizar(cliente);
	}

	public Contrato(Contrato contrato) {
		this.cliente = contrato.cliente;
		this.funcionario = contrato.funcionario;
		this.servico = contrato.servico;
		this.ano_inicio = contrato.ano_inicio;
		this.mes_inicio = contrato.mes_inicio;
		this.num_ordem = contrato.num_ordem;
	}

	// método para gerar um número de ordem de contrato
	private String gerarNumero() {
		if (data_atual.getYear() != LocalDate.now().getYear()) {
			Contrato.num_sequencial = 0;
			data_atual = LocalDate.now();
		}

		Contrato.num_sequencial++;

		return data_atual.getYear() + "-" + num_sequencial;
	}

	public double consultaSalario() {
		return funcionario.calculaSalario(servico);
	}

	public String toString() {
		return "\n----------\nNúmero da ordem do contrato: " + getNum_ordem() + "\nAno de início: " + getAno_inicio()
				+ "\nMês de início: " + getMes_inicio() + "\nNome do cliente: " + cliente.getNome()
				+ "\nNome do funcionário: " + funcionario.getNome() + "\nDescrição do serviço: "
				+ servico.getDescricao();
	}

	// getters
	public String getNum_ordem() {
		return num_ordem;
	}

	public int getAno_inicio() {
		return ano_inicio;
	}

	public int getMes_inicio() {
		return mes_inicio;
	}

	public Cliente getCliente() {
		return new Cliente(cliente);
	}

	public Funcionario getFuncionario() {
		return this.funcionario.fazCopia(funcionario);
	}

	public Servico getServico() {
		// objeto encapsulado
		return new Servico(servico);
	}

	// setters
	public void setAno_inicio(int ano_inicio) {
		this.ano_inicio = ano_inicio;
	}
}
