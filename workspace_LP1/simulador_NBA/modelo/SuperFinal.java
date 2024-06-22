package modelo;

import java.util.Scanner;

public class SuperFinal {
	
	Conferencia campeao_leste;
	Conferencia campeao_oeste;
	
	public SuperFinal(Conferencia campeao_leste, Conferencia campeao_oeste) {
		this.campeao_leste = campeao_leste;
		this.campeao_oeste = campeao_oeste;
	}
	
	public void supercampeao() {
		Scanner scanner = new Scanner(System.in);
		int vitorioso;
		
		System.out.println("Disputa da super final da NBA");
		System.out.println("Campeão da leste: "+campeao_leste.getCampeao().getNome());
		System.out.println("Campeão da oeste: "+campeao_oeste.getCampeao().getNome());
		
		System.out.println("Digite [1] - " +campeao_leste.getCampeao().getNome()+ " / [2] - " +campeao_oeste.getCampeao().getNome());
		vitorioso = scanner.nextInt();
		
		if(vitorioso == 1) {
			System.out.println("E o super campeão é o "+campeao_leste.getCampeao().getNome());
		}
	}
}
