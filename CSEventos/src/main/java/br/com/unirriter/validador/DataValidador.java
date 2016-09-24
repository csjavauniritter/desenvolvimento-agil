package br.com.unirriter.validador;

import org.joda.time.LocalDate;

import br.com.unirriter.exception.CSEventosException;
import br.com.unirriter.model.Evento;
import br.com.unirriter.utils.DateUtils;
import br.com.unirriter.utils.ResourceBundleUtils;

public class DataValidador implements Validador {

	@Override
	public void validar(Evento evento) throws CSEventosException {
		LocalDate dataEvento = evento.getData();
		
		if (DateUtils.verificarDataAnteriorAtual(dataEvento)) {
			throw new CSEventosException(ResourceBundleUtils.getInstance().getProperty("evento.data.maior.data.atual"));
		}
	}
}
