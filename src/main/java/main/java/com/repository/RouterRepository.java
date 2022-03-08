package main.java.com.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import main.java.com.entity.Router;
import main.java.com.util.HibernateUtil;

@Repository
public class RouterRepository {
	public List<Router> getAll(){
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Router order by id").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean insert(Router router) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(router);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean update(Router router){
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(router);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Router findById(int id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			Query<Router> query = session.createQuery("from Router where id=:router_id");
			query.setParameter("router_id", id);
			return query.getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean deleteById(int id){
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			Router router = (Router) session.load(Router.class, id);
			session.delete(router);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
}
