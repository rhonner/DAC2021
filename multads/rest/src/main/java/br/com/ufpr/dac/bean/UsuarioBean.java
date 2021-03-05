package br.com.ufpr.dac.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;

import br.com.ufpr.dac.dao.UsuarioDao;
import br.com.ufpr.dac.persistence.Usuario;

@SessionScoped
@ManagedBean(name = "usuariobean")
public class UsuarioBean {
	Usuario usuario = new Usuario();

	public void save() {
		UsuarioDao udao = new UsuarioDao();
		System.out.println(usuario);
		if (usuario.getId() == 0) {
			udao.inserir(usuario);
		} else {
			udao.alterar(usuario);
		}
	}

	public void deleteusuario() {
		UsuarioDao udao = new UsuarioDao();
		try {
			udao.excluir(usuario);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário excluido",
					"<a href=\"\">Sair</a>");
			PrimeFaces.current().dialog().showMessageDynamic(message, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		usuario = new Usuario();

		UsuarioDao udao = new UsuarioDao();
	}

	public void add() {
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
