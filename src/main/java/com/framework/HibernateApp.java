package com.framework;

import java.util.Collection;

import org.hibernate.SessionFactory;

public class HibernateApp {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Collection loadCountriesByRegion(String region) {
		
		
        return this.sessionFactory.getCurrentSession()
                .createQuery("from test.Product product where product.category=?")
                .setParameter(0, region)
                .list();
    }

}
