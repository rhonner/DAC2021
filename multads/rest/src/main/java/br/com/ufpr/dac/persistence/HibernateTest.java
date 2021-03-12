package br.com.ufpr.dac.persistence;

import java.util.List;

import org.hibernate.Session;

import br.com.ufpr.dac.dao.PessoaDao;
import br.com.ufpr.dac.dao.MultaDao;
import br.com.ufpr.dac.util.HibernateUtil;

public class HibernateTest {

public static void main(String[] args) {
         
        Session session = HibernateUtil.getSessionFactory().openSession();
 
        session.beginTransaction();

        
		/*
		 * MultaDao mdao = new MultaDao(); PerfilDao pdao = new PerfilDao();
		 * 
		 * Multa m = new Multa(); m.setDocumento("321321312");
		 * m.setEmail("wadawd@gmail.com"); Usuario u = new Usuario();
		 * m.setNome("negaoteste2"); u.setLogin("Multateste2");
		 * u.setSenha("testesenha2"); u.setPerfil(pdao.getById(2)); m.setUsuario(u);
		 * mdao.inserir(m);
		 */
		/*
		 * MultaDao pdao = new MultaDao(); List <Multa> lista = pdao.getList(); Multa p
		 * = lista.get(0);
		 */
        
        PessoaDao mdao = new PessoaDao();
        List<Pessoa>plist = mdao.getList();
        for (Pessoa Pessoa : plist) {
            System.out.println(Pessoa);
         
        

		}
        

    }
   
}