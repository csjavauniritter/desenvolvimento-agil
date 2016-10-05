package br.com.unirriter.model;

import java.util.List;

import org.joda.time.LocalDate;

import br.com.unirriter.enums.TipoIngresso;
import br.com.unirriter.utils.DateUtils;

public class Evento {

	private String nome;
	private LocalDate data;
	
	private PeriodoVenda periodoVenda;
	
	private List<TipoIngresso> ingressos;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public PeriodoVenda getPeriodoVenda() {
		return periodoVenda;
	}

	public void setPeriodoVenda(PeriodoVenda periodoVenda) {
		this.periodoVenda = periodoVenda;
	}

	public List<TipoIngresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<TipoIngresso> ingressos) {
		this.ingressos = ingressos;
	}

	@Override
	public String toString() {
		return "[EVENTO] Nome: " + nome + " - "
				+ "Data: " + DateUtils.formatarData(data) + " - " + periodoVenda.toString();
	}
}
