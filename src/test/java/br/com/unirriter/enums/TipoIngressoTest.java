package br.com.unirriter.enums;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class TipoIngressoTest {
	
	private TipoIngresso tipoIngresso;
	
	@Test
	public void validarTipoIngressoVIPValor1000() {
		tipoIngresso = TipoIngresso.VIP;
		
		assertEquals(BigDecimal.valueOf(1000.0), tipoIngresso.getValor());
	}
	
	@Test
	public void validarTipoIngressoBackstageValor800() {
		tipoIngresso = TipoIngresso.BACKSTAGE;
		
		assertEquals(BigDecimal.valueOf(800.0), tipoIngresso.getValor());
	}
	
	@Test
	public void validaTipoIngressoPlateiaVIPValor500() {
		tipoIngresso = TipoIngresso.PLATEIA_VIP;
		
		assertEquals(BigDecimal.valueOf(500.0), tipoIngresso.getValor());
	}
	
	@Test
	public void validaTipoIngressoPlateiaValor300() {
		tipoIngresso = TipoIngresso.PLATEIA;
		
		assertEquals(BigDecimal.valueOf(300.0), tipoIngresso.getValor());
	}
}
