package com.framework.hibernate.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.framework.hibernate.entity.Department;

public class HibernateBasicTest {

	private static SessionFactory sessionFactory;

	@BeforeClass
	public static void setup() {
		Configuration configure = new Configuration().configure();
		sessionFactory = configure.buildSessionFactory(
				new ServiceRegistryBuilder().applySettings(configure.getProperties()).buildServiceRegistry());
	}

	@Test
	public void test() {
		Session session = sessionFactory.openSession();
		
		List<Department> list = session.createQuery("from Department").list();
		list.stream().forEach(System.out::println);
		
	}
	
	@AfterClass
	public static void teardown(){
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

}
