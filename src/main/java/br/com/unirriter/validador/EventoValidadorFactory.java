package br.com.unirriter.validador;

import java.util.LinkedList;
import java.util.List;

import br.com.unirriter.model.Evento;

public class EventoValidadorFactory {
	
	private static EventoValidadorFactory instance = null;
	
	private List<Validador<Evento>> validadores;
	
	protected EventoValidadorFactory() {
		validadores = new LinkedList<Validador<Evento>>();
		this.criarValidadores();
	}
	
	public static EventoValidadorFactory getInstance() {
		if (instance == null) {
			instance = new EventoValidadorFactory();
		}
		return instance;
	}
	
	public List<Validador<Evento>> getValidadores() {	
		return validadores;
	}
	
	private void criarValidadores() {
		validadores.add(new EventoCamposObrigatoriosValidador());
		validadores.add(new EventoNomeMaximoCaracteresValidador());
		validadores.add(new EventoDataValidador());
		validadores.add(new EventoPeriodoVendaValidador());
		validadores.add(new EventoTiposIngressosValidador());
	}
}
