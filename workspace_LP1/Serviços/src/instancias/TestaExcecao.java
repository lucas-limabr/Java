package instancias;

import excecao.LimiteHoras;
import modelo.Servico;

public class TestaExcecao {

	public static void main(String[] args) {
		
		
		try {
			Servico s1 = new Servico("Pintura", 50.0, 2300, 24001);
			System.out.println(s1);
		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Servico s2 = new Servico("Encanador", 80.0, 4, 5);
			System.out.println(s2);
		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());
		}
	}

}
