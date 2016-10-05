package br.com.unirriter.service;

import br.com.unirriter.enums.TipoDesconto;
import br.com.unirriter.enums.TipoIngresso;

public class DescontoEstrategiaPadraoFixture {
	
	private static DescontoEstrategiaPadraoFixture instance;
	
	private DescontoEstrategiaPadraoFixture() {
	}
	
	public static DescontoEstrategiaPadraoFixture get() {
		if (instance == null) {
			instance = new DescontoEstrategiaPadraoFixture();
		}
		
		return instance;
	}
	
	public DescontoEstrategiaPadrao build(TipoIngresso tipoIngresso, TipoDesconto tipoDesconto) {
		DescontoEstrategiaPadrao descontoEstrategiaPadrao = new DescontoEstrategiaPadrao(tipoIngresso, tipoDesconto);
		return descontoEstrategiaPadrao;
	}
}
