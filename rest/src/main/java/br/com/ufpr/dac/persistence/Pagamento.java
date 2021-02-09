package br.com.ufpr.dac.persistence;

import java.sql.Timestamp;

public class Pagamento {
	private int id;
	private Timestamp datapagamento;
	private int atrasodias;
	private float valor;
	private int idmulta;
	
	public Pagamento() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDatapagamento() {
		return datapagamento;
	}

	public void setDatapagamento(Timestamp datapagamento) {
		this.datapagamento = datapagamento;
	}

	public int getAtrasodias() {
		return atrasodias;
	}

	public void setAtrasodias(int atrasodias) {
		this.atrasodias = atrasodias;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getIdmulta() {
		return idmulta;
	}

	public void setIdmulta(int idmulta) {
		this.idmulta = idmulta;
	}
	
	
	
}
