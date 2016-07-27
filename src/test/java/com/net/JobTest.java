package com.net;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JobTest {

	@Test
	public void testTask(){
		ApplicationContext context =new  ClassPathXmlApplicationContext("spring-task.xml");
		System.out.println(context.getStartupDate());
		
	}
}
