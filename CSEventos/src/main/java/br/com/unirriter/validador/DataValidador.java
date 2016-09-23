package br.com.unirriter.validador;

import org.joda.time.LocalDate;

import br.com.unirriter.exception.CSEventosException;
import br.com.unirriter.model.Evento;
import br.com.unirriter.utils.DateUtils;

public class DataValidador implements Validador {

	@Override
	public void validar(Evento evento) throws CSEventosException {
		LocalDate dataEvento = evento.getData();
		
		if (DateUtils.verificarDataAnteriorAtual(dataEvento)) {
			throw new CSEventosException("A data do evento deve ser maior ou igual a de hoje!");
		}
	}
}
