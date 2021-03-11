package br.com.ufpr.dac.bean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;

import br.com.ufpr.dac.dao.MultaDao;
import br.com.ufpr.dac.persistence.Multa;


@SessionScoped
@ManagedBean(name = "multabean")
public class MultaBean {
	
	private Multa multa = new Multa();
	private List<Multa> listagem;

	public Multa getMulta() {
		return multa;
	}

	public void setMulta(Multa multa) {
		this.multa = multa;
	}

	public List<Multa> getListagem() {
		return listagem;
	}

	public void setListagem(List<Multa> listagem) {
		this.listagem = listagem;
	}

	private void refresh() {
		MultaDao mdao = new MultaDao();
		setListagem(mdao.getList());
	}

	public void save() {
		MultaDao mdao = new MultaDao();	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		multa.setDatamulta(Timestamp.valueOf(sdf.format(System.currentTimeMillis())));
		System.out.println(multa);
		mdao.inserir(multa);
		refresh();
	}

	@PostConstruct
	public void init() {
		MultaDao mdao = new MultaDao();
		multa = new Multa();
		setListagem(mdao.getList());
	}

	public void add() {
		multa = new Multa();
	}

	public List<Multa> listagemd() {
		MultaDao mdao = new MultaDao();
		return mdao.getList();
	}
}