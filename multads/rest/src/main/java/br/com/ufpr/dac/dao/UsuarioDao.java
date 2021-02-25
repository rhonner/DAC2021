package br.com.ufpr.dac.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.ufpr.dac.persistence.Usuario;

public class UsuarioDao  extends PersistenceDao<Usuario> {
	public Usuario getBy(String attribute, Object value) {
        Criterion ctrn = Restrictions.eq(attribute, value);
        return getBy(ctrn);
    }
    
	public boolean getByLoginPassword(String login, String senha) {
        String sqlScript = "Select 1 from Usuario where login = :login and senha = :senha ;";
        Session session = sessionBuilder.getSession();
        SQLQuery qr = session.createSQLQuery(sqlScript);
        System.out.println(qr.toString());
        qr.setParameter("login", login);
        qr.setParameter("senha", senha);
        if(qr.uniqueResult() != null)        	
        	return true;
        else
        	return false;
    }
	
    public List<Usuario>getList(String search){
    	Criterion ctrnDescription = Restrictions.like("nome", "%" + search + "%").ignoreCase();
        return getList(ctrnDescription, Order.asc("id"));
    }
    
	/*
	 * public Usuario getById(int codigo) { return super.getById(codigo); }
	 * 
	 * public int insert (Usuario m) { return super.inserir(m); }
	 * 
	 * public void update (Usuario m) { super.alterar(m); }
	 * 
	 * public void delete (Usuario m) { super.excluir(m); }
	 */
}
