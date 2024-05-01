import java.util.ArrayList;
import java.util.List;

public class Cofre {
	private List<Moeda> lista = new ArrayList<Moeda>();
	private String proprietario;

	public Cofre(String proprietario) {
		this.proprietario = proprietario;
		
	}

	void depositaMoeda(Moeda... moeda) {
		
		for(int i = 0; i < moeda.length; i++) {
			lista.add(moeda[i]);
		}
	}

	double valorTotalCofre() {
		int qtd_5 = 0, qtd_10 = 0, qtd_25 = 0, qtd_50 = 0, qtd_1 = 0;
		double valor = 0;

		for (Moeda item : lista) {
			if (item.getValor() == 0.05) {
				qtd_5++;
			} else if (item.getValor() == 0.1) {
				qtd_10++;
			} else if (item.getValor() == 0.25) {
				qtd_25++;
			} else if (item.getValor() == 0.5) {
				qtd_50++;
			} else {
				qtd_1++;
			}
		}

		valor = (qtd_5 * 0.05) + (qtd_10 * 0.1) + (qtd_25 * 0.25) + (qtd_50 * 0.5) + (qtd_1 * 1.0);
		return valor;
	}

	public List<Moeda> getLista() {
		return lista;
	}

	public void setLista(List<Moeda> lista) {
		this.lista = lista;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

}
