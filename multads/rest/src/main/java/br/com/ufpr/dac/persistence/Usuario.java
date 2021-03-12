package br.com.ufpr.dac.persistence;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.ufpr.dac.dao.PerfilDao;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	public Usuario(int id, String login, int tipoperfil, String senha) {
		PerfilDao pdao = new PerfilDao();
		this.id = id;
		this.login = login;
		this.perfil = pdao.getById(tipoperfil);
		this.senha = senha;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name ="login")
	private String login;
	@Column(name ="senha")
	private String senha;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	@JoinColumn(name = "tipoperfil")
	private Perfil perfil;
	
	
	/*
	 * @OneToOne(mappedBy = "usuario") private Pessoa pessoa;
	 */
	
	public Usuario() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	/*
	 * public Pessoa getPessoa() { return pessoa; }
	 * 
	 * public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }
	 */
	
	@Override
    public boolean equals(Object object) {
        // Basic checks.
        if (object == this) return true;
        if (!(object instanceof Usuario)) return false;

        // Property checks.
        Usuario other = (Usuario) object;
        return Objects.equals(id, other.id)
            && Objects.equals(login, other.login)
            && Objects.equals(senha, other.senha)
            && Objects.equals(perfil, other.perfil)
		/* && Objects.equals(pessoa, other.pessoa) */ ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, senha, perfil);
    }
	
}
