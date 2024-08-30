public abstract class Usuario {
    private static int proximaMatricula = 1;
    private String nome;
    private String email;
    private String matricula;
    private String sexo;

    public Usuario(String nome, String email, String sexo) {
        this.nome = nome;
        this.email = email;
        this.matricula = "U" + proximaMatricula++;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getSexo() {
        return sexo;
    }

    public abstract String tratamento();
}