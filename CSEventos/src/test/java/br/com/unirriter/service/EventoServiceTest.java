package br.com.unirriter.service;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.unirriter.enums.TipoIngresso;
import br.com.unirriter.exception.CSEventosException;
import br.com.unirriter.model.Evento;
import br.com.unirriter.model.PeriodoVenda;

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
		this.eventoBuilder(evento, null, 
									LocalDate.now(), null, null);
		
		exceptionEsperada.expect(CSEventosException.class);
		exceptionEsperada.expectMessage("Campo nome é obrigatório!");
		
		eventoService.salvarEvento(evento);
	}
	
	@Test
	public void validarObrigatoriedadeCampoNomeVazio() throws Exception {
		this.eventoBuilder(evento, "", 
									LocalDate.now(), null, null);
		
		exceptionEsperada.expect(CSEventosException.class);
		exceptionEsperada.expectMessage("Campo nome é obrigatório!");
		
		eventoService.salvarEvento(evento);
	}

	@Test
	public void validarObrigatoriedadeCampoDataNula() throws Exception {
		this.eventoBuilder(evento, "Evento A", 
									null, null, null);
		
		exceptionEsperada.expect(CSEventosException.class);
		exceptionEsperada.expectMessage("Campo data é obrigatória!");
		
		eventoService.salvarEvento(evento);
	}
	
	@Test
	public void validarCampoNomeMaiorQue150Caracteres() throws Exception {
		String nome = StringUtils.rightPad("evento ", 151, 'x');
		this.eventoBuilder(evento, nome, 
									LocalDate.now(), 
									null, null);
		
		exceptionEsperada.expect(CSEventosException.class);
		exceptionEsperada.expectMessage("O nome permite no máximo 150 caracteres!");
		
		eventoService.salvarEvento(evento);
	}
	
	@Test
	public void validarCampoDataMenorQueDataAtual() throws Exception {
		this.eventoBuilder(evento, "Evento A", 
									LocalDate.now().minusMonths(1), 
									null, null);
		
		exceptionEsperada.expect(CSEventosException.class);
		exceptionEsperada.expectMessage("A data do evento deve ser maior ou igual a de hoje!");
		
		eventoService.salvarEvento(evento);
	}
	
	@Test
	public void validarPeriodoVendaDataFimMenorQueInicio() throws Exception {
		this.eventoBuilder(evento, "Evento A", 
									LocalDate.now().plusDays(10), 
									LocalDate.now(), 
									LocalDate.now().minusDays(2));
		
		exceptionEsperada.expect(CSEventosException.class);
		exceptionEsperada.expectMessage("A data de início de venda deve ser inferior a data de fim!");
		
		eventoService.salvarEvento(evento);
	}
	
	@Test
	public void validarTiposIngressosDuplicados() throws Exception {
		this.eventoBuilder(evento, "Evento A", 
									LocalDate.now().plusDays(10), 
									LocalDate.now(), 
									LocalDate.now().plusDays(2), 
									TipoIngresso.VIP, 
									TipoIngresso.BACKSTAGE,
									TipoIngresso.PLATEIA_VIP,
									TipoIngresso.BACKSTAGE);
		
		exceptionEsperada.expect(CSEventosException.class);
		exceptionEsperada.expectMessage("Tipos de Ingressos duplicados! Evento não pode ser salvo!");
		
		eventoService.salvarEvento(evento);
	}
	
	@Test
	public void salvarEvento() throws Exception {
		this.eventoBuilder(evento, "Evento Unit Test", 
									LocalDate.now().plusDays(10), 
									LocalDate.now(), 
									LocalDate.now(), 
									TipoIngresso.PLATEIA, 
									TipoIngresso.BACKSTAGE);

		assertTrue(eventoService.salvarEvento(evento));
	}
	
	private void eventoBuilder(Evento evento, String nome, LocalDate data, LocalDate inicio, LocalDate fim, TipoIngresso... ingresso) {
		evento.setNome(nome);
		evento.setData(data);
		evento.setPeriodoVenda(this.periodoVendaBuilder(inicio, fim));
		evento.setIngressos(Arrays.asList(ingresso));
	}
	
	private PeriodoVenda periodoVendaBuilder(LocalDate inicio, LocalDate fim) {
		PeriodoVenda periodoVenda = new PeriodoVenda(inicio, fim);
		return periodoVenda;
	}
}
