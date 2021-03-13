package br.com.ufpr.dac.response;

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

public class PerfilResponse {
	
	private int id;
	private String descricao;
	private String nome;
	
	private List<UsuarioResponse> usuarios; 
	private Collection<PermissaoResponse>permissoes;
	
	public PerfilResponse() {}
	
	
	
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


	
	public List<UsuarioResponse> getUsuarios() {
		  return this.usuarios; 
	}
	  
	public void setUsuarios(List<UsuarioResponse> usuarios) {
		  this.usuarios = usuarios; 
	}
	 



	public Collection<PermissaoResponse> getPermissoes() {
		return permissoes;
	}


	public void setPermissoes(Collection<PermissaoResponse> permissoes) {
		this.permissoes = permissoes;
	}
	
	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof PerfilResponse)) return false;

        // Property checks.
        PerfilResponse other = (PerfilResponse) object;
        return Objects.equals(id, other.id)
            && Objects.equals(descricao, other.descricao)
            && Objects.equals(nome, other.nome)
            && Objects.equals(usuarios, other.usuarios)
            && Objects.equals(permissoes, other.permissoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, nome, permissoes);
    }
	
	
}