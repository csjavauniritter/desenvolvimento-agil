package br.com.unirriter.model;

import org.joda.time.LocalDate;

import br.com.unirriter.utils.DateUtils;

public class PeriodoVenda {

	private LocalDate inicio;
	private LocalDate fim;
	
	public PeriodoVenda(LocalDate inicio, LocalDate fim) {
		this.inicio = inicio;
		this.fim = fim;
	}
	
	public LocalDate getInicio() {
		return inicio;
	}
	
	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}
	
	public LocalDate getFim() {
		return fim;
	}
	
	public void setFim(LocalDate fim) {
		this.fim = fim;
	}
	
	@Override
	public String toString() {
		return "Período de Venda: " + DateUtils.formatarData(inicio) + 
				" á " + DateUtils.formatarData(fim);
	}
}
