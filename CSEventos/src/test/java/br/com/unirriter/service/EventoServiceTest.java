package br.com.unirriter.service;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.unirriter.exception.CSEventosException;
import br.com.unirriter.model.Evento;

public class EventoServiceTest {

	private Evento evento;
	private EventoService eventoService;
	
	@Rule
	public ExpectedException exceptionEsperada = ExpectedException.none();
	
	@Before
	public void setUp() {
		evento = new Evento();
		eventoService = new EventoService();
	}
	
	@After
	public void tearDown() {
		evento = null;
		eventoService = null;
	}
	
	@Test
	public void validarObrigatoriedadeCampoNomeNulo() throws Exception {
		evento.setData(LocalDate.now());
		
		exceptionEsperada.expect(CSEventosException.class);
		exceptionEsperada.expectMessage("Campo nome é obrigatório!");
		
		eventoService.salvarEvento(evento);
	}
	
	@Test
	public void validarObrigatoriedadeCampoNomeVazio() throws Exception {
		evento.setNome("");
		evento.setData(LocalDate.now());
		
		exceptionEsperada.expect(CSEventosException.class);
		exceptionEsperada.expectMessage("Campo nome é obrigatório!");
		
		eventoService.salvarEvento(evento);
	}

	@Test
	public void validarObrigatoriedadeCampoDataNula() throws Exception {
		evento.setNome("Evento A");
		evento.setData(null);
		
		exceptionEsperada.expect(CSEventosException.class);
		exceptionEsperada.expectMessage("Campo data é obrigatória!");
		
		eventoService.salvarEvento(evento);
	}
	
	@Test
	public void validarCampoNomeMaiorQue150Caracteres() throws Exception {
		String nome = StringUtils.rightPad("evento ", 151, 'x');
		evento.setNome(nome);
		
		evento.setData(LocalDate.now());
		
		exceptionEsperada.expect(CSEventosException.class);
		exceptionEsperada.expectMessage("O nome permite no máximo 150 caracteres!");
		
		eventoService.salvarEvento(evento);
	}
	
	@Test
	public void validarCampoDataMenorQueDataAtual() throws Exception {
		evento.setNome("Evento A");
		LocalDate dataPassada = LocalDate.now().minusMonths(1);
		evento.setData(dataPassada);
		
		exceptionEsperada.expect(CSEventosException.class);
		exceptionEsperada.expectMessage("A data do evento deve ser maior ou igual a de hoje!");
		
		eventoService.salvarEvento(evento);
	}
	
	@Test
	public void salvarEvento() throws Exception {
		evento.setNome("Evento Unit Test");
		LocalDate data = LocalDate.now().plusDays(10);
		evento.setData(data);
		
		assertTrue(eventoService.salvarEvento(evento));
	}
}
