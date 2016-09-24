package br.com.unirriter.validador;

import java.util.LinkedList;
import java.util.List;

public class EventoValidadorFactory {
	
	private static EventoValidadorFactory instance = null;
	
	private List<EventoValidador> validadores;
	
	protected EventoValidadorFactory() {
		validadores = new LinkedList<EventoValidador>();
		this.criarValidadores();
	}
	
	public static EventoValidadorFactory getInstance() {
		if (instance == null) {
			instance = new EventoValidadorFactory();
		}
		return instance;
	}
	
	public List<EventoValidador> getValidadores() {	
		return validadores;
	}
	
	private void criarValidadores() {
		validadores.add(new EventoCamposObrigatoriosValidador());
		validadores.add(new EventoNomeMaximoCaracteresValidador());
		validadores.add(new EventoDataValidador());
	}
}
