package br.com.ufpr.dac.util;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import br.com.ufpr.dac.persistence.Infracao;
import br.com.ufpr.dac.persistence.Multa;
import br.com.ufpr.dac.persistence.Pagamento;
import br.com.ufpr.dac.persistence.Perfil;
import br.com.ufpr.dac.persistence.Permissao;
import br.com.ufpr.dac.persistence.Pessoa;
import br.com.ufpr.dac.persistence.PontuacaoVeiculo;
import br.com.ufpr.dac.persistence.TipoInfracao;
import br.com.ufpr.dac.persistence.Usuario;
 
public class HibernateUtil {
	private static SessionFactory sessionFactory;
 
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "org.postgresql.Driver");
				settings.put(Environment.URL,"jdbc:postgresql://localhost:5432/multads");
				settings.put(Environment.USER, "postgres");
				settings.put(Environment.PASS, "admin");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
				
				settings.put(Environment.SHOW_SQL, true);
				
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Pessoa.class);
				configuration.addAnnotatedClass(Usuario.class);
				configuration.addAnnotatedClass(Infracao.class);
				configuration.addAnnotatedClass(Multa.class);
				configuration.addAnnotatedClass(Pagamento.class);
				configuration.addAnnotatedClass(Perfil.class);
				configuration.addAnnotatedClass(Permissao.class);
				configuration.addAnnotatedClass(PontuacaoVeiculo.class);
				configuration.addAnnotatedClass(TipoInfracao.class);

				ServiceRegistry serviceRegistry = 
						new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return sessionFactory;
		
		
		
	}
	
	public static Session getSession()
    {
        return getSessionFactory().openSession();
    }
	
	
}