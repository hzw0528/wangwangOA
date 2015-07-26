package com.wangwang.oa.demo;



import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangwang.oa.domain.Demo;
import com.wangwang.oa.service.DemoService;
import com.wangwang.oa.service.impl.*;

public class TestSpring {
	ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	@Test
	public void testRun() {
		HelloAction helloAction = ctx.getBean("helloAction", HelloAction.class);
		System.out.println(helloAction);
	}

	@Test
	public void testSessionFactory() {
		SessionFactory sf = ctx.getBean("sessionFactory", SessionFactory.class);
		System.out.println(sf);
	}

	@Test
	public void testTransaction() {

		DemoService demoService = ctx.getBean("demoService", DemoService.class);
		demoService.addDemo(new Demo());
		
	}
}
