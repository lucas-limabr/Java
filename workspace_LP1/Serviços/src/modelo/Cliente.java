package modelo;

import java.util.Objects;

public class Cliente extends Pessoa implements Saudacao {

	private static int num_sequencial = 0;
	private static String letra_codigo = "C";
	private String codigo;

	// valor acumulado do total pago pelo cliente, considerando todos os serviços
	// contratados
	// por ele
	private double valor_total_pago;
	// total de serviços contratados pelo cliente
	private int qtd_servicos;

	// construtor
	public Cliente(String nome, String sobrenome, String email, String sexo) {
		super(nome, sobrenome, email, sexo);
		this.codigo = gerarCodigo();
	}

	// assegurando o encapsulamento
	public Cliente(Cliente cliente) {
		super(cliente);
		this.codigo = cliente.codigo;
		this.valor_total_pago = cliente.valor_total_pago;
		this.qtd_servicos = cliente.qtd_servicos;
	}

	private String gerarCodigo() {
		Cliente.num_sequencial++;

		return letra_codigo + num_sequencial;
	}

	public String toString() {

		return "\n----------\nNome: " + super.getNome() + "\nSobrenome: " + super.getSobrenome() + "\nEmail: "
				+ super.getEmail() + "\nSexo: " + super.getSexo() + "\nCódigo: " + getCodigo();
	}

	public String getCodigo() {
		return codigo;
	}

	@Override
	public String saudacao() {
		String msg = "";

		if (super.getSexo().equalsIgnoreCase("M")) {
			msg = "Prezado Senhor ";
		} else if (super.getSexo().equalsIgnoreCase("F")) {
			msg = "Prezada Senhora ";
		}

		return msg + super.getSobrenome();
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Cliente cliente = (Cliente) obj;

		return this.codigo.equals(cliente.codigo);
	}

	public double getValor_total_pago() {
		return valor_total_pago;
	}

	public void setValor_total_pago(double valor_total_pago) {

		this.valor_total_pago += valor_total_pago;
	}

	public int getQtd_servicos() {
		return qtd_servicos;
	}

	public void incrementaQtd_servicos() {
		this.qtd_servicos += 1;
	}
}
