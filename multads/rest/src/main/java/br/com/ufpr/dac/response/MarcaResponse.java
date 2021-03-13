package br.com.ufpr.dac.response;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

public class MarcaResponse {

	private int id;

	private String descricao;
	
	
	
	public MarcaResponse() {}

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



	

	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof MarcaResponse)) return false;

        // Property checks.
        MarcaResponse other = (MarcaResponse) object;
        return Objects.equals(id, other.id)
            && Objects.equals(descricao, other.descricao)
            ;

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao);
    }
	
}
