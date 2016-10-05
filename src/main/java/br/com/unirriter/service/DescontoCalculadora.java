package br.com.unirriter.service;

public class DescontoCalculadora {

	private DescontoEstrategia descontoEstrategia;
	
	public DescontoCalculadora(DescontoEstrategia descontoEstrategia) {
		this.descontoEstrategia = descontoEstrategia;
	}
	
	public Double getDesconto() {
		return descontoEstrategia.calcular();
	}
}
