
public class Instancias {

	public static void main(String[] args) {
		// criando as moedas
		Moeda moeda5 = new Moeda(0.05, "cinco centavos");
		Moeda moeda10 = new Moeda(0.1, "dez centavos");
		Moeda moeda25 = new Moeda(0.25, "vinte e cinco centavos");
		Moeda moeda50 = new Moeda(0.5, "cinquenta centavos");
		Moeda moeda1 = new Moeda(1, "um real");

		// criando os proporietários de cada cofre
		Cofre p1 = new Cofre("Lucas");

		for (int i = 0; i < 20; i++) {
			if (i < 5) {
				p1.depositaMoeda(moeda1, moeda25, moeda5);
			}

			if (i > 5 && i <= 8) {
				p1.depositaMoeda(moeda25, moeda5);
			}

			if (i > 8 && i <= 10) {
				p1.depositaMoeda(moeda5);
			}

			p1.depositaMoeda(moeda10);
		}

		p1.depositaMoeda(moeda50);

		for (int i = 0; i < p1.getLista().size(); i++) {
			System.out.println(p1.getLista().get(i).getDescricao());
		}

		System.out.println(p1.getProprietario());
		System.out.println(p1.valorTotalCofre());
		System.out.println("---------");

		// proprietário 2
		Cofre p2 = new Cofre("Hilton");

		for (int i = 0; i < 5; i++) {
			if (i < 2) {
				p2.depositaMoeda(moeda25, moeda50);
			}

			p2.depositaMoeda(moeda10);
		}

		System.out.println(p2.getProprietario());
		System.out.println(p2.valorTotalCofre());
	}
}
