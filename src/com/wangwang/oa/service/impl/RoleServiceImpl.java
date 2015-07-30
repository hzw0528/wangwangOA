package com.wangwang.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangwang.oa.dao.RoleDao;
import com.wangwang.oa.domain.Role;
import com.wangwang.oa.domain.extension.RoleExt;
import com.wangwang.oa.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;

	@Override
	public void addRole(Role role) {
		roleDao.save(role);
	}

	@Override
	public void modifyRole(Role role) {
		roleDao.update(role);

	}

	@Override
	public List<Role> getAlls() {

		return roleDao.getAlls();
		
	}

	@Override
	public void deleteById(Integer id) {
		roleDao.delete(id);

	}

	@Override
	public Role getRoleById(Integer id) {
		return roleDao.getById(id);
	}

}
