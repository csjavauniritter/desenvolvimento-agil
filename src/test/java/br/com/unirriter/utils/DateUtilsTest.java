package br.com.unirriter.utils;

import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.junit.Test;

public class DateUtilsTest {

	@Test
	public void validarDataString() {
		LocalDate data = new LocalDate(2016, 9, 17);

		String dataString = DateUtils.formatarData(data);
		
		assertEquals("17-09-2016", dataString);
	}
	
	@Test
	public void validarDataPosteriorAtual() {
		LocalDate data = LocalDate.now().plusMonths(2);
		
		assertTrue(DateUtils.verificarDataAnteriorOuIgualAtual(data));
	}
	
	@Test
	public void validarDataIgualAtual() {
		LocalDate data = LocalDate.now();
		
		assertTrue(DateUtils.verificarDataAnteriorOuIgualAtual(data));
	}
	
	@Test
	public void validarDataAnteriorAtual() {
		LocalDate data = LocalDate.now().minusMonths(3);
		
		assertFalse(DateUtils.verificarDataAnteriorOuIgualAtual(data));
	}
	
	@Test
	public void validarDataInicioPosteriorDataFim() {
		LocalDate dataInicio = LocalDate.now().plusDays(5);
		LocalDate dataFim = LocalDate.now();
		
		assertFalse(DateUtils.verificarDataInicioAnteriorOuIgualDataFim(dataInicio, dataFim));
	}
	
	@Test
	public void validarDataInicioIgualDataFim() {
		LocalDate dataInicio = LocalDate.now();
		LocalDate dataFim = LocalDate.now();
		
		assertTrue(DateUtils.verificarDataInicioAnteriorOuIgualDataFim(dataInicio, dataFim));
	}
	
	@Test
	public void validarDataInicioAnteriorDataFim() {
		LocalDate dataInicio = LocalDate.now();
		LocalDate dataFim = LocalDate.now().plusDays(5);
		
		assertTrue(DateUtils.verificarDataInicioAnteriorOuIgualDataFim(dataInicio, dataFim));
	}
}
