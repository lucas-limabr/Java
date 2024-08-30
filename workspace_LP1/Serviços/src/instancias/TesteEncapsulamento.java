package instancias;

import java.util.ArrayList;

import excecao.LimiteHoras;
import modelo.Assalariado;
import modelo.Cliente;
import modelo.Contrato;
import modelo.Funcionario;
import modelo.Historico;
import modelo.Servico;

public class TesteEncapsulamento {

	public static void main(String[] args) {

		Cliente c1 = new Cliente("Ana", "Carolina", "ana@gmail.com", "F");

		Assalariado f1 = new Assalariado("Lucas", "Lima", "lucas@gmail.com", "M", 1500.0);

		Servico s1;
		try {
			s1 = new Servico("Pintura", 50.0, 5, 6);
			
			System.out.println("Todos os objetos, sem exceção, foram encapsulados" + " com sucesso, confira!");

			Contrato contrato1 = new Contrato(c1, f1, s1);
			
			// criando uma cópia que recebe um objeto da classe Cliente
			Cliente copia1 = contrato1.getCliente();
			
			copia1.setNome("Gustavo");
			System.out.println(contrato1.getCliente().getNome());
			System.out.println("---------");
			
			// criando uma cópia que recebe um objeto da classe Funcionario
			Funcionario copia2 = contrato1.getFuncionario();
			
			copia2.setNome("Zezinho");
			System.out.println(contrato1.getFuncionario().getNome());
			System.out.println("---------");
			
			// criando uma cópia que recebe um objeto da classe Serviço
			Servico copia3 = contrato1.getServico();

			copia3.setDescricao("Tentando alterar descrição");
			System.out.println(contrato1.getServico().getDescricao());
			System.out.println("---------");
			
			// criando instância da classe Historico
			Historico historico = new Historico();
			historico.addContrato(contrato1);
			
			// criando uma cópia que recebe um ArrayList de objetos da classe Contrato
			ArrayList<Contrato> copia_lista = historico.getLista_contratos();

			copia_lista.get(0).setAno_inicio(2050);
			System.out.println(historico.getLista_contratos().get(0).getAno_inicio());
			System.out.println("---------");
			
		} catch (LimiteHoras e) {
			System.out.println(e.getMessage());
		}
	}
}
