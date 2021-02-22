package br.com.ufpr.dac.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.ufpr.dac.persistence.Usuario;

@SessionScoped
@ManagedBean(name = "loginbean")
public class LoginBean extends BackingBean{

	private Usuario usuario;
	private String login;
	private String senha;
	
	public LoginBean() {
		
	}
	
	public void logIn() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().dispatch("www.google.com");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
	
}
