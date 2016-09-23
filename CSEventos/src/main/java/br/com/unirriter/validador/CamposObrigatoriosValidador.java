package br.com.unirriter.validador;

import org.joda.time.LocalDate;

import br.com.unirriter.exception.CSEventosException;
import br.com.unirriter.model.Evento;

public class CamposObrigatoriosValidador implements Validador {

	@Override
	public void validar(Evento evento) throws CSEventosException {
		this.validarCampoNome(evento.getNome());
		this.validarCampoData(evento.getData());
	}

	private void validarCampoNome(String nome) throws CSEventosException {
		if (nome == null || "".equals(nome.trim())) {
			throw new CSEventosException("Campo nome é obrigatório!");
		}
	}
	
	private void validarCampoData(LocalDate data) throws CSEventosException {
		if (data == null) {
			throw new CSEventosException("Campo data é obrigatória!");
		}
	}
}
