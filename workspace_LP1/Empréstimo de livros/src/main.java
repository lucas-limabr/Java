import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Usuario usuario = new Aluno("Fulano da Silva Teixeira", "fulano@gmail.com", "M", "Engenharia");

        // Criação de alguns livros
        Livro livro1 = new Livro("Exatas: Use a cabeça! Java", "Kathy Sierra e Bert Bates", 8);
        Livro livro2 = new Livro("Clean Code", "Robert C. Martin", 5);

        // Listas de livros emprestados por diferentes usuários
        List<Livro> livrosEmprestados = new ArrayList<>();
        livrosEmprestados.add(livro1);
        livrosEmprestados.add(livro2);

        List<Livro> livrosEmprestadosAluno = new ArrayList<>();
        livrosEmprestadosAluno.add(livro1);
        livrosEmprestadosAluno.add(livro2);

        List<Livro> livrosEmprestadosProfessor = new ArrayList<>();
        livrosEmprestadosProfessor.add(livro1);

        List<Livro> livrosEmprestadosFuncionario = new ArrayList<>();
        livrosEmprestadosFuncionario.add(livro2);

        // Criação dos usuários
        Aluno aluno = new Aluno("José da Silva", "jose.silva@gmail.com", "M", "Engenharia");
        Professor professor = new Professor("Joana de Oliveira", "joana.oliveira@gmail.com", "F", "Ciência da Computação");
        Funcionario funcionario = new Funcionario("Carlos Teixeira", "carlos.teixeira@gmail.com", "M", "Administração");

        // Criação da Biblioteca
        Biblioteca biblioteca = new Biblioteca();

        try {
            // Criação dos empréstimos
            Emprestimo emprestimo = new Emprestimo(LocalDate.now(), LocalDate.now().plusDays(15), usuario, livrosEmprestados);
            Emprestimo emprestimoAluno = new Emprestimo(LocalDate.now().minusDays(10), LocalDate.now().minusDays(5), aluno, livrosEmprestadosAluno);
            Emprestimo emprestimoProfessor = new Emprestimo(LocalDate.now().minusDays(10), LocalDate.now().minusDays(5), professor, livrosEmprestadosProfessor);
            Emprestimo emprestimoFuncionario = new Emprestimo(LocalDate.now().minusDays(10), LocalDate.now().minusDays(5), funcionario, livrosEmprestadosFuncionario);

            // Registrar empréstimos na biblioteca
            biblioteca.registrarEmprestimo(emprestimo);
            biblioteca.registrarEmprestimo(emprestimoAluno);
            biblioteca.registrarEmprestimo(emprestimoProfessor);
            biblioteca.registrarEmprestimo(emprestimoFuncionario);

            // Adicionar mensagem de depuração após o registro de empréstimos
            System.out.println("Empréstimos registrados com sucesso na biblioteca.");

            // Criação do histórico de empréstimos
            HistoricoDeEmprestimos historico = new HistoricoDeEmprestimos();
            historico.adicionarEmprestimo(emprestimo);
            historico.adicionarEmprestimo(emprestimoAluno);
            historico.adicionarEmprestimo(emprestimoProfessor);
            historico.adicionarEmprestimo(emprestimoFuncionario);

            // Exibir a descrição de um empréstimo
            System.out.println(emprestimo.descricao());

            // Mostrar tratamento dos usuários
            System.out.println(aluno.tratamento());
            System.out.println(professor.tratamento());
            System.out.println(funcionario.tratamento() + "\n");

            // Identificação dos usuários
            System.out.println(IdentificadorDeUsuario.identificarUsuario(usuario));
            System.out.println(IdentificadorDeUsuario.identificarUsuario(aluno));
            System.out.println(IdentificadorDeUsuario.identificarUsuario(professor));
            System.out.println(IdentificadorDeUsuario.identificarUsuario(funcionario) + "\n");

            // Verificação de devolução e geração de relatório
            try {
                emprestimoAluno.verificarDevolucao();
                emprestimoProfessor.verificarDevolucao();
                emprestimoFuncionario.verificarDevolucao();
            } catch (DevolucaoAtrasadaException e) {
                System.out.println(e.getMessage());
            }

            // Listar livros emprestados em ordem crescente por título
            System.out.println("Livros em ordem crescente por título:");
            historico.listarLivrosPorTitulo();

            // Listar livros emprestados em ordem decrescente pelo nome do usuário
            System.out.println("\nLivros em ordem decrescente pelo nome do usuário:");
            historico.listarLivrosPorUsuario();

            // Listar o ranking dos livros mais emprestados
            System.out.println("\nRanking de livros mais emprestados:");
            biblioteca.listarRanking();

        } catch (LivroIndisponivelException e) {
            System.out.println(e.getMessage());
        }
    }
}

