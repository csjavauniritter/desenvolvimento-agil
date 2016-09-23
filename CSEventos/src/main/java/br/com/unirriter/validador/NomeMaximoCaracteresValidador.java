package br.com.unirriter.validador;

import br.com.unirriter.exception.CSEventosException;
import br.com.unirriter.model.Evento;

public class NomeMaximoCaracteresValidador implements Validador {

	@Override
	public void validar(Evento evento) throws CSEventosException {
		if (evento.getNome().length() > 150) {
			throw new CSEventosException("O nome permite no máximo 150 caracteres!");
		}
	}
}
