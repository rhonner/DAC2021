package br.com.ufpr.dac.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.ufpr.dac.dao.TipoInfracaoDao;
import br.com.ufpr.dac.persistence.TipoInfracao;

@SessionScoped
@ManagedBean(name = "enumBean")
public class EnumerationBean {
	
    public List<SelectItem> getTiposInfracao() {
        ArrayList<SelectItem> listaSelect = new ArrayList();
        TipoInfracaoDao tidao = new TipoInfracaoDao();
        List<TipoInfracao> tpinfracoes = tidao.getList();
        for (TipoInfracao g : tpinfracoes) {
            SelectItem s = new SelectItem(g.getId(), g.getDescricao());
            listaSelect.add(s);
        }
        return listaSelect;
    }
    
    @PostConstruct
    public List<TipoInfracao> getTiposInfracoes() {
    	TipoInfracaoDao tidao = new TipoInfracaoDao();
		return tidao.getList();
    }
    
    
 }
