package br.com.unirriter.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TipoDescontoTest {
	
	private TipoDesconto tipoDesconto;
	
	@Test
	public void validarTipoDescontoGold() {
		tipoDesconto = TipoDesconto.GOLD;
		
		assertEquals(75, tipoDesconto.getDesconto().intValue());
	}
	
	@Test
	public void validarTipoDescontoSilver() {
		tipoDesconto = TipoDesconto.SILVER;
		
		assertEquals(60, tipoDesconto.getDesconto().intValue());
	}
	
	@Test
	public void validarTipoDescontoEstudante() {
		tipoDesconto = TipoDesconto.ESTUDANTE;
		
		assertEquals(50, tipoDesconto.getDesconto().intValue());
	}
	
	@Test
	public void validarTipoDescontoIdoso() {
		tipoDesconto = TipoDesconto.IDOSO;
		
		assertEquals(50, tipoDesconto.getDesconto().intValue());
	}
}
