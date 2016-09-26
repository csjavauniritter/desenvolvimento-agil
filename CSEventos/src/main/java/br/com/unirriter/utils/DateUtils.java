package br.com.unirriter.utils;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtils {
	
	private static DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy");
	
	public static String formatarData(LocalDate data) {
		if (data == null) {
			return null;
		} else {
			return data.toString(formatter);
		}
	}
	
	public static boolean verificarDataAnteriorOuIgualAtual(LocalDate data) {
		return verificarDataInicioAnteriorOuIgualDataFim(LocalDate.now(), data);
	}
	
	public static boolean verificarDataInicioAnteriorOuIgualDataFim(LocalDate inicio, LocalDate fim) {
		return inicio.isBefore(fim) || inicio.isEqual(fim);
	}
}