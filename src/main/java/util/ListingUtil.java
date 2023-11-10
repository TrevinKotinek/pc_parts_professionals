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

import datamodel.listingsTable;

public class ListingUtil {
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

	public static List<listingsTable> listListings() {
		List<listingsTable> resultList = new ArrayList<>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> listings = session.createQuery("FROM listingsTable").list();
			for (Iterator<?> iterator = listings.iterator(); iterator.hasNext();) {
				listingsTable listing = (listingsTable) iterator.next();
				resultList.add(listing);
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

	public static void createlistingsTable(String type, String brand, String model, String condition, String price, String date, String user,
			String email, String phone, String city, String state) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(new listingsTable(type, brand, model, condition, price, date, user, email, phone, city, state));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static boolean deletelistingsTable(int id) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		listingsTable user = ListingUtil.get(id);
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

	public static listingsTable get(int id) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> restaurants = session.createQuery("FROM listingsTable").list();
			for (Iterator<?> iterator = restaurants.iterator(); iterator.hasNext();) {
				listingsTable user = (listingsTable) iterator.next();
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
	
	public static void deleteUsersPostings(String username) {
		List<listingsTable> allListings = listListings();
		for(listingsTable thisListing : allListings) {
			if(thisListing.getUser().equals(username)) {
				deletelistingsTable(thisListing.getId());
			}
		}
		
		
	}
}
