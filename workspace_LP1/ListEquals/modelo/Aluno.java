package modelo;

import java.util.Objects;

public class Aluno {

	private int matricula;
	private String nome;
	private double nota;

	public Aluno(int matricula, String nome, double nota) {
		this.matricula = matricula;
		this.nota = nota;
		this.nome = nome;

	}

	@Override
	public String toString() {
		return this.nome + "-" + this.matricula + "-" + this.nota;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Aluno)) {
			return false;
		}
		if(obj == this) {
			return true;
		}
		
		Aluno a = (Aluno)obj; 
		
		if(a.matricula == this.matricula) {
			return true;
		}
		return false;
	}
}
