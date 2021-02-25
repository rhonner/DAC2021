package br.com.ufpr.dac.persistence;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "permissao")
public class Permissao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "descricao")
	private String descricao;
	
	@ManyToMany(mappedBy = "permissoes",fetch = FetchType.EAGER)
	private Collection<Perfil>perfis;

	
	public Permissao() {}

	
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

	public Collection<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Collection<Perfil> perfis) {
		this.perfis = perfis;
	}
	
	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof Permissao)) return false;

        // Property checks.
        Permissao other = (Permissao) object;
        return Objects.equals(id, other.id)
            && Objects.equals(descricao, other.descricao)
            && Objects.equals(perfis, other.perfis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, perfis);
    }
	
}
