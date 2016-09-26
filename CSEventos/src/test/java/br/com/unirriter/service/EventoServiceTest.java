package br.com.unirriter.service;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

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
	public void validarPeriodoVendaDataFimMenorQueInicio() throws Exception {
		evento.setNome("Evento A");
		evento.setData(LocalDate.now().plusDays(10));
		
		LocalDate periodoVendaInicio = LocalDate.now();
		LocalDate periodoVendaFim = LocalDate.now().minusDays(2);
		evento.setPeriodoVenda(new PeriodoVenda(periodoVendaInicio, periodoVendaFim));
		
		exceptionEsperada.expect(CSEventosException.class);
		exceptionEsperada.expectMessage("A data de início de venda deve ser inferior a data de fim!");
		
		eventoService.salvarEvento(evento);
	}
	
	@Test
	public void validarTiposIngressosDuplicados() throws Exception {
		evento.setNome("Evento A");
		evento.setData(LocalDate.now().plusDays(10));
		
		LocalDate periodoVendaInicio = LocalDate.now();
		LocalDate periodoVendaFim = LocalDate.now().plusDays(2);
		evento.setPeriodoVenda(new PeriodoVenda(periodoVendaInicio, periodoVendaFim));
		
		List<TipoIngresso> ingressos = new LinkedList<TipoIngresso>();
		ingressos.add(TipoIngresso.VIP);
		ingressos.add(TipoIngresso.BACKSTAGE);
		ingressos.add(TipoIngresso.BACKSTAGE);
		ingressos.add(TipoIngresso.PLATEIA_VIP);
		evento.setIngressos(ingressos);
		
		exceptionEsperada.expect(CSEventosException.class);
		exceptionEsperada.expectMessage("Tipos de Ingressos duplicados! Evento não pode ser salvo!");
		
		eventoService.salvarEvento(evento);
	}
	
	@Test
	public void salvarEvento() throws Exception {
		evento.setNome("Evento Unit Test");
		LocalDate data = LocalDate.now().plusDays(10);
		evento.setData(data);
		
		LocalDate periodoVendaInicio = LocalDate.now();
		LocalDate periodoVendaFim = LocalDate.now();
		evento.setPeriodoVenda(new PeriodoVenda(periodoVendaInicio, periodoVendaFim));
		
		List<TipoIngresso> ingressos = new LinkedList<TipoIngresso>();
		ingressos.add(TipoIngresso.PLATEIA);
		ingressos.add(TipoIngresso.BACKSTAGE);
		evento.setIngressos(ingressos);
		
		assertTrue(eventoService.salvarEvento(evento));
	}
}
