package br.com.ufpr.dac.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.ufpr.dac.persistence.Pagamento;

public class PagamentoDao extends PersistenceDao<Pagamento>{
    public Pagamento getBy(String attribute, Object value) {
        Criterion ctrn = Restrictions.eq(attribute, value);
        return getBy(ctrn);
    }
    
    public List<Pagamento>getList(String search){
    	int atraso = Integer.parseInt(search);
    	Criterion ctrnDescription = Restrictions.eq("atrasodias", atraso);
        return getList(ctrnDescription, Order.asc("id"));
    }
    
	/*
	 * public Pagamento getById(int codigo) { return super.getById(codigo); }
	 * 
	 * public int insert (Pagamento m) { return super.inserir(m); }
	 * 
	 * public void update (Pagamento m) { super.alterar(m); }
	 * 
	 * public void delete (Pagamento m) { super.excluir(m); }
	 */
}
