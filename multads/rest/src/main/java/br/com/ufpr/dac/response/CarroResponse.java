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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class CarroResponse {
	private int id;
	private String descricao;
	private MarcaResponse marca;

	public CarroResponse() {}
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
	
	public MarcaResponse getMarca() {
		return marca;
	}


	public void setMarca(MarcaResponse marca) {
		this.marca = marca;
	}

	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof CarroResponse)) return false;

        // Property checks.
        CarroResponse other = (CarroResponse) object;
        return Objects.equals(id, other.id)
            && Objects.equals(descricao, other.descricao)
            && Objects.equals(marca, other.marca);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, marca);
    }
	
}