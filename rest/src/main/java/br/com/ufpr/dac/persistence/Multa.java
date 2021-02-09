package br.com.ufpr.dac.persistence;

import java.sql.Timestamp;

public class Multa {
	private int id;
	private String renavam;
	private String document;
	private Timestamp datamulta;
	private String descricao;
	private int idinfracao;
	
	public Multa() {}

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

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Timestamp getDatamulta() {
		return datamulta;
	}

	public void setDatamulta(Timestamp datamulta) {
		this.datamulta = datamulta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdinfracao() {
		return idinfracao;
	}

	public void setIdinfracao(int idinfracao) {
		this.idinfracao = idinfracao;
	}
	
	
	
}
