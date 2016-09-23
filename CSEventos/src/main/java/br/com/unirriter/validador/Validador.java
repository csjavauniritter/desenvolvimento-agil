package br.com.unirriter.validador;

import br.com.unirriter.exception.CSEventosException;
import br.com.unirriter.model.Evento;

public interface Validador {

	public void validar(Evento evento) throws CSEventosException;
}
