package aplication;

import java.util.Scanner;

public class SuperFinal {
	String campeao_leste;
	String campeao_oeste;
	
	public SuperFinal(String campeao_leste, String campeao_oeste) {
		this.campeao_leste = campeao_leste;
		this.campeao_oeste = campeao_oeste;
		
		supercampeao();
	}
	
	public void supercampeao() {
		Scanner scanner = new Scanner(System.in);
		int vitorioso;
		
		System.out.println("Disputa da super final da NBA");
		System.out.println("Campeão da leste: "+campeao_leste);
		System.out.println("Campeão da oeste: "+campeao_oeste);
		
		System.out.println("Digite [1] - " +campeao_leste+ " / [2] - " +campeao_oeste);
		vitorioso = scanner.nextInt();
		
		if(vitorioso == 1) {
			System.out.println("E o super campeão é o "+campeao_leste);
		}
		else if (vitorioso == 2) {
			System.out.println("E o super campeão é o "+campeao_oeste);
		}
	}
}
