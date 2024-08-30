public class Funcionario extends Usuario {
    private String departamento;

    public Funcionario(String nome, String email, String sexo, String departamento) {
        super(nome, email, sexo);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String tratamento() {
        return (getSexo().equalsIgnoreCase("M") ? "Funcionário " : "Funcionária ");
    }

    public String nomeComTratamento() {
        return tratamento() + getNome();
    }
}