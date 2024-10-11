package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Agrupamento<E> {

	private List<E> lista = new ArrayList<>();

	public boolean adiciona(E elemento) {

		if (lista.contains(elemento)) {
			return false;
		} else {
			return lista.add(elemento);
		}
	}

	public boolean remove(E elemento) {
		if (lista.remove(elemento)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean temItens() {
		return !lista.isEmpty();
	}

	public String listagem() {

		String lista_formatada = new String();

		for (E item : lista) {
			lista_formatada += item.toString();
		}

		return lista_formatada;
	}

	public E busca(E elemento) {
		for (E item : lista) {
			if (item.equals(elemento)) {
				return item;
			}
		}

		return null;
	}
	
	protected List<E> getLista() {
		
		ArrayList<E> copia_lista = new ArrayList<>();
		
		for(E item : lista) {
			copia_lista.add(item);
		}
			
		return copia_lista;
	}

	public boolean addEmGrupo(List<E> lista) {
		if (lista.isEmpty()) {
			return false;
		}

		for (E item : lista) {
			lista.add(item);
		}

		return true;
	}
}
