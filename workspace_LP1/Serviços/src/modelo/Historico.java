package modelo;

import java.util.ArrayList;

public class Historico {

	//composição
	private ArrayList<Contrato> lista_contratos = new ArrayList<Contrato>();

	public void informacoes(Contrato contrato) {
		if(lista_contratos.contains(contrato)) {
			System.out.println("Número da ordem do contrato: "+contrato.getNum_ordem());
			System.out.println("Ano de início: "+contrato.getAno_inicio());
			System.out.println("Mês de início: "+contrato.getMes_inicio());
		}
		else {
			System.out.println("Este contrato não existe");
		}
	}

	public double faturamentoTotPrevisto() {
		double faturamento_previsto = 0.0;
		
		for(Contrato item : lista_contratos) {
			faturamento_previsto += item.getServico().calculaOrcamento();
		}
		
		return faturamento_previsto;
	}
	
	public double faturamentoPago() {
		double faturamento_pg = 0.0;
		
		for(Contrato item : lista_contratos) {
			faturamento_pg += item.getServico().valorPago();
		}
		
		return faturamento_pg;
	}
	
	//parâmetro varargs para aceitar a passagem de vários objetos ao mesmo tempo
	public boolean addContrato(Contrato... contrato) {
		boolean pelomenos_um_add = false;
		
		for(Contrato item : contrato) {
			if(!lista_contratos.contains(item)) {
				lista_contratos.add(item);
				pelomenos_um_add = true;
			}
			else {
				System.out.println("O contrato "+item.getNum_ordem()+" não foi adicionado, pois, "
						+ "ele já existe na lista!");
			}
		}

		return pelomenos_um_add;
	}
	
	public boolean removeContrato(Contrato contrato) {
		if(lista_contratos.remove(contrato)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean buscaContrato(Contrato contrato) {
		if(lista_contratos.contains(contrato)) {
			return true;
		}
		else {
			return false;
		}
	}

	//getter
	public ArrayList<Contrato> getLista_contratos() {
		
		ArrayList<Contrato> copia_lista = new ArrayList<Contrato>();
		
		for(Contrato item : lista_contratos) {
			copia_lista.add(new Contrato(item));
		}
		//ArrayList de objetos encapsulado
		return copia_lista;
	}
}
