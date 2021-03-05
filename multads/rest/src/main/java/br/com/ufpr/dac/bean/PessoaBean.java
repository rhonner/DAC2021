package br.com.ufpr.dac.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;

import br.com.ufpr.dac.dao.InfracaoDao;
import br.com.ufpr.dac.dao.PerfilDao;
import br.com.ufpr.dac.dao.PessoaDao;
import br.com.ufpr.dac.dao.UsuarioDao;
import br.com.ufpr.dac.persistence.Infracao;
import br.com.ufpr.dac.persistence.Perfil;
import br.com.ufpr.dac.persistence.Pessoa;
import br.com.ufpr.dac.persistence.Usuario;


@SessionScoped
@ManagedBean(name = "pessoabean")
public class PessoaBean {
	
	private Pessoa pessoa = new Pessoa();
	private List<Pessoa> listagem;
	Usuario usuario = new Usuario();
	Perfil perfil = new Perfil();
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	private void refresh() {
		PessoaDao pedao = new PessoaDao();
		setListagem(pedao.listPolices());
	}
	
	public void save() {
		PessoaDao pedao = new PessoaDao();
		UsuarioDao udao = new UsuarioDao();
		if (pessoa.getId() == 0) {
			pedao.inserir(pessoa);
		} else {
			udao.alterar(pessoa.getUsuario());
			pedao.alterar(pessoa);
		}
		refresh();
	}

	public void deletepessoa() {
		PessoaDao pedao = new PessoaDao();
		UsuarioDao udao = new UsuarioDao();
		try {
			pedao.excluir(pessoa);
			udao.excluir(pessoa.getUsuario());
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Policial excluído",
					"<a href=\"listaPessoa.xhtml\">Sair</a>");
			PrimeFaces.current().dialog().showMessageDynamic(message, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		PerfilDao perfildao = new PerfilDao();
		PessoaDao pedao = new PessoaDao();
		pessoa = new Pessoa();
		usuario = new Usuario();
		perfil = new Perfil();
		usuario.setPerfil(perfildao.getById(2));
		pessoa.setUsuario(usuario);

		setListagem(pedao.listPolices());
	}

	public void add() {
		pessoa = new Pessoa();
	}

	public List<Pessoa> listagem() {
		PessoaDao pedao = new PessoaDao();
		return pedao.listPolices();
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Pessoa> getListagem() {
		return listagem;
	}

	public void setListagem(List<Pessoa> listagem) {
		this.listagem = listagem;
	}
}