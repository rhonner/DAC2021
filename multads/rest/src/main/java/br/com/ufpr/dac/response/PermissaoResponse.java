package br.com.ufpr.dac.response;

import java.util.Collection;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


public class PermissaoResponse {
	private int id;
	private String descricao;
	private Collection<PerfilResponse>perfis;
	
	public PermissaoResponse() {}

	
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

	public Collection<PerfilResponse> getPerfis() {
		return perfis;
	}

	public void setPerfis(Collection<PerfilResponse> perfis) {
		this.perfis = perfis;
	}
	
	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof PermissaoResponse)) return false;

        // Property checks.
        PermissaoResponse other = (PermissaoResponse) object;
        return Objects.equals(id, other.id)
            && Objects.equals(descricao, other.descricao)
            && Objects.equals(perfis, other.perfis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, perfis);
    }
	
	
	
}
