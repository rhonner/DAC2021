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
import javax.persistence.OneToOne;
import javax.persistence.Table;


public class CidadeResponse {

	private int id;
	private String nome;

	private EstadoResponse estado;
	
	private List<PessoaResponse>pessoas;
	
	public CidadeResponse() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EstadoResponse getEstado() {
		return estado;
	}

	public void setEstado(EstadoResponse estado) {
		this.estado = estado;
	}

	public List<PessoaResponse> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<PessoaResponse> pessoas) {
		this.pessoas = pessoas;
	}
	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof CidadeResponse)) return false;

        // Property checks.
        CidadeResponse other = (CidadeResponse) object;
        return Objects.equals(id, other.id)
            && Objects.equals(nome, other.nome)
            && Objects.equals(estado, other.estado)
            && Objects.equals(pessoas, other.pessoas);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, estado, pessoas);
    }


	
	
}