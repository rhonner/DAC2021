package br.com.ufpr.dac.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.ufpr.dac.persistence.Pessoa;
import br.com.ufpr.dac.persistence.Usuario;

public class PessoaDao extends PersistenceDao<Pessoa>{

	public List<Pessoa> listPolices() {
        List<Pessoa> lista = new ArrayList();

        String sqlScript = "select distinct ps.* from pessoa ps, usuario u, perfil pe where ps.idusuario = u.id and u.tipoperfil = 2";
        Session session = sessionBuilder.getSession();
        SQLQuery qr = session.createSQLQuery(sqlScript);
        UsuarioDao udao = new UsuarioDao();
        Pessoa ev;
        List<Object[]> objLst = qr.list();
        if (!objLst.isEmpty()) {
            for (Object[] obj : objLst) {
                ev = new Pessoa(
                        (int) obj[0], (String) obj[1],
                        (String) obj[2], (String) obj[3],  udao.getById((int)obj[4]));
                lista.add(ev);
            }
        }
        return lista;
        
    }
    
    public List<Pessoa>getList(){
    	
    	return getList(Order.asc("id"));
    }
	
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
