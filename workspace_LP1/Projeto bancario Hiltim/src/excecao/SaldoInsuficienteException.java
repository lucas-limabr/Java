package excecao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class SaldoInsuficienteException extends Exception{
	private static ArrayList<String> historico = new ArrayList<String>();
	private static int contador = 0;
		
	public SaldoInsuficienteException(String tipoConta){
        contador++;
        historico.add("Saque inv�lido no. " + contador + " em uma " + 
        		tipoConta + ": em " + LocalDate.now() + 
        		" �s " + LocalTime.now());
    }
	
	public static ArrayList<String> getHistorico(){
		return (ArrayList<String>) historico;//n�o evitei a quebra de encaspsulamento
	}
	
	public String getMessage() {
		return "Um saque inv�lido foi registrado!";
	}
}