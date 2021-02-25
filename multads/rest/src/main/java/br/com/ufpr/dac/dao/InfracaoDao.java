package br.com.ufpr.dac.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.ufpr.dac.persistence.Infracao;
import br.com.ufpr.dac.persistence.Usuario;

public class InfracaoDao extends PersistenceDao<Infracao>{
	
    public Infracao getBy(String attribute, Object value) {
        Criterion ctrn = Restrictions.eq(attribute, value);
        return getBy(ctrn);
    }
    
    public List<Infracao>getList(){
    	
    	return getList(Order.asc("id"));
    }
    
    public List<Infracao>getList(String search){
    	Criterion ctrnDescription = Restrictions.like("descricao", "%" + search + "%").ignoreCase();
        return getList(ctrnDescription, Order.asc("id"));
    }
    
	/*
	 * public Infracao getById(int codigo) { return super.getById(codigo); }
	 * 
	 * public int insert (Infracao m) { return super.inserir(m); }
	 * 
	 * public void update (Infracao m) { super.alterar(m); }
	 * 
	 * public void delete (Infracao m) { super.excluir(m); }
	 */
}
