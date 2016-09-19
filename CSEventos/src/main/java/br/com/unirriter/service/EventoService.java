package br.com.unirriter.service;

import org.joda.time.LocalDate;

import br.com.unirriter.exception.CSEventosException;
import br.com.unirriter.model.Evento;
import br.com.unirriter.utils.DateUtils;

public class EventoService {
	
	public static void validarEvento(Evento evento) throws CSEventosException {
		validarCamposObrigatorios(evento);
		validarNomeCaracteres(evento);
		validarDataMaiorDataAtual(evento);
	}
	
	private static void validarCamposObrigatorios(Evento evento) throws CSEventosException {
		validarCampoNome(evento.getNome());
		validarCampoData(evento.getData());
	}
	
	private static void validarCampoNome(String nome) throws CSEventosException {
		if (null == nome || "".equals(nome.trim())) {
			throw new CSEventosException("Campo nome é obrigatório!");
		}
	}
	
	private static void validarCampoData(LocalDate data) throws CSEventosException {
		if (null == data) {
			throw new CSEventosException("Campo data é obrigatória!");
		}
	}

	private static void validarNomeCaracteres(Evento evento) throws CSEventosException {
		if (evento.getNome().length() > 150) {
			throw new CSEventosException("O nome permite no máximo 150 caracteres!");
		}
	}

	private static void validarDataMaiorDataAtual(Evento evento) throws CSEventosException {
		LocalDate dataEvento = evento.getData();
		
		if (DateUtils.verificarDataAnteriorAtual(dataEvento)) {
			throw new CSEventosException("A data do evento deve ser maior ou igual a de hoje!");
		}
	}
}
