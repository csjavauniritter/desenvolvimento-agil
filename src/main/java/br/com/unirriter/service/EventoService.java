package br.com.unirriter.service;

import java.util.List;

import br.com.unirriter.exception.CSEventosException;
import br.com.unirriter.model.Evento;
import br.com.unirriter.validador.Validador;
import br.com.unirriter.validador.EventoValidadorFactory;

public class EventoService {
	
	private EventoValidadorFactory validador;
	
	public EventoService() {
		this.validador = EventoValidadorFactory.getInstance();
	}

	public boolean salvarEvento(Evento evento) throws CSEventosException {
		if (evento == null) {
			throw new CSEventosException("Evento nulo!");
		}
		
		/**
		 * validar evento
		 */
		List<Validador<Evento>> validadores = validador.getValidadores();
		for (Validador<Evento> validador : validadores) {
			validador.validar(evento);
		}
		
		/**
		 * salvar evento
		 */
		return true;
	}
}
