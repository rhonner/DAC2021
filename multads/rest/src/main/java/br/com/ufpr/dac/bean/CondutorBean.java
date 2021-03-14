package br.com.ufpr.dac.bean;

import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.text.MaskFormatter;

import org.primefaces.util.LangUtils;

import br.com.ufpr.dac.impl.PessoaImpl;
import br.com.ufpr.dac.persistence.Multa;
import br.com.ufpr.dac.response.PessoaResponse;


@SessionScoped
@ManagedBean(name = "condutorbean")
public class CondutorBean {
	
	private PessoaResponse condutor = new PessoaResponse();
	private List<PessoaResponse> listagem;
	private List<PessoaResponse> emptyList;
	private List<PessoaResponse> filteredListagem;



	public void refresh() {
		PessoaImpl cdao = new PessoaImpl();
		setListagem(cdao.getListaPessoa());
	}


	@PostConstruct
	public void init() {
		setListagem(emptyList);
	}
	
	public List<PessoaResponse> getEmptyList() {
		return emptyList;
	}
	
	public void add() {
		setListagem(emptyList);
	}


	public void setEmptyList(List<PessoaResponse> emptyList) {
		this.emptyList = emptyList;
	}


	public void initializeList() {
		PessoaImpl cdao = new PessoaImpl();
		setListagem(cdao.getListaPessoa());
	}
	
	public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
		if (LangUtils.isValueBlank(filterText)) {
			return true;
		}
		int filterInt = getInteger(filterText);

		PessoaResponse condutor = (PessoaResponse) value;
		return condutor.getDocumento().toLowerCase().contains(filterText)
				|| condutor.getNome().toLowerCase().contains(filterText)
				|| condutor.getEmail().toLowerCase().contains(filterText);
	}

	private int getInteger(String string) {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException ex) {
			return 0;
		}
	}
	
	public String format(String pattern, Object value, boolean suppressZero) {
		if (!suppressZero || Double.parseDouble(value.toString()) != 0) {
			MaskFormatter mask;
			try {
				mask = new MaskFormatter(pattern);
				mask.setValueContainsLiteralCharacters(false);
				return mask.valueToString(value);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} else {
			return "";
		}
	}

	public PessoaResponse getCondutor() {
		return condutor;
	}


	public void setCondutor(PessoaResponse condutor) {
		this.condutor = condutor;
	}


	public List<PessoaResponse> getListagem() {
		return listagem;
	}


	public void setListagem(List<PessoaResponse> listagem) {
		this.listagem = listagem;
	}
	
	public List<PessoaResponse> getFilteredListagem() {
		return filteredListagem;
	}


	public void setFilteredListagem(List<PessoaResponse> filteredListagem) {
		this.filteredListagem = filteredListagem;
	}


}
