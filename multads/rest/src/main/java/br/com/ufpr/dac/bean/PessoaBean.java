package br.com.ufpr.dac.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;

import br.com.ufpr.dac.dao.PessoaDao;
import br.com.ufpr.dac.persistence.Pessoa;
import br.com.ufpr.dac.persistence.Usuario;


@SessionScoped
@ManagedBean(name = "pessoabean")
public class PessoaBean {
	
	private Pessoa pessoa = new Pessoa();
	Usuario usuario = new Usuario();

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void save() {
		PessoaDao pedao = new PessoaDao();
		System.out.println(usuario);
		if (pessoa.getId() == 0) {
			pedao.inserir(pessoa);
		} else {
			pedao.alterar(pessoa);
		}
	}

	public void deletepessoa() {
		PessoaDao pedao = new PessoaDao();
		try {
			pedao.excluir(pessoa);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "pessoa excluido",
					"<a href=\"\">Sair</a>");
			PrimeFaces.current().dialog().showMessageDynamic(message, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		PessoaDao pedao = new PessoaDao();

	}

	public void add() {
		pessoa = new Pessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}