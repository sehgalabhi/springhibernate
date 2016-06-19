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
public class HibernateApp2_SaveAndSessionGet {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		UserDetails userDetails1 = new UserDetails();
		userDetails1.setUserId(1);
		userDetails1.setUserName("First User");
		//userDetails1.setAddress("First Address");
		userDetails1.setJoinedDate(Calendar.getInstance().getTime());
		userDetails1.setDescription("First Description");
		userDetails1.setJoinedTime(Calendar.getInstance().getTime());
			
		UserDetails userDetails2 = new UserDetails(); 
		
		userDetails2.setUserId(2);
		userDetails2.setUserName("Second User");
	//	userDetails2.setAddress("Second Address");
		userDetails2.setJoinedDate(Calendar.getInstance().getTime());
		userDetails2.setDescription("Second Description");
		userDetails2.setJoinedTime(Calendar.getInstance().getTime());
		
		Configuration configuration = new Configuration().configure();

		SessionFactory sessionFactory = configuration.buildSessionFactory(
				new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry());
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(userDetails1);
		session.save(userDetails2);

		tx.commit();
		session.close();
		
		
		userDetails1 = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		userDetails1 = (UserDetails)session.get(UserDetails.class, 1);
		System.out.println(userDetails1);

	}
}
