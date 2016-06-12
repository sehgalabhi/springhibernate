package com.framework.hibernate.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.framework.hibernate.spring.HibernateSpring;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/springHibernate.xml")
public class HibernateSpringTest {

	@Autowired
	private HibernateSpring hibernateSpring;
	
	public HibernateSpring getHibernateSpring() {
		return hibernateSpring;
	}

	public void setHibernateSpring(HibernateSpring hibernateSpring) {
		this.hibernateSpring = hibernateSpring;
	}

	@Test
	public void test1() {
		hibernateSpring.executeQuery();
	}

}
