package br.com.unirriter.model;

import org.joda.time.LocalDate;

import br.com.unirriter.utils.DateUtils;

public class Evento {

	private String nome;
	private LocalDate data;
	
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
	
	@Override
	public String toString() {
		return "[EVENTO] Nome: " + nome + " - Data: " + DateUtils.formatarData(data);
	}
}
