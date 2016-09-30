package br.com.unirriter.validador;

import java.util.List;

import br.com.unirriter.enums.TipoIngresso;
import br.com.unirriter.exception.CSEventosException;
import br.com.unirriter.model.Evento;

public class EventoTiposIngressosValidador extends Validador<Evento> {

	@Override
	public void validar(Evento evento) throws CSEventosException {
		if (evento.getIngressos() == null || evento.getIngressos().isEmpty()) {
			throw new CSEventosException("Tipos de Ingressos inválidos!");
		}
		
		List<TipoIngresso> ingressos = evento.getIngressos();
		this.validarIngressosDuplicados(ingressos);
	}
	
	private void validarIngressosDuplicados(List<TipoIngresso> ingressos) throws CSEventosException {
		for (TipoIngresso tipoIngresso : TipoIngresso.values()) {
			boolean duplicados = this.verificarIngressosDuplicados(tipoIngresso, ingressos);
			if (duplicados) {
				throw new CSEventosException(this.getPropriedade("evento.tipos.ingressos.duplicados"));
			}
		}
	}
	
	private boolean verificarIngressosDuplicados(TipoIngresso tipoIngresso, List<TipoIngresso> ingressos) {
		int numeroIngressos = 0;
		for (TipoIngresso ingresso : ingressos) {
			if (tipoIngresso.equals(ingresso)) {
				numeroIngressos++;
			}
		}
		return numeroIngressos > 1;
	}
}
