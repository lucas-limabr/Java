public class Professor extends Usuario {
    private String departamento;

    public Professor(String nome, String email, String sexo, String departamento) {
        super(nome, email, sexo);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String tratamento() {
        return (getSexo().equalsIgnoreCase("M") ? "Professor " : "Professora ");
    }

    public String nomeComTratamento() {
        return tratamento() + getNome();
    }
}