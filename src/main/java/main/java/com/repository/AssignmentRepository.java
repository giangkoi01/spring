package main.java.com.repository;

import main.java.com.entity.Assignment;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import main.java.com.util.HibernateUtil;

import java.util.List;

@Repository
public class AssignmentRepository {

	public List<Assignment> getAll(){
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Assignment").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Assignment findById(int id) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			Query<Assignment> query = session.createQuery("from Assignment where id=:assignment_id");
			query.setParameter("assignment_id", id);
			return query.getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean insert(Assignment assignment) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(assignment);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean update(Assignment assignment){
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(assignment);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteById(int id){
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			Assignment assignment = (Assignment) session.load(Assignment.class, id);
			session.delete(assignment);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteByRouterId(int id){
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			Query<Assignment> query = session.createQuery("from Assignment where router.id=:router_id");
			query.setParameter("router_id", id);
			List<Assignment> assignments = query.list();

			for (Assignment assignment: assignments) {
				session.delete(assignment);
			}
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteByDriverId(int id){
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			Query<Assignment> query = session.createQuery("from Assignment where driver.id=:driver_id");
			query.setParameter("driver_id", id);
			List<Assignment> assignments = query.list();

			for (Assignment assignment: assignments) {
				session.delete(assignment);
			}
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
}
