public class Livro {
    private String titulo;
    private String autor;
    private int unidadesDisponiveis;

    public Livro(String titulo, String autor, int unidadesDisponiveis) {
        this.titulo = titulo;
        this.autor = autor;
        this.unidadesDisponiveis = unidadesDisponiveis;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getUnidadesDisponiveis() {
        return unidadesDisponiveis;
    }

    public void emprestar() throws LivroIndisponivelException {
        if (unidadesDisponiveis <= 0) {
            throw new LivroIndisponivelException("O livro '" + titulo + "' não está disponível para empréstimo.");
        }
        unidadesDisponiveis--;
    }

    public void devolver() {
        unidadesDisponiveis++;
    }
}