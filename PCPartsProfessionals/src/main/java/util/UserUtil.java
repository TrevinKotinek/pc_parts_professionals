package util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import datamodel.usersTable;

public class UserUtil {
	static SessionFactory sessionFactory = null;
	public static usersTable currentUser;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory != null) {
			return sessionFactory;
		}
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public static List<usersTable> listUsers() {
		List<usersTable> resultList = new ArrayList<>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Users = session.createQuery("FROM usersTable").list();
			for (Iterator<?> iterator = Users.iterator(); iterator.hasNext();) {
				usersTable user = (usersTable) iterator.next();
				resultList.add(user);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}
	
	public static boolean userExists(String username, String password) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Users = session.createQuery("FROM usersTable").list();
			for (Iterator<?> iterator = Users.iterator(); iterator.hasNext();) {
				usersTable user = (usersTable) iterator.next();
				if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
					currentUser = user;
					return true;
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	public static void createUsersTable(String username, String password, String email, String phone) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(new usersTable(username, password, email, phone));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static boolean deleteUsersTable(int id) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		usersTable user = UserUtil.get(id);
		if (user != null) {
			try {
				tx = session.beginTransaction();
				session.delete(user);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
			return true;
		}
		return false;
	}

	public static usersTable get(int id) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> restaurants = session.createQuery("FROM usersTable").list();
			for (Iterator<?> iterator = restaurants.iterator(); iterator.hasNext();) {
				usersTable user = (usersTable) iterator.next();
				if (user.getId() == id) {
					return user;
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}
