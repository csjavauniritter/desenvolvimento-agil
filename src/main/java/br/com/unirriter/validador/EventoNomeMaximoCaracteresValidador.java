package br.com.unirriter.validador;

import br.com.unirriter.exception.CSEventosException;
import br.com.unirriter.model.Evento;

public class EventoNomeMaximoCaracteresValidador extends Validador<Evento> {

	@Override
	public void validar(Evento evento) throws CSEventosException {
		if (evento.getNome().length() > 150) {
			throw new CSEventosException(this.getPropriedade("evento.nome.maximo.caracteres"));
		}
	}
}
