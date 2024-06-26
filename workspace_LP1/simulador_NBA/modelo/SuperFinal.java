package modelo;

import java.util.Scanner;

public class SuperFinal {
	
	Times campeao_leste;
	Times campeao_oeste;
	
	public SuperFinal(Times campeao_leste, Times campeao_oeste) {
		this.campeao_leste = campeao_leste;
		this.campeao_oeste = campeao_oeste;
	}
	
	public void supercampeao() {
		Scanner scanner = new Scanner(System.in);
		int vitorioso;
		
		System.out.println("\nDisputa da super final da NBA");
		System.out.println("Campeão da leste: "+campeao_leste.getNome());
		System.out.println("Campeão da oeste: "+campeao_oeste.getNome());
		
		System.out.println("\nDigite [1] - " +campeao_leste.getNome() + " / [2] - " +campeao_oeste.getNome());
		vitorioso = scanner.nextInt();
		
		if(vitorioso == 1) {
			System.out.println("\nE o super campeão é o "+campeao_leste.getNome());
		}
	}
}
