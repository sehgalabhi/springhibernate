package com.framework.hibernate.spring;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.framework.hibernate.entity.Department;

public class HibernateSpring {

	private SessionFactory sessionFactory;

	public void executeQuery() {
		Session session = sessionFactory.openSession();
		List<Department> departmentsList = session.createQuery("from Department").list();
		departmentsList.stream().forEach(System.out::println);

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
