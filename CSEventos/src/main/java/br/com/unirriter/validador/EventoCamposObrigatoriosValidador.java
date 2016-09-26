package br.com.unirriter.validador;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;

import br.com.unirriter.exception.CSEventosException;
import br.com.unirriter.model.Evento;

public class EventoCamposObrigatoriosValidador extends Validador<Evento> {

	@Override
	public void validar(Evento evento) throws CSEventosException {
		this.validarCampoNome(evento.getNome());
		this.validarCampoData(evento.getData());
	}

	private void validarCampoNome(String nome) throws CSEventosException {
		if (StringUtils.isBlank(nome)) {
			throw new CSEventosException(this.getPropriedade("evento.nome.obrigatorio"));
		}
	}
	
	private void validarCampoData(LocalDate data) throws CSEventosException {
		if (data == null) {
			throw new CSEventosException(this.getPropriedade("evento.data.obrigatorio"));
		}
	}
}
