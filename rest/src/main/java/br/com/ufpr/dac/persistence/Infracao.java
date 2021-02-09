package br.com.ufpr.dac.persistence;

public class Infracao {
	private int id;
	private String descricao;
	private int idtipo;
	
	public Infracao() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdtipo() {
		return idtipo;
	}

	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}
	
	
	
}
