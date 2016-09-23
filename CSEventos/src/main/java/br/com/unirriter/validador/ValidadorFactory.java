package br.com.unirriter.validador;

import java.util.LinkedList;
import java.util.List;

public class ValidadorFactory {
	
	private static ValidadorFactory instance = null;
	
	private List<Validador> validadores;
	
	protected ValidadorFactory() {
		this.criarValidadores();
	}
	
	public static ValidadorFactory getInstance() {
		if (instance == null) {
			instance = new ValidadorFactory();
		}
		return instance;
	}
	
	public List<Validador> getValidadores() {	
		return validadores;
	}
	
	private void criarValidadores() {
		validadores = new LinkedList<Validador>();
		validadores.add(new CamposObrigatoriosValidador());
		validadores.add(new NomeMaximoCaracteresValidador());
		validadores.add(new DataValidador());
	}
}
