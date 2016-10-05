package br.com.unirriter.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.unirriter.enums.TipoDesconto;
import br.com.unirriter.enums.TipoIngresso;

public class DescontoEstrategiaPadraoTest {
	
	private DescontoEstrategia descontoEstrategiaPadrao;
	
	@Test
	public void validarDescontoVIPParaIdoso() {
		descontoEstrategiaPadrao = DescontoEstrategiaPadraoFixture.get().build(TipoIngresso.VIP, TipoDesconto.IDOSO);
		
		assertEquals(Double.valueOf(500.0), descontoEstrategiaPadrao.calcular());
	}
	
	@Test
	public void validarDescontoVIPParaPublicoGeral() {
		descontoEstrategiaPadrao = DescontoEstrategiaPadraoFixture.get().build(TipoIngresso.VIP, TipoDesconto.INTEIRO);
		
		assertEquals(Double.valueOf(1000.0), descontoEstrategiaPadrao.calcular());
	}
}
