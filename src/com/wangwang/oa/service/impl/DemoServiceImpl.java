package com.wangwang.oa.service.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangwang.oa.domain.Demo;
import com.wangwang.oa.service.DemoService;


@Service("demoService")
@Transactional
public class DemoServiceImpl implements DemoService {

	// 注入容器管理的SessionFactory对象
	@Resource
	private SessionFactory sessionFactory;

	
	@Override
	@Transactional
	public void addDemo(Demo demo) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(demo);
		int i=1/0;
		session.save(demo);
		
	}

}
