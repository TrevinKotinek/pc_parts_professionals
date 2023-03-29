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

import datamodel.forumsTable;

public class ForumUtil {
	static SessionFactory sessionFactory = null;

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

	public static List<forumsTable> listForums() {
		List<forumsTable> resultList = new ArrayList<>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Forums = session.createQuery("FROM forumsTable").list();
			for (Iterator<?> iterator = Forums.iterator(); iterator.hasNext();) {
				forumsTable forum = (forumsTable) iterator.next();
				resultList.add(forum);
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


	public static void createforumsTable(String username, String title, String text, String date) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(new forumsTable(username, title, text, date));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static boolean deleteforumsTable(int id) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		forumsTable user = ForumUtil.get(id);
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

	public static forumsTable get(int id) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> restaurants = session.createQuery("FROM forumsTable").list();
			for (Iterator<?> iterator = restaurants.iterator(); iterator.hasNext();) {
				forumsTable user = (forumsTable) iterator.next();
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
