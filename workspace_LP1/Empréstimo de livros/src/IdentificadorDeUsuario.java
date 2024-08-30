public class IdentificadorDeUsuario {
    public static String identificarUsuario(Usuario usuario) {
        if (usuario instanceof Aluno) {
            return "Usuário Aluno";
        } else if (usuario instanceof Professor) {
            return "Usuário Professor";
        } else if (usuario instanceof Funcionario) {
            return "Usuário Funcionário";
        } else {
            return "Usuário Desconhecido";
        }
    }
}