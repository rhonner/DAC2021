package br.com.ufpr.dac.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
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
    
    public List<Integer> getTotalMultaMonths(int atual) {
    	int passado = 0;
    	List<Integer> list = new ArrayList<Integer>();
    	if(atual == 1)
    		passado = 12;
    	else
    		passado = atual-1;
    	
        String sqlScript = "select count(*) from MULTA where (SELECT EXTRACT(MONTH FROM datamulta)) = :mes ;";
        Session session = sessionBuilder.getSession();
        SQLQuery qr = session.createSQLQuery(sqlScript);
        System.out.println(qr.toString());
        qr.setParameter("mes", atual);
        BigInteger result = (BigInteger) qr.uniqueResult();
        list.add(result.intValue());
        qr.setParameter("mes", passado);
        BigInteger result2 = (BigInteger) qr.uniqueResult();
        list.add(result2.intValue());
        return list;
    }
    
    public List<Multa>getList(String search){
    	Criterion ctrnDescription = Restrictions.like("descricao", "%" + search + "%").ignoreCase();
        return getList(ctrnDescription, Order.asc("id"));
    }
    
    public List<Multa>getListByDoc(String search){
    	Criterion ctrnDescription = Restrictions.like("documento", search).ignoreCase();
        return getList(ctrnDescription, Order.asc("id"));
    }
    
    public List<Multa>getListByRenavam(String search){
    	Criterion ctrnDescription = Restrictions.like("renavam", search).ignoreCase();
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
