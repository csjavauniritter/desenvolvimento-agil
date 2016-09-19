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
		
		assertFalse(DateUtils.verificarDataAnteriorAtual(data));
	}
	
	@Test
	public void validarDataIgualAtual() {
		LocalDate data = LocalDate.now();
		
		assertFalse(DateUtils.verificarDataAnteriorAtual(data));
	}
	
	@Test
	public void validarDataAnteriorAtual() {
		LocalDate data = LocalDate.now().minusMonths(3);
		
		assertTrue(DateUtils.verificarDataAnteriorAtual(data));
	}
}
