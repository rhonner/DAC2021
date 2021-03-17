package br.com.ufpr.dac.bean;

import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.text.MaskFormatter;

import org.primefaces.util.LangUtils;

import br.com.ufpr.dac.impl.PessoaImpl;
import br.com.ufpr.dac.impl.VeiculoImpl;
import br.com.ufpr.dac.response.PessoaResponse;
import br.com.ufpr.dac.response.VeiculoResponse;

@SessionScoped
@ManagedBean(name = "veiculobean")
public class VeiculoBean {

	private VeiculoResponse veiculo = new VeiculoResponse();
	private List<VeiculoResponse> veiculoList;
	private List<VeiculoResponse> listagem;
	private List<VeiculoResponse> emptyList;
	private List<VeiculoResponse> filteredListagem;

	public void refresh() {
		VeiculoImpl vdao = new VeiculoImpl();
		setListagem(vdao.getListaVeiculo());
	}

	@PostConstruct
	public void init() {
		veiculo = new VeiculoResponse();
		setListagem(emptyList);
	}

	public List<VeiculoResponse> getEmptyList() {
		return emptyList;
	}

	public void add() {
		setListagem(emptyList);
	}

	public void setEmptyList(List<VeiculoResponse> emptyList) {
		this.emptyList = emptyList;
	}

	public void initializeList() throws Exception {
		VeiculoImpl vdao = new VeiculoImpl();
//		PessoaImpl pdao = new PessoaImpl();
//		for (VeiculoResponse veiculoResponse : vdao.getListaVeiculo()) {
//			try {
//				if (pdao.getByRenavam(veiculoResponse.getRenavam()).size() > 0)
//					veiculoResponse.setPessoa(pdao.getByRenavam(veiculoResponse.getRenavam()).get(0));
//			} catch (Exception e) {
//				throw new Exception(e.getMessage());
//			}s
//		}
		
		PessoaImpl pdao = new PessoaImpl();
		List<PessoaResponse>pplist = pdao.getListaPessoa();
		List<VeiculoResponse>vlistvr = vdao.getListaVeiculo();
		for (VeiculoResponse veiculoResponse : vlistvr) {
			
			for(PessoaResponse pr : pplist) {
				if(pr.getVeiculos().size()>0) {
					for(int i=0;i<pr.getVeiculos().size();i++) {

						if (pr.getVeiculos().get(i).getRenavam().equals(veiculoResponse.getRenavam())) {
							veiculoResponse.setPessoa(pr);
						}
					}
				}
				
			}
			
		}
		setListagem(vlistvr);
	}

	public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
		if (LangUtils.isValueBlank(filterText)) {
			return true;
		}

		int filterInt = getInteger(filterText);

		VeiculoResponse veiculo = (VeiculoResponse) value;
		return veiculo.getPlaca().toLowerCase().matches(filterText);
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

	public VeiculoResponse getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoResponse veiculo) {
		this.veiculo = veiculo;
	}

	public List<VeiculoResponse> getListagem() {
		return listagem;
	}

	public void setListagem(List<VeiculoResponse> listagem) {
		this.listagem = listagem;
	}

	public List<VeiculoResponse> getFilteredListagem() {
		return filteredListagem;
	}

	public void setFilteredListagem(List<VeiculoResponse> filteredListagem) {
		this.filteredListagem = filteredListagem;
	}
}
