package br.com.ufpr.dac.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.ufpr.dac.persistence.Permissao;
import br.com.ufpr.dac.persistence.Usuario;

public class PermissaoDao extends PersistenceDao<Permissao>{

    public Permissao getBy(String attribute, Object value) {
        Criterion ctrn = Restrictions.eq(attribute, value);
        return getBy(ctrn);
    }
    
    public List<Permissao>getList(){
    	
    	return getList(Order.asc("id"));
    }
    
    public List<Permissao>getList(String search){
    	Criterion ctrnDescription = Restrictions.like("descricao", "%" + search + "%").ignoreCase();
        return getList(ctrnDescription, Order.asc("id"));
    }
    
	/*
	 * public Permissao getById(int codigo) { return super.getById(codigo); }
	 * 
	 * public int insert (Permissao m) { return super.inserir(m); }
	 * 
	 * public void update (Permissao m) { super.alterar(m); }
	 * 
	 * public void delete (Permissao m) { super.excluir(m); }
	 */
	
}
