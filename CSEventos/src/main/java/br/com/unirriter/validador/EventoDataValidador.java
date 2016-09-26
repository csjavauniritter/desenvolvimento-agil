package br.com.unirriter.validador;

import org.joda.time.LocalDate;

import br.com.unirriter.exception.CSEventosException;
import br.com.unirriter.model.Evento;
import br.com.unirriter.utils.DateUtils;

public class EventoDataValidador extends Validador<Evento> {

	@Override
	public void validar(Evento evento) throws CSEventosException {
		LocalDate dataEvento = evento.getData();
		
		if (!DateUtils.verificarDataAnteriorOuIgualAtual(dataEvento)) {
			throw new CSEventosException(this.getPropriedade("evento.data.maior.data.atual"));
		}
	}
}
