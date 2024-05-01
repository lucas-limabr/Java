public class TestaConta {
	public static void main(String[] args) {
		
		//instanciando a classe Clientes
		Clientes cl1 = new Clientes(001, "Rodrigo", "rodri@gmail.com", "32928765");
		Clientes cl2 = new Clientes(010, "Léo", "leo@gmail.com", "32928741");
		Clientes cl3 = new Clientes(011, "Bruno", "bruno@gmail.com", "32928712");
		
		Conta c1 = new Conta(cl1, 12345, 2000);
		c1.saca(3000);
		
		Conta c2 = new Conta(cl2, 1000);
		c2.deposita(-500);
		
		Conta c3 = new Conta(cl3);
		
		c1.imprime();
		c2.imprime();
		c3.imprime();
	}
}
