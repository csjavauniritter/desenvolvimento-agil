package br.com.unirriter.service;

import br.com.unirriter.enums.TipoDesconto;
import br.com.unirriter.enums.TipoIngresso;

public class DescontoEstrategiaPadrao implements DescontoEstrategia {

	private TipoIngresso ingresso;
	private TipoDesconto desconto;
	
	public DescontoEstrategiaPadrao(TipoIngresso ingresso, TipoDesconto desconto) {
		this.ingresso = ingresso;
		this.desconto = desconto;
	}

	@Override
	public Double calcular() {
		Integer valorDesconto = 100 - desconto.getDesconto();
		
		return (ingresso.getValor().doubleValue() * valorDesconto) / 100;
	}
}
