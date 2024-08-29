package modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Ranking {

	private static Map<Cliente, String> ranking = new HashMap<>();
	
	public static void categorizar(Cliente cliente) {
		
		if(cliente.getValor_total_pago() >= 30000) {
			ranking.put(cliente, "A");
		}
		else if(cliente.getValor_total_pago() >= 10000) {
			ranking.put(cliente, "B");
		}
		else {
			ranking.put(cliente, "C");
		}
	}
	
	public static String getCategoria(Cliente cliente) {
		return ranking.get(cliente);
	}
	
	public static Set<Cliente> getKeys(){
		Set<Cliente> conjunto_keys = ranking.keySet();
		
		return conjunto_keys;
	}
}
