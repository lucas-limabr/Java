package modelo;

import java.util.Objects;

public class Aluno {

	private String nome;
	private int matricula;
	
	public Aluno(String n, int m)
	{
		this.nome = n;
		this.matricula = m;
	}
	
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Aluno))
		{
			return false;
		}
		
		if(obj == this)
		{
			return true;
		}
		
		//casting para atribuir um objeto mais abrangente (da classe Object) à uma
		//classe mais específica (Aluno), que é justamente a que eu quero verificar
		Aluno aluno = (Aluno)obj;
		
		if(this.nome.equals(aluno.nome) && this.matricula == aluno.matricula)
		{
			return true;
		}
		
		return false;
	}
}
