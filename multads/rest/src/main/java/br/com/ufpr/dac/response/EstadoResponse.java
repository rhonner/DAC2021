package br.com.ufpr.dac.response;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

public class EstadoResponse {

	private int id;
	private String sigla;
	private String nome;
	
	private List<CidadeResponse> cidade;

	public void setCidade(List<CidadeResponse> cidade) {
		this.cidade = cidade;
	}

	public EstadoResponse() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof EstadoResponse)) return false;

        // Property checks.
        EstadoResponse other = (EstadoResponse) object;
        return Objects.equals(id, other.id)
            && Objects.equals(sigla, other.sigla)
            && Objects.equals(nome, other.nome)
            && Objects.equals(cidade, other.cidade);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sigla, nome, cidade);
    }

	
	
}
