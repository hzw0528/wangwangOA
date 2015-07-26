package com.wangwang.oa.demo;

import org.junit.Test;

import com.wangwang.dao.impl.UserDaoImpl;
import com.wangwang.oa.dao.UserDao;
import com.wangwang.oa.domain.User;

public class TestUserDaoImpl {
	@Test
	public void testConstractor() {
       UserDao<User> user=new UserDaoImpl();
	}
}
