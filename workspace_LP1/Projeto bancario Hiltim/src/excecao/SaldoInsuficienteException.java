package excecao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class SaldoInsuficienteException extends Exception{
	private static ArrayList<String> historico = new ArrayList<String>();
	private static int contador = 0;
		
	public SaldoInsuficienteException(String tipoConta){
        contador++;
        historico.add("Saque inválido no. " + contador + " em uma " + 
        		tipoConta + ": em " + LocalDate.now() + 
        		" às " + LocalTime.now());
    }
	
	public static ArrayList<String> getHistorico(){
		return (ArrayList<String>) historico;//não evitei a quebra de encaspsulamento
	}
	
	public String getMessage() {
		return "Um saque inválido foi registrado!";
	}
}