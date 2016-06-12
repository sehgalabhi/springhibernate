package com.framework;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/messageApp.xml")
public class SpringTest extends TestCase{
	@Autowired
	private MessageApp messageApp;

	@Ignore
	@Test
	public void testMessage(){
		System.out.println(	messageApp.getMessage());
	}
	
}
