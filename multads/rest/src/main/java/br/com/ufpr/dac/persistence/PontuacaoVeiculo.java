package br.com.ufpr.dac.persistence;

import java.sql.Timestamp;

public class PontuacaoVeiculo {
	private int id;
	private String renavam;
	private int pontuacao;
	private Timestamp dataultima;
	
	public PontuacaoVeiculo() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Timestamp getDataultima() {
		return dataultima;
	}

	public void setDataultima(Timestamp dataultima) {
		this.dataultima = dataultima;
	}
	
	
	
}
