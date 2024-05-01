package instancias;

import java.util.ArrayList;

import modelo.Cliente;
import modelo.Contrato;
import modelo.Funcionario;
import modelo.Historico;
import modelo.Pessoas;
import modelo.Servico;

public class TesteEncapsulamento {

	public static void main(String[] args) {
		
		//criando instâncias da classe Pessoas
		Pessoas p1 = new Pessoas("Lucas", "Lima", "lucas@gmail.com", "M");
		Pessoas p2 = new Pessoas("Ana", "Carolina", "ana@gmail.com", "F");
		
		//criando instância da classe Cliente
		Cliente c1 = new Cliente(p1, "C1");
		
		//criando instância da classe Servico
		Servico s1 = new Servico("Pintura", 50.0, 5, 6, "S1"); 
		
		System.out.println("Todos os objetos, sem exceção, foram encapsulados"
				+ " com sucesso, confira!");
		
		//criando uma cópia que recebe um objeto da classe Pessoas
		Pessoas copia = c1.getCliente();
		
		//alterei na cópia
		copia.setNome("Vini");
		
		//não se refletiu no objeto original
		System.out.println(c1.getCliente().getNome());
		System.out.println("---------");
		
		//criando instância da classe Funcionário
		Funcionario f1 = new Funcionario(p2, "F1");
		
		//criando uma cópia que recebe um objeto da classe Pessoas
		Pessoas copia2 = f1.getFuncionario();
		
		copia2.setNome("Jorge");
		System.out.println(f1.getFuncionario().getNome());
		System.out.println("---------");
		
		//criando instância da classe Contrato
		Contrato contrato1 = new Contrato(c1, f1, s1);
		
		//criando uma cópia que recebe um objeto da classe Cliente
		Cliente copia3 = contrato1.getCliente();
		
		copia3.getCliente().setNome("Gustavo");
		System.out.println(contrato1.getCliente().getCliente().getNome());
		System.out.println("---------");
		
		//criando uma cópia que recebe um objeto da classe Funcionario
		Funcionario copia4 = contrato1.getFuncionario();
		
		copia4.getFuncionario().setNome("Zezinho");
		System.out.println(contrato1.getFuncionario().getFuncionario().getNome());
		System.out.println("---------");
		
		//criando uma cópia que recebe um objeto da classe Serviço
		Servico copia5 = contrato1.getServico();
		
		copia5.setDescricao("Tentando alterar descrição");
		System.out.println(contrato1.getServico().getDescricao());
		System.out.println("---------");
		
		//criando instância da classe Historico
		Historico historico = new Historico();
		historico.addContrato(contrato1);
		
		//criando uma cópia que recebe um ArrayList de objetos da classe Contrato
		ArrayList<Contrato> copia_lista = historico.getLista_contratos();
		
		copia_lista.get(0).setAno_inicio(2050);
		System.out.println(historico.getLista_contratos().get(0).getAno_inicio());
		System.out.println("---------");
	}
}
