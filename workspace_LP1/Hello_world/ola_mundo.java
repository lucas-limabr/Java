import java.time.LocalTime;

public class ola_mundo {

	public static void main(String... parametros) {
		
		//objetos para hora
		LocalTime hora_atual = LocalTime.now();
		
		int hora = hora_atual.getHour();
		String turno;
		
		if(hora >= 0 && hora < 5) {
			turno = "Acordado na madrugada pai?";
		}
		else if(hora < 12) {
			turno = "Bom dia my friend";
		}
		else if(hora < 18) {
			turno = "Boa tarde amigão";
		}
		else {
			turno = "Boa noite meu querido";
		}
		
		System.out.println(turno);
		System.out.println("Foram recebidos "+parametros.length+" parâmetros");
		
		for(String nomes : parametros) {
			System.out.println(nomes);
		}
	}
}
