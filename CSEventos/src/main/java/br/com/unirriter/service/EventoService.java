package br.com.unirriter.service;

import java.util.List;

import br.com.unirriter.exception.CSEventosException;
import br.com.unirriter.model.Evento;
import br.com.unirriter.validador.Validador;
import br.com.unirriter.validador.ValidadorFactory;

public class EventoService {
	
	private ValidadorFactory validador;
	
	public EventoService() {
		this.validador = ValidadorFactory.getInstance();
	}

	public boolean salvarEvento(Evento evento) throws CSEventosException {
		if (evento == null) {
			throw new CSEventosException("Evento nulo!");
		}
		
		/**
		 * validar evento
		 */
		List<Validador> validadores = validador.getValidadores();
		for (Validador validador : validadores) {
			validador.validar(evento);
		}
		
		/**
		 * salvar evento
		 */
		return true;
	}
}
