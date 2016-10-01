package br.com.unirriter.enums;

import java.math.BigDecimal;

public enum TipoIngresso {
	
	VIP(1000.0), 
	BACKSTAGE(800.0), 
	PLATEIA_VIP(500.0), 
	PLATEIA(300.0);
	
	private BigDecimal valor;
	
	private TipoIngresso(Double valor) {
		this.valor = BigDecimal.valueOf(valor);
	}

	public BigDecimal getValor() {
		return valor;
	}
	
	public Double getValorComDesconto(TipoDesconto tipoDesconto) {
		return (valor.doubleValue() * tipoDesconto.getDesconto()) / 100;
	}
}
