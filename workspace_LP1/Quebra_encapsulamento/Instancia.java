
public class Instancia {

	public static void main(String[] args) {
		Alunos a1 = new Alunos("Lucas", 30, 40, 30);
		
		System.out.println(a1.exibeTela()); 
		System.out.println(a1.calculaSituacao());
		
		double[] copia = a1.getNotas();
		
		//isso só não afetará o array original pois eu retornei uma cópia dele
		for(int i = 0; i < copia.length; i++) {
			copia[i] = 100;
		}
		
		System.out.println(a1.exibeTela());
		System.out.println(a1.calculaSituacao());
		
	}
}
