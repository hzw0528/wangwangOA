package com.wangwang.oa.demo;

import org.junit.Test;

import com.wangwang.oa.dao.RoleDao;
import com.wangwang.oa.dao.UserDao;
import com.wangwang.oa.dao.impl.RoleDaoImpl;
import com.wangwang.oa.dao.impl.UserDaoImpl;
import com.wangwang.oa.domain.Role;
import com.wangwang.oa.domain.User;

public class TestUserDaoImpl {
	@Test
	public void testConstractor() {
		UserDao<User> user = new UserDaoImpl();
		RoleDao role = new RoleDaoImpl();
	}
}
