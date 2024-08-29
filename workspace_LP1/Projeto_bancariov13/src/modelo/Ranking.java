package modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Ranking {

	private static Map<Integer, String> ranking = new HashMap<Integer, String>();

	public static boolean categorizar(Integer codigo, double saldo) {

		if (saldo >= 50.000) {
			ranking.put(codigo, "A");
			return true;
		} else if (saldo >= 10.000) {
			ranking.put(codigo, "B");
			return true;
		} else if (saldo > 0) {
			ranking.put(codigo, "C");
			return true;
		}
		return false;
	}

	public static String getCategoria(Integer codigo) {

		return ranking.get(codigo);
	}
	
	public static Set<Integer> getKeys(){
		Set<Integer> conjunto_keys = ranking.keySet();
		
		return conjunto_keys;
	}
}
