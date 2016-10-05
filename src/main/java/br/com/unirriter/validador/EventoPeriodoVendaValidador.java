package br.com.unirriter.validador;

import org.joda.time.LocalDate;

import br.com.unirriter.exception.CSEventosException;
import br.com.unirriter.model.Evento;
import br.com.unirriter.utils.DateUtils;

public class EventoPeriodoVendaValidador extends Validador<Evento> {

	@Override
	public void validar(Evento evento) throws CSEventosException {
		if (evento.getPeriodoVenda() == null) {
			throw new CSEventosException("Período de Venda nulo!");
		}
		
		LocalDate dataInicio = evento.getPeriodoVenda().getInicio();
		LocalDate dataFim = evento.getPeriodoVenda().getFim();
		
		if (!DateUtils.verificarDataInicioAnteriorOuIgualDataFim(dataInicio, dataFim)) {
			throw new CSEventosException(this.getPropriedade("evento.data.final.venda.maior.inicio.venda"));
		}
	}
}
