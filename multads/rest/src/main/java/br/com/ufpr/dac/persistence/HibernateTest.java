package br.com.ufpr.dac.persistence;

import java.util.List;

import org.hibernate.Session;

import br.com.ufpr.dac.dao.PessoaDao;
import br.com.ufpr.dac.impl.PessoaImpl;
import br.com.ufpr.dac.response.PessoaResponse;
import br.com.ufpr.dac.dao.PessoaDao;
import br.com.ufpr.dac.util.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		/*
		 * PessoaDao mdao = new PessoaDao(); PerfilDao pdao = new PerfilDao();
		 * 
		 * Pessoa m = new Pessoa(); m.setDocumento("321321312");
		 * m.setEmail("wadawd@gmail.com"); Usuario u = new Usuario();
		 * m.setNome("negaoteste2"); u.setLogin("Pessoateste2");
		 * u.setSenha("testesenha2"); u.setPerfil(pdao.getById(2)); m.setUsuario(u);
		 * mdao.inserir(m);
		 */
		/*
		 * PessoaDao pdao = new PessoaDao(); List <Pessoa> lista = pdao.getList();
		 * Pessoa p = lista.get(0);
		 */

		PessoaDao mdao = new PessoaDao();

		PessoaImpl p = new PessoaImpl();
		List<PessoaResponse> plist = p.getListaPessoaGenericSearch("antelectus");
		for (PessoaResponse pessoa : plist) {
			System.out.println(pessoa);

		}

		/*
		 * List<Pessoa>plist = mdao.getExemplo("ri"); for (Pessoa pessoa : plist) {
		 * System.out.println(pessoa);
		 * 
		 * 
		 * 
		 * }
		 */

	}

}