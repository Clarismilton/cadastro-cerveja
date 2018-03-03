package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import bean.Cerveja;
import util.HibernateUtil;

public class CervejaDao implements CervejaDaoI {

	private SessionFactory session;
	
	public void insert(Cerveja c){
		session = HibernateUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		s.persist(c);
		tx.commit();
		s.close();
	}
	
	public void update(Cerveja c){
		session = HibernateUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		s.update(c);
		tx.commit();
		s.close();
	}
	
	public void delete(Cerveja c){
		session = HibernateUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		s.delete(c);
		tx.commit();
		s.close();
	}
	
	public List<Cerveja> select(){
		List<Cerveja> result = new ArrayList<Cerveja>();
		session = HibernateUtil.getSessionFactory();
		Session s = session.openSession();
		Transaction tx = s.beginTransaction();
		result = s.createCriteria(Cerveja.class).list();
		s.close();
		return result;
	}	
}