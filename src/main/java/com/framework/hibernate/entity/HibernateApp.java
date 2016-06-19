package com.framework.hibernate.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.framework.hibernate.entity.Address;
import com.framework.hibernate.entity.UserDetails;

/**
 * First class for Hibernates
 * 
 * @author abhi
 *
 */
public class HibernateApp {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		UserDetails userDetails1 = new UserDetails();

		userDetails1.setUserName("First User");
		Address address = new Address();
		address.setCity("Amstel");
		;
		address.setStreet("Remb 1");
		address.setState("Amst");
		address.setZipcode("1181");
		// userDetails1.setHomeAddress(address);

		Address officeAddress = new Address();
		officeAddress.setCity("Amstel");
		;
		officeAddress.setStreet("Gus 1");
		officeAddress.setState("Amst");
		officeAddress.setZipcode("1181");
		// userDetails1.setOfficeAddress(officeAddress);

		List<Address> addresses1 = new ArrayList<>();
		addresses1.add(address);
		addresses1.add(officeAddress);
		userDetails1.setListOfAddresses(addresses1);
		userDetails1.setJoinedDate(Calendar.getInstance().getTime());
		userDetails1.setDescription("First Description");
		userDetails1.setJoinedTime(Calendar.getInstance().getTime());

		UserDetails userDetails2 = new UserDetails();

		userDetails2.setUserName("Second User");
		Address address2 = new Address();
		address2.setCity("Amstel");
		;
		address2.setStreet("Remb 2");
		address2.setState("Amst");
		address2.setZipcode("1181");
		// userDetails2.setHomeAddress(address2);

		Address officeAddress2 = new Address();
		officeAddress2.setCity("Amstel");
		;
		officeAddress2.setStreet("Gus 2");
		officeAddress2.setState("Amst");
		officeAddress2.setZipcode("1181");
		// userDetails2.setOfficeAddress(officeAddress2);

		List<Address> addresses2 = new ArrayList<>();
		addresses2.add(address2);
		addresses2.add(officeAddress2);

		userDetails2.setJoinedDate(Calendar.getInstance().getTime());
		userDetails2.setDescription("Second Description");
		userDetails2.setJoinedTime(Calendar.getInstance().getTime());
		userDetails2.setListOfAddresses(addresses2);

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

		userDetails1 = (UserDetails) session.get(UserDetails.class, 10);
		System.out.println(userDetails1);
		List<Address> addresses = userDetails1.getListOfAddresses();
		session.close();
		addresses.stream().forEach(System.out::println);
	}
}
