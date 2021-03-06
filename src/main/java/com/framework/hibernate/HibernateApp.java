package com.framework.hibernate;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistryBuilder;

import com.framework.hibernate.entity.FourWheeler;
import com.framework.hibernate.entity.TwoWheeler;
import com.framework.hibernate.entity.Vehicle;

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
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");

		TwoWheeler twoWheele = new TwoWheeler();
		twoWheele.setVehicleName("Bike");
		twoWheele.setSteeringHandle("Bike Steering Handle");

		FourWheeler fourWheele = new FourWheeler();
		fourWheele.setVehicleName("Porshche");
		fourWheele.setSteeringHandle("Porshche Steering Handle");

		Configuration configuration = new Configuration().configure();

		SessionFactory sessionFactory = configuration.buildSessionFactory(
				new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry());
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(vehicle);

		session.save(twoWheele);
		session.save(fourWheele);
	
	
		Criteria criteria = session.createCriteria(Vehicle.class);
			criteria.addOrder(Order.desc("vehicleId"));
		
			Example example = Example.create(vehicle);
			
			
		///	System.out.println(criteria);
		List<Vehicle> vehicles = criteria.list();
		
		vehicles.stream().forEach(System.out::println);
			
		tx.commit();
		session.close();



	}
}
