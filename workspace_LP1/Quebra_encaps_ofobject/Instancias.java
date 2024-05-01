
public class Instancias {

	public static void main(String[] args) {

		Curso c = new Curso(111, "BSI");
		Aluno a = new Aluno("Fulano", c);
		System.out.println(a);
		
		Curso auxiliar = a.getCurso();
		auxiliar.setDescricao("Téc. TI");
		
		System.out.println(a);
	}

}
