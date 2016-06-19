package com.framework.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.framework.hibernate.entity.UserDetails;
import com.framework.hibernate.entity.Vehicle;

/**
 * First class for Hibernates
 * 
 * @author abhi
 *
 */
public class HibernateApp_ManytoMany {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		UserDetails userDetails1 = new UserDetails();

		userDetails1.setUserName("First User");

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		List<UserDetails> userList = new ArrayList<>();
		userList.add(userDetails1);
		vehicle.setUserList(userList);
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Bike");
		vehicle1.setUserList(userList);
		
		List<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(vehicle1);
		vehicles.add(vehicle);
		userDetails1.setVehicles(vehicles);
		Configuration configuration = new Configuration().configure();

		SessionFactory sessionFactory = configuration.buildSessionFactory(
				new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry());
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(userDetails1);
		//
//		session.save(vehicle);
//		session.save(vehicle1);
		tx.commit();
		session.close();

		userDetails1 = null;
		session = sessionFactory.openSession();
		session.beginTransaction();

		userDetails1 = (UserDetails) session.get(UserDetails.class, 10);
		System.out.println(userDetails1);
	}
}
