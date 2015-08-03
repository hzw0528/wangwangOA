package com.wangwang.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wangwang.oa.dao.DepartmentDao;
import com.wangwang.oa.domain.Department;
import com.wangwang.oa.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Resource
	private DepartmentDao departmentDao;

	@Override
	public List<Department> getAllDepartments() {
		return departmentDao.getAlls();
	}

	@Override
	public void addDepartment(Department department) {
		departmentDao.save(department);
	}

	@Override
	public void modifyDepartment(Department department) {
		departmentDao.update(department);
	}

	@Override
	public void deleteDepartmentById(Integer id) {
		departmentDao.delete(id);
	}

	@Override
	public Department getDepartmentById(Integer id) {

		return departmentDao.getById(id);
	}

	@Override
	public List<Department> getDepartmentsByParentId(Integer parentId) {
		if (parentId != null) {
			return departmentDao.getAllByParents(parentId);
		}
		return null;
	}

	@Override
	public List<Department> getTopDepartments() {

		return departmentDao.getTopDepartments();
	}

}
