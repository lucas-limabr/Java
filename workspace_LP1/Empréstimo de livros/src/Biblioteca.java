import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {
    private HashMap<Livro, Integer> rankingDeLivros;
    private ListaGerenciadora<Emprestimo> emprestimosGerenciados;

    public Biblioteca() {
        this.rankingDeLivros = new HashMap<>();
        this.emprestimosGerenciados = new ListaGerenciadora<>();
    }

    // Método para atualizar o ranking de livros
    public void atualizarRanking(Livro livro) {
        if (rankingDeLivros.containsKey(livro)) {
            rankingDeLivros.put(livro, rankingDeLivros.get(livro) + 1);
        } else {
            rankingDeLivros.put(livro, 1);
        }
    }

    // Listar todos os livros e seus totais de empréstimos
    public void listarRanking() {
        for (Map.Entry<Livro, Integer> entry : rankingDeLivros.entrySet()) {
            System.out.println("Livro: " + entry.getKey().getTitulo() + ", Empréstimos: " + entry.getValue());
        }
    }

    // Consultar a quantidade de empréstimos de um determinado livro
    public int consultarEmprestimos(Livro livro) {
        return rankingDeLivros.getOrDefault(livro, 0);
    }

    // Método para atualizar o ranking sempre que um novo empréstimo é realizado
    public void registrarEmprestimo(Emprestimo emprestimo) {
        emprestimosGerenciados.adicionar(emprestimo);
        for (Livro livro : emprestimo.getLivrosEmprestados()) {
            atualizarRanking(livro);
        }
    }

    // Classe genérica para gerenciar listas de qualquer tipo
    public static class ListaGerenciadora<T> {
        private List<T> lista;

        public ListaGerenciadora() {
            this.lista = new ArrayList<>();
        }

        public void adicionar(T item) {
            lista.add(item);
        }

        public void remover(T item) {
            lista.remove(item);
        }

        public void listar() {
            for (T item : lista) {
                System.out.println(item);
            }
        }

        // Método para retornar a lista interna
        public List<T> getLista() {
            return lista;
        }
    }
}
