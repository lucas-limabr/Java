import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class Emprestimo {
	private static int proximoNumeroEmprestimo = 1;
	private String numeroEmprestimo;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	private Usuario usuario;
	private List<Livro> livrosEmprestados;

	public Emprestimo(LocalDate dataEmprestimo, LocalDate dataDevolucao, Usuario usuario, List<Livro> livrosEmprestados)
			throws LivroIndisponivelException {
		this.numeroEmprestimo = LocalDate.now().getYear() + "-" + proximoNumeroEmprestimo++;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.usuario = usuario;
		this.livrosEmprestados = new ArrayList<>();
		for (Livro livro : livrosEmprestados) {
			livro.emprestar();
			this.livrosEmprestados.add(livro);
		}
	}

	public String descricao() {
		String descricao = "Número de Empréstimo: " + numeroEmprestimo + "\n";
		descricao += "Usuário: " + usuario.getNome() + "\n";
		descricao += "Data do Empréstimo: " + dataEmprestimo + "\n";
		descricao += "Data de Devolução: " + dataDevolucao + "\n\n";
		descricao += "LIVRO(S) EMPRESTADO(S):\n";
		for (Livro livro : livrosEmprestados) {
			descricao += "Título: " + livro.getTitulo() + "\nAutor: " + livro.getAutor() + ", Unidades Restantes: "
					+ livro.getUnidadesDisponiveis() + "\n\n";
		}
		return descricao;
	}

	public void gerarRelatorioDevolucaoAtrasada() {
		if (LocalDate.now().isAfter(dataDevolucao)) {
			long diasAtraso = LocalDate.now().toEpochDay() - dataDevolucao.toEpochDay();
			double multa = calcularMulta(diasAtraso);

			StringBuilder relatorio = new StringBuilder();
			relatorio.append(usuario.tratamento() + " " + usuario.getNome() + ", \n");
			relatorio.append("Segue a lista de livros com devolução em atraso: \n");
			for (Livro livro : livrosEmprestados) {
				relatorio.append("Título: ").append(livro.getTitulo()).append("\n");
			}
			relatorio.append("Dias em atraso: ").append(diasAtraso).append("\n");
			relatorio.append(String.format("%.2f", multa)).append("\n");
			System.out.println(relatorio.toString());
		}
	}

	private double calcularMulta(long diasAtraso) {
		if (usuario instanceof Professor) {
			return 0; // Professores são isentos de multa
		}
		return diasAtraso * 2.0; // Exemplo: R\$2,00 por dia de atraso
	}

	private void gerarRelatorio(long diasAtraso, double multa) {
		String tratamento = usuario.tratamento();
		StringBuilder relatorio = new StringBuilder();
		relatorio.append(tratamento).append(",\n");
		relatorio.append("Segue a lista de livros com devolução em atraso:\n");
		for (Livro livro : livrosEmprestados) {
			relatorio.append("Título: ").append(livro.getTitulo()).append("\n");
		}
		relatorio.append("Dias em atraso: ").append(diasAtraso).append("\n");
		relatorio.append("Multa a ser paga: R$").append(String.format("%.2f", multa)).append("\n");
		System.out.println(relatorio.toString());
	}

	public void verificarDevolucao() throws DevolucaoAtrasadaException {
		if (LocalDate.now().isAfter(dataDevolucao)) {
			long diasAtraso = LocalDate.now().toEpochDay() - dataDevolucao.toEpochDay();
			double multa = calcularMulta(diasAtraso);
			gerarRelatorio(diasAtraso, multa);
			throw new DevolucaoAtrasadaException("Devolução de livro(s) em atraso.");
		}
	}

	public String getNumeroEmprestimo() {
		return numeroEmprestimo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public List<Livro> getLivrosEmprestados() {
		return new ArrayList<>(livrosEmprestados);
	}

	public void adicionarLivro(Livro livro) {
		livrosEmprestados.add(livro);
	}

	public void removerLivro(Livro livro) {
		livrosEmprestados.remove(livro);
	}

	public boolean verificarLivro(Livro livro) {
		return livrosEmprestados.contains(livro);
	}
	
	public List<Livro> livrosEmprestadosPorTituloCrescente() {
	    List<Livro> livrosOrdenados = new ArrayList<>(livrosEmprestados);
	    Collections.sort(livrosOrdenados, Comparator.comparing(Livro::getTitulo));
	    return livrosOrdenados;
	}
	
	public List<Livro> livrosEmprestadosPorNomeUsuarioDecrescente() {
	    List<Livro> livrosOrdenados = new ArrayList<>(livrosEmprestados);
	    Collections.sort(livrosOrdenados, Comparator.comparing(Livro::getTitulo));
	    return livrosOrdenados;
	}
}
