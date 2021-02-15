package br.com.ufpr.dac.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.ufpr.dac.persistence.Pessoa;

public class PessoaDao extends PersistenceDao<Pessoa>{


    
    public Pessoa getBy(String attribute, Object value) {
        Criterion ctrn = Restrictions.eq(attribute, value);
        return getBy(ctrn);
    }
    
    public List<Pessoa>getList(String search){
    	Criterion ctrnDescription = Restrictions.like("nome", "%" + search + "%").ignoreCase();
        return getList(ctrnDescription, Order.asc("id"));
    }
    
	/*
	 * public Pessoa getById(int codigo) { return super.getById(codigo); }
	 * 
	 * public int insert (Pessoa m) { return super.inserir(m); }
	 * 
	 * public void update (Pessoa m) { super.alterar(m); }
	 * 
	 * public void delete (Pessoa m) { super.excluir(m); }
	 */
}
