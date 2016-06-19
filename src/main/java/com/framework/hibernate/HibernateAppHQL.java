package com.framework.hibernate;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
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
public class HibernateAppHQL {

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
		// vehicle.setVehicleName("UpdateD Car");
	
		Query query = session.createQuery("from Vehicle where vehicleid = :vehicleid"  );
		query.setInteger("vehicleid", 1);
	
	
		
		List<Vehicle> vehicles = query.list();
		vehicles.stream().forEach(System.out::println);
		Query query2 = session.getNamedQuery("Vehicle.byID");
		query2.setInteger(0, 2);
		vehicles = query2.list();
		
		
		
		vehicles.stream().forEach(System.out::println);

		
		Query query3 = session.getNamedQuery("Vehicle.byName");
		query3.setInteger(0, 3);
		vehicles = query3.list();
		vehicles.stream().forEach(System.out::println);
		tx.commit();
		session.close();



	}
}
