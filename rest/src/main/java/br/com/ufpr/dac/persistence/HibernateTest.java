package br.com.ufpr.dac.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.ufpr.dac.util.HibernateUtil;

public class HibernateTest {

public static void main(String[] args) {
         
        Session session = HibernateUtil.getSessionFactory().openSession();
 
        session.beginTransaction();


      
     

        Query q = session.createQuery("From Pessoa ");
                
        List<Pessoa> resultList = q.list();
        System.out.println("num of employess:" + resultList.size());
        for (Pessoa next : resultList) {
            System.out.println("next employee: " + next);
        }

    }
   
}