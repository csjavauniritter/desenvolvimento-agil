package br.com.unirriter.validador;

import br.com.unirriter.exception.CSEventosException;
import br.com.unirriter.model.Evento;
import br.com.unirriter.utils.ResourceBundleUtils;

public class NomeMaximoCaracteresValidador implements Validador {

	@Override
	public void validar(Evento evento) throws CSEventosException {
		if (evento.getNome().length() > 150) {
			throw new CSEventosException(ResourceBundleUtils.getInstance().getProperty("evento.nome.maximo.caracteres"));
		}
	}
}
