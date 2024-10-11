package instancias;
import excecao.LimiteHoras;
import modelo.Assalariado;
import modelo.Cliente;
import modelo.Comissionado;
import modelo.Contrato;
import modelo.Funcionario;
import modelo.HistoricoContratos;
import modelo.Servico;

public class TesteAgrupamento {

	public static void main(String[] args) {

		Cliente c1 = new Cliente("Lucas", "Lima", "lucas@gmail.com", "M");
		Cliente c2 = new Cliente("Ana", "Carolina", "ana@gmail.com", "F");

		Funcionario f1 = new Assalariado("Gabriela", "Rezende", "gabriela@gmail.com", "F", 1500.0);
		Funcionario f2 = new Comissionado("Pedro", "Augusto", "pedro@gmail.com", "M", 800);

		HistoricoContratos lista_contratos = new HistoricoContratos();
		Contrato contract1 = null;
		Contrato contract2 = null;

		Servico s1;
		try {
			s1 = new Servico("Reparo em eletrodomésticos", 100.0, 4, 6);

			contract1 = new Contrato(c1, f1, s1);

		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());
		}

		Servico s2;
		try {
			s2 = new Servico("Fiação elétrica", 110.0, 5, 5);

			contract2 = new Contrato(c2, f2, s2);
			lista_contratos.adiciona(contract2);

		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());

		}

		lista_contratos.adiciona(contract1);
		lista_contratos.adiciona(contract2);
		System.out.println(lista_contratos.informacoes(contract2));
		
		System.out.println(lista_contratos.consultarCategoriaCliente("C1"));
		
		System.out.println(lista_contratos.faturamentoPago()); 
		
	}
}
