package br.com.unirriter.enums;

public enum TipoDesconto {
	
	INTEIRO(0),
	GOLD(75),
	SILVER(60),
	ESTUDANTE(50),
	IDOSO(50);
	
	private Integer desconto;
	
	private TipoDesconto(Integer desconto) {
		this.desconto = desconto;
	}
	
	public Integer getDesconto() {
		return desconto;
	}
}
