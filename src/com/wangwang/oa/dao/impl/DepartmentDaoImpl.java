package com.wangwang.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wangwang.oa.base.BaseDaoImpl;
import com.wangwang.oa.dao.DepartmentDao;
import com.wangwang.oa.domain.Department;

@Repository
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements
		DepartmentDao {

	@Override
	public List<Department> getAllByParents(Integer parentId) {
		if (parentId != null) {
			return getSession()
					.createQuery(
							"FROM Department d WHERE d.parent.id=:parentId")
					.setParameter("parentId", parentId).list();
		}
		return null;
	}

	@Override
	public List<Department> getTopDepartments() {

		return getSession().createQuery("FROM Department WHERE parent IS NULL")
				.list();
	}
}
