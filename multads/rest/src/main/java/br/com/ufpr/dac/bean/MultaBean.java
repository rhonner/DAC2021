package br.com.ufpr.dac.bean;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.security.auth.x500.X500Principal;

import org.primefaces.PrimeFaces;
import org.primefaces.model.FilterMeta;
import org.primefaces.util.LangUtils;

import br.com.ufpr.dac.dao.MultaDao;
import br.com.ufpr.dac.persistence.Multa;

@SessionScoped
@ManagedBean(name = "multabean")
public class MultaBean {

	private Multa multa = new Multa();
	private List<Multa> listagem;
	private List<Multa> filteredMultaList;

	private List<FilterMeta> filterBy;
	
	public List<Multa> getFilteredMultaList() {
		return filteredMultaList;
	}

	public void setFilteredMultaList(List<Multa> filteredMultaList) {
		this.filteredMultaList = filteredMultaList;
	}

	double gravissimaPer;
	double gravePer;
	double mediaPer;
	double levePer;
	int gravissima;
	int grave;
	int media;
	int leve;
	int qtdTotal;
	Integer mesAtual;
	Integer mesPassado;

	public Integer getMesAtual() {
		return mesAtual;
	}

	public void setMesAtual(Integer mesAtual) {
		this.mesAtual = mesAtual;
	}

	public Integer getMesPassado() {
		return mesPassado;
	}

	public void setMesPassado(Integer mesPassado) {
		this.mesPassado = mesPassado;
	}

	public int getGravissima() {
		return gravissima;
	}

	public void setGravissima(int gravissima) {
		this.gravissima = gravissima;
	}

	public int getGrave() {
		return grave;
	}

	public void setGrave(int grave) {
		this.grave = grave;
	}

	public int getMedia() {
		return media;
	}

	public void setMedia(int media) {
		this.media = media;
	}

	public int getLeve() {
		return leve;
	}

	public void setLeve(int leve) {
		this.leve = leve;
	}

	public int getQtdTotal() {
		return qtdTotal;
	}

	public void setQtdTotal(int qtdTotal) {
		this.qtdTotal = qtdTotal;
	}

	public double getGravissimaPer() {
		return gravissimaPer;
	}

	public void setGravissimaPer(double gravissimaPer) {
		this.gravissimaPer = gravissimaPer;
	}

	public double getGravePer() {
		return gravePer;
	}

	public void setGravePer(double gravePer) {
		this.gravePer = gravePer;
	}

	public double getMediaPer() {
		return mediaPer;
	}

	public void setMediaPer(double mediaPer) {
		this.mediaPer = mediaPer;
	}

	public double getLevePer() {
		return levePer;
	}

	public void setLevePer(double levePer) {
		this.levePer = levePer;
	}

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
		setListagem(mdao.getListDesc());
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
		setListagem(mdao.getListDesc());
		listPercent();
		
//		 filterBy = new ArrayList<>();

	}

	public void add() {
		multa = new Multa();
	}

	public List<Multa> listagemd() {
		MultaDao mdao = new MultaDao();
		return mdao.getListDesc();
	}

	public void listPercent() {
		MultaDao mdao = new MultaDao();
		List<Integer> list = new ArrayList<Integer>();
		for (Multa multa : mdao.getList()) {
			int tipo = multa.getInfracao().getTipoinfracao().getId();
			switch (tipo) {
			case 1:
				gravissima++;
				break;
			case 2:
				grave++;
				break;
			case 3:
				media++;
				break;
			case 4:
				leve++;
				break;
			}
			qtdTotal++;
		}
		gravissimaPer = gravissima * 100 / qtdTotal;
		gravePer = grave * 100 / qtdTotal;
		mediaPer = media * 100 / qtdTotal;
		levePer = leve * 100 / qtdTotal;

		LocalDate localDate = LocalDate.now();
		int month = localDate.getMonthValue();
		list = mdao.getTotalMultaMonths(month);
		mesAtual = list.get(0);
		mesPassado = list.get(1);
	}

	public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
		if (LangUtils.isValueBlank(filterText)) {
			return true;
		}
		int filterInt = getInteger(filterText);

		Multa multa = (Multa) value;
		return 	   multa.getRenavam().toLowerCase().contains(filterText)
				|| multa.getDescricao().toLowerCase().contains(filterText)
				|| multa.getDatamulta().toString().toLowerCase().contains(filterText)
				|| multa.getDocumento().toLowerCase().contains(filterText)
				|| multa.getInfracao().getDescricao().toLowerCase().contains(filterText);
	}

	private int getInteger(String string) {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException ex) {
			return 0;
		}
	}
}