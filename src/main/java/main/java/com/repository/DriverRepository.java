package main.java.com.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import main.java.com.entity.Driver;
import main.java.com.util.HibernateUtil;

@Repository
public class DriverRepository {
	public List<Driver> getAll(){
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery("from Driver ").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean insert(Driver driver) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(driver);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Driver findById(int id) {
		System.out.println("abc1");
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			System.out.println("abc");
			System.out.println(id);
			Query<Driver> query = session.createQuery("from Driver where id=:driver_id");
			query.setParameter("driver_id", id);
			return query.getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean update(Driver driver){
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(driver);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean deleteById(int id){
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			session.beginTransaction();
			Driver driver = (Driver) session.load(Driver.class, id);
			session.delete(driver);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e){
			e.printStackTrace();
		}
		return false;
	}
}
