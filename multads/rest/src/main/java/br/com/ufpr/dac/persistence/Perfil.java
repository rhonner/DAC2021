package br.com.ufpr.dac.persistence;

import java.util.Collection;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "perfil")
public class Perfil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "nome")
	private String nome;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	private List<Usuario> usuarios;
	 
	
	@ManyToMany(targetEntity = Permissao.class,fetch = FetchType.EAGER)
	@JoinTable(name = "perfilpermissao",
	joinColumns = {@JoinColumn(name = "idperfil")},
	inverseJoinColumns = {@JoinColumn(name = "idpermissao")})
	private Collection<Permissao>permissoes;
	
	public Perfil() {}
	
	
	
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


	
	  public List<Usuario> getUsuarios() { return this.usuarios; }
	  
	  public void setUsuarios(List<Usuario> usuarios) { this.usuarios = usuarios; }
	 



	public Collection<Permissao> getPermissoes() {
		return permissoes;
	}


	public void setPermissoes(Collection<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
	
	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof Perfil)) return false;

        // Property checks.
        Perfil other = (Perfil) object;
        return Objects.equals(id, other.id)
            && Objects.equals(descricao, other.descricao)
            && Objects.equals(nome, other.nome)
			&& Objects.equals(usuarios, other.usuarios) 
            && Objects.equals(permissoes, other.permissoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, nome , permissoes);
    }
}
