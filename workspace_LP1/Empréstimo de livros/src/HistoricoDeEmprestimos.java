import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class HistoricoDeEmprestimos {
    private List<Emprestimo> emprestimosRealizados;

    public HistoricoDeEmprestimos() {
        this.emprestimosRealizados = new ArrayList<>();
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimosRealizados.add(emprestimo);
    }

    public void removerEmprestimo(Emprestimo emprestimo) {
        emprestimosRealizados.remove(emprestimo);
    }

    public boolean verificarEmprestimo(Emprestimo emprestimo) {
        return emprestimosRealizados.contains(emprestimo);
    }

    public void listarLivrosPorTitulo() {
        List<Emprestimo> emprestimosOrdenados = new ArrayList<>(emprestimosRealizados);
        emprestimosOrdenados.sort(Comparator.comparing(e -> e.getLivrosEmprestados().get(0).getTitulo()));

        for (Emprestimo emprestimo : emprestimosOrdenados) {
            for (Livro livro : emprestimo.getLivrosEmprestados()) {
                System.out.println("Título: " + livro.getTitulo() + " | Usuário: " + emprestimo.getUsuario().getNome());
            }
        }
    }

    public void listarLivrosPorUsuario() {
        List<Emprestimo> emprestimosOrdenados = new ArrayList<>(emprestimosRealizados);
        emprestimosOrdenados.sort((e1, e2) -> e2.getUsuario().getNome().compareTo(e1.getUsuario().getNome()));

        for (Emprestimo emprestimo : emprestimosOrdenados) {
            for (Livro livro : emprestimo.getLivrosEmprestados()) {
                System.out.println("Usuário: " + emprestimo.getUsuario().getNome() + " | Título: " + livro.getTitulo());
            }
        }
    }
}
