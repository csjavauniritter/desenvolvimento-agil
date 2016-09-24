package br.com.unirriter.enums;

import java.math.BigDecimal;

public enum TipoIngresso {
	
	VIP(BigDecimal.valueOf(1000)), 
	BACKSTAGE(BigDecimal.valueOf(800)), 
	PLATEIA_VIP(BigDecimal.valueOf(500)), 
	PLATEIA(BigDecimal.valueOf(300));
	
	private BigDecimal valor;
	
	private TipoIngresso(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValor() {
		return valor;
	}
}
