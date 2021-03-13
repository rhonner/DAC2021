package br.com.ufpr.dac.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;

import br.com.ufpr.dac.dao.TipoInfracaoDao;
import br.com.ufpr.dac.persistence.TipoInfracao;

@SessionScoped
@ManagedBean(name = "tipoinfracaobean")
public class TipoInfracaoBean {

	private TipoInfracao tpinfracao = new TipoInfracao();
	private String descricao;
	private List<TipoInfracao> listagem;
	private float valor;
	private int pontuacao;

	public TipoInfracaoBean() {

	}

	
	public List<TipoInfracao>getList(){
		TipoInfracaoDao tidao = new TipoInfracaoDao();
		return tidao.getList();
	}
	public void refresh() {
		TipoInfracaoDao tidao = new TipoInfracaoDao();
		listagem = tidao.getList();
	}

	public void save() {
		TipoInfracaoDao tidao = new TipoInfracaoDao();
		if (tpinfracao.getId() == 0) {
			tidao.inserir(tpinfracao);
		} else {
			tidao.alterar(tpinfracao);
		}
		refresh();
	}

	public void deleteTpInfracao() {
		TipoInfracaoDao tidao = new TipoInfracaoDao();
		try {

			tidao.excluir(tpinfracao);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário excluido",
					"<a href=\"listaTipoInfracao.xhtml\">Sair</a>");
			PrimeFaces.current().dialog().showMessageDynamic(message, false);
			refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		TipoInfracaoDao tidao = new TipoInfracaoDao();

		listagem = tidao.getList();
	}

	public void add() {
		tpinfracao = new TipoInfracao();
	}

	public List<TipoInfracao> listagemd() {
		TipoInfracaoDao tidao = new TipoInfracaoDao();
		return tidao.getList();
	}

	public TipoInfracao getTpinfracao() {
		return tpinfracao;
	}

	public void setTpinfracao(TipoInfracao tpinfracao) {
		this.tpinfracao = tpinfracao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public List<TipoInfracao> getListagem() {
		return listagem;
	}

	public void setListagem(List<TipoInfracao> listagem) {
		this.listagem = listagem;
	}

}
