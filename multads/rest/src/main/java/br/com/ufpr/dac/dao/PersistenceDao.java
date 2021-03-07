package br.com.ufpr.dac.dao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import java.lang.reflect.*;
import br.com.ufpr.dac.util.HibernateUtil;

public abstract class PersistenceDao<T> implements EntityDao<T>, Serializable {
	
	private static final long serialVersionUID = -2480602680248698521L;
	
    protected transient HibernateUtil sessionBuilder;
    protected transient Class persistentClass;
    
    public PersistenceDao() {
    	this.persistentClass = (Class<T>) ((ParameterizedType) 
	    	      getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    @Override
    public int inserir(T entity) {
        int id = 0;
        try {
            Session session = HibernateUtil.getSession();
            
            Transaction tx = session.beginTransaction();
            try {
                
                session.save(entity);
                tx.commit();
                

            } catch (Exception ex) {
                tx.rollback();                
            }
        } catch (Exception ex) {
        }
        return id;
    }
    
    
    @Override
    public void alterar(T entity) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            try {                
                session.merge(entity);           
                tx.commit();
                

            } catch (Exception ex) {
                tx.rollback();
            	ex.printStackTrace();
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
    }
    
    
    
    @Override
    public void excluir(T entity) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            try {
                session.refresh(entity);
                session.delete(entity);
                tx.commit();
            } catch (Exception ex) {
                tx.rollback();
            	ex.printStackTrace();
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
    }
    
    @Override
    public void excluir(List<T> entities) {
        try {
            Session session = HibernateUtil.getSession();
            Transaction tx = session.beginTransaction();
            try {
                for (T entity : entities) {
	                session.refresh(entity);
	                session.delete(entity);
                }
                tx.commit();
                

            } catch (Exception ex) {
                tx.rollback();
            }
        } catch (Exception ex) {
        }
    }    

    
   
    
    
    
    public T getById(int id) {
        Object item = null;
        try {
            Session session = HibernateUtil.getSession();
            item = session.get(persistentClass, id);
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        return (T) item;
    }

    public T getBy(Criterion ctrn) {
        Object item = null;
        try {
            Session session = HibernateUtil.getSession();
            Criteria cr = session.createCriteria(persistentClass);
            if (ctrn != null) {
                cr.add(ctrn);
            }
            cr.setMaxResults(1);
            if (cr.uniqueResult() != null) {
                item = cr.uniqueResult();
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        return (T) item;
    }
            
    public int getCount(Criterion ctrn) {
        int count = 0;
        try {   
            Session session = HibernateUtil.getSession();
            Criteria cr = session.createCriteria(persistentClass);
            if (ctrn != null) {
                cr.add(ctrn);
            }
            cr.setProjection(Projections.count("codigo"));
            if (cr.uniqueResult() != null) {
                count = Integer.valueOf(String.valueOf(cr.uniqueResult()));
            }
        } catch (Exception ex) {   
        	ex.printStackTrace();
        }
        return count;
    }

    public int getCount() {
        return getCount(null);
    }

    protected List<T> getList(Class c, Integer firstRow,
            Integer maxRows, Criterion ctrn, Order ... orders) {
        List<T> lista = new ArrayList();
        try {
            Session session = HibernateUtil.getSession();
            //Transaction tx = session.beginTransaction();
            Criteria cr = session.createCriteria(c);
            if (ctrn != null) {
                cr.add(ctrn);
            }
            if (firstRow != null) {
                cr.setFirstResult(firstRow);
            }
            if (maxRows != null) {
                cr.setMaxResults(maxRows);
            }
            if (orders != null) {
                for (Order o : orders)
                    cr.addOrder(o);
            }
            lista = cr.list();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        return lista;
    }
    
    public List<T> getList(Integer firstRow,
            Integer maxRows, Criterion ctrn, Order ... orders) {
    	return getList(persistentClass, firstRow, maxRows, ctrn, orders);
    }

    protected List<T> getList(Class c, Criterion ctrn, Order ... orders) {
        return getList(c, null, null, ctrn, orders);
    }

    protected List<T> getList(Class c, Criterion ctrn) {
        return getList(c, null, null, ctrn);
    }
    
    protected List<T> getList(Class c, Order ... orders) {
        return getList(c, null, orders);
    }

    protected List<T> getList(Criterion ctrn, Order ... orders) {
        return getList(persistentClass, null, null, ctrn, orders);
    }
    
    protected List<T> getList(Criterion ctrn) {
        return getList(persistentClass, null, null, ctrn, (Order[]) null);
    }    

    @Deprecated
    protected List<T> getList(Order ... orders) {
        return getList(persistentClass, null, orders);
    }
    
    @Deprecated
    public List<T> getList() {
        return getList(persistentClass, null, (Order[]) null);
    }
    
    public Boolean getExist(Criterion ctrn) {
        Boolean res = null;
        try {
            Session session = HibernateUtil.getSession();
            Criteria cr = session.createCriteria(persistentClass);
            if (ctrn != null) {
                cr.add(ctrn);
            }
            cr.setMaxResults(1);
            res = cr.uniqueResult() != null;
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        return res;
    }
}