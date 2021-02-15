package br.com.ufpr.dac.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.ufpr.dac.persistence.TipoInfracao;

public class TipoInfracaoDao extends PersistenceDao<TipoInfracao>{
    public TipoInfracao getBy(String attribute, Object value) {
        Criterion ctrn = Restrictions.eq(attribute, value);
        return getBy(ctrn);
    }
    	
    public List<TipoInfracao>getList(String search){
    	Criterion ctrnDescription = Restrictions.like("descricao", "%" + search + "%").ignoreCase();
        return getList(ctrnDescription, Order.asc("id"));
    }
    
	/*
	 * public TipoInfracao getById(int codigo) { return super.getById(codigo); }
	 * 
	 * public int insert (TipoInfracao m) { return super.inserir(m); }
	 * 
	 * public void update (TipoInfracao m) { super.alterar(m); }
	 * 
	 * public void delete (TipoInfracao m) { super.excluir(m); }
	 */
}
