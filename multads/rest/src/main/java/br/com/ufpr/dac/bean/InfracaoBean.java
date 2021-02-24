package br.com.ufpr.dac.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;

import br.com.ufpr.dac.dao.InfracaoDao;
import br.com.ufpr.dac.persistence.Infracao;
import br.com.ufpr.dac.persistence.TipoInfracao;


@SessionScoped
@ManagedBean(name = "infracaobean")
public class InfracaoBean {
	
	private Infracao infracao = new Infracao();
	private List<Infracao> listagem;
	TipoInfracao tpinfracao = new TipoInfracao();

	
	public TipoInfracao getTpinfracao() {
		return tpinfracao;
	}

	public void setTpinfracao(TipoInfracao tpinfracao) {
		this.tpinfracao = tpinfracao;
	}

	private void refresh() {
		InfracaoDao tidao = new InfracaoDao();
		setListagem(tidao.getList());
	}

	public void save() {
		InfracaoDao tidao = new InfracaoDao();
		System.out.println(tpinfracao);
		if (infracao.getId() == 0) {
			tidao.inserir(infracao);
		} else {
			tidao.alterar(infracao);
		}
		refresh();
	}

	public void deleteinfracao() {
		InfracaoDao tidao = new InfracaoDao();
		try {

			tidao.excluir(infracao);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário excluido",
					"<a href=\"listaInfracao.xhtml\">Sair</a>");
			PrimeFaces.current().dialog().showMessageDynamic(message, false);
			refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		InfracaoDao tidao = new InfracaoDao();

		setListagem(tidao.getList());
	}

	public void add() {
		infracao = new Infracao();
	}

	public List<Infracao> listagemd() {
		InfracaoDao tidao = new InfracaoDao();
		return tidao.getList();
	}

	public List<Infracao> getListagem() {
		return listagem;
	}

	public void setListagem(List<Infracao> listagem) {
		this.listagem = listagem;
	}

	public Infracao getInfracao() {
		return infracao;
	}

	public void setInfracao(Infracao infracao) {
		this.infracao = infracao;
	}
}
