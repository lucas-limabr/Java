
public class Cofre {
	private Moeda[] listaMoedas;
	private String proprietario;

	public Cofre(String proprietario) {

		this.proprietario = proprietario;
		listaMoedas = new Moeda[100];
	}

	void depositaMoeda(Moeda... moeda) {
		int i = 0;

		while (listaMoedas[i] != null) {
			if (i == 99) {
				break;
			}
			i++;
		}

		if (listaMoedas[i] == null) {
			for (int j = 0; j < moeda.length && i <= 99; j++) {
				listaMoedas[i] = moeda[j];
				i++;
			}
		}

	}

	double valorTotalCofre() {
		int qtd_5 = 0, qtd_10 = 0, qtd_25 = 0, qtd_50 = 0, qtd_1 = 0;
		double valor = 0;

		for (int i = 0; getListaMoedas()[i] != null; i++) {
			if (getListaMoedas()[i].getValor() == 0.05) {
				qtd_5++;
			} else if (getListaMoedas()[i].getValor() == 0.1) {
				qtd_10++;
			} else if (getListaMoedas()[i].getValor() == 0.25) {
				qtd_25++;
			} else if (getListaMoedas()[i].getValor() == 0.5) {
				qtd_50++;
			} else {
				qtd_1++;
			}
		}

		valor = (qtd_5 * 0.05) + (qtd_10 * 0.1) + (qtd_25 * 0.25) + (qtd_50 * 0.5) + (qtd_1 * 1.0);
		return valor;
	}

	public Moeda[] getListaMoedas() {
		return listaMoedas;
	}

	public void setListaMoedas(Moeda[] listaMoedas) {
		this.listaMoedas = listaMoedas;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

}
