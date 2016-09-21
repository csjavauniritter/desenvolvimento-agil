package br.com.unirriter.validador;

import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.unirriter.exception.CSEventosException;
import br.com.unirriter.model.Evento;
import br.com.unirriter.validador.EventoValidador;

public class EventoValidadorTest {
	
	private Evento evento;
	
	@Rule
	public ExpectedException exceptionEsperada = ExpectedException.none();
	
	@Before
	public void setUp() {
		evento = new Evento();
	}
	
	@After
	public void tearDown() {
		evento = null;
	}
	
	@Test
	public void validarObrigatoriedadeCampoNomeNulo() throws Exception {
		evento.setData(LocalDate.now());
		
		exceptionEsperada.expect(CSEventosException.class);
		exceptionEsperada.expectMessage("Campo nome é obrigatório!");
		
		EventoValidador.validar(evento);
	}
	
	@Test
	public void validarObrigatoriedadeCampoNomeVazio() throws Exception {
		evento.setNome("");
		evento.setData(LocalDate.now());
		
		exceptionEsperada.expect(CSEventosException.class);
		exceptionEsperada.expectMessage("Campo nome é obrigatório!");
		
		EventoValidador.validar(evento);
	}

	@Test
	public void validarObrigatoriedadeCampoDataNula() throws Exception {
		evento.setNome("Evento A");
		evento.setData(null);
		
		exceptionEsperada.expect(CSEventosException.class);
		exceptionEsperada.expectMessage("Campo data é obrigatória!");
		
		EventoValidador.validar(evento);
	}
	
	@Test
	public void validarCampoNomeMaiorQue150Caracteres() throws Exception {
		evento.setNome("Evento XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
				+ "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
				+ "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		evento.setData(LocalDate.now());
		
		exceptionEsperada.expect(CSEventosException.class);
		exceptionEsperada.expectMessage("O nome permite no máximo 150 caracteres!");
		
		EventoValidador.validar(evento);
	}
	
	@Test
	public void validarCampoDataMenorQueDataAtual() throws Exception {
		evento.setNome("Evento A");
		LocalDate dataPassada = LocalDate.now().minusMonths(1);
		evento.setData(dataPassada);
		
		exceptionEsperada.expect(CSEventosException.class);
		exceptionEsperada.expectMessage("A data do evento deve ser maior ou igual a de hoje!");
		
		EventoValidador.validar(evento);
	}
	
	@Test
	public void validarEvento() throws Exception {
		evento.setNome("Evento Unit Test");
		LocalDate data = LocalDate.now().plusDays(10);
		evento.setData(data);
		
		EventoValidador.validar(evento);
	}
}
