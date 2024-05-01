import java.util.Arrays;

public class Alunos {
	private String nome;
	private double[] notas;
	
	public Alunos(String nome, double... n){
		this.nome = nome;
		this.notas = new double[n.length];
		this.notas = n;
	}
	
	public String calculaSituacao() {
		String situacao;
		
		if(CalculaMedia() < 60) {
			situacao = "reprovado"; 
		}
		else {
			situacao = "aprovado";
		}
		
		return situacao;
	}
	
	private double CalculaMedia() {
		double media = 0;
		for(double n : notas) {
			media += n;
		}
		
		media /= notas.length;
		
		return media;
	}
	
	//faz uma concatenação de string com um vetor de double, após ser convertido para String também
	public String exibeTela() {
		//toString converte um ARRAY de um tipo primitivo qualquer em uma string
		return nome + " -> Notas: " + Arrays.toString(notas);
	}
	
	public double[] getNotas() {
		//eu passo uma cópia do array double e não o array original, pois um vetor é um objeto, quando eu retorno um objeto eu
		//retorno um endereço de memória, se eu atribuo este retorno para um outro array lá no main, o que eu alterar neste outro
		//vetor refletirá no array original
		
		return notas.clone();
		
		//maneira alternativa de retirnar uma cópia de um array
		//double[] copia = Arrays.copyOf(notas, notas.length);
	}
}
