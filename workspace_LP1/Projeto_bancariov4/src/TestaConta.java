public class TestaConta {
	public static void main(String[] args) {
		Conta c1 = new Conta(12345, "José da Silva", 2000);
		c1.saca(3000);
		
		Conta c2 = new Conta("Ana Maria", 1000);
		c2.deposita(-500);
		
		Conta c3 = new Conta("Rodrigo");
		
		c1.imprime();
		c2.imprime();
		c3.imprime();
	}
}
