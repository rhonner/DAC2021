package br.com.ufpr.dac.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.ufpr.dac.persistence.Multa;
import br.com.ufpr.dac.persistence.Usuario;

public class MultaDao extends PersistenceDao<Multa>{
	
	

    
    public Multa getBy(String attribute, Object value) {
        Criterion ctrn = Restrictions.eq(attribute, value);
        return getBy(ctrn);
    }
    
    public List<Multa>getList(){
    	
    	return getList(Order.asc("id"));
    }
    
    public List<Multa>getListDesc(){
    	
    	return getList(Order.desc("datamulta"));
    }
    
    public List<Multa>getList(String search){
    	Criterion ctrnDescription = Restrictions.like("descricao", "%" + search + "%").ignoreCase();
        return getList(ctrnDescription, Order.asc("id"));
    }
    
	/*
	 * public Multa getById(int codigo) { return super.getById(codigo); }
	 * 
	 * public int insert (Multa m) { return super.inserir(m); }
	 * 
	 * public void update (Multa m) { super.alterar(m); }
	 * 
	 * public void delete (Multa m) { super.excluir(m); }
	 */
    
}
