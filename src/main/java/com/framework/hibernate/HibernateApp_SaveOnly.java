package com.framework.hibernate;

import java.sql.Date;
import java.time.Year;
import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.framework.hibernate.entity.UserDetails;

/**
 * First class for Hibernates
 * 
 * @author abhi
 *
 */
public class HibernateApp_SaveOnly {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(2);
		userDetails.setUserName("Abhi");
	//	userDetails.setAddress("First Address");
		userDetails.setJoinedDate(Calendar.getInstance().getTime());
		userDetails.setDescription("First Description");
		userDetails.setJoinedTime(Calendar.getInstance().getTime());
		Configuration configuration = new Configuration().configure();

		SessionFactory sessionFactory = configuration.buildSessionFactory(
				new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry());
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(userDetails);

		tx.commit();
		session.close();

	}
}
