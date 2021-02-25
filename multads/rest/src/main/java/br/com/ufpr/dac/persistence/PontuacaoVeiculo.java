package br.com.ufpr.dac.persistence;

import java.sql.Timestamp;
import java.util.Objects;

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
	
	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof PontuacaoVeiculo)) return false;

        // Property checks.
        PontuacaoVeiculo other = (PontuacaoVeiculo) object;
        return Objects.equals(id, other.id)
            && Objects.equals(renavam, other.renavam)
            && Objects.equals(pontuacao, other.pontuacao)
            && Objects.equals(dataultima, other.dataultima);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, renavam, pontuacao, dataultima);
    }
	
}
